package com.example.anurag_pc.shreya2017summer;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anurag_pc.shreya2017summer.fragment.DemoFragment;
import com.example.anurag_pc.shreya2017summer.fragment.WorkFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private TextView tv_demo;
    private TextView tv_work;

//    @OnClick(R.id.activity_tool_work)
//    public void work(View view)
//    {
//        Intent i=new Intent(MainActivity.this, Quiz1Activity.class);
//        startActivity(i);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        TextView textView1 = (TextView) findViewById(R.id.activity_tool_work);
//        textView1.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                serve(view);
//            }
//
//        });
//
//        ButterKnife.bind(this);
        initialView();
        setListener();
    }

    private void serve(View view) {
        Intent i = new Intent();
        i.setClass(this, Quiz1Activity.class);
        startActivity(i);
    }


    private void initialView() {

        tv_demo = (TextView) findViewById(R.id.activity_tool_demo);
        tv_work = (TextView) findViewById(R.id.activity_tool_work);


    }


    private void setListener() {
        WorkFragment workFragment = new WorkFragment();
        DemoFragment demoFragment = new DemoFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_fragment, demoFragment).commit();
        tv_demo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_work.setTextColor(Color.BLACK);

                tv_demo.setTextColor(Color.RED);
            }
        });
        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                tv_work.setTextColor(Color.RED);
                tv_demo.setTextColor(Color.BLACK);
                //serve(View);
            }
        };
        tv_work.setOnClickListener(listener);
        tv_work.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {

                serve(view);
            }

//        });
            //tv_work.setOnClickListener(listener);


        });
    }

    public void login(View v) {
        Toast.makeText(MainActivity.this, "You clicked login", Toast.LENGTH_SHORT).show();
    }
}



