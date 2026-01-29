package com.example.laundrymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class User_data_unpaid extends AppCompatActivity {


    SmsManager sms;
    EditText id,name,bill;

    DBManager db;
    Button reminder,update;
    String id1,name1, phone1,bill1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data_unpaid);

        sms=SmsManager.getDefault();
        id=findViewById(R.id.c_id);
        name=findViewById(R.id.c_name);
        bill=findViewById(R.id.c_unpaid_et);
        reminder=findViewById(R.id.reminder);
        update=findViewById(R.id.update);

        db=new DBManager(this);
        Intent i=getIntent();
        id1=i.getStringExtra("id");
        name1=i.getStringExtra("name");
        bill1=i.getStringExtra("bill");
        phone1 =i.getStringExtra("phone");
        id.setText(id1);
        name.setText(name1);
        bill.setText(bill1);


        String msg="Dear Customer, "+name1+" Your Laundry bill "+bill1+" rs. is pending please pay your bill as soon as possible";
        reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(User_data_unpaid.this, ""+ phone1, Toast.LENGTH_SHORT).show();
                sms.sendTextMessage(phone1,null,msg,null,null);
            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u_bill=bill.getText().toString();
                db.update_bill(id1,u_bill);
                finish();
            }
        });

    }
}