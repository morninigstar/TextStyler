/*
 * Created by Sujoy Datta. Copyright (c) 2018. All rights reserved.
 *
 * To the person who is reading this..
 * When you finally understand how this works, please do explain it to me too at sujoydatta26@gmail.com
 * P.S.: In case you are planning to use this without mentioning me, you will be met with mean judgemental looks and sarcastic comments.
 */

package com.morningstar.textstyler.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.morningstar.textstyler.R;
import com.morningstar.textstyler.adapters.CustomRecyclerAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText editText;
    private RecyclerView recyclerView;

    private CustomRecyclerAdapter customRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        editText = findViewById(R.id.inputField);
        recyclerView = findViewById(R.id.recyclerView);

        setSupportActionBar(toolbar);

        setUpRecycler();
    }

    private void setUpRecycler() {
        customRecyclerAdapter = new CustomRecyclerAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(customRecyclerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_rate:
                Toast.makeText(this, "Rate App", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_share:
                Toast.makeText(this, "Share App", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_toggle:
                Toast.makeText(this, "Toggle Mode", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}
