package com.example.vitalii_mapd711_pizzashop.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(foreignKeys = {
        @ForeignKey(entity = CustomerSchema.class,
        parentColumns = "customerID",
        childColumns = "customer"),

        @ForeignKey(entity = PizzaSchema.class,
        parentColumns = "productID",
        childColumns = "product"),

        @ForeignKey(entity = AdminSchema.class,
        parentColumns = "employeeID",
        childColumns = "employee")
})
public class OrderSchema {

    @PrimaryKey
    @NonNull
    public String orderID;

    @ColumnInfo(name = "customer", index = true)
    public String customer;

    @ColumnInfo(name = "product", index = true)
    public String product;

    @ColumnInfo(name = "employee", index = true)
    public String employee;

    public int amount;

    public String status;
}
