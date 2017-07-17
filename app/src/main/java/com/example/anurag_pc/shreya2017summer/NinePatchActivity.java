package com.example.anurag_pc.shreya2017summer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by Anurag-PC on 6/18/2017.
 */

public class NinePatchActivity extends AppCompatActivity {
    private ImageView iv1,iv2;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nine_patch);
        iv1 = (ImageView) findViewById(R.id.draw);
        iv2 = (ImageView) findViewById(R.id.mip);
    }
}
