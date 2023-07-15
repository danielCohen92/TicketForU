package com.example.ticketforu.Interfaces;


import android.content.Context;
import android.content.Intent;

import com.example.ticketforu.BuyActivity;
import com.example.ticketforu.Models.Ticket;
import com.example.ticketforu.OpenTicketActivity;

public interface OpenTicketCallBack {

    static String itemClicked(Ticket item) {
        String TicketDetails = item.toString();
        return TicketDetails;
    }


}

