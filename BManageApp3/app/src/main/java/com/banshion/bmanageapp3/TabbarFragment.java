package com.banshion.bmanageapp3;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TabbarFragment extends Fragment implements View.OnClickListener {

    private RelativeLayout m_IndexBtn, m_MenuBtn,m_MeBtn;
    private ImageView m_IndexIcon,m_MenuIcon, m_MeIcon;
    private TextView m_IndexText,m_MenuText, m_MeText;
    private int indexClick = 0;
    private int menuClick = 0;
    private int meClick = 0;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tabbar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        m_IndexBtn = view.findViewById(R.id.index_btn);
        m_MenuBtn = view.findViewById(R.id.menu_btn);
        m_MeBtn = view.findViewById(R.id.me_btn);

        m_IndexIcon = view.findViewById(R.id.index_icon);
        m_MenuIcon = view.findViewById(R.id.menu_icon);
        m_MeIcon = view.findViewById(R.id.me_icon);

        m_IndexText = view.findViewById(R.id.index_text);
        m_MenuText = view.findViewById(R.id.menu_text);
        m_MeText = view.findViewById(R.id.me_text);

        m_IndexBtn.setOnClickListener(this);
        m_MenuBtn.setOnClickListener(this);
        m_MeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.index_btn:
                if (indexClick % 2 != 0) {
                    m_IndexIcon.setImageResource(R.drawable.index_unselected);
                    m_IndexText.setTextColor(getResources().getColor(R.color.grey));
                } else {
                    m_IndexIcon.setImageResource(R.drawable.index_selected);
                    m_IndexText.setTextColor(getResources().getColor(R.color.blue));
                }
                startActivity(new Intent(getActivity(), IndexActivity.class));
                indexClick++;
                break;
            case R.id.menu_btn:
                if (menuClick % 2 != 0) {
                    m_MenuIcon.setImageResource(R.drawable.menu_unselected);
                    m_MenuText.setTextColor(getResources().getColor(R.color.grey));
                } else {
                    m_MenuIcon.setImageResource(R.drawable.menu_selected);
                    m_MenuText.setTextColor(getResources().getColor(R.color.blue));
                }
                startActivity(new Intent(getActivity(), MenuActivity.class));
                menuClick++;
                break;
            case R.id.me_btn:
                if (meClick % 2 != 0) {
                    m_MeIcon.setImageResource(R.drawable.me_unselected);
                    m_MeText.setTextColor(getResources().getColor(R.color.grey));
                } else {
                    m_MeIcon.setImageResource(R.drawable.me_selected);
                    m_MeText.setTextColor(getResources().getColor(R.color.blue));
                }
                meClick++;
                break;
        }
    }
}
