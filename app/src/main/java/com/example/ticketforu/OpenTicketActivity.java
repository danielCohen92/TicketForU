package com.example.ticketforu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.textview.MaterialTextView;

public class OpenTicketActivity extends AppCompatActivity {

    private MaterialTextView details;
    private String ticketD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_ticket);
        findView();

        Intent intent = getIntent();
        ticketD = intent.getStringExtra("ticketDetail");
        details.setText(ticketD);

    }

    @SuppressLint("WrongViewCast")
    private void findView() {

        details = findViewById(R.id.Details_TXT) ;

    }
}