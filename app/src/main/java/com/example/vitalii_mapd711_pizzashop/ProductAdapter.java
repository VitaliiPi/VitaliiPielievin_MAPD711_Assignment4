package com.example.vitalii_mapd711_pizzashop;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vitalii_mapd711_pizzashop.database.PizzaSchema;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<PizzaSchema> productDataset;


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView productImage;
        public TextView productTitle;
        public EditText productAmount;

        public ViewHolder(View itemView) {
            super(itemView);
            productImage = (ImageView) itemView.findViewById(R.id.product_image);
            productTitle = (TextView) itemView.findViewById(R.id.product_name);
            productAmount = (EditText) itemView.findViewById(R.id.product_amount);
        }
    }

    // Constructor

    public ProductAdapter(List<PizzaSchema> myDataset) {
        productDataset = myDataset;
    }

    // Create new views

    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        ViewHolder productViewHolder = new ViewHolder(v);
        return productViewHolder;

    }

    // Replace the contents of a view

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        // Get element from your dataset at this position
        // Replace the contents of the view with that element

        holder.productImage.setImageResource(productDataset.get(position).imageID);
        holder.productTitle.setText(productDataset.get(position).productName);
        holder.productAmount.setHint(R.string.amount_hint);

    }

    // Return the size of your dataset

    @Override
    public int getItemCount() {
        return productDataset.size();
    }
}

