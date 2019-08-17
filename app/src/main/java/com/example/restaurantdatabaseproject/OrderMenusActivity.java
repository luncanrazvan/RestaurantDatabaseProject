package com.example.restaurantdatabaseproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class OrderMenusActivity extends AppCompatActivity {

    private static final String TAG = "OrderMenusActivity";

    private RecyclerView recyclerView;
    private FoodRecViewAdapter adapter;
    private Util util;
    private Button buttonConfirm;
    private Button refButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_menus);
        Toolbar toolbar=findViewById(R.id.toolBar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Orders");
        Log.d(TAG, "onCreate: started");
        adapter=new FoodRecViewAdapter(this);
        adapter.setType("ordered");
        util=new Util();
        recyclerView=findViewById(R.id.recView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        adapter.setFood(util.getOrderedFood());
        buttonConfirm=findViewById(R.id.confirmOrderButton);
        refButton=findViewById(R.id.refButton);
        refButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
            }
        });
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(OrderMenusActivity.this);
                builder.setMessage("Are you sure you want to confirm this order?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int sum=0;
                        for(Food food:util.getOrderedFood()){
                            sum+=food.getPrice()*food.getQuantity();
                            food.setQuantityZero();
                        }
                        MyDBHandlerOrdered myDBHandlerOrdered=new MyDBHandlerOrdered(OrderMenusActivity.this,null,null,1);
                        myDBHandlerOrdered.deleteAllOrderedProducts();
                        util.getOrderedFood().clear();
                        AlertDialog.Builder builder=new AlertDialog.Builder(OrderMenusActivity.this);
                        builder.setMessage("Order has been confirmed, price: "+sum);
                        builder.show();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setCancelable(false);
                builder.create().show();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
