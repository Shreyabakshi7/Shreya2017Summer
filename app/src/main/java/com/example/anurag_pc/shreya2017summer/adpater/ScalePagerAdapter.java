package com.example.anurag_pc.shreya2017summer.adpater;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Anurag-PC on 6/12/2017.
 */

public class ScalePagerAdapter extends PagerAdapter {


    private final ArrayList<View> list;

    public ScalePagerAdapter(ArrayList<View> list)
    {
        this.list = list;
    }
    @Override
    public int getCount()
    {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view ==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position), 0);
        return list.get(position);
    }


}
