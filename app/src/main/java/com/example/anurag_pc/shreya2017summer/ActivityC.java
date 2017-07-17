package com.example.anurag_pc.shreya2017summer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Anurag-PC on 6/17/2017.
 */


public class ActivityC extends BaseActivity {
    @OnClick(R.id.activity_c_a)
    public void toA(View v){ goToActivity(ActivityA.class);}

    @OnClick(R.id.activity_c_b)
    public void toB(View v){ goToActivity(ActivityB.class);}



    @OnClick(R.id.activity_c_c)
    public void toC(View v){ goToActivity(ActivityC.class);}

    @OnClick(R.id.activity_c_d)
    public void toD(View v){ goToActivity(ActivityD.class);}



    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        Toast.makeText(this,"onCreate",Toast.LENGTH_SHORT).show();
        ButterKnife.bind(this);

    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        //shortToast("onNewIntent");
        Toast.makeText(this,"onNewIntent",Toast.LENGTH_SHORT).show();
    }
}
