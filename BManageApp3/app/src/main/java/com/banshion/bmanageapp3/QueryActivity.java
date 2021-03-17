//package com.banshion.bmanageapp3;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.graphics.Color;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.bigkoo.pickerview.builder.TimePickerBuilder;
//import com.bigkoo.pickerview.listener.OnTimeSelectListener;
//import com.bigkoo.pickerview.view.TimePickerView;
//import com.contrarywind.view.WheelView;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class QueryActivity extends AppCompatActivity implements View.OnClickListener{
//
//    private RelativeLayout m_RlClose;
//    private WheelView wheelView;
//    private TextView m_TvInStartTime, m_TvInEndTime;
//    private RelativeLayout m_RlStarTime, m_RLEndTime;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_query);
//        m_RlClose = findViewById(R.id.rl_close);
//        wheelView = findViewById(R.id.wheelview);
//        m_RlClose.setOnClickListener(this);
//        m_TvInStartTime = findViewById(R.id.in_start_time);
//        m_TvInEndTime = findViewById(R.id.in_end_time);
//        m_RlStarTime = findViewById(R.id.rl_start_time);
//        m_RLEndTime = findViewById(R.id.rl_end_time);
//
//        m_RlStarTime.setOnClickListener(this);
//        m_RLEndTime.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.rl_close:
//                finish();
//                break;
//            case R.id.rl_start_time:
//            //时间选择器
//                TimePickerView pvTime1 = new TimePickerBuilder(QueryActivity.this, new OnTimeSelectListener() {
//                    @Override
//                    public void onTimeSelect(Date date, View v) {
//                        m_TvInStartTime.setText(getTime(date));
//                    }
//                })
//                        .setLabel("年", "月", "日", null, null, null)//默认设置为年月日时分秒
//                        .build();
//                pvTime1.show();
//                break;
//            case R.id.rl_end_time:
//                //时间选择器
//                TimePickerView pvTime2 = new TimePickerBuilder(QueryActivity.this, new OnTimeSelectListener() {
//                    @Override
//                    public void onTimeSelect(Date date, View v) {
//                        m_TvInEndTime.setText(getTime(date));
//                    }
//                })
//                        .setLabel("年", "月", "日", null, null, null)//默认设置为年月日时分秒
//                        .build();
//                pvTime2.show();
//                break;
//        }
//    }
//
//    public String getTime(Date date) {
//        return new SimpleDateFormat("yyyy-MM-dd").format(date);
//    }
//}
//
//
