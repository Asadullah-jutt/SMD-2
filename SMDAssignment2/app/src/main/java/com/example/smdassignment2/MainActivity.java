package com.example.smdassignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    RecyclerView items;
    itemAdapter myAdapter;
    static public ArrayList<item> list = new ArrayList<>();
    ArrayList<item> searchlist;
    Button AddNewres;
    EditText searchtext ;


    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onResume() {
        super.onResume();
//        Toast.makeText( MainActivity.this, "qwqe" +list.size() , Toast.LENGTH_SHORT).show();
//
        myAdapter.notifyDataSetChanged();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        items.setHasFixedSize(true);
        myAdapter = new itemAdapter(list);

        items.setLayoutManager(new LinearLayoutManager(this));
        //rvChats.setLayoutManager(new GridLayoutManager(this,4));
        items.setAdapter(myAdapter);



        searchtext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not needed for this implementation
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Not needed for this implementation
            }

            @Override
            public void afterTextChanged(Editable s) {
                String query = s.toString().trim().toLowerCase(); // Convert to lowercase for case-insensitivity

                if (query.isEmpty()) {
                    // If the search text is empty, display the original list sorted by rating
                    Collections.sort(list);
                    myAdapter.updateList(list);
                } else {
                    // Perform search
                    searchlist = new ArrayList<>();
                    for (item Item : list) {
                        if (Item.getName().toLowerCase().contains(query)) { // Check for partial matches
                            searchlist.add(Item);
                        }
                    }
                    // Sort the search results based on rating
                    Collections.sort(searchlist);
                    myAdapter.updateList(searchlist); // Update RecyclerView with sorted search results
                }
            }
        });






        AddNewres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddNewRes.class);
                // Start the SecondActivity
                startActivity(intent);
//                finish();

            }
        });
    }

    public static <T> void swapLists(ArrayList<T> list1, ArrayList<T> list2) {
        // Create a temporary list to hold the contents of list1
        ArrayList<T> temp = new ArrayList<>(list1);

        // Clear list1 and add elements of list2 to list1
        list1.clear();
        list1.addAll(list2);

        // Clear list2 and add elements of temp (original list1) to list2
        list2.clear();
        list2.addAll(temp);
    }

    private void init()
    {

        list.add(new item("Jheela Food Point","Androon","0322-1234567","Desi Ghee",4.2));
        list.add(new item("Spice House", "Lahore", "0321-1234567", "Specializes in spicy dishes", 4.5));
        list.add(new item("Peshawari Grill", "Islamabad", "0300-9876543", "Famous for traditional Peshawari cuisine", 4.2));
        list.add(new item("Ravi Restaurant", "Karachi", "0345-6789123", "Offers a wide range of desi dishes", 4.0));
        list.add(new item("Sultan's Kitchen", "Rawalpindi", "0333-4567890", "Known for its Mughlai cuisine", 4.4));
        list.add(new item("Koyla Karahi", "Faisalabad", "0311-2345678", "Specializes in karahi dishes cooked on coal", 4.1));
        list.add(new item("Pearl Continental Restaurant", "Multan", "0322-3456789", "Fine dining with a variety of cuisines", 4.7));
        list.add(new item("Cafe Flo", "Karachi", "0344-5678901", "Offers a cozy atmosphere with continental cuisine", 3.8));
        list.add(new item("The Lahore Social", "Lahore", "0303-1234567", "Modern restaurant serving fusion food", 4.3));
        list.add(new item("Quetta Khadda", "Quetta", "0332-3456789", "Specializes in Balochi dishes", 4.6));
        list.add(new item("Kabul Restaurant", "Peshawar", "0315-6789012", "Authentic Afghan cuisine", 4.4));
        list.add(new item("Shahi Nan Khatai", "Sialkot", "0346-7890123", "Famous for its traditional sweets and snacks", 4.2));
        list.add(new item("Bundu Khan", "Gujranwala", "0321-2345678", "Renowned for its barbecue dishes", 4.3));
        list.add(new item("Murree Hotel", "Murree", "0300-4567890", "Offers picturesque views and continental cuisine", 4.1));
        list.add(new item("Chaman Ice Cream", "Hyderabad", "0331-2345678", "Popular for its wide variety of ice creams", 4.5));
        list.add(new item("Khyber Pass", "Peshawar", "0344-5678901", "Authentic Pathan cuisine in a rustic setting", 4.2));

        Collections.sort(list);
        items = findViewById(R.id.items);
        AddNewres = findViewById(R.id.btnAddNewContact);
        searchtext = findViewById(R.id.etsearch);
    }
}