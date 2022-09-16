package com.example.myroomdatabase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myroomdatabase.db.AppDatabase;
import com.example.myroomdatabase.db.Product;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ProductListAdapter productListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addNewProductButton = findViewById(R.id.addNewProductButton);
        addNewProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, AddNewProductActivity.class),100);
            }
        });
        initRecyclerView();

        loadProductList();
    }
    private void  initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        productListAdapter = new ProductListAdapter(this);
        recyclerView.setAdapter(productListAdapter);
    }
    private  void loadProductList(){
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        List<Product> productList = db.productDao().getAllProducts();
        productListAdapter.setProductList(productList);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 100){
            loadProductList();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}