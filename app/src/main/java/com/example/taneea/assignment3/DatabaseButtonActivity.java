package com.example.taneea.assignment3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DatabaseButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_button);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        FloatingActionButton delete = (FloatingActionButton) findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseDelete();
            }
        });
        FloatingActionButton edit = (FloatingActionButton) findViewById(R.id.update);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseUpdate();
            }
        });
        FloatingActionButton list = (FloatingActionButton) findViewById(R.id.list);
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseView();
            }
        });
        FloatingActionButton back = (FloatingActionButton) findViewById(R.id.back);
    }

    public void databaseDelete() {
        Intent intent = new Intent(this, DeleteActivity.class);
        startActivity(intent);
        setContentView(R.layout.activity_delete);
    }

    public void databaseView() {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
        setContentView(R.layout.activity_list);
    }

    public void databaseUpdate() {
        Intent intent = new Intent(this, UpdateActivity.class);
        startActivity(intent);
        setContentView(R.layout.activity_update);
    }

    public void backPress() {
        Intent intent = new Intent(this, InteractDBActivity.class);
        startActivity(intent);
        setContentView(R.layout.activity_interact_db);
    }

}
