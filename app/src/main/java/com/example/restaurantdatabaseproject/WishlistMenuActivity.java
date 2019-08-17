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

public class WishlistMenuActivity extends AppCompatActivity {

    private static final String TAG = "WishlistMenuActivity";

    private RecyclerView recyclerView;
    private FoodRecViewAdapter foodRecViewAdapter;
    private Util util;
    private Button buttonClearAll;
    private Button buttonRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist_menu);
        Toolbar toolbar1=findViewById(R.id.toolBar2);
        setSupportActionBar(toolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("WishList");
        Log.d(TAG, "onCreate: start");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        foodRecViewAdapter=new FoodRecViewAdapter(this);
        foodRecViewAdapter.setType("wish");
        util=new Util();
        recyclerView=findViewById(R.id.recView1);
        recyclerView.setAdapter(foodRecViewAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        foodRecViewAdapter.setFood(util.getWishListFood());
        buttonClearAll=findViewById(R.id.clearWishlistButton);
        buttonClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(WishlistMenuActivity.this);
                builder.setMessage("Delete Wishlist?");
                builder.setTitle("Delete");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MyDBHandlerWish myDBHandlerWish=new MyDBHandlerWish(WishlistMenuActivity.this,null,null,1);
                        myDBHandlerWish.deleteAllWishProducts();
                        util.getWishListFood().clear();
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
        buttonRefresh=findViewById(R.id.refButton1);
        buttonRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
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
