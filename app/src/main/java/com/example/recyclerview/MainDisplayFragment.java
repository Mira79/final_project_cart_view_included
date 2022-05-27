package com.example.recyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainDisplayFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment1,container,false);

        ArrayList<Product> items = new ArrayList<>();

        items.add(new Product("T Shirt mono","29.99 CAD", "https://static.zara.net/photos///2021/I/0/2/p/5584/400/401/2/w/148/5584400401_6_1_1.jpg?ts=1626434562119"));
        items.add(new Product("T Shirt lava","40.9 CAD", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ53mgJ9Xqn4JGFZcjlhgNBvhkc_N-0QZjoIQ&usqp=CAU"));

        items.add(new Product("Saoirse hoodie","49.99 CAD", "https://static.zara.net/photos///2022/V/0/2/p/0761/410/420/2/w/148/0761410420_6_1_1.jpg?ts=1643706476809"));
        items.add(new Product("Hoodie","4.9 CAD", "https://static.zara.net/photos///2022/V/0/2/p/4087/430/911/2/w/148/4087430911_6_1_1.jpg?ts=1637684327801"));
        items.add(new Product("Dress Shirt","35.49 CAD", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjFnHiHJE_C5Kd1XAqlwee_2CCbkM1CrkSPA&usqp=CAU"));
        items.add(new Product("shorts","20.49 CAD", "https://static.zara.net/photos///2022/V/1/2/p/2201/920/001/2/w/148/2201920001_6_1_1.jpg?ts=1646151449684"));
        items.add(new Product("Dress shirt","4.9 CAD", "https://static.zara.net/photos///2022/V/0/2/p/4432/425/400/2/w/148/4432425400_6_1_1.jpg?ts=1647523418209"));
        items.add(new Product("Fragrance","15.99 CAD", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjFnHiHJE_C5Kd1XAqlwee_2CCbkM1CrkSPA&usqp=CAU"));
        items.add(new Product("Saoir","4.9 CAD", "https://static.zara.net/photos///2021/V/2/2/p/0210/016/999/2/w/850/0210016999_1_1_1.jpg?ts=1610529018840"));
        items.add(new Product("Loose shirt","35.46 CAD", "https://lp2.hm.com/hmgoepprod?set=source[/63/bf/63bff99a833b12a5f444c91c17a99b1835c49a4f.jpg],origin[dam],category[],type[LOOKBOOK],res[z],hmver[1]&call=url[file:/product/main]"));
        items.add(new Product("jacket","20.99 CAD", "https://static.zara.net/photos///2022/V/0/3/p/8367/532/406/2/w/148/8367532406_6_1_1.jpg?ts=1645704892968"));
        items.add(new Product("tote bag","34.99 CAD", "https://static.zara.net/photos///2021/I/1/3/p/1556/830/050/2/w/148/1556830050_6_1_1.jpg?ts=1629978827404"));
        items.add(new Product("Black Shirt","42.99 CAD", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4Yywo1LuQVLTrYnZu1UfhLDUgGCUVB8kSZw&usqp=CAU"));

        RecyclerView productsView;
        productsView =  view.findViewById(R.id.mainrecyclerView);

        MainViewAdapter adapdter = new MainViewAdapter(this );

        productsView.setLayoutManager(new GridLayoutManager(getContext(), 2));


        adapdter.setContacts(items);

        productsView.setAdapter(adapdter);


        return view;
    }
}
