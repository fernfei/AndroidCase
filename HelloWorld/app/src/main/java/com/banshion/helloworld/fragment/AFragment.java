package com.banshion.helloworld.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.banshion.helloworld.R;

public class AFragment extends Fragment {

    private TextView m_TvTitle;
    private Button btn1, btn2, btn3;
    private Activity activity;
    private BFragment bFragment;
    private IOnSendMessage onSendMessage;

    public static AFragment newInstance(String title) {
        AFragment aFragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        aFragment.setArguments(bundle);
        return aFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        m_TvTitle = view.findViewById(R.id.tv_title);
        btn1 = view.findViewById(R.id.btn_change);
        btn2 = view.findViewById(R.id.change_text);
        btn3 = view.findViewById(R.id.btn_chuandi);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null == bFragment) {
                    bFragment = new BFragment();
                }
                Fragment fragment = getFragmentManager().findFragmentByTag("a");
                //.addToBackStack(null)可以返回回去
                if (fragment != null) {
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
                } else {
                    getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fl_container, bFragment).commitAllowingStateLoss();
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_TvTitle.setText("我是新文字");
            }

        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != getActivity()) {
                    //todo
//                    ContainerActivity containerActivity = ((ContainerActivity) getActivity());
//                    containerActivity.senData("你好，我是传递的数据！");
                    onSendMessage.sandData("我是实现接口的方式传递数据哦！");
                }
            }
        });
        if (null != getArguments()) {
            m_TvTitle.setText(getArguments().getString("title"));
        }

    }

    /**
     * 当fragment和activity建立关系时调用这个方法
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onSendMessage = ((ContainerActivity) context);
        } catch (ClassCastException classCastException) {
            throw new ClassCastException("类型转换异常！");
        }
    }

    /**
     * 当getActivity()为null
     * 当fragment和activity解除关系时调用这个方法
     * 执行这个方法
     */
    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //取消异步
    }

    public interface IOnSendMessage {
        void sandData(String text);
    }
}
