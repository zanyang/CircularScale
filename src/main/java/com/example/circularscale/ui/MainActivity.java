package com.example.circularscale.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.circularscale.R;
import com.example.circularscale.widget.CircleDial;

public class MainActivity extends AppCompatActivity {
    private static final int TAG = 1;

    private CircleDial mCircleDial;
    private EditText inputMin, inputMax, inputCurrent;
    private Button btnSure;

    private int min, max, center1;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case TAG:
                    mCircleDial.setAngle(min, max);
                    mCircleDial.setMinMaxTem(min, max);
                    mCircleDial.setCenterTemper(center1);
            }
        }
    };
    private Button btnNewCredit;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCircleDial = (CircleDial) findViewById(R.id.temp_line_dial);
        inputMin = (EditText) findViewById(R.id.min_temp);
        inputMax = (EditText) findViewById(R.id.max_temp);
        inputCurrent = (EditText) findViewById(R.id.current_temp);
        btnSure = (Button) findViewById(R.id.sure_temp);
        btnNewCredit = (Button) findViewById(R.id.btn_main_newcredit);

        btnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        min = Integer.parseInt(inputMin.getText().toString());
                        max = Integer.parseInt(inputMax.getText().toString());
                        center1 = Integer.parseInt(inputCurrent.getText().toString());

                        Message msg = new Message();
                        msg.what = TAG;
                        mHandler.sendMessage(msg);
                    }
             }).start();

            }
        });
        btnNewCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,NewCreditSesame.class);
                startActivity(intent);
            }
        });
    }
}
