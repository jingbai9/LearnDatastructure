package me.myshop.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mzlion.easyokhttp.HttpClient;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import me.myshop.R;
import me.myshop.common.constant.Mall;
import me.myshop.common.utils.JsonParse;
import me.myshop.common.utils.MyData;

public class BalanceActivity extends AppCompatActivity {


    private Handler mHandler = new Handler();
    private EditText et_balance;
    private TextView tv_balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);

        tv_balance = findViewById(R.id.tv_balance);
        et_balance = findViewById(R.id.et_balance);

        Button btn_submit = findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String balance_change = et_balance.getText().toString();
                if (balance_change.length()==0){
                    Toast.makeText(BalanceActivity.this,"请填写充值金额",Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(BalanceActivity.this,ChargeActivity.class);
                intent.putExtra("balance_change",balance_change);
                startActivityForResult(intent,100);
            }

        });
        updateBalance();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode!= Activity.RESULT_OK)
        {
            return;
        }
        if (requestCode==100){
            et_balance.setText("");
            updateBalance();
        }
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
                            double balance_d = Double.parseDouble(balance);
                            tv_balance.setText(new DecimalFormat("0.0").format(new BigDecimal(balance_d)) + "元");
                        }
                    }
                });
            }
        }).start();
    }

}
