
package com.example.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;


public class CartFragment extends Fragment {

    Button checkoutButton;
    ImageButton delete;
    static ArrayList<CartModel> cartModel = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_cart, container, false);

        checkoutButton = view.findViewById(R.id.cartCheckout);
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment();
            }
        });


        RecyclerView cartItemsRecyclervView;
        cartItemsRecyclervView =  view.findViewById(R.id.cartrecyclerView);


        CartAdaptor adapdtor = new CartAdaptor(this );
        cartItemsRecyclervView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        adapdtor.setCartModel(cartModel);
        cartItemsRecyclervView.setAdapter(adapdtor);


        return view;
    }
    public static void addItem(CartModel item){
        cartModel.add(item);
    }
    public static void removeItem(int i){
        cartModel.remove(i);
    }
    public void replaceFragment() {
        AppCompatActivity activity = (AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new shippiing_fragment()).addToBackStack(null).commit();

    }
}