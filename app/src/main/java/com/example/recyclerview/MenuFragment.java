package com.example.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.AndroidException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.recyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;


public class MenuFragment extends Fragment {

    ListView list;
    Button menButton, womenButton, kidsButton;
    ArrayAdapter arrayAdapter;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        list = (ListView) view.findViewById(R.id.listMenu);
        menButton = view.findViewById(R.id.mens);
        womenButton = view.findViewById(R.id.women);
        kidsButton = view.findViewById(R.id.kids);


        ArrayList<String> menlist = new ArrayList<>();
        ArrayList<String> womenlist = new ArrayList<>();
        ArrayList<String> kidslist = new ArrayList<>();

        menlist.add("Home");
        menlist.add("Suits");
        menlist.add("Formal Shirts");
        menlist.add("T-Shirts");
        menlist.add("Jeans");
        menlist.add("Pants");

        womenlist.add("Home");
        womenlist.add("Dresses");
        womenlist.add("Shirts");
        womenlist.add("Pants");
        womenlist.add("Skirts");
        womenlist.add("Winter Clotihing");

        kidslist.add("Home");
        kidslist.add("Girls");
        kidslist.add("Boys");
        kidslist.add("Mini | 0-12 months");
        kidslist.add("Accessories");

        arrayAdapter = new ArrayAdapter(
                getActivity(), android.R.layout.simple_list_item_1, menlist);
        list.setAdapter(arrayAdapter);

        womenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayAdapter = new ArrayAdapter(
                        getActivity(), android.R.layout.simple_list_item_1, womenlist);
                list.setAdapter(arrayAdapter);
            }
        });
        menButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayAdapter = new ArrayAdapter(
                        getActivity(), android.R.layout.simple_list_item_1, menlist);
                list.setAdapter(arrayAdapter);
            }
        });
        kidsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayAdapter = new ArrayAdapter(
                        getActivity(), android.R.layout.simple_list_item_activated_1, kidslist);
                list.setAdapter(arrayAdapter);
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                replaceFragment();
            }
        });


        return view;
    }
    public void replaceFragment() {
        AppCompatActivity activity = (AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new MainDisplayFragment()).addToBackStack(null).commit();

    }
}