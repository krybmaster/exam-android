package com.ryb.konst.exam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayMessageActivity extends AppCompatActivity {

    private static final String TAG = "myLogs";

    TextView txtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String sLogin = intent.getStringExtra("Name");

        // Создаем текстовое поле
        txtLogin = (TextView) findViewById(R.id.txtLogin);
        txtLogin.setText(sLogin);
        Toast.makeText(this, sLogin, Toast.LENGTH_LONG).show();

    }
}
