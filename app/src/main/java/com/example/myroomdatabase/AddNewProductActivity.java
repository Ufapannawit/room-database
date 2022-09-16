package com.example.myroomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myroomdatabase.db.AppDatabase;
import com.example.myroomdatabase.db.Product;

public class AddNewProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_product);

        final EditText name = findViewById(R.id.nameInput);
        final EditText price = findViewById(R.id.priceInput);
        Button save = findViewById(R.id.saveButon);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNewProduct(name.getText().toString(), price.getText().toString());
            }
        });
    }

    private void  saveNewProduct(String name,String price){
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        Product product = new Product();
        product.name = name;
        product.price = price;
        db.productDao().insertProduct(product);

        finish();
    }
}