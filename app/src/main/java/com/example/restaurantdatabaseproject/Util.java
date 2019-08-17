package com.example.restaurantdatabaseproject;

import java.util.ArrayList;

public class Util {

    private static ArrayList<Food> allFood;
    private static ArrayList<Food> vegetarianFood;
    private static ArrayList<Food> veganFood;
    private static ArrayList<Food> orderedFood;
    private static ArrayList<Food> wishListFood;
    private static int id=0;

    public Util(){
        if(allFood==null){
            allFood=new ArrayList<>();
            //initAllFood();
        }

        if(orderedFood==null){
            orderedFood=new ArrayList<>();
        }

        if(wishListFood==null){
            wishListFood=new ArrayList<>();
        }

        if(vegetarianFood==null){
            vegetarianFood=new ArrayList<>();
        }

        if(veganFood==null){
            veganFood=new ArrayList<>();
        }
    }

    public static void setAllFood(ArrayList<Food> allFood) {
        Util.allFood = allFood;
    }

    public void addNewOrder(Food food){
        orderedFood.add(food);
    }

    public void addNewInWishlist(Food food){
        if(!wishListFood.contains(food))
            wishListFood.add(food);
    }

    public static ArrayList<Food> getAllFood() {
        return allFood;
    }

    public static ArrayList<Food> getOrderedFood() {
        return orderedFood;
    }

    public static ArrayList<Food> getWishListFood() {
        return wishListFood;
    }

    public static void removeOrderedFood(Food food){
        orderedFood.remove(food);
    }

    public static void removeWishFood(Food food){wishListFood.remove(food);}

    public static void addVeganFood(Food food){
        veganFood.add(food);
    }

    public static void addVegetarianFood(Food food){
        vegetarianFood.add(food);
    }

    public static ArrayList<Food> getVeganFood() {
        return veganFood;
    }

    public static ArrayList<Food> getVegetarianFood() {
        return vegetarianFood;
    }

    /*private static void initAllFood(){


        id++;
        //allFood.add(new Food("Pireu cu Chiftele",0,25,"https://www.petitchef.ro/imgupl/recipe/chiftelute-de-pui-cu-piure--md-11970p15011.jpg","asdsad",id));
        Food food=new Food("Pireu cu Chiftele",0,25,"https://www.petitchef.ro/imgupl/recipe/chiftelute-de-pui-cu-piure--md-11970p15011.jpg","asdsad",id);

        id++;
        //allFood.add(new Food("Taietei cu Branza",1,15,"https://savoriurbane.com/wp-content/uploads/2017/02/Taietei-cu-branza-si-slanina-Turos-csusza-8.jpg","asdsad",id));
        Food food1=new Food("Taietei cu Branza",1,15,"https://savoriurbane.com/wp-content/uploads/2017/02/Taietei-cu-branza-si-slanina-Turos-csusza-8.jpg","asdsad",id);
        id++;
        //allFood.add(new Food("Supa de pui",0,15,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id));
        Food food2=new Food("Supa de pui",0,15,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id);
        id++;
        //allFood.add(new Food("Salata de Varza",2,9,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id));
        Food food3=new Food("Salata de Varza",2,9,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id);
        id++;
        //allFood.add(new Food("Legume La Gratar",2,35,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id));
        Food food4=new Food("Legume La Gratar",2,35,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id);
        id++;
        //allFood.add(new Food("Sarmale",0,20,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id));
        Food food5=new Food("Sarmale",0,20,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id);
        id++;
        //allFood.add(new Food("Supa de Fasole",1,33,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id));
        Food food6=new Food("Supa de Fasole",1,33,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id);
        id++;
        //allFood.add(new Food("Tofu",2,15,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id));
        Food food7=new Food("Tofu",2,15,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id);
        id++;
        //allFood.add(new Food("Paste BaconZola",0,43,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id));
        Food food8=new Food("Paste BaconZola",0,43,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id);
        id++;
        //allFood.add(new Food("Burger",0,30,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id));
        Food food9=new Food("Burger",0,30,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id);
        id++;
        //allFood.add(new Food("Branza cu Zahar",1,15,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id));
        Food food10=new Food("Branza cu Zahar",1,15,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id);
        id++;
       // allFood.add(new Food("Omleta",1,10,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id));
        Food food11=new Food("Omleta",1,10,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id);
        id++;
        //allFood.add(new Food("Pizza",0,34,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id));
        Food food12=new Food("Pizza",0,34,"https://savoriurbane.com/wp-content/uploads/2015/03/Supa-limpede-de-pui.jpg","dsadas",id);
    }
    */

}
