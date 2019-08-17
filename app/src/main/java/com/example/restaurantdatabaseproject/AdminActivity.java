package com.example.restaurantdatabaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AdminActivity extends AppCompatActivity {

    private Button buttonSubmit;

    private EditText foodName;
    private EditText foodPrice;
    private EditText foodURL;
    private EditText foodDescription;

    private Spinner typeSpinner;
    private Spinner freshSpinner;

    private String name;
    private int price;
    private int type;
    private String imageURL;
    private String description;
    private int fresh;

    MyDBHandler myDBHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Insert Item");
        buttonSubmit=findViewById(R.id.btnSubmit);
        foodName=findViewById(R.id.NameET);
        foodPrice=findViewById(R.id.priceET);
        typeSpinner=findViewById(R.id.typeSpinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.foodTypes,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(adapter);
        foodURL=findViewById(R.id.URLET);
        foodDescription=findViewById(R.id.descET);
        freshSpinner=findViewById(R.id.freshSpinner);
        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(this,R.array.freshOrNot,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        freshSpinner.setAdapter(adapter1);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=foodName.getText().toString();
                price= Integer.parseInt(foodPrice.getText().toString());
                type=typeSpinner.getSelectedItemPosition();
                imageURL=foodURL.getText().toString();
                description=foodDescription.getText().toString();
                fresh=freshSpinner.getSelectedItemPosition();
                Startup.id++;
                Food food=new Food(name,type,price,imageURL,description,Startup.id,fresh);
                myDBHandler=new MyDBHandler(AdminActivity.this,null,null,1);
                myDBHandler.addProduct(food);
            }
        });
    }
}
