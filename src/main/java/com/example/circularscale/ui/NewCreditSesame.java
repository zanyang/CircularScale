package com.example.circularscale.ui;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.circularscale.R;
import com.example.circularscale.widget.NewCreditSesameView;

import java.util.Random;

/**
 * <pre>
 *     author : lzy
 *     e-mail : zanyang.lin@newbeeair.com
 *     time   : 2017/04/25
 *     desc   :
 * </pre>
 */

public class NewCreditSesame extends AppCompatActivity {

    private final int[] mColors = new int[]{
            0xFFFF80AB,
            0xFFFF4081,
            0xFFFF5177,
            0xFFFF7997
    };

    private RelativeLayout mLayout;

    private NewCreditSesameView newCreditSesameView;

    private Random random = new Random();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newcredit);
        initView();
    }

    public void initView() {

        mLayout = (RelativeLayout) findViewById(R.id.layout);
        ImageView mButton = (ImageView) findViewById(R.id.btn);
        newCreditSesameView = (NewCreditSesameView) findViewById(R.id.sesame_view);
        mLayout.setBackgroundColor(mColors[0]);
        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                int i = random.nextInt(999);
                newCreditSesameView.setSesameValues(i);
                startColorChangeAnim();
            }
        });
    }

    public void startColorChangeAnim() {

        ObjectAnimator animator = ObjectAnimator.ofInt(mLayout, "backgroundColor", mColors);
        animator.setDuration(3000);
        animator.setEvaluator(new ArgbEvaluator());
        animator.start();
    }
}
