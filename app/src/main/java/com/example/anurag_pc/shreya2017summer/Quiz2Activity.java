package com.example.anurag_pc.shreya2017summer;

import android.os.Bundle;
import android.view.View;

//import com.example.anurag_pc.shreya2017summer.dialog.CustomDialog;
import com.example.anurag_pc.shreya2017summer.dialog.CustomDialog;
import com.example.anurag_pc.shreya2017summer.dialog.QuizCustomDialog;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Quiz2Activity extends BaseActivity {


    private android.content.Context context;

    @OnClick(R.id.quiz2_main)
    public void ok(View view) {
        QuizCustomDialog quizcustomDialog = new QuizCustomDialog(this, new QuizCustomDialog.ICustomDialogListener() {

            @Override
            public void onOKClicked(String msg) {
                shortToast(msg);

            }

            @Override
            public void onCancelClicked() {
                onCancelClicked();
            }
        });
        quizcustomDialog.setCanceledOnTouchOutside(true);
        quizcustomDialog.show();
    }

//        final Dialog dialog = new Dialog(context);
//        dialog.setContentView(R.layout.activity_quiz2);
//        //dialog.setTitle("Title...");
//
//        TextView text = (TextView) dialog.findViewById(R.id.dialog_quiz2_tv);
//
//        RadioGroup radioGroup = (RadioGroup) dialog.findViewById(R.id.activity_quiz2_radio_group);
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            public int checkedID;
//
//            @Override
//            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
//                checkedID = checkedId;
//
//            }
//        });
//
//
//        Button okdialog = (Button) dialog.findViewById(R.id.activity_quiz2_ok);
//        okdialog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog.dismiss();
//                shortToast("You clicked OK");
//            }
//        });
//        Button canceldialog = (Button) dialog.findViewById(R.id.activity_quiz2_cancel);
//        canceldialog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//                //shortToast("You clicked OK");
//            }
//        });
//
//        dialog.show();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz2_main);
        ButterKnife.bind(this);

    }
}


