package com.example.ticketforu.Adapters;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticketforu.BuyActivity;
import com.example.ticketforu.Interfaces.OpenTicketCallBack;
import com.example.ticketforu.Interfaces.TicketCallback;
import com.example.ticketforu.Models.Ticket;
import com.example.ticketforu.OpenTicketActivity;
import com.example.ticketforu.R;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;


public class TicketAdapter extends RecyclerView.Adapter <TicketAdapter.TicketViewHolder> {

    private BuyActivity context;
    private ArrayList<Ticket> tickets;
    private TicketCallback ticketCallback;


    public TicketAdapter(BuyActivity context, ArrayList<Ticket> tickets) {
        this.context = context;
        this.tickets = tickets;
    }


    @NonNull
    @Override
    public TicketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("passed VT:", "" + viewType);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ticket_item, parent, false);
        TicketViewHolder ticketViewHolder = new TicketViewHolder(view);
        return ticketViewHolder;    }

    @Override
    public void onBindViewHolder(@NonNull TicketAdapter.TicketViewHolder holder, int position) {
        Ticket ticket = getItem(position);
        //holder.record_Number.setText(position+ 1 + ")");
        holder.Name_Of_Artist_LBL.setText(ticket.getNameOfArtist());
        holder.City_LBL.setText(ticket.getCity());
        holder.Date_LBL.setText(ticket.getDate());
        holder.Price_LBL.setText("" + ticket.getPrice());

    }

    public void setTicketsCallback(TicketCallback ticketCallback) {
        this.ticketCallback = ticketCallback;
    }


    @Override
    public int getItemCount() {
        return this.tickets == null ? 0 : tickets.size();
    }

    private Ticket getItem(int position) {
        return this.tickets.get(position);
    }

    public class TicketViewHolder extends RecyclerView.ViewHolder {

        private MaterialTextView Name_Of_Artist_LBL;
        private MaterialTextView City_LBL;
        private MaterialTextView Date_LBL;
        private MaterialTextView Price_LBL;

        public TicketViewHolder(@NonNull View itemView) {

            super(itemView);
            Name_Of_Artist_LBL = itemView.findViewById(R.id.Name_Of_Artist);
            City_LBL = itemView.findViewById(R.id.City_OUTPUT);
            Date_LBL = itemView.findViewById(R.id.Date_OUTPUT);
            Price_LBL = itemView.findViewById(R.id.Price_OUTPUT);

            itemView.setOnClickListener(v -> {

                Log.d("TAG", String.valueOf("PressOnTicket"));
                OpenTicketCallBack.itemClicked(getItem(getAdapterPosition()));
                Log.d("TAG", String.valueOf(OpenTicketCallBack.itemClicked(getItem(getAdapterPosition()))));


                Context context = itemView.getContext();
                Intent openIntent = new Intent(context, OpenTicketActivity.class);
                openIntent.putExtra("ticketDetail", OpenTicketCallBack.itemClicked(getItem(getAdapterPosition())));
                context.startActivity(openIntent);

            });

        }


    }





}
