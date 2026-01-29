package com.example.laundrymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class View_data extends AppCompatActivity {

    int id;
    String name,mobile,address;
    DBManager db;
    ListView customer_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        db=new DBManager(View_data.this);
            Intent i=getIntent();
            ArrayList<String> arr=i.getStringArrayListExtra("list");
            customer_list=findViewById(R.id.customer_list);
            ArrayAdapter<String> user=new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,arr);
            customer_list.setAdapter(user);


        customer_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent=new Intent(View_data.this,user_data.class);
                String s=customer_list.getItemAtPosition(i).toString();
                Cursor cursor=db.fetch_data(s);

                int idIndex = cursor.getColumnIndex("id");
                int nameIndex = cursor.getColumnIndex("name");
                int mobileIndex = cursor.getColumnIndex("phone");
                int addressIndex = cursor.getColumnIndex("address");


                while(cursor.moveToNext())
                {
                    id=cursor.getInt(idIndex);
                    name=cursor.getString(nameIndex);
                    mobile=cursor.getString(mobileIndex);
                    address=cursor.getString(addressIndex);


                }

                db.close();
                intent.putExtra("id",""+id);
                intent.putExtra("name",name);
                intent.putExtra("mobile",mobile);
                intent.putExtra("address",address);

                startActivity(intent);
            }
        });
    }
}