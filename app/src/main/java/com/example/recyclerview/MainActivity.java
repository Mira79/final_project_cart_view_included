package com.example.recyclerview;


import androidx.recyclerview.widget.RecyclerView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.recyclerview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding  binding;

    private RecyclerView productsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding = ActivityMainBinding.inflate(getLayoutInflater());
         setContentView(binding.getRoot());

         replaceFragment(new HomeFragment());

         binding.bottomNavigationView.setOnItemSelectedListener(item ->{

             switch (item.getItemId()){

                 case R.id.home:
                     replaceFragment(new HomeFragment());
                     break;
                 case R.id.search:
                     replaceFragment(new SearchFragment());
                     break;
                 case R.id.menu:
                     replaceFragment(new MenuFragment());
                     break;
                 case R.id.profile:
                     startActivity(new Intent(MainActivity.this, LoginActivity.class));
                     finish();
                   //  replaceFragment(new ProfileFragment());
                     break;
                 case R.id.cart:
                     replaceFragment(new CartFragment());
                     break;
             }
             return true;
         });


        //setContentView(R.layout.activity_main);

        }

        private void replaceFragment(Fragment fragment) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.frameLayout, fragment);
            fragmentTransaction.commit();
        }
    }
