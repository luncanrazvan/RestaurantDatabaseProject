package com.example.restaurantdatabaseproject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FoodRecViewAdapter extends RecyclerView.Adapter<FoodRecViewAdapter.ViewHolder> {
    private static final String TAG = "FoodRecViewAdapter";
    private ArrayList<Food> foods=new ArrayList<>();
    private Util util;

    private String type="";

    private MyDBHandlerOrdered myDBHandlerOrdered;
    private MyDBHandlerWish myDBHandlerWish;

    public FoodRecViewAdapter(Context context){
        this.context=context;
        this.util=new Util();
        myDBHandlerOrdered=new MyDBHandlerOrdered(context,null,null,1);
        myDBHandlerWish=new MyDBHandlerWish(context,null,null,1);
    }

    private Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_food_recycler_view,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Log.d(TAG, "onBindViewHolder: called");
        holder.foodName.setText(foods.get(position).getName());
        if(foods.get(position).getFresh()==1){
            holder.freshTextView.setText("Fresh");
        }else{
            holder.freshTextView.setText("Not Fresh");
        }
        holder.foodCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,FoodActivity.class);
                intent.putExtra("foodId",foods.get(position).getId());
                context.startActivity(intent);
            }
        });

        holder.foodCard.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(type.equals("ordered") || type.equals("wish")){
                    AlertDialog.Builder builder=new AlertDialog.Builder(context);
                    builder.setTitle("Remove");
                    builder.setMessage("Remove this item?");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            switch (type){
                                case "ordered":
                                    myDBHandlerOrdered.deleteOrderedProduct(foods.get(position).getName());
                                    util.removeOrderedFood(foods.get(position));
                                    break;
                                case "wish":
                                    myDBHandlerWish.deleteWishProduct(foods.get(position).getName());
                                    util.removeWishFood(foods.get(position));
                                    break;
                                default:
                                    break;
                            }

                            notifyDataSetChanged();
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.create().show();
                }
                return true;
            }
        });
        Glide.with(context).asBitmap().load(foods.get(position).getImageUrl()).into(holder.foodImage);
    }

    public int getItemCount(){
        return foods.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView foodImage;
        private TextView foodName;
        private CardView foodCard;
        private TextView freshTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.foodImage = itemView.findViewById(R.id.foodImage);
            this.foodName = itemView.findViewById(R.id.foodNameTV);
            this.foodCard = itemView.findViewById(R.id.foodCard);
            this.freshTextView=itemView.findViewById(R.id.freshTV);
        }
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFood(ArrayList<Food> food){
        this.foods=food;
        notifyDataSetChanged();
    }
}
