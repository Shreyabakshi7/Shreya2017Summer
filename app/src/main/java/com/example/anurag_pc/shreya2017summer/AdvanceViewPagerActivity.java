package com.example.anurag_pc.shreya2017summer;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.anurag_pc.shreya2017summer.adpater.AdvanceListViewAdapter;
import com.example.anurag_pc.shreya2017summer.adpater.BaseViewPagerAdapter;
import com.example.anurag_pc.shreya2017summer.adpater.ViewFragmentStateAdapter;
import com.example.anurag_pc.shreya2017summer.fragment.BlueFragment;
import com.example.anurag_pc.shreya2017summer.fragment.GreenFragment;
import com.example.anurag_pc.shreya2017summer.fragment.MiniBlueFragment;
import com.example.anurag_pc.shreya2017summer.fragment.MiniGreenFragment;
import com.example.anurag_pc.shreya2017summer.fragment.MiniRedFragment;
import com.example.anurag_pc.shreya2017summer.fragment.RedFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdvanceViewPagerActivity extends BaseActivity {

    //private ArrayList<Pair<String,Fragment>> list = new ArrayList<Pair<String,Fragment>>();
   // private ViewPager viewPager;
    private ArrayList<Fragment> list= new ArrayList<Fragment>();

    //@BindView(R.id.advance_view_pager_tablayout)
    //TabLayout tabLayout;

    @BindView(R.id.activity_advance_view_pager)
    ViewPager viewPager;


    @BindView(R.id.activity_advance_list_view_mini)
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_view_pager);
        ButterKnife.bind(this);
//        list.add(new Pair<String, Fragment>("Red",new MiniRedFragment()));
//        list.add(new Pair<String, Fragment>("Green",new MiniGreenFragment()));
//        list.add(new Pair<String, Fragment>("Blue",new MiniBlueFragment()));
        list.add(new MiniRedFragment());
        list.add(new MiniGreenFragment());
        list.add(new MiniBlueFragment());
        //ViewFragmentStateAdapter adapter= new ViewFragmentStateAdapter(this.getSupportFragmentManager(),list);
        BaseViewPagerAdapter pagerAdapter= new BaseViewPagerAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(1);
        //tabLayout.setupWithViewPager(viewPager);

        ArrayList<String> list= new ArrayList<>();
        list.add("Hello");
        list.add("Hello, how are you?");
        list.add("I am fine, thankyou!");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        AdvanceListViewAdapter adapter = new AdvanceListViewAdapter(this,list);
        lv.setAdapter(adapter);

        TextView tv=new  TextView(this);
        //tv.setText("HeaderView");
        //tv.setTextSize(50);
        //lv.addHeaderView(viewPager);

        TextView tv1=new  TextView(this);
//        tv.setText("FooterView");
//        tv.setTextSize(50);
//        lv.addHeaderView(viewPager);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showToast(String.valueOf(position));
            }
        });

    }
    }

