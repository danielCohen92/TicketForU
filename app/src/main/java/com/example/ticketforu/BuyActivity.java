package com.example.ticketforu;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.ticketforu.Adapters.TicketAdapter;
import com.example.ticketforu.Logic.TicketsManager;
import com.example.ticketforu.Models.Ticket;

import java.util.ArrayList;

public class BuyActivity extends AppCompatActivity {

    private RecyclerView Ticket_LST;

    public Context getContext() {
        Context context = this.getBaseContext();
        return context;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        findViews();
        initView();
    }

    public void onResume() {
        super.onResume();
    }

    private void initView() {
        //FireBase - get Data from Database -> Unfortunately - Not success.
        //TicketsManager manager =  new TicketsManager();
        //ArrayList <Ticket> tickets;
        //tickets = manager.getTicketArray() ;

        //With ArrayList
        ArrayList<Ticket> tickets = TicketsManager.getTicket();

        TicketAdapter ticketAdapter = new TicketAdapter(this, tickets);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        Ticket_LST.setAdapter(ticketAdapter);
        Ticket_LST.setLayoutManager(linearLayoutManager);
    }

    public void refreshUI() {

    }

    private void findViews() {
        Ticket_LST = findViewById(R.id.Ticket_LST);
    }
}