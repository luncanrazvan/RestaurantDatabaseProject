package com.example.restaurantdatabaseproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class MainActivity extends AppCompatActivity {

    private Button viewMenuButton;
    private Button viewWishlistButton;
    private Button viewOrderButton;
    private Button viewAboutButton;
    private Button adminButton;

    private RadioButton allTypes;
    private RadioButton vegTypes;
    private RadioButton veganTypes;


    private Util util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        setOnClickListeners();

        util=new Util();

    }

    private void setOnClickListeners(){
        viewMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!allTypes.isChecked() && !veganTypes.isChecked() && !vegTypes.isChecked()){
                    AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this).setTitle("Error").setMessage("You must select a certain type of food.")
                            .setPositiveButton("Got it", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });
                    builder.setCancelable(false);
                    builder.create().show();
                }else{
                    if(allTypes.isChecked()){
                        refreshDataBase();
                        Intent intent=new Intent(MainActivity.this,ViewMenusActivity.class);
                        startActivity(intent);
                    }
                    if(veganTypes.isChecked()){
                        refreshDataBase();
                        Intent intent=new Intent(MainActivity.this,VeganFoodActivity.class);
                        startActivity(intent);
                    }
                    if(vegTypes.isChecked()){
                        refreshDataBase();
                        Intent intent=new Intent(MainActivity.this,VegetarianFoodActivity.class);
                        startActivity(intent);
                    }

                }
            }
        });

        viewWishlistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshWishlistDatabase();
                Intent intent=new Intent(MainActivity.this,WishlistMenuActivity.class);
                startActivity(intent);
            }
        });

        viewOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshOrderedDatabase();
                Intent intent=new Intent(MainActivity.this,OrderMenusActivity.class);
                startActivity(intent);
            }
        });

        viewAboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AboutActivity.class);
                startActivity(intent);
            }
        });

        adminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MainActivityAdmin.class);
                startActivity(intent);
            }
        });
    }

    private void initComponents(){

        viewMenuButton=findViewById(R.id.btnViewAll);
        viewWishlistButton=findViewById(R.id.btnWishList);
        viewOrderButton=findViewById(R.id.btnWiewOrder);
        viewAboutButton=findViewById(R.id.btnAbout);
        adminButton=findViewById(R.id.btnAdmin);
        allTypes=findViewById(R.id.allTypes);
        vegTypes=findViewById(R.id.vegTypes);
        veganTypes=findViewById(R.id.veganTypes);
    }

    private void refreshDataBase(){
        MyDBHandler myDBHandler=new MyDBHandler(this,null,null,1);
        SQLiteDatabase db=myDBHandler.getReadableDatabase();
        String[] field={myDBHandler.getColumnId(),myDBHandler.getColumnName(),
                myDBHandler.getColumnType(),myDBHandler.getColumnPrice(),myDBHandler.getColumnImageUrl(),
                myDBHandler.getColumnDescription(),myDBHandler.getColumnQuantity(),myDBHandler.getColumnFresh()};
        Cursor cursor=db.query(myDBHandler.getTableName(),field,null,null,null,null,null);
        int iID= cursor.getColumnIndex(myDBHandler.getColumnId());
        int iname=cursor.getColumnIndex(myDBHandler.getColumnName());
        int itype=cursor.getColumnIndex(myDBHandler.getColumnType());
        int iprice=cursor.getColumnIndex(myDBHandler.getColumnPrice());
        int iURL=cursor.getColumnIndex(myDBHandler.getColumnImageUrl());
        int idesc=cursor.getColumnIndex(myDBHandler.getColumnDescription());
        int ifresh=cursor.getColumnIndex(myDBHandler.getColumnFresh());
        //int iquant=cursor.getColumnIndex(myDBHandler.getColumnQuantity());
        util.getAllFood().clear();
        util.getVeganFood().clear();
        util.getVegetarianFood().clear();

        for(cursor.moveToFirst(); !cursor.isAfterLast();cursor.moveToNext()){

            int id= cursor.getInt(iID);
            String name=cursor.getString(iname);
            int type=cursor.getInt(itype);
            int price=cursor.getInt(iprice);
            String URL=cursor.getString(iURL);
            String Desc=cursor.getString(idesc);
            //int quant=cursor.getInt(iquant);
            int fresh=cursor.getInt(ifresh);
            Food food13=new Food(name,type,price,URL,Desc,id,fresh);
            //Log.d(TAG, id+" "+name+" "+type);
            if(type==1){
                util.addVegetarianFood(food13);
            }
            if(type==2){
                util.addVeganFood(food13);
            }
            util.getAllFood().add(food13);
        }
    }

    private void refreshOrderedDatabase(){
        MyDBHandlerOrdered myDBHandlerOrdered=new MyDBHandlerOrdered(this,null,null,1);
        SQLiteDatabase dbO=myDBHandlerOrdered.getReadableDatabase();
        String[] fieldO={myDBHandlerOrdered.getColumnId(),myDBHandlerOrdered.getColumnName(),
                myDBHandlerOrdered.getColumnType(),myDBHandlerOrdered.getColumnPrice(),myDBHandlerOrdered.getColumnImageUrl(),
                myDBHandlerOrdered.getColumnDescription(),myDBHandlerOrdered.getColumnQuantity(),myDBHandlerOrdered.getColumnFresh()};
        Cursor cursorO=dbO.query(myDBHandlerOrdered.getTableName(),fieldO,null,null,null,null,null);
        int iIDO= cursorO.getColumnIndex(myDBHandlerOrdered.getColumnId());
        int inameO=cursorO.getColumnIndex(myDBHandlerOrdered.getColumnName());
        int itypeO=cursorO.getColumnIndex(myDBHandlerOrdered.getColumnType());
        int ipriceO=cursorO.getColumnIndex(myDBHandlerOrdered.getColumnPrice());
        int iURLO=cursorO.getColumnIndex(myDBHandlerOrdered.getColumnImageUrl());
        int idescO=cursorO.getColumnIndex(myDBHandlerOrdered.getColumnDescription());
        int iquantO=cursorO.getColumnIndex(myDBHandlerOrdered.getColumnQuantity());
        int ifreshO=cursorO.getColumnIndex(myDBHandlerOrdered.getColumnFresh());
        util.getOrderedFood().clear();
        for(cursorO.moveToFirst(); !cursorO.isAfterLast();cursorO.moveToNext()){

            int id= cursorO.getInt(iIDO);
            String name=cursorO.getString(inameO);
            int type=cursorO.getInt(itypeO);
            int price=cursorO.getInt(ipriceO);
            String URL=cursorO.getString(iURLO);
            String Desc=cursorO.getString(idescO);
            int quant=cursorO.getInt(iquantO);
            int fresh=cursorO.getInt(ifreshO);
            Food food13=new Food(name,type,price,URL,Desc,id,fresh);
            food13.setQuantity(quant);
            Log.d(TAG, id+" "+name+" "+type);
            util.getOrderedFood().add(food13);
            Log.d(TAG, util.getOrderedFood().size()+" lista");
        }
    }

    private void refreshWishlistDatabase(){
        MyDBHandlerWish myDBHandlerWish=new MyDBHandlerWish(this,null,null,1);
        SQLiteDatabase dbW=myDBHandlerWish.getReadableDatabase();
        String[] fieldW={myDBHandlerWish.getColumnId(),myDBHandlerWish.getColumnName(),
                myDBHandlerWish.getColumnType(),myDBHandlerWish.getColumnPrice(),myDBHandlerWish.getColumnImageUrl(),
                myDBHandlerWish.getColumnDescription(),myDBHandlerWish.getColumnQuantity(),myDBHandlerWish.getColumnFresh()};
        Cursor cursorW=dbW.query(myDBHandlerWish.getTableName(),fieldW,null,null,null,null,null);
        int iIDW= cursorW.getColumnIndex(myDBHandlerWish.getColumnId());
        int inameW=cursorW.getColumnIndex(myDBHandlerWish.getColumnName());
        int itypeW=cursorW.getColumnIndex(myDBHandlerWish.getColumnType());
        int ipriceW=cursorW.getColumnIndex(myDBHandlerWish.getColumnPrice());
        int iURLW=cursorW.getColumnIndex(myDBHandlerWish.getColumnImageUrl());
        int idescW=cursorW.getColumnIndex(myDBHandlerWish.getColumnDescription());
        int ifreshW=cursorW.getColumnIndex(myDBHandlerWish.getColumnFresh());
        util.getWishListFood().clear();
        for(cursorW.moveToFirst(); !cursorW.isAfterLast();cursorW.moveToNext()){

            int id= cursorW.getInt(iIDW);
            String name=cursorW.getString(inameW);
            int type=cursorW.getInt(itypeW);
            int price=cursorW.getInt(ipriceW);
            String URL=cursorW.getString(iURLW);
            String Desc=cursorW.getString(idescW);
            int fresh=cursorW.getInt(ifreshW);
            Food food13=new Food(name,type,price,URL,Desc,id,fresh);
            Log.d(TAG, id+" "+name+" "+type);
            util.getWishListFood().add(food13);
        }
    }
}
