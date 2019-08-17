package com.example.restaurantdatabaseproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {

    private static final String TAG = "FoodActivity";

    private TextView foodName;
    private TextView foodPrice;
    private TextView foodType;
    private TextView description;

    private ImageView foodImage;

    private Button btnAddToOrders;
    private Button btnAddToWishlist;

    private Food incomingFood;

    private Util util;

    private MyDBHandlerOrdered myDBHandlerOrdered;
    private MyDBHandlerWish myDBHandlerWish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initWidgets();
        Intent intent=getIntent();
        int id=intent.getIntExtra("foodId",0);
        util=new Util();
        ArrayList<Food> foods=util.getAllFood();
        for(Food food:foods){
            if(food.getId()==id){
                incomingFood=food;
                foodName.setText("Name: "+food.getName());
                foodPrice.setText("Price: "+food.getPrice());
                foodType.setText("Type: "+food.getType());
                description.setText("Description: "+food.getDescription());
                Glide.with(this).asBitmap().load(food.getImageUrl()).into(foodImage);
            }
        }

        btnAddToOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAddToOrdersTapped();
            }
        });

        btnAddToWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAddToWishlistTapped();
            }
        });
    }

    private void btnAddToOrdersTapped(){
        Log.d(TAG, "btnAddToOrdersTapped: Started");
        ArrayList<Food> orderedFoods=util.getOrderedFood();
        if(orderedFoods.contains(incomingFood)){
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setMessage("You already ordered this type of food.");
            builder.setPositiveButton("Add Again", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    // myDBHandlerOrdered=new MyDBHandlerOrdered(FoodActivity.this,null,null,1);
                    // util.getOrderedFood().add(incomingFood);
                    // myDBHandlerOrdered.addOrderedProduct(incomingFood);
                    incomingFood.incQuantity();
                    myDBHandlerOrdered.updateQuantityByName(incomingFood.getName());
                    Toast.makeText(FoodActivity.this,incomingFood.getName()+" has beed added to your orders.",Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.setCancelable(false);
            builder.create().show();
        }else{
            incomingFood.incQuantity();
            myDBHandlerOrdered=new MyDBHandlerOrdered(FoodActivity.this,null,null,1);
            util.getOrderedFood().add(incomingFood);
            myDBHandlerOrdered.addOrderedProduct(incomingFood);
            Toast.makeText(this,incomingFood.getName()+" has beed added to your orders.",Toast.LENGTH_SHORT).show();
        }
    }

    private void btnAddToWishlistTapped(){
        Log.d(TAG, "btnAddToWishlistTapped: Started");
        if(util.getWishListFood().contains(incomingFood)){
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setMessage("You have already added this product in your wishlist.");
            builder.setPositiveButton("Got It", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.setCancelable(false);
            builder.create().show();
        }else{
            Log.d(TAG, util.getWishListFood().size()+" ");
            myDBHandlerWish=new MyDBHandlerWish(FoodActivity.this,null,null,1);
            util.addNewInWishlist(incomingFood);
            myDBHandlerWish.addWishProduct(incomingFood);
            Toast.makeText(this,incomingFood.getName()+" has beed added to your wishlist.",Toast.LENGTH_SHORT).show();
        }
    }

    private void initWidgets(){
        foodName=findViewById(R.id.fnTV);
        foodPrice=findViewById(R.id.fpTV);
        foodType=findViewById(R.id.typeTV);
        foodImage=findViewById(R.id.foodImage1);
        description=findViewById(R.id.descTV);
        btnAddToOrders=findViewById(R.id.btnAddToOrders);
        btnAddToWishlist=findViewById(R.id.btnWL);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
