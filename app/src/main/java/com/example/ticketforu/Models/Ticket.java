package com.example.ticketforu.Models;

import androidx.annotation.NonNull;

public class Ticket {

    private String key ="";
    private String nameOfArtist = "";
    private String city = "";
    private String phoneNumber = "" ;
    private String date = "";
    private int numOfRow =0;

    private String show = "";
    private int price = 0 ;
    private int kindOfShow = 0;// 1 - Music , 2 - StandUp , 3 - Theater

    public Ticket() {}

    public String getKey(){
        return key;
    }

    public Ticket setKey(String key){
        this.key = key;
        return this;

    }

    public String getNameOfArtist() {
        return nameOfArtist;
    }

    public Ticket setNameOfArtist(String nameOfArtist) {
        this.nameOfArtist = nameOfArtist;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Ticket setCity(String city) {
        this.city = city;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public Ticket setPhoneNumber (String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Ticket setDate(String date) {
        this.date = date;
        return this;
    }

    public String getShow() {
        return this.show;
    }

    public int getNumOfRow(){
        return  numOfRow ;
    }

    public Ticket setNumOfRow(int numOfRow) {
        this.numOfRow = numOfRow;
        return this;
    }

    public int getPrice() {
        return  price ;
    }
    public Ticket setPrice (int Price) {
        this.price = Price;
        return this;
    }

    public Ticket setShow(String show) {
        this.show = show;
        return this;
    }

    public int getKindOfShow(){
        return kindOfShow;
    }
    public Ticket setKindOfShow (int kindOfShow) {
        if (kindOfShow==0){
            show = "Fashion-Haute couture";
            this.kindOfShow = kindOfShow;
            return this;
        }
        if (kindOfShow==1){
            show = "Music";
            this.kindOfShow = kindOfShow;
            return this;
        }
        if (kindOfShow==2){
            show = "StandUp";
            this.kindOfShow = kindOfShow;
            return this;
        }
        if (kindOfShow==3){
            show = "Theater";
            this.kindOfShow = kindOfShow;
            return this;
        }
        return this;
    }

    @NonNull
    @Override
    public String toString() {
        return
                "Type of show: \n " + show +  ".\n" +
                        "Artist Name: \n" + nameOfArtist + ".\n"+
                        "City: "        + city + ".\n "+
                        "Date: "        + date + ".\n "+
                        "Row: "         + numOfRow + ".\n " +
                        "Price: "       + price + ".\n "+
                        "Phone Number: "        + phoneNumber + ".\n " ;
    }
}
