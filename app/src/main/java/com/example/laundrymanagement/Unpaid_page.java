package com.example.laundrymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Unpaid_page extends AppCompatActivity {

    SmsManager sms;
    String bill;
    Button yes,no;
    String mob;
    String msg;

    DBManager db;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unpaid_page);

        db=new DBManager(Unpaid_page.this);
        Intent i=getIntent();
        name=i.getStringExtra("name");
        mob=i.getStringExtra("phone");
        bill=i.getStringExtra("bill");

        String msg="Dear Customer, "+name+" Your Laundry bill "+bill+" rs. is pending please pay your bill as soon as possible";
        sms=SmsManager.getDefault();
        yes=findViewById(R.id.yes);
        no=findViewById(R.id.no);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sms.sendTextMessage(mob,null,msg,null,null);
                Toast.makeText(Unpaid_page.this, "Message Sent to Customer", Toast.LENGTH_SHORT).show();
            }
        });
    }
}