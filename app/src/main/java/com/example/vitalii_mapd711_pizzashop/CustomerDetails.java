package com.example.vitalii_mapd711_pizzashop;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.vitalii_mapd711_pizzashop.database.AppDatabase;
import com.example.vitalii_mapd711_pizzashop.database.CustomerSchema;
import com.example.vitalii_mapd711_pizzashop.database.OrderSchema;
import com.example.vitalii_mapd711_pizzashop.database.PizzaSchema;

import java.util.List;
import java.util.Locale;

import static com.example.vitalii_mapd711_pizzashop.MainActivity.PREFS;

public class CustomerDetails extends AppCompatActivity {

    AppDatabase mDb;
    EditText customerFirstName;
    EditText customerLastName;
    EditText address;
    EditText email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);

        SharedPreferences sharedPrefs = getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        String username = sharedPrefs.getString("username", "username");

        mDb = AppDatabase.getInMemoryDatabase(getApplicationContext());

        CustomerSchema customer = mDb.customerModel().loadCustomerByUsername(username);
        String customerID = customer.customerID;


        List<OrderSchema> orderContents = mDb.orderModel().loadOrderByCustomerId(customerID);
        StringBuilder sb = new StringBuilder();
        for (OrderSchema order : orderContents) {

            PizzaSchema product = mDb.productModel().loadProductById(order.product);
            sb.append(String.format(Locale.CANADA, "%s - %s pizzas\n", product.productName, order.amount));
        }

        TextView orderDetails = (TextView)findViewById(R.id.orderDetails);
        orderDetails.setText("Hi, " + customer.firstName + "! " + "You ordered : \n" + sb);

        customerFirstName = findViewById(R.id.customerFirstName);
        customerLastName = findViewById(R.id.customerLastName);
        address = findViewById(R.id.address);
        email = findViewById(R.id.email);

        customerFirstName.setText(customer.firstName);
        customerLastName.setText(customer.lastName);
        address.setText(customer.address);
        email.setText(customer.email);


    }

    public void onConfirmClick (View view) {
        Intent i = new Intent(CustomerDetails.this, PizzaOrderConfirmation.class);
        startActivity(i);
    }






}
