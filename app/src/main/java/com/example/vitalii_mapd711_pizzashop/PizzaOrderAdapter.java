package com.example.vitalii_mapd711_pizzashop;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vitalii_mapd711_pizzashop.database.OrderSchema;
import com.example.vitalii_mapd711_pizzashop.database.PizzaSchema;

import java.util.List;


public class PizzaOrderAdapter extends RecyclerView.Adapter<PizzaOrderAdapter.ViewHolder> {


    private List<OrderSchema> orderDataset;
    private List<PizzaSchema> productDataset;


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView orderProductId;
        public TextView orderProductAmount;

        public ViewHolder(View itemView) {
            super(itemView);
            orderProductId = (TextView) itemView.findViewById(R.id.order_product_id);
            orderProductAmount = (TextView) itemView.findViewById(R.id.order_product_amount);
        }
    }

    // Constructor

    public PizzaOrderAdapter(List<OrderSchema> myDataset, List<PizzaSchema> myProductDataset) {
        orderDataset = myDataset;
        productDataset = myProductDataset;
    }

    // Create new views

    @Override
    public PizzaOrderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
        PizzaOrderAdapter.ViewHolder orderViewHolder = new PizzaOrderAdapter.ViewHolder(v);
        return orderViewHolder;

    }

    // Replace the contents of a view

    @Override
    public void onBindViewHolder(PizzaOrderAdapter.ViewHolder holder, int position) {
        // Get element from your dataset at this position
        // Replace the contents of the view with that element

        holder.orderProductId.setText(productDataset.get(position).productName);
        holder.orderProductAmount.setText(String.valueOf(orderDataset.get(position).amount));

    }

    // Return the size of your dataset

    @Override
    public int getItemCount() {
        return orderDataset.size();
    }
}
