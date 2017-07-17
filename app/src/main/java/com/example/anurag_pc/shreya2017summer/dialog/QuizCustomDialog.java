package com.example.anurag_pc.shreya2017summer.dialog;

import android.app.Dialog;
import android.content.Context;
import android.provider.Settings;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.anurag_pc.shreya2017summer.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Anurag-PC on 7/3/2017.
 */

public class QuizCustomDialog extends Dialog {

    private final ICustomDialogListener listener;
    private int checkedID;

    public interface ICustomDialogListener {
        public void onOKClicked(String msg);
        public void onCancelClicked();

    }
    @OnClick(R.id.activity_quiz2_ok)
    public void OK(View view) {
        switch (checkedID) {
            case R.id.yes:
                listener.onOKClicked("YES");
                break;
            case R.id.no:
                listener.onOKClicked("NO");
                break;

                //System.close(0);
                default:
        }


        //listener.onOKClicked("You clicked OK from QuizDialog");
        cancel();
    }
    @OnClick(R.id.activity_quiz2_cancel)
    public void cancel(View view) {

        //listener.onOKClicked("You clicked OK");
        cancel();
    }


    @BindView(R.id.activity_quiz2_radio_group)
    RadioGroup radioGroup;

    @OnClick(R.id.yes)
    public void yes(View view) {
       // listener.onOKClicked("Yes");
       // cancel();
    }

    @OnClick(R.id.no)
    public void no(View view) {
        //listener.onOKClicked("No");
        // cancel();
    }
    @OnClick(R.id.exit)
    public void exit(View view) {
        System.exit(0);
        //listener.onOKClicked("Exit");
        // cancel();
    }



//    @BindView(R.id.dialog_quiz2_tv)
//    TextView textView;
//    private int checkedID;

    public QuizCustomDialog(@NonNull Context context, ICustomDialogListener listener) {
        super(context, R.style.dialog);
        setContentView(R.layout.activity_quiz2);
        ButterKnife.bind(this);
        this.listener =  listener;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                checkedID=checkedId;

            }
        });
    }
}
