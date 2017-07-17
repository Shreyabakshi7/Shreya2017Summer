package com.example.anurag_pc.shreya2017summer.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.example.anurag_pc.shreya2017summer.Quiz2Activity;
import com.example.anurag_pc.shreya2017summer.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Anurag-PC on 6/21/2017.
 */

public class CustomDialog extends Dialog {



    private final ICustomDialogListener listener;

    public interface ICustomDialogListener{
        public void onOKClicked(String msg);
        //public void onCancleClicked();
    }

    @OnClick(R.id.dialog_custom_ok)
    public void ok(View view)
    {
        listener.onOKClicked("You clicked OK");
        cancel();
    }

    public CustomDialog(@NonNull Context context,ICustomDialogListener listener) {
        super(context,R.style.dialog);
        setContentView(R.layout.dialog_custom);
        //setContentView(R.layout.activity_quiz2);
        ButterKnife.bind(this);
        this.listener=listener;

    }


}
