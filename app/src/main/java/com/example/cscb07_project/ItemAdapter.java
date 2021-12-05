package com.example.cscb07_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Product> {

    private int resource;
    private Context context;

    private static class ViewHolder {
        TextView tvProductName;
        TextView tvProductQuantity;
        TextView tvProductPrice;
    }

    public ItemAdapter(Context context, int resource, List<Product> products) {
        super(context, resource, products);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent){
        Product product = getItem(position);

        String productName = product.name;
        String productQuantity = ((Integer) product.inventory_quantity).toString();
        String productPrice = ((Double) product.price).toString();


        ViewHolder viewHolder;

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(resource, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvProductName = (TextView) convertView.findViewById(R.id.textViewItemName);
            viewHolder.tvProductQuantity = (TextView) convertView.findViewById(R.id.textViewQuantity);
            viewHolder.tvProductPrice = (TextView) convertView.findViewById(R.id.textViewPrice);

            convertView.setTag(convertView);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvProductName.setText(productName);
        viewHolder.tvProductQuantity.setText(productQuantity);
        viewHolder.tvProductPrice.setText(productPrice);

        return convertView;
    }

}
