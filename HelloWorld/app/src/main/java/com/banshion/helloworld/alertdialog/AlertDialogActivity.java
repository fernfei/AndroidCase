package com.banshion.helloworld.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.banshion.helloworld.R;
import com.banshion.helloworld.utils.ToastUtil;

public class AlertDialogActivity extends AppCompatActivity {

    private Button btn1,btn2,btn3, btn4, btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        OnClick onClick = new OnClick();
        btn1.setOnClickListener(onClick);
        btn2.setOnClickListener(onClick);
        btn3.setOnClickListener(onClick);
        btn4.setOnClickListener(onClick);
        btn5.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder.setTitle("请回答").setMessage("敢不敢和我比划比划？").setIcon(R.drawable.success)
                            //肯定的按钮
                            .setPositiveButton("我让你见识见识什么叫黑手！", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(AlertDialogActivity.this, "👴");
                                }
                                //中立按钮
                            }).setNeutralButton("三天之内撒了你！", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(AlertDialogActivity.this, "Who else could you be?");
                        }
                        //否定按钮
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(AlertDialogActivity.this, "👊👴👊");
                        }
                    }).show();
                    break;
                case R.id.btn2:
                    String[] gender = new String[]{"男", "女"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder2.setTitle("选择性别").setItems(gender, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(AlertDialogActivity.this, gender[which]);
                        }
                    }).show();
                    break;
                case R.id.btn3:
                    String[] gender2 = new String[]{"男", "女"};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder3.setSingleChoiceItems(gender2, 1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(AlertDialogActivity.this, gender2[which]);
                            dialog.dismiss();
                        }
                    }).setCancelable(false).show();
                    break;
                case R.id.btn4:
                    String[] gender4 = new String[]{"SING", "DANCE","RAP","BASKETBALL"};
                    boolean[] isSelected = new boolean[]{false, false, true, false};
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder4.setTitle("选择兴趣").setMultiChoiceItems(gender4, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            ToastUtil.showMsg(AlertDialogActivity.this, gender4[which] + ":" + isChecked);
                        }
                    }).show();
                    break;
                case R.id.btn5:

                    AlertDialog.Builder builder5 = new AlertDialog.Builder(AlertDialogActivity.this);
                    LayoutInflater from = LayoutInflater.from(AlertDialogActivity.this);
                    View view = from.inflate(R.layout.layout_dialog, null);
                    EditText userName = view.findViewById(R.id.UserName);
                    EditText password = view.findViewById(R.id.Password);
                    Button login = view.findViewById(R.id.Login);
                    login.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ToastUtil.showMsg(AlertDialogActivity.this, "登陆成功");
                        }
                    });
                    builder5.setTitle("请先登录").setView(view).show();
                    break;
            }
        }
    }

}