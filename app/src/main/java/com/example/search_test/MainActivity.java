package com.example.search_test;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SearchView searchView;
    ListView mylistView;

    ArrayList<String> arrayList;
    ArrayAdapter <String> adapter;

    @SuppressLint({"WrongViewCast", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        searchView=findViewById(R.id.listView);
        mylistView=findViewById(R.id.listView);

        mylistView.setVisibility(View.GONE);

        arrayList= new ArrayList <> ();
        arrayList.add("Monday");
        arrayList.add("Tuesday");
        arrayList.add("Wednesday");
        arrayList.add("Thursday");
        arrayList.add("Friday");
        arrayList.add("Saturday");
        arrayList.add("Sunday");

        adapter =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);

        mylistView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                mylistView.setVisibility(View.VISIBLE);
                adapter.getFilter().filter(s );
                return false;
            }
        });




    }
}