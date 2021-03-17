package com.banshion.bmanageapp3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText m_InputText;
    private TextView m_TvMarket,m_TvWarehouse,m_TvLogistics,m_TvHr, m_TvFinance, m_TvUser;
    private TextView m_TvTemp;//当前被选中的对象
    private int m_MenuDefaultImage;
    private LinearLayout m_Function,m_Function2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        m_InputText = findViewById(R.id.search_input);
        m_TvMarket = findViewById(R.id.tv_market);
        m_TvWarehouse = findViewById(R.id.tv_warehouse);
        m_TvLogistics = findViewById(R.id.tv_logistics);
        m_TvHr = findViewById(R.id.tv_hr);
        m_TvFinance = findViewById(R.id.tv_finance);
        m_TvUser = findViewById(R.id.tv_user);
        m_Function = findViewById(R.id.ll_function);
        m_Function2 = findViewById(R.id.ll_function2);

        setDrawableImage(m_InputText, getResources().getDrawable(R.drawable.search), 20, 20, 1);

        TabbarFragment tabbarFragment = new TabbarFragment();
        getFragmentManager().beginTransaction().add(R.id.fl_tab_bar,tabbarFragment).commitAllowingStateLoss();

        setDrawableImage(m_TvMarket, getResources().getDrawable(R.drawable.market_black), 20, 20, 1);
        setDrawableImage(m_TvWarehouse, getResources().getDrawable(R.drawable.warehouse_grey), 20, 18, 1);
        setDrawableImage(m_TvLogistics, getResources().getDrawable(R.drawable.logistics_grey), 20, 18, 1);
        setDrawableImage(m_TvHr, getResources().getDrawable(R.drawable.hr_grey), 20, 20, 1);
        setDrawableImage(m_TvFinance, getResources().getDrawable(R.drawable.finance_grey), 20, 20, 1);
        setDrawableImage(m_TvUser, getResources().getDrawable(R.drawable.user_grey), 20, 20, 1);

        m_TvTemp = m_TvMarket;//默认选中
        m_MenuDefaultImage = R.drawable.market_grey;

        m_TvMarket.setOnClickListener(this);
        m_TvWarehouse.setOnClickListener(this);
        m_TvLogistics.setOnClickListener(this);
        m_TvHr.setOnClickListener(this);
        m_TvFinance.setOnClickListener(this);
        m_TvUser.setOnClickListener(this);
        m_Function.setOnClickListener(this);
        m_Function2.setOnClickListener(this);
    }

    /**
     *
     * @param textView TextView
     * @param drawable Drawable
     * @param width drawable width
     * @param height drawable height
     * @param pos 1 left 2 right 3 top 4 bottom
     */
    public void setDrawableImage(TextView textView, Drawable drawable, int width, int height, int pos) {
        drawable.setBounds(0, 0, width, height);
        if (pos == 1)
            textView.setCompoundDrawables(drawable, null, null, null);
        else if(pos == 2)
            textView.setCompoundDrawables(null, null, drawable, null);
        else if(pos == 3)
            textView.setCompoundDrawables(null, drawable, null, null);
        else
            textView.setCompoundDrawables(null, null, null, drawable);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_market:
                recoverMenu();
                m_TvMarket.setBackgroundColor(getResources().getColor(R.color.white));
                m_TvMarket.setTextColor(getResources().getColor(R.color.black));
                setDrawableImage(m_TvMarket, getResources().getDrawable(R.drawable.market_black), 20, 20, 1);
                m_TvTemp = m_TvMarket;
                m_MenuDefaultImage=R.drawable.market_grey;
                break;
            case R.id.tv_warehouse:
                recoverMenu();
                m_TvWarehouse.setBackgroundColor(getResources().getColor(R.color.white));
                m_TvWarehouse.setTextColor(getResources().getColor(R.color.black));
                setDrawableImage(m_TvWarehouse, getResources().getDrawable(R.drawable.warehouse_black), 20, 20, 1);
                m_TvTemp = m_TvWarehouse;
                m_MenuDefaultImage=R.drawable.warehouse_grey;
                break;
            case R.id.tv_logistics:
                recoverMenu();
                m_TvLogistics.setBackgroundColor(getResources().getColor(R.color.white));
                m_TvLogistics.setTextColor(getResources().getColor(R.color.black));
                setDrawableImage(m_TvLogistics, getResources().getDrawable(R.drawable.logistics_black), 20, 20, 1);
                m_TvTemp = m_TvLogistics;
                m_MenuDefaultImage=R.drawable.logistics_grey;
                break;
            case R.id.tv_hr:
                recoverMenu();
                m_TvHr.setBackgroundColor(getResources().getColor(R.color.white));
                m_TvHr.setTextColor(getResources().getColor(R.color.black));
                setDrawableImage(m_TvHr, getResources().getDrawable(R.drawable.hr_black), 20, 20, 1);
                m_TvTemp = m_TvHr;
                m_MenuDefaultImage=R.drawable.hr_grey;
                break;
            case R.id.tv_finance:
                recoverMenu();
                m_TvFinance.setBackgroundColor(getResources().getColor(R.color.white));
                m_TvFinance.setTextColor(getResources().getColor(R.color.black));
                setDrawableImage(m_TvFinance, getResources().getDrawable(R.drawable.finance_black), 20, 20, 1);
                m_TvTemp = m_TvFinance;
                m_MenuDefaultImage=R.drawable.finance_grey;
                break;
            case R.id.tv_user:
                recoverMenu();
                m_TvUser.setBackgroundColor(getResources().getColor(R.color.white));
                m_TvUser.setTextColor(getResources().getColor(R.color.black));
                setDrawableImage(m_TvUser, getResources().getDrawable(R.drawable.user_black), 20, 20, 1);
                m_TvTemp = m_TvUser;
                m_MenuDefaultImage=R.drawable.user_grey;
                break;
            case R.id.ll_function:
                startActivity(new Intent(MenuActivity.this, FinanceActivity.class));
                break;
            case R.id.ll_function2:
//                startActivity(new Intent(MenuActivity.this, QueryActivity.class));
                break;
        }
    }

    public void recoverMenu() {
        if (null != m_TvTemp && m_MenuDefaultImage != 0) {
            m_TvTemp.setBackgroundColor(getResources().getColor(R.color.menu_bg_grey));
            m_TvTemp.setTextColor(getResources().getColor(R.color.menu_text_grey));
            setDrawableImage(m_TvTemp, getResources().getDrawable(m_MenuDefaultImage), 20, 20, 1);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}