package com.example.restaurantdatabaseproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;

public class ViewMenusActivity extends AppCompatActivity {

    private static final String TAG = "ViewMenusActivity";

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_menus);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Log.d(TAG, "onCreate: started");
        recyclerView=findViewById(R.id.allMenusRecView);
        FoodRecViewAdapter foodRecViewAdapter=new FoodRecViewAdapter(this);
        recyclerView.setAdapter(foodRecViewAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        Util util=new Util();
        ArrayList<Food> foods=util.getAllFood();
        foodRecViewAdapter.setFood(foods);
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
