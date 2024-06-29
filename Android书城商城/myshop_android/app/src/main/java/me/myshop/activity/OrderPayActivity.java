package me.myshop.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.mzlion.easyokhttp.HttpClient;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import me.myshop.R;
import me.myshop.common.constant.Mall;
import me.myshop.common.utils.JsonParse;
import me.myshop.common.utils.MyData;
import me.myshop.entity.Goods;
import me.myshop.entity.Order;
import me.myshop.entity.RecInfo;
import me.myshop.entity.Result;
import me.myshop.entity.User;
import me.myshop.entity.UserAndOrder;

public class OrderPayActivity extends AppCompatActivity {

    private String mPayMode = "余额";
    private List<Goods> mGoodsList;
    private RecInfo mRecInfo;
    private double mAllGoodsTotalCost;
    private TextView tv_balance;
    private double balance;

    private Handler mHandler = new Handler();

    @SuppressLint("InflateParams")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRecInfo = (RecInfo) getIntent().getSerializableExtra("rec_info");
        mGoodsList = (List<Goods>) getIntent().getSerializableExtra("goods_list");
        mAllGoodsTotalCost = getIntent().getDoubleExtra("total_cost", 0);
        setContentView(R.layout.activity_order_pay);

        ImageView iv_back = findViewById(R.id.iv_back);
        TextView tv_total_cost = findViewById(R.id.tv_total_cost);
        tv_total_cost.setText(new DecimalFormat("0.0").format(new BigDecimal(mAllGoodsTotalCost)));

        //操作按钮
        Button btn_cancel = findViewById(R.id.btn_cancel);
        Button btn_pay = findViewById(R.id.btn_pay);

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAllGoodsTotalCost > balance) {
                    Toast.makeText(OrderPayActivity.this, "余额不足，请先去充值", Toast.LENGTH_SHORT).show();
                    return;
                }

                User user = MyData.getInstance(getApplicationContext()).getUser();

                Order mOrder = new Order(user.getUid(), mPayMode, mAllGoodsTotalCost, "未发货", mRecInfo, mGoodsList);

                final UserAndOrder userAndOrder = new UserAndOrder();
                userAndOrder.setUser(user);
                userAndOrder.setOrder(mOrder);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String responseData = HttpClient
                                .textBody(Mall.BASE_URL + Mall.ORDER_REL_PATH + "/submit")
                                .json(JsonParse.toJson(userAndOrder))
                                .execute()
                                .asString();

                        final Result result = JsonParse.fromJson(responseData, Result.class);

                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (result.getStatus().equals(Mall.SUCCESS)) {
                                    Toast.makeText(OrderPayActivity.this, "提交成功", Toast.LENGTH_SHORT).show();

                                    mOrder.setId(Integer.valueOf(result.getId()));
                                    mOrder.setCreateTime(result.getOrderCreateTime());

                                    MyData.getInstance(getApplicationContext()).addMyOrderList(mOrder);

                                    setResult(Activity.RESULT_OK);

                                    //结束activity
                                    finish();
                                    //使用特殊关闭activity的动画覆盖默认的动画
                                    overridePendingTransition(R.anim.unchanged, R.anim.slide_in_top);
                                } else {
                                    Toast.makeText(OrderPayActivity.this, result.getMsg(), Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
                }).start();
            }
        });


        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tv_balance = findViewById(R.id.tv_balance);
        updateBalance();
    }

    private void updateBalance() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String balance = HttpClient
                        .textBody(Mall.BASE_URL + Mall.USER_REL_PATH + "/balance")
                        .queryString("uid", MyData.getInstance(getApplicationContext()).getUser().getUid())
                        .json(JsonParse.toJson(MyData.getInstance(getApplicationContext()).getUser()))
                        .execute()
                        .asString();

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (balance != null && balance.length() > 0) {
                            OrderPayActivity.this.balance = Double.parseDouble(balance);
                            tv_balance.setText("可用余额：" + new DecimalFormat("0.0").format(new BigDecimal(OrderPayActivity.this.balance)) + "元");
                        }
                    }
                });
            }
        }).start();
    }

}