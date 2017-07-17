package com.example.anurag_pc.shreya2017summer;

import android.app.Notification;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Message;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.anurag_pc.shreya2017summer.dialog.CustomDialog;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.onClick;
import static com.example.anurag_pc.shreya2017summer.R.style.dialog;

public class DialogActivity extends BaseActivity {

    private final int DIALOG=12345;


    android.os.Handler mhandler= new android.os.Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case DIALOG:
                    Bundle bundle = msg.getData();
                    String s = bundle.getString("msg");
                    shortToast("Dialog message: " + s);
                    break;
                default:
            }
            super.handleMessage(msg);


        }
    };



        @BindView(R.id.activity_radio_dialog)
    RadioGroup radioGroup;
    private Object which;
    //private int choice;

   // private Reference choices;

    private Object msg;



    private int checkedID=0;
    @OnClick(R.id.activity_dialog_ok)
    public void OK(View view) {
        switch (checkedID) {
            case R.id.rb1:
                normalDialog();
                break;
            case R.id.rb2:
                listDialog();
                break;
            case R.id.rb3:
                singleChoiceDialog();
                break;
            case R.id.rb4:
                multiChoiceDialog();
                break;
            case R.id.rb5:
                waitingDialog();
                break;
            case R.id.rb6:
                progressDialog();
                break;
            case R.id.rb7:
                inputDialog();
                break;
            case R.id.rb8:


                CustomDialog customDialog = new CustomDialog(this, new CustomDialog.ICustomDialogListener() {

                    @Override
                    public void onOKClicked(String msg) {
                        shortToast(msg);

                    }
                });
                customDialog.setCanceledOnTouchOutside(true);
                customDialog.show();
                break;
            default:

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                shortToast("You chose:" + checkedId);
                checkedID = checkedId;

            }
        });
    }

    private void normalDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("AlertTitle");
        builder.setMessage("This is a normal dialog");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shortToast("You clicked Yes");
            }
        });
        builder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shortToast("You clicked Neutral");
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shortToast("You clicked Cancel");
            }
        });

        builder.show();
    }

    private void listDialog() {

        final String[] items = {"item1", "item2", "item3", "item4"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("I am a list dialog");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shortToast("You clicked:" + items[which]);
            }
        });
        builder.show();
    }


    private void inputDialog() {

        final EditText editText = new EditText(this);
        AlertDialog.Builder inputDialog = new AlertDialog.Builder(this);
        inputDialog.setTitle("I am an input dialog").setView(editText);
        inputDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shortToast(editText.getText().toString());
            }
        });
        inputDialog.setNegativeButton("Cancel", null).show();
    }


    //int choice= 2;

    private void progressDialog() {

        final int MAX_PROGRESS = 100;
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setProgress(0);
        progressDialog.setTitle("Downloading");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(MAX_PROGRESS);
        progressDialog.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int progress = 0;

                while (progress < MAX_PROGRESS) {
                    try {
                        Thread.sleep(100);
                        progress++;
                        progressDialog.setProgress(progress);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                Bundle bundle= new Bundle();
                bundle.putString("msg","Download Success");
                Message msg= Message.obtain();
                msg.what=DIALOG;
                msg.setData(bundle);

                mhandler.sendMessage(msg);
                progressDialog.cancel();

            }

        }).start();

    }

    ProgressDialog waitingDialog;

    private void waitingDialog() {
        waitingDialog = new ProgressDialog(this);
        waitingDialog.setTitle("Downloading");
        waitingDialog.setMessage("Waiting..");
        waitingDialog.setCancelable(true);
        waitingDialog.show();
        waitingDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                shortToast("Dialog was cancelled! ");
            }


        });

    }
    ArrayList<Integer> choices= new ArrayList();

    private void multiChoiceDialog()
    {
        final String[] items = {"item1", "item2", "item3", "item4"};
        final boolean initChoiceSets[]={false,true,false,false};
        choices.clear();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("I am a multi choice dialog");
        builder.setMultiChoiceItems(items,initChoiceSets, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked)
                {
                    choices.add(which);
                }else
                {
                    choices.remove(which);
                }
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int size =choices.size();
                String str="";
                for(int i=0;i<size;i++)
                {
                    str += items[choices.get(i)]+" ";
                }
                shortToast("You chose: " + str);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                shortToast("Cancel was clicked ");
            }
        });
        builder.show();
    }
    int choice= 2;

    private void singleChoiceDialog() {
        final String[] items = {"item1", "item2", "item3", "item4"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("I am a single choice dialog");
        builder.setIcon(R.mipmap.ic_launcher);

        builder.setSingleChoiceItems(items, choice, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                choice = which;
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shortToast("You clicked: " + choice);
            }
        });
        builder.show();
    }

}




