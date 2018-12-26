package com.ryb.konst.exam;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DisplayMessageActivity extends AppCompatActivity {

    private static final String TAG = "myLogs";

    TextView txtLogin;

    List<Theme> q = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String sLogin = intent.getStringExtra("Name");

        // Создаем текстовое поле
        txtLogin = (TextView) findViewById(R.id.txtLogin);
        txtLogin.setText(sLogin);



        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.themes);
        // создаем адаптер
        DataAdapter adapter = new DataAdapter(this, q);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);

        FirebaseFirestore db = FirebaseFirestore.getInstance();



        db.collection("quiz").document("3BG0zYwsre22ES0Zzn32").collection("questions")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getString("text"));  //getData().values());
                                q.add(new Theme(document.getString("text")));
                            }
                            System.out.println("array" + q);
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });

    }
}
