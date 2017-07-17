package com.example.anurag_pc.shreya2017summer.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.anurag_pc.shreya2017summer.ActivityA;
import com.example.anurag_pc.shreya2017summer.AdvanceListViewActivity;
import com.example.anurag_pc.shreya2017summer.AdvanceViewPagerActivity;
import com.example.anurag_pc.shreya2017summer.AnimationActivity;
import com.example.anurag_pc.shreya2017summer.AnimatorActivity;
import com.example.anurag_pc.shreya2017summer.CheckBoxActivity;
import com.example.anurag_pc.shreya2017summer.DialogActivity;
import com.example.anurag_pc.shreya2017summer.GestureActivity;
import com.example.anurag_pc.shreya2017summer.HandlerActivity;
import com.example.anurag_pc.shreya2017summer.NinePatchActivity;
import com.example.anurag_pc.shreya2017summer.NotificationActivity;
import com.example.anurag_pc.shreya2017summer.Quiz2Activity;
import com.example.anurag_pc.shreya2017summer.R;
import com.example.anurag_pc.shreya2017summer.RadioCheckboxShreyaActivity;
import com.example.anurag_pc.shreya2017summer.RadioGroupActivity;
import com.example.anurag_pc.shreya2017summer.ResultActivity;
import com.example.anurag_pc.shreya2017summer.RunnableHandlerActivity;
import com.example.anurag_pc.shreya2017summer.ScaleTypeActivity;
import com.example.anurag_pc.shreya2017summer.ServiceActivity;
import com.example.anurag_pc.shreya2017summer.SharedPreferenceActivity;
import com.example.anurag_pc.shreya2017summer.TestAudioActivity;
import com.example.anurag_pc.shreya2017summer.ViewPagerActivity;
import com.example.anurag_pc.shreya2017summer.adpater.ListNormalAdapter;
import com.example.anurag_pc.shreya2017summer.audio.BaseBean;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DemoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DemoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private final ArrayList<String> contentList;
    private ListView listView;


    public DemoFragment() {
        contentList= new ArrayList<String>();
        contentList.add("ViewPager");
        contentList.add("ImageScaleType");
        contentList.add("9Patch");
        contentList.add("Notification");
        contentList.add("AdvanceListView");
        contentList.add("AdvanceViewPager");
        contentList.add("LaunchMode");
        contentList.add("ActivityResult");
        contentList.add("RadioGroup");
        contentList.add("CheckBox");
        contentList.add("Dialog");
        contentList.add("Handler");
        contentList.add("Runnable");
        contentList.add("Animation");
        contentList.add("Animator");
        contentList.add("Gesture");
        contentList.add("SharedPreference");
        contentList.add("Service&Broadcast");
        contentList.add("Quiz2");
        contentList.add("TestAudioPlayer");
        contentList.add("AudioPlayer");
        // Required empty public constructor
    }


    public static DemoFragment newInstance(String param1, String param2) {
        DemoFragment fragment = new DemoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_demo, container, false);
        listView= (ListView)view.findViewById(R.id.fragment_demo_lv);
        ListNormalAdapter adapter= new ListNormalAdapter(this.getContext(),contentList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?>parent,View view ,int position,long id)
            {
                switch(position)
                {
                    case 0:
                        Intent intent= new Intent(getActivity(), ViewPagerActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1= new Intent(getActivity(), ScaleTypeActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2= new Intent(getActivity(), NinePatchActivity.class);
                        startActivity(intent2);
                        break;

                    case 3:
                        Intent intent3= new Intent(getActivity(), NotificationActivity.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4=  new Intent(getActivity(), AdvanceListViewActivity.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5=  new Intent(getActivity(), AdvanceViewPagerActivity.class);
                        startActivity(intent5);
                        break;

                    case 6:
                        Intent intent6=  new Intent(getActivity(), ActivityA.class);
                        intent6.putExtra("key","fromDemoFragment");     // with this we can passs info
                        intent6.putExtra("IntegerInfo",10);
                        Bundle bundle = new Bundle(); //its like package info can go directly from a>b>c>d from main once that's not possible in intent
                        BaseBean bean= new BaseBean();//bundle can carry obj intent can't
                        bean.setName("bean");
                        bundle.putString("StringBundle","FromBundleDemo");
                        bundle.putInt("IntBundle",101);
                        bundle.putSerializable("Object",bean);
                        intent6.putExtra("Bundle",bundle);//
                        startActivity(intent6);
                        break;

                    case 7:
                        Intent intent7= new Intent(getActivity(), ResultActivity.class);
                        startActivity(intent7);
                        break;
                    case 8:
                        Intent intent8= new Intent(getActivity(), RadioGroupActivity.class);
                        startActivity(intent8);
                        break;
                    case 9:
                        Intent intent9= new Intent(getActivity(), CheckBoxActivity.class);
                        startActivity(intent9);
                        break;
                    case 10:
                        Intent intent10= new Intent(getActivity(), DialogActivity.class);
                        startActivity(intent10);
                        break;
                    case 11:
                        Intent intent11= new Intent(getActivity(), HandlerActivity.class);
                        startActivity(intent11);
                        break;
                    case 12:
                        Intent intent12= new Intent(getActivity(), RunnableHandlerActivity.class);
                        startActivity(intent12);
                        break;
                    case 13:
                        Intent intent13= new Intent(getActivity(), AnimationActivity.class);
                        startActivity(intent13);
                        break;
                    case 14:
                        Intent intent14= new Intent(getActivity(), AnimatorActivity.class);
                        startActivity(intent14);
                        break;
                    case 15:
                        Intent intent15= new Intent(getActivity(), GestureActivity.class);
                        startActivity(intent15);
                        break;
                    case 16:
                        Intent intent16= new Intent(getActivity(), SharedPreferenceActivity.class);
                        startActivity(intent16);
                        break;
                    case 17:
                        Intent intent17= new Intent(getActivity(), ServiceActivity.class);
                        startActivity(intent17);
                        break;
                    case 18:
                        Intent intent18= new Intent(getActivity(), Quiz2Activity.class);
                        startActivity(intent18);
                        break;
                    case 19:
                        Intent intent19= new Intent(getActivity(), TestAudioActivity.class);
                        startActivity(intent19);
                        break;
                    case 20:
                        Intent intent20= new Intent(getActivity(), Quiz2Activity.class);
                        startActivity(intent20);
                        break;

                    default:

                }
            }
        });

        return view;
    }


}

