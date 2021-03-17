package com.banshion.bmanageapp3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.banshion.bmanageapp3.utils.ToastUtils;

public class IndexActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText m_InputText;
    private WebView m_LineEChart,m_HistogramEChart;
    private LinearLayout m_LineEChartLayout, m_HistogramEChartLayout;
    private TextView m_ThreeMonth,m_ThreeMonthHistogram;
    private TextView m_HalfYear,m_HalfYearHistogram;
    private TextView m_FullYear,m_FullYearHistogram;
    private int m_ThreeMonthClick = 1, m_ThreeMonthHistogramClick = 1;
    private int m_HalfYearClick = 1, m_HalfYearHistogramClick = 1;
    private int m_FullYearClick = 1, m_FullYearHistogramClick = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        TabbarFragment tabbarFragment = new TabbarFragment();
        getFragmentManager().beginTransaction().add(R.id.fl_tab_bar,tabbarFragment).commitAllowingStateLoss();
        m_InputText = findViewById(R.id.search_input);
        m_LineEChartLayout = findViewById(R.id.line_echart_layout);
        m_HistogramEChartLayout = findViewById(R.id.histogram_echart_layout);
        m_ThreeMonth = findViewById(R.id.three_month);
        m_HalfYear = findViewById(R.id.half_year);
        m_FullYear = findViewById(R.id.full_year);
        m_ThreeMonthHistogram = findViewById(R.id.three_month_histogram);
        m_HalfYearHistogram = findViewById(R.id.half_year__histogram);
        m_FullYearHistogram = findViewById(R.id.full_year__histogram);
        Drawable v_SearchImg = getResources().getDrawable(R.drawable.search);
        v_SearchImg.setBounds(0, 0, 20, 20);
        m_InputText.setCompoundDrawables(v_SearchImg, null, null, null);

        m_LineEChart = findViewById(R.id.wv_line_echart);
        m_LineEChart.getSettings().setJavaScriptEnabled(true);
        m_LineEChart.loadUrl("file:///android_asset/index_echarts.html");

        m_HistogramEChart = findViewById(R.id.wv_histogram_echart);
        m_HistogramEChart.getSettings().setJavaScriptEnabled(true);
        m_HistogramEChart.loadUrl("file:///android_asset/histogram_echarts.html");

        m_ThreeMonth.setOnClickListener(this);
        m_HalfYear.setOnClickListener(this);
        m_FullYear.setOnClickListener(this);

        m_ThreeMonthHistogram.setOnClickListener(this);
        m_HalfYearHistogram.setOnClickListener(this);
        m_FullYearHistogram.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.three_month:
                m_HalfYear.setTextColor(Color.parseColor("#77787B"));
                m_HalfYear.setBackground(null);
                m_FullYear.setTextColor(Color.parseColor("#77787B"));
                m_FullYear.setBackground(null);
                m_HalfYearClick = 1;
                m_FullYearClick = 1;
                if (m_ThreeMonthClick % 2 == 0) {
                    m_ThreeMonth.setTextColor(Color.parseColor("#77787B"));
                    m_ThreeMonth.setBackground(null);
                } else {
                    m_ThreeMonth.setTextColor(Color.parseColor("#3D76FB"));
                    m_ThreeMonth.setBackground(getResources().getDrawable(R.drawable.tv_underline_selected));
                }
                m_ThreeMonthClick++;

                break;
            case R.id.half_year:
                m_ThreeMonth.setTextColor(Color.parseColor("#77787B"));
                m_ThreeMonth.setBackground(null);
                m_FullYear.setTextColor(Color.parseColor("#77787B"));
                m_FullYear.setBackground(null);
                m_ThreeMonthClick = 1;
                m_FullYearClick = 1;
                if (m_HalfYearClick % 2 == 0) {
                    m_HalfYear.setTextColor(Color.parseColor("#77787B"));
                    m_HalfYear.setBackground(null);
                } else {
                    m_HalfYear.setTextColor(Color.parseColor("#3D76FB"));
                    m_HalfYear.setBackground(getResources().getDrawable(R.drawable.tv_underline_selected));
                }
                m_HalfYearClick++;
                break;
            case R.id.full_year:
                m_ThreeMonth.setTextColor(Color.parseColor("#77787B"));
                m_ThreeMonth.setBackground(null);
                m_HalfYear.setTextColor(Color.parseColor("#77787B"));
                m_HalfYear.setBackground(null);
                m_ThreeMonthClick = 1;
                m_HalfYearClick = 1;
                if (m_FullYearClick % 2 == 0) {
                    m_FullYear.setTextColor(Color.parseColor("#77787B"));
                    m_FullYear.setBackground(null);
                } else {
                    m_FullYear.setTextColor(Color.parseColor("#3D76FB"));
                    m_FullYear.setBackground(getResources().getDrawable(R.drawable.tv_underline_selected));
                }
                m_FullYearClick++;
                break;
            case R.id.three_month_histogram:
                m_HalfYearHistogram.setTextColor(Color.parseColor("#77787B"));
                m_HalfYearHistogram.setBackground(null);
                m_FullYearHistogram.setTextColor(Color.parseColor("#77787B"));
                m_FullYearHistogram.setBackground(null);
                m_HalfYearHistogramClick = 1;
                m_FullYearHistogramClick = 1;
                if (m_ThreeMonthHistogramClick % 2 == 0) {
                    m_ThreeMonthHistogram.setTextColor(Color.parseColor("#77787B"));
                    m_ThreeMonthHistogram.setBackground(null);
                } else {
                    m_ThreeMonthHistogram.setTextColor(Color.parseColor("#3D76FB"));
                    m_ThreeMonthHistogram.setBackground(getResources().getDrawable(R.drawable.tv_underline_selected));
                }
                m_ThreeMonthHistogramClick++;
                break;
            case R.id.half_year__histogram:
                m_ThreeMonthHistogram.setTextColor(Color.parseColor("#77787B"));
                m_ThreeMonthHistogram.setBackground(null);
                m_FullYearHistogram.setTextColor(Color.parseColor("#77787B"));
                m_FullYearHistogram.setBackground(null);
                m_ThreeMonthHistogramClick = 1;
                m_FullYearHistogramClick = 1;
                if (m_HalfYearHistogramClick % 2 == 0) {
                    m_HalfYearHistogram.setTextColor(Color.parseColor("#77787B"));
                    m_HalfYearHistogram.setBackground(null);
                } else {
                    m_HalfYearHistogram.setTextColor(Color.parseColor("#3D76FB"));
                    m_HalfYearHistogram.setBackground(getResources().getDrawable(R.drawable.tv_underline_selected));
                }
                m_HalfYearHistogramClick++;
                break;
            case R.id.full_year__histogram:
                m_ThreeMonthHistogram.setTextColor(Color.parseColor("#77787B"));
                m_ThreeMonthHistogram.setBackground(null);
                m_HalfYearHistogram.setTextColor(Color.parseColor("#77787B"));
                m_HalfYearHistogram.setBackground(null);
                m_ThreeMonthHistogramClick = 1;
                m_HalfYearHistogramClick = 1;
                if (m_FullYearHistogramClick % 2 == 0) {
                    m_FullYearHistogram.setTextColor(Color.parseColor("#77787B"));
                    m_FullYearHistogram.setBackground(null);
                } else {
                    m_FullYearHistogram.setTextColor(Color.parseColor("#3D76FB"));
                    m_FullYearHistogram.setBackground(getResources().getDrawable(R.drawable.tv_underline_selected));
                }
                m_FullYearHistogramClick++;
                break;
        }
    }
}