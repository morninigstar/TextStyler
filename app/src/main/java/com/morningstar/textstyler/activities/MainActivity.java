/*
 * Created by Sujoy Datta. Copyright (c) 2018. All rights reserved.
 *
 * To the person who is reading this..
 * When you finally understand how this works, please do explain it to me too at sujoydatta26@gmail.com
 * P.S.: In case you are planning to use this without mentioning me, you will be met with mean judgemental looks and sarcastic comments.
 */

package com.morningstar.textstyler.activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.morningstar.textstyler.R;
import com.morningstar.textstyler.adapters.CustomRecyclerAdapter;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText editText;
    private RecyclerView recyclerView;

    private ArrayList<Typeface> customFontsList;
    private Typeface typeface;
    private String text = "Random Text";

    private CustomRecyclerAdapter customRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        editText = findViewById(R.id.inputField);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        customFontsList = new ArrayList<>();

        setSupportActionBar(toolbar);

        createFontsList();
        setUpRecycler(text);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                text = editText.getText().toString();
                setUpRecycler(text);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void createFontsList() {
        customFontsList.add(ResourcesCompat.getFont(this, R.font.bitter_mind));
        customFontsList.add(ResourcesCompat.getFont(this, R.font.forgiven_script));
        customFontsList.add(ResourcesCompat.getFont(this, R.font.javelyn));
        customFontsList.add(ResourcesCompat.getFont(this, R.font.nofhistica));
        customFontsList.add(ResourcesCompat.getFont(this, R.font.perfect_christmas));
        customFontsList.add(ResourcesCompat.getFont(this, R.font.stifora));
        customFontsList.add(ResourcesCompat.getFont(this, R.font.valentine));
        customFontsList.add(ResourcesCompat.getFont(this, R.font.wonderful_night));
        customFontsList.add(ResourcesCompat.getFont(this, R.font.bonjour_allegra));
        customFontsList.add(ResourcesCompat.getFont(this, R.font.farisa_dark));
        customFontsList.add(ResourcesCompat.getFont(this, R.font.pumpkin_pie));
        customFontsList.add(ResourcesCompat.getFont(this, R.font.quiche));
        customFontsList.add(ResourcesCompat.getFont(this, R.font.revallyna));
        customFontsList.add(ResourcesCompat.getFont(this, R.font.sandwich));
    }

    private void setUpRecycler(String string) {
        customRecyclerAdapter = new CustomRecyclerAdapter(this, customFontsList, string);
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
