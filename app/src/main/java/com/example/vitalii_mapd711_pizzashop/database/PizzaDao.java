package com.example.vitalii_mapd711_pizzashop.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;


import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

@Dao
public interface PizzaDao {

    @Query("select * from PizzaSchema")
    List<PizzaSchema> loadAllProducts();

    @Query("select * from PizzaSchema where productID = :id")
    PizzaSchema loadProductById(String id);

    @Query("select * from PizzaSchema where productName = :productName")
    PizzaSchema findProductByName(String productName);

    @Insert(onConflict = IGNORE)
    void insertProduct(PizzaSchema product);

    @Delete
    void deleteProduct(PizzaSchema product);


    @Query("DELETE FROM PizzaSchema")
    void deleteAll();
}
