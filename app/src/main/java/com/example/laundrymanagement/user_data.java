package com.example.laundrymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class user_data extends AppCompatActivity {

    EditText et_id,et_name,et_mob,et_address;
    Button update;
    DBManager db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);
        et_id=findViewById(R.id.c_id);
        et_name=findViewById(R.id.c_name);
        et_mob=findViewById(R.id.c_mob);
        et_address=findViewById(R.id.c_add);


        db=new DBManager(user_data.this);
        update=findViewById(R.id.update);

        Intent i=getIntent();
        String id=i.getStringExtra("id");
        String name=i.getStringExtra("name");
        String mobile=i.getStringExtra("mobile");
        String address=i.getStringExtra("address");


        et_id.setText(""+id);
        et_name.setText(""+name);
        et_mob.setText(""+mobile);
        et_address.setText(""+address);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id1=et_id.getText().toString();
                String name1=et_name.getText().toString();
                String mobile1=et_mob.getText().toString();
                String address1=et_address.getText().toString();



                if(mobile1.length()>10 || mobile1.length()<10)
                {
                    Toast.makeText(user_data.this, "Enter valid Mobile Number", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(user_data.this, "Updated", Toast.LENGTH_SHORT).show();
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    db.update_data(id1,name1,mobile1,address1);
                    finish();
                }

            }
        });
    }
}