package com.example.vitalii_mapd711_pizzashop;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vitalii_mapd711_pizzashop.database.OrderSchema;
import com.example.vitalii_mapd711_pizzashop.database.PizzaSchema;

import java.util.List;
import java.util.Objects;


public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.ViewHolder> {


    private List<OrderSchema> orderListDataset;
    private List<PizzaSchema> productListDataset;


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

    public OrderListAdapter(List<OrderSchema> myDataset, List<PizzaSchema> myProductDataset) {
        orderListDataset = myDataset;
        productListDataset = myProductDataset;
    }

    // Creaate new views

    @Override
    public OrderListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
        OrderListAdapter.ViewHolder orderListViewHolder = new OrderListAdapter.ViewHolder(v);
        return orderListViewHolder;

    }

    // Replace the contents of a view
    @Override
    public void onBindViewHolder(OrderListAdapter.ViewHolder holder, int position) {
        // Get element from your dataset at this position
        // Replace the contents of the view with that element

        holder.orderProductAmount.setText(String.valueOf(orderListDataset.get(position).amount));
        String productId = orderListDataset.get(position).product;

        for (PizzaSchema product : productListDataset) {
            if (Objects.equals(product.productID, productId)) {
                holder.orderProductId.setText(product.productName);
            }
        }




    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return orderListDataset.size();
    }
}
