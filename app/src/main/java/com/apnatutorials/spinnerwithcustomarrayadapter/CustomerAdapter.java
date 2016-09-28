package com.apnatutorials.spinnerwithcustomarrayadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class CustomerAdapter extends ArrayAdapter<Customer> {
    ArrayList<Customer> customers, tempCustomer, suggestions;

    public CustomerAdapter(Context context, ArrayList<Customer> objects) {
        super(context, R.layout.customer_row, R.id.tvCustomer, objects);
        this.customers = objects;
        this.tempCustomer = new ArrayList<Customer>(objects);
        this.suggestions = new ArrayList<Customer>(objects);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return initView(position, convertView, null);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        Customer customer = getItem(position);
        if (convertView == null) {
            if (parent == null)
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.customer_row, null);
            else
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.customer_row, parent, false);
        }
        TextView txtCustomer = (TextView) convertView.findViewById(R.id.tvCustomer);
        ImageView ivCustomerImage = (ImageView) convertView.findViewById(R.id.ivCustomerImage);
        if (txtCustomer != null)
            txtCustomer.setText(customer.getFirstName() + " " + customer.getLastName());


        if (ivCustomerImage != null)
            ivCustomerImage.setImageResource(customer.getProfilePic());

        // Now assign alternate color for rows
        if (position % 2 == 0)
            convertView.setBackgroundColor(getContext().getColor(R.color.odd));
        else
            convertView.setBackgroundColor(getContext().getColor(R.color.even));
        ivCustomerImage.setImageResource(customer.getProfilePic());

        return convertView;
    }
}
