package com.example.ticketforu.Logic;
import android.provider.ContactsContract;
import android.util.Log;
import androidx.annotation.NonNull;
import com.example.ticketforu.Models.Ticket;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;



import com.google.firebase.database.*;

public class TicketsManager {


    public static ArrayList<Ticket> tickets;

    public TicketsManager() {
    }

    public static ArrayList<Ticket> getTicket() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket()
                .setNameOfArtist(" Ori Hizkia")
                .setCity("Raanana")
                .setPhoneNumber("0527791467")
                .setDate("25/08/2023")
                .setNumOfRow(5)
                .setKindOfShow(2) //standUp
                .setPrice(150)
        );

        tickets.add(new Ticket()
                .setNameOfArtist("Kobi Maymon")
                .setCity("Haifa")
                .setPhoneNumber("0528757867")
                .setDate("30/08/2023")
                .setNumOfRow(7)
                .setKindOfShow(2) //standUp
                .setPrice(170)
        );

        tickets.add(new Ticket()
                .setNameOfArtist("Lital Shvartz")
                .setCity("Ashdod")
                .setPhoneNumber("0527748825")
                .setDate("01/09/2023")
                .setNumOfRow(14)
                .setKindOfShow(2) //standUp
                .setPrice(130)
        );

        tickets.add(new Ticket()
                .setNameOfArtist("Eyal Golan")
                .setCity("Ashdod")
                .setPhoneNumber("0527748825")
                .setDate("01/09/2023")
                .setNumOfRow(1)
                .setKindOfShow(1) //Music
                .setPrice(200)
        );

        tickets.add(new Ticket()
                .setNameOfArtist("Love Story")
                .setCity("Tel-Aviv")
                .setPhoneNumber("0528892325")
                .setDate("03/09/2023")
                .setNumOfRow(6)
                .setKindOfShow(3) //Theater
                .setPrice(250)
        );
        return tickets;
    }


    //Firebase databese reading - doesn't work.
    public static ArrayList<Ticket> getTicketArray() {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("tickets");
        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot :dataSnapshot.getChildren())                {
                        Ticket t = postSnapshot.getValue(Ticket.class);
                        Log.d("ptttt", t.toString());
                        tickets.add(t);
                }

            }

            @Override
            public void onCancelled( DatabaseError error) {
                Log.d("ptttt", "Error reading database");
            }
        });

        return tickets;

    }
}



