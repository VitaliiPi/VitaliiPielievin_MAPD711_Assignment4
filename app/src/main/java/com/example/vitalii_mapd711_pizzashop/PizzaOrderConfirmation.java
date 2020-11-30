package com.example.vitalii_mapd711_pizzashop;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.vitalii_mapd711_pizzashop.database.AppDatabase;
import com.example.vitalii_mapd711_pizzashop.database.CustomerSchema;
import com.example.vitalii_mapd711_pizzashop.database.OrderSchema;
import com.example.vitalii_mapd711_pizzashop.database.PizzaSchema;

import java.util.List;

import static com.example.vitalii_mapd711_pizzashop.MainActivity.PREFS;

public class PizzaOrderConfirmation extends AppCompatActivity {

    private AppDatabase mDb;
    private List<OrderSchema> orderDataset;
    private List<PizzaSchema> productDataset;

    private RecyclerView orderRecycler;
    private RecyclerView.Adapter orderAdapter;
    private RecyclerView.LayoutManager orderLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_order_confirmation);

        mDb = AppDatabase.getInMemoryDatabase(getApplicationContext());

        SharedPreferences sharedPrefs = getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        String username = sharedPrefs.getString("username", "username");
        CustomerSchema customer = mDb.customerModel().loadCustomerByUsername(username);

        orderDataset = mDb.orderModel().loadOrderByCustomerId(customer.customerID);
        productDataset = mDb.productModel().loadAllProducts();


        orderRecycler = (RecyclerView) findViewById(R.id.confirmationRecycler);

        orderLayoutManager = new LinearLayoutManager(this);
        orderRecycler.setLayoutManager(orderLayoutManager);

        orderAdapter = new PizzaOrderAdapter(orderDataset, productDataset);
        orderRecycler.setAdapter(orderAdapter);

    }

    public void onHomeClicked (View view) {

        SharedPreferences sharedPrefs = getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.remove("username");
        editor.apply();

        Intent i = new Intent(PizzaOrderConfirmation.this, MainActivity.class);
        startActivity(i);
    }





}
