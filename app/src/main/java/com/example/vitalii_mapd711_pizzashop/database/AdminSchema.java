package com.example.vitalii_mapd711_pizzashop.database;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class AdminSchema {

    @PrimaryKey
    @NonNull
    public String employeeID;

    public String username;
    public String password;
    public String firstName;
    public String lastName;
}
