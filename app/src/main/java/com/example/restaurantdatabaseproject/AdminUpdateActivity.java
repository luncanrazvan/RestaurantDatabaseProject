package com.example.restaurantdatabaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class AdminUpdateActivity extends AppCompatActivity {

    private Spinner updateSpinner;
    private Spinner freshSpinnerUpdate;
    private Spinner namesSpinnerUpdate;

    private Button updateSubmitButton;

    private int price;
    private int freshOrNot;
    private String description;
    private String name;

    private EditText priceET;
    private EditText descET;
    //private EditText nameET;

    private MyDBHandler myDBHandler;
    private MyDBHandlerOrdered myDBHandlerOrdered;
    private MyDBHandlerWish myDBHandlerWish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_update);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Update Item");
        this.updateSpinner=findViewById(R.id.updateChoiceSpinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.arrayForUpdates,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.updateSpinner.setAdapter(adapter);
        this.freshSpinnerUpdate=findViewById(R.id.freshSpinnerUpdate);
        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(this,R.array.freshOrNot,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.freshSpinnerUpdate.setAdapter(adapter1);
        updateSubmitButton=findViewById(R.id.btnSubmitUpdate);
        priceET=findViewById(R.id.priceETUpdate);
        descET=findViewById(R.id.inserDescUpdateET);
        this.namesSpinnerUpdate=findViewById(R.id.spinnerNamesUpdate);
        //nameET=findViewById(R.id.nameETUpdate);

        myDBHandler=new MyDBHandler(AdminUpdateActivity.this,null,null,1);
        myDBHandlerOrdered=new MyDBHandlerOrdered(AdminUpdateActivity.this,null,null,1);
        myDBHandlerWish=new MyDBHandlerWish(AdminUpdateActivity.this,null,null,1);

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
        namesSpinnerUpdate.setAdapter(adapter2);

        updateSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (updateSpinner.getSelectedItemPosition()){
                    case 0:
                        //name=nameET.getText().toString();
                        name=namesSpinnerUpdate.getSelectedItem().toString();
                        price=Integer.parseInt(priceET.getText().toString());
                        myDBHandler.updateProductP(name,price);
                        myDBHandlerOrdered.updateProductP(name,price);
                        myDBHandlerWish.updateProductP(name,price);
                        break;
                    case 1:
                        //name=nameET.getText().toString();
                        name=namesSpinnerUpdate.getSelectedItem().toString();
                        description=descET.getText().toString();
                        myDBHandler.updateProductD(name,description);
                        myDBHandlerOrdered.updateProductD(name,description);
                        myDBHandlerWish.updateProductD(name,description);
                        break;
                    case 2:
                        //name=nameET.getText().toString();
                        name=namesSpinnerUpdate.getSelectedItem().toString();
                        freshOrNot=freshSpinnerUpdate.getSelectedItemPosition();
                        myDBHandler.updateProductF(name,freshOrNot);
                        myDBHandlerOrdered.updateProductF(name,freshOrNot);
                        myDBHandlerWish.updateProductF(name,freshOrNot);
                    case 3:
                        //name=nameET.getText().toString();
                        name=namesSpinnerUpdate.getSelectedItem().toString();
                        price=Integer.parseInt(priceET.getText().toString());
                        description=descET.getText().toString();
                        myDBHandler.updateProductPD(name,price,description);
                        myDBHandlerOrdered.updateProductPD(name,price,description);
                        myDBHandlerWish.updateProductPD(name,price,description);
                        break;
                    case 4:
                        //name=nameET.getText().toString();
                        name=namesSpinnerUpdate.getSelectedItem().toString();
                        price=Integer.parseInt(priceET.getText().toString());
                        freshOrNot=freshSpinnerUpdate.getSelectedItemPosition();
                        myDBHandler.updateProductPF(name,price,freshOrNot);
                        myDBHandlerOrdered.updateProductPF(name,price,freshOrNot);
                        myDBHandlerWish.updateProductPF(name,price,freshOrNot);
                        break;

                    case 5:
                        //name=nameET.getText().toString();
                        name=namesSpinnerUpdate.getSelectedItem().toString();
                        description=descET.getText().toString();
                        freshOrNot=freshSpinnerUpdate.getSelectedItemPosition();
                        myDBHandler.updateProductFD(name,freshOrNot,description);
                        myDBHandlerOrdered.updateProductFD(name,freshOrNot,description);
                        myDBHandlerWish.updateProductFD(name,freshOrNot,description);
                        break;
                    case 6:
                        //name=nameET.getText().toString();
                        name=namesSpinnerUpdate.getSelectedItem().toString();
                        price=Integer.parseInt(priceET.getText().toString());
                        description=descET.getText().toString();
                        freshOrNot=freshSpinnerUpdate.getSelectedItemPosition();
                        myDBHandler.updateProductPFD(name,price,freshOrNot,description);
                        myDBHandlerOrdered.updateProductPFD(name,price,freshOrNot,description);
                        myDBHandlerWish.updateProductPFD(name,price,freshOrNot,description);
                        break;
                }
            }
        });

    }
}
