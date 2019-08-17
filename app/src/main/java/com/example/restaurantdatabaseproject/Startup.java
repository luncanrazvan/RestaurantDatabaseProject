package com.example.restaurantdatabaseproject;

import android.app.Application;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class Startup extends Application {

    public static int id=0;
    //private ArrayList<Food> foods;
    private Util util;
    private MyDBHandler myDBHandler;
    private MyDBHandlerOrdered myDBHandlerOrdered;
    private MyDBHandlerWish myDBHandlerWish;

    @Override
    public void onCreate() {
        super.onCreate();
        //this.foods=new ArrayList<>();
        this.util=new Util();
        this.myDBHandler=new MyDBHandler(this,null,null,1);
        this.myDBHandlerOrdered=new MyDBHandlerOrdered(this,null,null,1);
        this.myDBHandlerWish=new MyDBHandlerWish(this,null,null,1);
        startInit();
    }

    private void startInit(){
        //this.deleteDatabase("products.db");
        id++;
        //allFood.add(new Food("Pireu cu Chiftele",0,25,"https://www.petitchef.ro/imgupl/recipe/chiftelute-de-pui-cu-piure--md-11970p15011.jpg","asdsad",id));
        Food food=new Food("Pireu cu Chiftele",0,25,"https://www.petitchef.ro/imgupl/recipe/chiftelute-de-pui-cu-piure--md-11970p15011.jpg","asdsad",id,1);

        id++;
        //allFood.add(new Food("Taietei cu Branza",1,15,"https://savoriurbane.com/wp-content/uploads/2017/02/Taietei-cu-branza-si-slanina-Turos-csusza-8.jpg","asdsad",id));
        Food food1=new Food("Taietei cu Branza",1,15,"https://savoriurbane.com/wp-content/uploads/2017/02/Taietei-cu-branza-si-slanina-Turos-csusza-8.jpg","asdsad",id,1);
        id++;
        //allFood.add(new Food("Supa de pui",0,15,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id));
        Food food2=new Food("Supa de pui",0,15,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id,1);
        id++;
        //allFood.add(new Food("Salata de Varza",2,9,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id));
        Food food3=new Food("Salata de Varza",2,9,"https://www.e-retete.ro/files/recipes/salata-de-varza-simpla.jpg","dsadas",id,1);
        id++;
        //allFood.add(new Food("Legume La Gratar",2,35,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id));
        Food food4=new Food("Legume La Gratar",2,35,"https://www.lauralaurentiu.ro/wp-content/uploads/2012/11/legume-la-gratar.jpg","dsadas",id,1);
        id++;
        //allFood.add(new Food("Sarmale",0,20,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id));
        Food food5=new Food("Sarmale",0,20,"https://media.kaufland.com/images/PPIM/AP_Content_1010/std.lang.all/04/63/Asset_1890463.jpg","dsadas",id,1);
        id++;
        //allFood.add(new Food("Supa de Fasole",1,33,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id));
        Food food6=new Food("Supa de Fasole",1,33,"https://retete.unica.ro/wp-content/uploads/2010/06/ciorba-de-fasole-1-1024x695.jpg","dsadas",id,1);
        id++;
        //allFood.add(new Food("Tofu",2,15,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id));
        Food food7=new Food("Tofu",2,15,"https://upload.wikimedia.org/wikipedia/commons/6/66/Tofu_4.jpg","dsadas",id,0);
        id++;
        //allFood.add(new Food("Paste BaconZola",0,43,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id));
        Food food8=new Food("Paste Carbonara",0,43,"https://cdn.jamieoliver.com/recipe-database/oldImages/medium/1558_1_1436795948.jpg","dsadas",id,0);
        id++;
        //allFood.add(new Food("Burger",0,30,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id));
        Food food9=new Food("Burger",0,30,"https://www.goodfood.com.au/content/dam/images/h/1/1/j/5/b/image.related.wideLandscape.940x529.h11w9b.png/1530167192718.jpg","dsadas",id,0);
        id++;
        //allFood.add(new Food("Branza cu Zahar",1,15,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id));
        Food food10=new Food("Branza cu Zahar",1,15,"https://copiisiparinti.files.wordpress.com/2017/09/dsc_0053.jpg","dsadas",id,1);
        id++;
        // allFood.add(new Food("Omleta",1,10,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id));
        Food food11=new Food("Omleta",1,10,"https://retete.unica.ro/wp-content/uploads/2012/07/omleta.jpg","dsadas",id,1);
        id++;
        //allFood.add(new Food("Pizza",0,34,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id));
        Food food12=new Food("Pizza",0,34,"https://cdn.apartmenttherapy.info/image/fetch/f_auto,q_auto:eco/https%3A%2F%2Fstorage.googleapis.com%2Fgen-atmedia%2F3%2F2018%2F03%2F55cd28cae8ee78fe1e52ab1adc9eafff24c9af92.jpeg","dsadas",id,0);
        myDBHandler.addProduct(food);
        myDBHandler.addProduct(food1);
        myDBHandler.addProduct(food2);
        myDBHandler.addProduct(food3);
        myDBHandler.addProduct(food4);
        myDBHandler.addProduct(food5);
        myDBHandler.addProduct(food6);
        myDBHandler.addProduct(food7);
        myDBHandler.addProduct(food8);
        myDBHandler.addProduct(food9);
        myDBHandler.addProduct(food10);
        myDBHandler.addProduct(food11);
        myDBHandler.addProduct(food12);

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