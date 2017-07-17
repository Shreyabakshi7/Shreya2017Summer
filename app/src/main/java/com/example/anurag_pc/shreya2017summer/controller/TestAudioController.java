package com.example.anurag_pc.shreya2017summer.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.example.anurag_pc.shreya2017summer.ServiceActivity;
import com.example.anurag_pc.shreya2017summer.service.TestService;
import com.example.anurag_pc.shreya2017summer.util.UtilLog;

/**
 * Created by Anurag-PC on 7/5/2017.
 */

public class TestAudioController {
    public final static int AudioPlaying = 111;
    public final static int AudioLoading = 222;
    public final static int AudioPaused= 333;
    
    public static int STATUS = AudioPaused;
    private  TestAudioReceiver testAudioReceiver;
    private  Context context;
    private AudioListener listener;

    public TestAudioController(Context context,AudioListener listener) {
        this.context= context;
        this.listener= listener;
        
    }

    public  void play(String url) {
        Intent intent= new Intent(context, TestService.class);
        intent.setAction("AUDIO");
        intent.putExtra("URL",url);
        context.startActivity(intent);
        initReceiver();
    }

    private  void initReceiver() {
        testAudioReceiver= new TestAudioReceiver();
        IntentFilter filter= new IntentFilter();
        filter.addAction(TestService.AUDIO);
        context.registerReceiver(testAudioReceiver,filter);

    }

    public void pause() {
        Intent intent= new Intent(context, TestService.class);
        intent.setAction("AUDIO");
        intent.putExtra("CMD",TestService.PAUSE);
        //intent.putExtra("URL",url);
        context.startActivity(intent);
        initReceiver();
    }

    public interface AudioListener{
        public void onPlaying();
         public void onLoading();
         public void onPaused();
        //public void onCancleClicked();
    }
    
    
    public class TestAudioReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(TestService.AUDIO)) {
                int msg = intent.getIntExtra("MSG", 0);
                switch (msg){
                    case TestService.PLAYING:
                    STATUS= AudioPlaying;
                        listener.onPlaying();
                        UtilLog.d("AUDIO","Playing");
                        break;
                    case TestService.LOADING:
                        STATUS= AudioLoading;
                        listener.onLoading();
                        UtilLog.d("AUDIO","Loading");
                        break;

                    case TestService.PAUSED:
                        STATUS= AudioPaused;
                        listener.onPaused();
                        UtilLog.d("AUDIO","Paused");
                        break;


                }
            }
            }
        }
}
