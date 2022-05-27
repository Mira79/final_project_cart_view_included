package com.example.recyclerview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class singleProductFragment extends Fragment {


    String name, number, url;
    ImageButton imageButton;
    ImageButton cartButton;
    Button addToCart;

    public singleProductFragment() {
        // Required empty public constructor
    }

    public singleProductFragment(String name, String number, String url) {
        this.name = name;
        this.number = number;
        this.url = url;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.single_product_layout, container, false);

        addToCart = view.findViewById(R.id.addtocart);
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartModel item = new CartModel( name,"black", "400",url, "small");
                CartFragment.addItem(item);

            }
        });

        cartButton = view.findViewById(R.id.cart);
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment();
            }
        });
        imageButton = view.findViewById(R.id.backbutton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        ImageView  imageholder = view.findViewById(R.id.productPicture);
        TextView nameholder = view.findViewById(R.id.description);
        TextView priceholder = view.findViewById(R.id.price);

        nameholder.setText(name);
        priceholder.setText(number);
        Glide.with(getContext()).load(url).into(imageholder);





        return view;
    }

    public void onBackPressed(){
        AppCompatActivity activity = (AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new MainDisplayFragment()).addToBackStack(null).commit();

    }
    public void replaceFragment() {
        AppCompatActivity activity = (AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new CartFragment()).addToBackStack(null).commit();

    }


}