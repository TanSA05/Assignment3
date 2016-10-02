package com.example.taneea.assignment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SuccessActivity extends AppCompatActivity {

    private static final String TAG = "Yo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
    }

    public void backPress(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        setContentView(R.layout.activity_login);
    }
}
