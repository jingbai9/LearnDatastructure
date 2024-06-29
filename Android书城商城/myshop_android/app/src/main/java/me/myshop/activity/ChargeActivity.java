package me.myshop.activity;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.mzlion.easyokhttp.HttpClient;

import me.myshop.R;
import me.myshop.common.constant.Mall;
import me.myshop.common.utils.JsonParse;
import me.myshop.common.utils.MyData;

public class ChargeActivity extends AppCompatActivity {


    private Handler mHandler = new Handler();
    private TextView tv_balance;
    private String balance_change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        balance_change = getIntent().getStringExtra("balance_change");
        setContentView(R.layout.activity_charge);

        tv_balance = findViewById(R.id.tv_balance);
        tv_balance.setText("￥" + balance_change);
        Button btn_submit = findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String balance = HttpClient
                                .textBody(Mall.BASE_URL + Mall.USER_REL_PATH + "/recharge")
                                .queryString("uid", MyData.getInstance(getApplicationContext()).getUser().getUid())
                                .queryString("balance_change", balance_change)
                                .json(JsonParse.toJson(MyData.getInstance(getApplicationContext()).getUser()))
                                .execute()
                                .asString();

                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (balance != null && balance.length() > 0) {
                                    Toast.makeText(ChargeActivity.this, "充值成功", Toast.LENGTH_LONG).show();
                                    setResult(RESULT_OK);
                                    finish();
                                }
                            }
                        });
                    }
                }).start();

            }

        });
    }


}
