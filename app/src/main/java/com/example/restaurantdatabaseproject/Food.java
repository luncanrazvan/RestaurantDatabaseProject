package com.example.restaurantdatabaseproject;

public class Food {

    private String name;
    private int type;
    private int price;
    private String imageUrl;
    private String description;
    private int quantity;
    private int fresh;
    int id;

    public Food(String name, int type, int price, String imageUrl, String description, int id,int fresh) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.imageUrl = imageUrl;
        this.description = description;
        this.id = id;
        this.quantity=0;
        this.fresh=fresh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void incQuantity(){
        this.quantity++;
    }

    public void setQuantityZero(){
        this.quantity=0;
    }

    public void setQuantity(int quantity){
        this.quantity=quantity;
    }

    public void setFresh(int fresh){
        this.fresh=fresh;
    }

    public int getFresh(){
        return this.fresh;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", price=" + price +
                ", imageUrl=" + imageUrl +
                ", description='" + description + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return false;
        }

        if(getClass()!=obj.getClass()){
            return false;
        }

        Food compared=(Food) obj;

        if(this.getId()!=compared.getId()){
            return false;
        }

        if(this.getType()!=compared.getType()){
            return false;
        }

        if(this.getPrice()!=compared.getPrice()){
            return false;
        }

        if(this.getDescription()==null || !this.getDescription().equals(compared.getDescription())){
            return false;
        }

        if(this.getName()==null || !this.getName().equals(compared.getName())){
            return false;
        }

        if(this.getImageUrl()==null || !this.getImageUrl().equals(compared.getImageUrl())){
            return false;
        }
        return true;
    }


    public int hashCode(){
        if(this.getName()==null){
            return 7;
        }
        return this.getName().hashCode()+this.getImageUrl().hashCode()+this.getDescription().hashCode()+this.getPrice()+this.getType()+this.getId();
    }

    /*public int getQuantity() {
        return quantity;
    }

    public void incQuantity(){
        this.quantity++;
    }
    */
}
