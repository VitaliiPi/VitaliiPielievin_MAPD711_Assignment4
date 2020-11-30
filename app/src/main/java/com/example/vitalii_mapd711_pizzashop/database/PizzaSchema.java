package com.example.vitalii_mapd711_pizzashop.database;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class PizzaSchema {

    @PrimaryKey
    @NonNull
    public String productID;

    public String productName;
    public int quantity;
    public String category;
    public int imageID;
}
