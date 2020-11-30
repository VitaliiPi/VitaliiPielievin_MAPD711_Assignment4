package com.example.vitalii_mapd711_pizzashop.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;


@Dao
public interface AdminDao {

    @Query("select * from AdminSchema")
    List<AdminSchema> loadAllEmployees();

    @Query("select * from AdminSchema where employeeID = :id")
    AdminSchema loadEmployeeById(int id);

    @Query("select * from AdminSchema where username = :username")
    AdminSchema loadEmployeeByUsername(String username);

    @Query("select * from AdminSchema where firstName = :firstName and lastName = :lastName")
    List<AdminSchema> findEmployeeByNameAndLastName(String firstName, String lastName);

    @Insert(onConflict = IGNORE)
    void insertEmployee(AdminSchema employee);

    @Delete
    void deleteEmployee(AdminSchema employee);


    @Query("DELETE FROM AdminSchema")
    void deleteAll();

}
