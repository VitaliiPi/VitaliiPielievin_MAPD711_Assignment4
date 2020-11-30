package com.example.vitalii_mapd711_pizzashop.database;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface OrderDao {

    @Query("SELECT * From OrderSchema")
    List<OrderSchema> findAllOrders();

    @Query("select * from OrderSchema where orderID = :id")
    List<OrderSchema> loadOrdersWithId(String id);

    @Query("select * from OrderSchema where orderID = :id")
    OrderSchema loadOrderById(String id);

    @Query("select * from OrderSchema where customer = :id")
    List<OrderSchema> loadOrderByCustomerId(String id);

    @Insert()
    void insertOrder(OrderSchema order);

    @Update(onConflict = REPLACE)
    void updateOrder(OrderSchema order);

    @Query("DELETE FROM OrderSchema")
    void deleteAll();

}
