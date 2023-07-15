package com.example.ticketforu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.ticketforu.Adapters.TicketAdapter;
import com.example.ticketforu.Logic.TicketsManager;
import com.example.ticketforu.Models.Ticket;
import com.google.android.material.textfield.TextInputEditText;

import java.security.AccessController;
import java.util.ArrayList;

public class SellActivity extends AppCompatActivity {

    private TextInputEditText ArtistName;
    private TextInputEditText City;
    private TextInputEditText Date;
    private TextInputEditText PhoneNumber;
    private TextInputEditText numberOfRow;

    private TextInputEditText Price;
    private RadioGroup chooseShow;
    int ShowChosen = 1; // 1 - Music , 2 - StandUp , 3 - Theater
    private Button PublishTicket;
    private Button BackToMunuBtn;

    private RecyclerView Ticket_LST;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        findViews();
        StartActivity();
    }

    private void StartActivity() {
        //FireBase - get Data from Database -> Unfortunately - Not success.
        //TicketsManager manager =  new TicketsManager();
        // ArrayList <Ticket> tickets = manager.getTicketArray() ;

        //With ArrayList
        chooseShow.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View selectedRadioButton = group.findViewById(checkedId);
                onRadioButtonClicked(selectedRadioButton);
            }
        });

        PublishTicket.setOnClickListener(view -> {
            Log.d("TAG", String.valueOf("Press on publish button"));
            ArrayList<Ticket> tickets = TicketsManager.getTicket();
            int NumberOfRow  = Integer.parseInt(numberOfRow.getText().toString()) ;
            int price  = Integer.parseInt(Price.getText().toString()) ;

            tickets.add(new Ticket()
                            .setNameOfArtist(ArtistName.getText().toString())
                            .setCity(City.getText().toString())
                            .setPhoneNumber(PhoneNumber.getText().toString())
                            .setDate(Date.getText().toString())
                            .setNumOfRow(NumberOfRow)
                            .setKindOfShow(ShowChosen) //standUp
                            .setPrice(price)
            );
            Toast.makeText(this, "Ticket Add Successfully", Toast.LENGTH_LONG).show();
            Log.d("TAG", String.valueOf(tickets.get(5).toString()));
        });


        BackToMunuBtn.setOnClickListener(view -> {
            Intent menuIntent = new Intent(this, MainActivity.class);
            startActivity(menuIntent);
            finish();
        });


    }




    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radio_MusicShow:
                if (checked)
                    ShowChosen = 1;
                break;
            case R.id.radio_StandUp:
                if (checked)
                    ShowChosen = 2;
                break;
            case R.id.radio_TheaterShow:
                if (checked)
                    ShowChosen = 3;
                break;
        }
    }


    private void findViews() {
        ArtistName = findViewById(R.id.nameOfArtist_INPUT);
        City = findViewById(R.id.City_INPUT);
        Date = findViewById(R.id.Date_INPUT);
        PhoneNumber = findViewById(R.id.PhoneNumber_INPUT);
        numberOfRow = findViewById(R.id.numOfRow_INPUT);
        Price = findViewById(R.id.Price_INPUT);
        chooseShow = findViewById(R.id.radio_Group);
        PublishTicket = findViewById(R.id.PublishMyTicket_BTN);
        BackToMunuBtn = findViewById(R.id.BackToMenu_BTN);
    }

}