package com.example.ticketforu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.ticketforu.Models.Ticket;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button BuyTicket;
    private Button SellTicket;
    private Button PopMeATicket;
    private Button ExitBtn;

    private HashMap <String, Ticket> ticketsMap = new HashMap <>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        StartApp();
    }

    private void StartApp() {
        // Write a message to the database


        //FireBase - Upload Data
        //UploadTickets();




        BuyTicket.setOnClickListener(view -> {
            OpenActivity(1);

        });
        SellTicket.setOnClickListener(view -> {
            OpenActivity(2);
        });

        PopMeATicket.setOnClickListener(view -> {
            OpenActivity(3);
        });

        ExitBtn.setOnClickListener(view -> {
            finishAffinity();

        });

    }

    private void UploadTickets() {

        ticketsMap.put ("P0001", new Ticket()
                .setKey("P0001")
                .setNameOfArtist("Hadar Geva Fashion Week")
                .setCity("Tel Aviv")
                .setPhoneNumber("0504400163")
                .setDate("19/11/2023")
                .setKindOfShow(0) //standUp
                .setNumOfRow(0)
                .setPrice(450));

        ticketsMap.put ("P0002", new Ticket()
                .setKey("P0002")
                .setNameOfArtist("Kobi Maymon")
                .setCity("Haifa")
                .setPhoneNumber("0528757867")
                .setDate("30/08/2023")
                .setNumOfRow(7)
                .setKindOfShow(2) //standUp
                .setPrice(170));

        ticketsMap.put ("P0003", new Ticket()
                .setKey("P0003")
                .setNameOfArtist("Lital Shvartz")
                .setCity("Ashdod")
                .setPhoneNumber("0527748825")
                .setDate("01/09/2023")
                .setNumOfRow(14)
                .setKindOfShow(2) //standUp
                .setPrice(130));

        ticketsMap.put ("P0004", new Ticket()
                .setKey("P0004")
                .setNameOfArtist("Eyal Golan")
                .setCity("Ashdod")
                .setPhoneNumber("0527748825")
                .setDate("01/09/2023")
                .setNumOfRow(1)
                .setKindOfShow(1) //Music
                .setPrice(200));

        ticketsMap.put ("P0005", new Ticket()
                .setKey("P0005")
                .setNameOfArtist("Love Story")
                .setCity("Tel-Aviv")
                .setPhoneNumber("0528892325")
                .setDate("03/09/2023")
                .setNumOfRow(6)
                .setKindOfShow(3) //Theater
                .setPrice(250));

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("tickets");

        for (Map.Entry<String,Ticket> entry : ticketsMap.entrySet()){
            myRef.push().setValue(entry.getValue());
        }

    }

    private void OpenActivity(int i) {
        if(i == 1 ){ //Open BuyActivity
            Intent buyIntent = new Intent(this, BuyActivity.class);
            startActivity(buyIntent);
            finish();
        }
        if(i == 2 ){ //Open SellActivity
            Intent sellIntent = new Intent(this, SellActivity.class);
            startActivity(sellIntent);
            finish();
        }
        if(i == 3 ){ //Pop Me A Ticket
            Intent popIntent = new Intent(this, popActivity.class);
            startActivity(popIntent);
            finish();
        }



    }







    private void findViews() {
        BuyTicket = findViewById(R.id.BuyTicket_BTN);
        SellTicket = findViewById(R.id.SellTicket_BTN);
        PopMeATicket = findViewById(R.id.PopMeATicket_BTN);
        ExitBtn = findViewById(R.id.action_logout);
    }
}