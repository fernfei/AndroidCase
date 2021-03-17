package com.banshion.uiwidgettest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.banshion.uiwidgettest.fragment.AnotherRightFragment;
import com.banshion.uiwidgettest.fragment.RightFragment;
import com.banshion.uiwidgettest.recycler.FruitAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private List<Fruit> fruitList = new ArrayList<>();
    private String[] data = {"Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango",
            "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
        replaceFragment(new RightFragment());
//        initFruit();
//        RecyclerView recyclerView = findViewById(R.id.recycle_view);
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(staggeredGridLayoutManager);
//        FruitAdapter fruitAdapter = new com.banshion.uiwidgettest.recycler.FruitAdapter(fruitList);
//        recyclerView.setAdapter(fruitAdapter);
//        ListView listView = findViewById(R.id.list_view);
//        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, data);
//        listView.setAdapter(stringArrayAdapter);
//        FruitAdapter fruitAdapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item, fruitList);
//        listView.setAdapter(fruitAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Fruit fruit = fruitList.get(position);
//                Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    private void initFruit() {
        for (int i = 0; i < data.length; i++) {
            Fruit fruit = new Fruit(data[i], R.drawable.apple_pic);
            fruitList.add(fruit);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                replaceFragment(new AnotherRightFragment());
                break;
        }
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.right_fragment, fragment);
        fragmentTransaction.addToBackStack(null);//addToBackStack()参数用于收一个名字用于描述返回栈的状态，一般传入null
        fragmentTransaction.commit();
    }
}