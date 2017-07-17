package com.example.anurag_pc.shreya2017summer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.anurag_pc.shreya2017summer.audio.BaseBean;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Anurag-PC on 6/17/2017.
 */


public class ActivityA extends BaseActivity {


   @OnClick(R.id.activity_a_a)
    public void toA(View v){ goToActivity(ActivityA.class);}

    @OnClick(R.id.activity_a_b)
    public void toB(View v){ goToActivity(ActivityB.class);}

    @OnClick(R.id.activity_a_c)
    public void toC(View v){ goToActivity(ActivityC.class);}

    @OnClick(R.id.activity_a_d)
    public void toD(View v){ goToActivity(ActivityD.class);}




    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Toast.makeText(this,"onCreate",Toast.LENGTH_SHORT).show();
        ButterKnife.bind(this);
        // newly added in 6/21 class
        Intent intent = getIntent();
        Bundle bundle= intent.getBundleExtra("Bundle");
        String bs= bundle.getString("StringBundle");
        int bi= bundle.getInt("IntegerBundle",0);
        BaseBean bean= (BaseBean) bundle.getSerializable("Object");
        shortToast(bean.getName());
       // shortToast(bs);
        //shortToast("Integer is:"+bi);
      //  String s =intent.getStringExtra("StringInfo");
        //int i = intent.getIntExtra("IntegerInfo",0);
        //shortToast(s);
        //shortToast(i+""); //
        //shortToast(String.valueOf(i));//Both are same way to convert int to string
        //shortToast("Integer is:"+i);

        //shortToast("onCreate");

    }
    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        //shortToast("onNewIntent");
        Toast.makeText(this,"onNewIntent",Toast.LENGTH_SHORT).show();
    }



}
