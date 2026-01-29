package com.example.laundrymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Unpaid_Rec extends AppCompatActivity {

    int id;
    String name,phone,bill;
    DBManager db;
    ListView unpaid_users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unpaid_rec);

        db=new DBManager(Unpaid_Rec.this);
        Intent i=getIntent();
        ArrayList<String> arr=i.getStringArrayListExtra("list");

        ArrayAdapter adapter=new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,arr);
        unpaid_users=findViewById(R.id.unpaid_users);

        unpaid_users.setAdapter(adapter);


        unpaid_users.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name=unpaid_users.getItemAtPosition(position).toString();
                Cursor cursor=db.fetch_data(name);
                Intent  i=new Intent(Unpaid_Rec.this,User_data_unpaid.class);
                int idIndex = cursor.getColumnIndex("id");
                int nameIndex = cursor.getColumnIndex("name");
                int phoneIndex = cursor.getColumnIndex("phone");
                int billIndex = cursor.getColumnIndex("bill");

                while(cursor.moveToNext())
                {
                    id=cursor.getInt(idIndex);
                    name=cursor.getString(nameIndex);
                    phone=cursor.getString(phoneIndex);
                    bill=cursor.getString(billIndex);

                }

                i.putExtra("id",""+id);
                i.putExtra("name",name);
                i.putExtra("phone",phone);
                i.putExtra("bill",bill);
                startActivity(i);
            }
        });
    }
}