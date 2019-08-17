package com.example.restaurantdatabaseproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivityAdmin extends AppCompatActivity {

    private Button btnToInsert;
    private Button btnToDelete;
    private Button btnToUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);
        Toolbar toolbar=findViewById(R.id.toolBar3);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Admin Main Menu");
        btnToInsert=findViewById(R.id.btnToInsert);
        btnToInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivityAdmin.this,AdminActivity.class);
                startActivity(intent);

            }
        });
        btnToDelete=findViewById(R.id.btnToDelete);
        btnToDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivityAdmin.this,AdminDelete.class);
                startActivity(intent);
            }
        });
        btnToUpdate=findViewById(R.id.btnToUpdate);
        btnToUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivityAdmin.this,AdminUpdateActivity.class);
                startActivity(intent);
            }
        });
    }
}
