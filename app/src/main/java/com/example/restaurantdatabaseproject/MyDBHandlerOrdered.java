package com.example.restaurantdatabaseproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHandlerOrdered  extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="orderedProducts.db";
    private static final String TABLE_PRODUCTS="orderedProducts";
    private static final String COLUMN_NAME="Name";
    private static final String COLUMN_TYPE="Type";
    private static final String COLUMN_PRICE="Price";
    private static final String COLUMN_IMAGE_URL="ImageURL";
    private static final String COLUMN_DESCRIPTION="Description";
    private static final String COLUMN_ID="ID";
    private static final String COLUMN_QUANTITY="Quantity";
    private static final String COLUMN_FRESH="Fresh";

    public MyDBHandlerOrdered(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query=" CREATE TABLE orderedProducts (ID INTEGER PRIMARY KEY, Name TEXT, Type INTEGER, Price INTEGER, ImageURL TEXT,Description TEXT, Quantity INTEGER, Fresh INTEGER)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_PRODUCTS);
        onCreate(sqLiteDatabase);
       /* SQLiteDatabase db=this.getReadableDatabase();
        String[] field={this.getColumnId(),this.getColumnName(),
                this.getColumnType(),this.getColumnPrice(),this.getColumnImageUrl(),
                this.getColumnDescription()};
        Cursor cursor=db.query(this.getTableName(),field,null,null,null,null,null);
        int iID= cursor.getColumnIndex(this.getColumnId());
        int iname=cursor.getColumnIndex(this.getColumnName());
        int itype=cursor.getColumnIndex(this.getColumnType());
        int iprice=cursor.getColumnIndex(this.getColumnPrice());
        int iURL=cursor.getColumnIndex(this.getColumnImageUrl());
        int idesc=cursor.getColumnIndex(this.getColumnDescription());
        util.getAllFood().clear();
        util.getVeganFood().clear();
        util.getVegetarianFood().clear();

        for(cursor.moveToFirst(); !cursor.isAfterLast();cursor.moveToNext()){

            int id= cursor.getInt(iID);
            String name=cursor.getString(iname);
            int type=cursor.getInt(itype);
            System.out.println(type);
            int price=cursor.getInt(iprice);
            String URL=cursor.getString(iURL);
            String Desc=cursor.getString(idesc);
            Food food13=new Food(name,type,price,URL,Desc,id);
            Log.d(TAG, id+" "+name+" "+type);
            if(type==1){
                util.addVegetarianFood(food13);
            }
            if(type==2){
                util.addVeganFood(food13);
            }
            util.getAllFood().add(food13);
        }
        */
    }

    public void addOrderedProduct(Food food){
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_ID,food.getId());
        contentValues.put(COLUMN_NAME,food.getName());
        contentValues.put(COLUMN_TYPE,food.getType());
        contentValues.put(COLUMN_PRICE,food.getPrice());
        contentValues.put(COLUMN_IMAGE_URL,food.getImageUrl());
        contentValues.put(COLUMN_DESCRIPTION,food.getDescription());
        contentValues.put(COLUMN_QUANTITY,food.getQuantity());
        contentValues.put(COLUMN_FRESH,food.getFresh());
        SQLiteDatabase db=getWritableDatabase();
        db.insert(TABLE_PRODUCTS,null,contentValues);
        db.close();
    }

    public void deleteOrderedProduct(String productName){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("DELETE FROM "+ TABLE_PRODUCTS+" WHERE "+COLUMN_NAME+"=\""+productName+"\";");
    }

    public void deleteAllOrderedProducts(){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("DELETE FROM "+ TABLE_PRODUCTS);
    }

    public void updateQuantityByName(String name){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("UPDATE "+TABLE_PRODUCTS+" SET Quantity = Quantity+1 WHERE "+COLUMN_NAME+"=\""+name+"\";");
    }

    public void updateProductPFD(String name,int price1,int freshOrNot, String desc1){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("UPDATE "+TABLE_PRODUCTS+" SET "+COLUMN_PRICE+ " = "+price1+" , "+COLUMN_FRESH+" = "+freshOrNot+" , " +COLUMN_DESCRIPTION+" = '"+desc1+"' WHERE "+COLUMN_NAME+"=\""+name+"\";");
    }

    public void updateProductFD(String name,int freshOrNot, String desc1){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("UPDATE "+TABLE_PRODUCTS+" SET "+COLUMN_FRESH+" = "+freshOrNot+" , " +COLUMN_DESCRIPTION+" = '"+desc1+"' WHERE "+COLUMN_NAME+"=\""+name+"\";");
    }

    public void updateProductPD(String name,int price1,String desc1){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("UPDATE "+TABLE_PRODUCTS+" SET "+COLUMN_PRICE+ " = "+price1+" , " +COLUMN_DESCRIPTION+" = '"+desc1+"' WHERE "+COLUMN_NAME+"=\""+name+"\";");
    }

    public void updateProductPF(String name,int price1,int freshOrNot){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("UPDATE "+TABLE_PRODUCTS+" SET "+COLUMN_PRICE+ " = "+price1+" , "+COLUMN_FRESH+" = "+freshOrNot+" WHERE "+COLUMN_NAME+"=\""+name+"\";");
    }

    public void updateProductP(String name,int price1){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("UPDATE "+TABLE_PRODUCTS+" SET "+COLUMN_PRICE+ " = "+price1+" WHERE "+COLUMN_NAME+"=\""+name+"\";");
    }

    public void updateProductF(String name,int freshOrNot){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("UPDATE "+TABLE_PRODUCTS+" SET "+COLUMN_FRESH+" = "+freshOrNot+" WHERE "+COLUMN_NAME+"=\""+name+"\";");
    }

    public void updateProductD(String name,String desc1){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("UPDATE "+TABLE_PRODUCTS+" SET " +COLUMN_DESCRIPTION+" = '"+desc1+"' WHERE "+COLUMN_NAME+"=\""+name+"\";");
    }

    public static String getTableName(){
        return TABLE_PRODUCTS;
    }

    public static int getDatabaseVersion() {
        return DATABASE_VERSION;
    }

    public static String getTableProducts() {
        return TABLE_PRODUCTS;
    }

    public static String getColumnName() {
        return COLUMN_NAME;
    }

    public static String getColumnType() {
        return COLUMN_TYPE;
    }

    public static String getColumnPrice() {
        return COLUMN_PRICE;
    }

    public static String getColumnImageUrl() {
        return COLUMN_IMAGE_URL;
    }

    public static String getColumnDescription() {
        return COLUMN_DESCRIPTION;
    }

    public static String getColumnId() {
        return COLUMN_ID;
    }

    public static String getColumnQuantity(){ return COLUMN_QUANTITY; }

    public static String getColumnFresh(){return COLUMN_FRESH;}
}
