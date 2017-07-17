package com.example.anurag_pc.shreya2017summer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.anurag_pc.shreya2017summer.dialog.QuizCustomDialog;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Quiz1Activity extends BaseActivity {

    @OnClick(R.id.quiz1)
    public void quiz1(View view)
    {

    }
    @OnClick(R.id.button_submit)
    public void submit(View view)
    {
        Intent intent= new Intent(Quiz1Activity.this, Quiz5Activity.class);
        startActivity(intent);
    }


    @OnClick(R.id.quiz2)
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);
        ButterKnife.bind(this);
    }
}
