package com.ryb.konst.exam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText edtLogin;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initDB();

        btnLogin = (Button) findViewById(R.id.btnLogin);
        edtLogin = (EditText) findViewById(R.id.edtLogin);
    }

    public void login() {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        name = edtLogin.getText().toString();
        intent.putExtra("Name", name);
        startActivity(intent);
    }

    public void initDB()  {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
    }

    public void btnLoginClick(View view) {
        login();
    }
}
