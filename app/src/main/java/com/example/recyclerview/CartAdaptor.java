package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class CartAdaptor extends RecyclerView.Adapter<CartAdaptor.ViewHolder> {
    ArrayList<CartModel> cartModel = new ArrayList<>();

    private CartFragment context;
    ImageButton deleteButton;

    public CartAdaptor(CartFragment context) {
        this.context = context;
    }
    @NonNull
    @Override
    public CartAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cart_view_layout, viewGroup, false);
        CartAdaptor.ViewHolder holder = new CartAdaptor.ViewHolder(view);



        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdaptor.ViewHolder viewHolder, @SuppressLint("RecyclerView") int i) {
        viewHolder.productDescription.setText(cartModel.get(i).getProductDescription());
       viewHolder.size.setText(cartModel.get(i).getSize());
       viewHolder.color.setText(cartModel.get(i).getColor());
       viewHolder.price.setText(cartModel.get(i).getPrice());
      viewHolder.subtotal.setText(cartModel.get(i).getQty());


        Glide.with(context)
                .asBitmap()
                .load(cartModel.get(i).url)
                .into(viewHolder.imageView);

    }

    @Override
    public int getItemCount() {
        return cartModel.size();
    }

    public void setCartModel(ArrayList<CartModel> cartModel) {
        this.cartModel = cartModel;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView productDescription, size, color, price, subtotal ;
        private EditText qty;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.cartimage);
            productDescription = (TextView) itemView.findViewById(R.id.cartItemDescription);
            price = (TextView) itemView.findViewById(R.id.cartitemprice);
            size = (TextView) itemView.findViewById(R.id.cartitemsize);
            color = (TextView) itemView.findViewById(R.id.cartitemcolor);
            subtotal = (TextView) itemView.findViewById(R.id.subtotal);
            qty = (EditText) itemView.findViewById(R.id.cartItemQuantity);
        }
    }
}