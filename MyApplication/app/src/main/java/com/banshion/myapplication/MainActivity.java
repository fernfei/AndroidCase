package com.banshion.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
//    keytool -import -file ‪E:\aliyun.cer -keystore "D:\installed\AnbroidStudio\jre\jre\lib\security\cacerts" -alias asAliyunGradle
//    keytool -import -file ‪E:\gradle_services.cer -keystore "D:\installed\AnbroidStudio\jre\jre\lib\security\cacerts" -alias asGradleServices
//keytool -list -keystore cacerts -alias vbooking
    //keytool -list -v -alias aurora -keystore "C:\Program Files\Java\jdk1.8.0_201\jre\lib\security\cacerts" -storepass changeit
//keytool -list -v -alias asAliyunGradle -keystore "D:\installed\AnbroidStudio\jre\jre\lib\security\cacerts" -storepass changeit
//keytool -list -v -alias asGradleServices -keystore "D:\installed\AnbroidStudio\jre\jre\lib\security\cacerts" -storepass changeit
    keytool -list -keystore asAliyunGradle -storepass changeit
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}