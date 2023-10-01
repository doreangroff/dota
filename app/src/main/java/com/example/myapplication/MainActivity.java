package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.entity.User;
import com.example.myapplication.fragments.FirstFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> users = new ArrayList<User>();
    ListView usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_fragment, new FirstFragment(), "first_fragment")
                .commit();
    }


}

