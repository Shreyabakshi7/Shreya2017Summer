package com.example.anurag_pc.shreya2017summer;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.id.list;

public class RadioCheckboxShreyaActivity extends BaseActivity {
    private int checkedID;
    private HashMap<String, Boolean> list = new HashMap<String, Boolean>();

    @BindView(R.id.shreya_check_box_1)
    CheckBox checkbox1;

    @BindView(R.id.shreya_check_box_2)
    CheckBox checkbox2;

    @BindView(R.id.shreya_radio_group)
    RadioGroup radioGroup;

    @OnClick(R.id.shreya_submit)
    public void submit(View view)
    {
        shortToast("You chose RadioButton:"+checkedID);


        String s = "You checked: ";
        for (Map.Entry<String, Boolean> entry : list.entrySet()) {
            if (entry.getValue()) {
                s = s + "" + entry.getKey();
            }
        }
        shortToast(s);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_checkbox_shreya);
        ButterKnife.bind(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                checkedID=checkedId;
            }
        });

        checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(),isChecked);
            }
        });
        checkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(), isChecked);
            }
        });
    }
}
