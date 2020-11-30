package com.example.vitalii_mapd711_pizzashop.database;


import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.vitalii_mapd711_pizzashop.R;

import java.util.Date;

public class DatabaseInitializer {

    // Operation for insertion delay
    private static final int DELAY_MILLIS = 500;

    public static void populateAsync(final AppDatabase db) {

        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final AppDatabase db) {
        populateWithTestData(db);
    }

    private static void addOrder(final AppDatabase db, final String orderID,
                                 final CustomerSchema customer, final PizzaSchema product, final AdminSchema employee, int amount, Date dateAdded, String status) {
        OrderSchema order = new OrderSchema();
        order.orderID = orderID;
        order.customer = customer.customerID;
        order.product = product.productID;
        order.employee = employee.employeeID;
        order.amount = amount;
        order.status = status;
        db.orderModel().insertOrder(order);
    }

    private static PizzaSchema addPizza(final AppDatabase db, final String productID, final String productName, String category, int price, int quantity, int imageID) {
        PizzaSchema product = new PizzaSchema();
        product.productID = productID;
        product.productName = productName;
        product.category = category;
        product.quantity = quantity;
        product.imageID = imageID;
        db.productModel().insertProduct(product);
        return product;
    }

    private static AdminSchema addAdmin(final AppDatabase db, final String employeeID, final String username, final String password, String firstName, String lastName) {
        AdminSchema employee = new AdminSchema();
        employee.employeeID = employeeID;
        employee.username = username;
        employee.password = password;
        employee.firstName = firstName;
        employee.lastName = lastName;
        db.employeeModel().insertEmployee(employee);
        return employee;
    }

    private static CustomerSchema addCustomer(final AppDatabase db, final String customerID, final String username, final String password, String firstName, String lastName, String address, String email) {

        CustomerSchema customer = new CustomerSchema();
        customer.customerID = customerID;
        customer.username = username;
        customer.password = password;
        customer.firstName = firstName;
        customer.lastName = lastName;
        customer.address = address;
        customer.email = email;
        db.customerModel().insertCustomer(customer);
        return customer;
    }



    private static void populateWithTestData(AppDatabase db) {

        db.customerModel().deleteAll();
        db.employeeModel().deleteAll();
        db.productModel().deleteAll();
        db.orderModel().deleteAll();


        CustomerSchema customer1 = addCustomer(db, "1", "vitalii", "customer", "Vitalii", "Pielievin", "190 Progress Ave, Toronto", "vpieliev@my.cencol.ca");
        CustomerSchema customer2 = addCustomer(db, "2", "test2", "123", "Customer2", "Test2", "89 Yonge Street, Toronto", "test2@test.com");
        AdminSchema employee1 = addAdmin(db, "1", "admin", "admin", "Admin", "Admin");

        PizzaSchema product1 = addPizza(db, "1", "Pepperoni Pizza", "pizza", 6, 100, R.drawable.pepperoni);
        PizzaSchema product2 = addPizza(db, "2", "California Pizza", "pizza", 10, 100, R.drawable.california);
        PizzaSchema product3 = addPizza(db, "3", "Deluxe Pizza", "pizza", 9, 100, R.drawable.deluxe);


    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }

    }
}