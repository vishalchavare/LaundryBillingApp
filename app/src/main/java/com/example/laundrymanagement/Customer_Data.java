package com.example.laundrymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Customer_Data extends AppCompatActivity {


    EditText name,phone,address;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_data);


        name=findViewById(R.id.c_name);
        phone=findViewById(R.id.c_phone);
        address=findViewById(R.id.c_address);
        next=findViewById(R.id.Next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c_name=name.getText().toString().trim();
                String c_phone=phone.getText().toString().trim();
                String c_address=address.getText().toString().toString();

                Toast.makeText(Customer_Data.this, ""+c_name+c_phone+c_address, Toast.LENGTH_SHORT).show();
                if(c_name.isEmpty() || c_phone.isEmpty() || c_address.isEmpty())
                {
                    Toast.makeText(Customer_Data.this, "Please fill all the blanks", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(c_phone.length()>10 || c_phone.length()<10)
                    {
                        Toast.makeText(Customer_Data.this, "Enter Valid Number", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        name.setText("");
                        phone.setText("");
                        address.setText("");
                        Intent i=new Intent(Customer_Data.this,Services.class);
                        i.putExtra("c_name",c_name);
                        i.putExtra("c_phone",c_phone);
                        i.putExtra("c_address",c_address);
                        startActivity(i);
                    }
                }
            }
        });
    }
}