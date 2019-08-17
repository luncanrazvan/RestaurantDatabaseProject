package com.example.restaurantdatabaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class AdminDelete extends AppCompatActivity {

    private Button deleteButton;
    private Spinner spinnerNameToDelete;

    MyDBHandler myDBHandler;
    MyDBHandlerOrdered myDBHandlerOrdered;
    MyDBHandlerWish myDBHandlerWish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_delete);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Delete Item");
        deleteButton=findViewById(R.id.buttonDelete1);
        spinnerNameToDelete=findViewById(R.id.spinnerNameToDelete);
        myDBHandler=new MyDBHandler(AdminDelete.this,null,null,1);
        myDBHandlerOrdered=new MyDBHandlerOrdered(AdminDelete.this,null,null,1);
        myDBHandlerWish=new MyDBHandlerWish(AdminDelete.this,null,null,1);

        SQLiteDatabase db=myDBHandler.getReadableDatabase();
        String[] field={myDBHandler.getColumnId(),myDBHandler.getColumnName(),
                myDBHandler.getColumnType(),myDBHandler.getColumnPrice(),myDBHandler.getColumnImageUrl(),
                myDBHandler.getColumnDescription(),myDBHandler.getColumnQuantity(),myDBHandler.getColumnFresh()};
        Cursor cursor=db.query(myDBHandler.getTableName(),field,null,null,null,null,null);
        int iname=cursor.getColumnIndex(myDBHandler.getColumnName());
        ArrayList<String> names=new ArrayList<>();
        for(cursor.moveToFirst(); !cursor.isAfterLast();cursor.moveToNext()){
            String name=cursor.getString(iname);
            names.add(name);

        }
        ArrayAdapter<String> adapter2=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,names);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNameToDelete.setAdapter(adapter2);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=spinnerNameToDelete.getSelectedItem().toString();
                myDBHandlerWish.deleteWishProduct(name);
                myDBHandlerOrdered.deleteOrderedProduct(name);
                myDBHandler.deleteProduct(name);
            }
        });
    }
}
