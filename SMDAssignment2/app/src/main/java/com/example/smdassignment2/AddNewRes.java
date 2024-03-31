package com.example.smdassignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;



public class AddNewRes extends AppCompatActivity {

    TextInputEditText RNname , RNloc , RNphone , RNdes , RNrat;

    Button Addres ;

    item myItem ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_res);
        init();

        Addres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name , loc , phone , des , rat ;
                name = RNname.toString().trim();
                loc = RNloc.toString().trim();
                phone = RNphone.toString().trim();
                des = RNdes.toString().trim();
                rat = RNrat.toString().trim();

                myItem  = new item(name,loc,phone,des,Double.parseDouble(rat));
                MainActivity.list.add(new item(name,loc,phone,des,Double.parseDouble(rat)));
//


//                 Put the item object into the Bundle
//                Bundle bundle = new Bundle();
//                bundle.putParcelable("item", myItem);

                Intent i = new Intent(AddNewRes.this , MainActivity.class);
//                i.putExtras(bundle);
                startActivity(i);
                myItem = null ;
//                finish();




            }
        });

    }

    void init()
    {
        RNname = findViewById(R.id.etres);
        RNloc = findViewById(R.id.etloc);
        RNphone = findViewById(R.id.etphone);
        RNdes = findViewById(R.id.etdes);
        RNrat = findViewById(R.id.etrat);

        Addres = findViewById(R.id.btnadd);



    }
}