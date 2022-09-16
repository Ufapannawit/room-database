package com.example.myroomdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myroomdatabase.db.Product;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.MyViewHolder> {

    private Context context;
    private List<Product> productList;
    public ProductListAdapter(Context context){
        this.context = context;
    }

    public void  setProductList(List<Product> productList){
        this.productList = productList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent ,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListAdapter.MyViewHolder holder, int position) {
        holder.tvId.setText("Product ID : "+this.productList.get(position).id);
        holder.tvName.setText("Product Name : "+this.productList.get(position).name);
        holder.tvPrice.setText("price : "+this.productList.get(position).price);
    }

    @Override
    public int getItemCount() {
        return this.productList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvId;
        TextView tvName;
        TextView tvPrice;
        public MyViewHolder(View view){
            super(view);
            tvId = view.findViewById(R.id.tvId);
            tvName = view.findViewById(R.id.tvName);
            tvPrice = view.findViewById(R.id.tvPrice);
        }
    }
}
