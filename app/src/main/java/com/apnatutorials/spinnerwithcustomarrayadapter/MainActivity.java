package com.apnatutorials.spinnerwithcustomarrayadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CustomerAdapter adapter = null;
    ArrayList<Customer> customers = null;
    Spinner mySpinner ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customers = new ArrayList<>();
        customers = populateCustomerData(customers);
        mySpinner = (Spinner) findViewById( R.id.mySpinner ) ;
        adapter = new CustomerAdapter(this, customers);
        mySpinner.setAdapter(adapter);
    }


    private ArrayList<Customer> populateCustomerData(ArrayList<Customer> customers) {
        customers.add(new Customer("Balendra", "Singh", 1, R.drawable.c1));
        customers.add(new Customer("Bipin", "Arora", 2, R.drawable.c2));
        customers.add(new Customer("Babulal", "Marandi", 3, R.drawable.c3));


        customers.add(new Customer("Aishwarya", "Rai", 8, R.drawable.c8));
        customers.add(new Customer("Asin", "Kaif", 9, R.drawable.c9));
        customers.add(new Customer("Arshi", "Khan", 10, R.drawable.c10));

        return customers;
    }
}
