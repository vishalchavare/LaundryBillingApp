package com.example.laundrymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Invoice extends AppCompatActivity {

    private static final int  r_iron_nor = 8;
    private static final int  r_iron_lk = 10;
    private static final int  r_iron_sari = 60;
    private static final int  r_iron_blazer = 80;
    private static final int  r_normal_steam_i = 10;
    private static final int  r_wash_only = 59;
    private static final int  r_wash_iron = 89;
    private static final int  r_shirt_dc = 70;
    private static final int  r_trouser_dc = 70;
    private static final int  r_kurta_dc = 100;
    private static final int r_shoe_nor = 200;
    private static final int  r_shoe_hl = 250;
    private static final int  r_shoe_l = 300;
    private static final int  r_certain_wash = 8;

    DBManager db;
    TextView todays_date,c_name;

    TextView total_tv;

    double normal_iron_t=0,iron_lk_t=0,iron_sari_t=0,iron_blazer_t=0,normal_str_iron_t=0,wash_only_t=0,wash_iron_t=0,
            shirt_dc_t=0, trouser_dc_t=0,kurta_dc_t=0, shoe_nor_t=0,
            shoe_hl_t=0, shoe_l_t=0,certain_wash_t=0;

    double total;
    Button paid,unpaid;
    TableRow normal_iron_tr,iron_lk_tr,iron_sari_tr,iron_blazer_tr,
            normal_str_iron_tr,wash_only_tr,wash_iron_tr,
            shirt_dc_tr, trouser_dc_tr,kurta_dc_tr, shoe_nor_tr,
            shoe_hl_tr, shoe_l_tr,certain_wash_tr;

    TextView  normal_iron_qty,iron_lk_qty,iron_sari_qty,iron_blazer_qty,
            normal_str_iron_qty,wash_only_qty,wash_iron_qty,
            shirt_dc_qty, trouser_dc_qty,kurta_dc_qty, shoe_nor_qty,
            shoe_hl_qty, shoe_l_qty,certain_wash_qty;

    TextView  normal_iron_total,iron_lk_total,iron_sari_total,iron_blazer_total,
            normal_str_iron_total,wash_only_total,wash_iron_total,
            shirt_dc_total, trouser_dc_total,kurta_dc_total, shoe_nor_total,
            shoe_hl_total, shoe_l_total,certain_wash_total;


    String str_c_name,str_c_phone,str_c_address;
    double iron_nor, iron_lk, iron_sari, iron_blazer,wash_only,wash_iron,shoe_nor,shoe_hl,shoe_l,shirt_dc,trouser_dc,kurta_dc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        db=new DBManager(Invoice.this);

        total_tv=findViewById(R.id.total_tv);

        total_tv.setText("0");
        Intent i =getIntent();
        iron_nor=i.getDoubleExtra("iron_nor",0.00);
        iron_lk=i.getDoubleExtra("iron_lk",0.00);
        iron_sari=i.getDoubleExtra("iron_sari",0.00);
        iron_blazer=i.getDoubleExtra("iron_blazer",0.00);
        wash_only=i.getDoubleExtra("wash_only",0.00);
        wash_iron=i.getDoubleExtra("wash_iron",0.00);
        shoe_nor=i.getDoubleExtra("shoe_nor",0.00);
        shoe_hl=i.getDoubleExtra("shoe_hl",0.00);
        shoe_l=i.getDoubleExtra("shoe_l",0.00);
        shirt_dc=i.getDoubleExtra("shirt_dc",0.00);
        trouser_dc=i.getDoubleExtra("trouser_dc",0.00);
        kurta_dc=i.getDoubleExtra("kurta_dc",0.00);


        str_c_name=i.getStringExtra("c_name");
        str_c_phone=i.getStringExtra("c_phone");
        str_c_address=i.getStringExtra("c_address");

        paid =findViewById(R.id.paid);
        unpaid=findViewById(R.id.unpaid);

        normal_iron_tr=findViewById(R.id.normal_iron_tr);
        iron_lk_tr=findViewById(R.id.iron_lk_tr);
        iron_sari_tr=findViewById(R.id.iron_sari_tr);
        iron_blazer_tr=findViewById(R.id.iron_blazer_tr);
        normal_str_iron_tr=findViewById(R.id.normal_str_iron_tr);
        wash_only_tr=findViewById(R.id.wash_only_tr);
        wash_iron_tr=findViewById(R.id.wash_iron_tr);
        shirt_dc_tr =findViewById(R.id.shirt_dc_tr);
        trouser_dc_tr =findViewById(R.id.trouser_dc_tr);
        kurta_dc_tr =findViewById(R.id.kurta_dc_tr);
        shoe_nor_tr =findViewById(R.id.shoes_cleaning_tr);
        shoe_hl_tr =findViewById(R.id.half_leather_tr);
        shoe_l_tr =findViewById(R.id.leather_shoes_tr);
        certain_wash_tr=findViewById(R.id.certain_wash_tr);

        normal_iron_qty=findViewById(R.id.i_nor_qty);
        iron_lk_qty=findViewById(R.id.i_lk_qty);
        iron_sari_qty=findViewById(R.id.i_sari_qty);
        iron_blazer_qty=findViewById(R.id.i_blazer_qty);
        normal_str_iron_qty=findViewById(R.id.str_i_nor_qty);
        wash_only_qty=findViewById(R.id.w_only_qty);
        wash_iron_qty=findViewById(R.id.w_iron_qty);
        shirt_dc_qty =findViewById(R.id.shirt_dc_qty);
        trouser_dc_qty =findViewById(R.id.trouser_dc_qty);
        kurta_dc_qty =findViewById(R.id.kurta_dc_qty);
        shoe_nor_qty =findViewById(R.id.shoes_clean_qty);
        shoe_hl_qty =findViewById(R.id.shoes_clean_hl_qty);
        shoe_l_qty =findViewById(R.id.shoes_clean_l_qty);

        normal_iron_total=findViewById(R.id.iron_nor_total);
        iron_lk_total=findViewById(R.id.iron_lk_total);
        iron_sari_total=findViewById(R.id.iron_sari_total);
        iron_blazer_total=findViewById(R.id.iron_blazer_total);
        wash_only_total=findViewById(R.id.wash_only_total);
        wash_iron_total=findViewById(R.id.wash_iron_total);
        shirt_dc_total =findViewById(R.id.shirt_dc_total);
        trouser_dc_total =findViewById(R.id.trouser_dc_total);
        kurta_dc_total =findViewById(R.id.kurta_dc_total);
        shoe_nor_total =findViewById(R.id.shoes_clean_total);
        shoe_hl_total =findViewById(R.id.shoes_clean_hl_total);
        shoe_l_total =findViewById(R.id.shoes_clean_l_total);
        certain_wash_total=findViewById(R.id.certain_wash_total);



        normal_iron_t=Double.parseDouble(normal_iron_total.getText().toString());
        iron_lk_t=Double.parseDouble(iron_lk_total.getText().toString());
        iron_sari_t=Double.parseDouble(iron_sari_total.getText().toString());
        iron_blazer_t=Double.parseDouble(iron_blazer_total.getText().toString());
        wash_only_t=Double.parseDouble(wash_only_total.getText().toString());
        wash_iron_t=Double.parseDouble(wash_iron_total.getText().toString());
        shirt_dc_t =Double.parseDouble(shirt_dc_total.getText().toString());
        trouser_dc_t =Double.parseDouble(trouser_dc_total.getText().toString());
        kurta_dc_t =Double.parseDouble(kurta_dc_total.getText().toString());
        shoe_nor_t =Double.parseDouble(shoe_nor_total.getText().toString());
        shoe_hl_t =Double.parseDouble(shoe_hl_total.getText().toString());
        shoe_l_t =Double.parseDouble(shoe_l_total.getText().toString());
        certain_wash_t=Double.parseDouble(certain_wash_total.getText().toString());

        total=0;
        total=(normal_iron_t+iron_lk_t+iron_sari_t+iron_blazer_t+normal_str_iron_t+wash_only_t+wash_iron_t+ shirt_dc_t + trouser_dc_t +kurta_dc_t+ shoe_nor_t +
                shoe_hl_t + shoe_l_t +certain_wash_t);
        total_tv.setText(""+total);

        todays_date=findViewById(R.id.today_date);
        c_name=findViewById(R.id.c_name);

        c_name.setText(str_c_name);


        LocalDate today = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            today = LocalDate.now();
        }
        DateTimeFormatter formatter = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            String formattedDate = today.format(formatter);

            todays_date.setText(formattedDate);
        }
        if(iron_nor!=0)
        {
            normal_iron_tr.setVisibility(View.VISIBLE);
            normal_iron_qty.setText(""+(int)iron_nor);
            normal_iron_total.setText(""+(r_iron_nor*iron_nor));
        }
        if(iron_lk!=0)
        {
            iron_lk_tr.setVisibility(View.VISIBLE);
            iron_lk_qty.setText(""+(int)iron_lk);
            iron_lk_total.setText(""+(r_iron_lk*iron_lk));
        }
        if(iron_sari!=0)
        {
            iron_sari_tr.setVisibility(View.VISIBLE);
            iron_sari_qty.setText(""+(int)iron_sari);
            iron_sari_total.setText(""+r_iron_sari*iron_sari);
        }
        if(iron_blazer!=0)
        {
            iron_blazer_tr.setVisibility(View.VISIBLE);
            iron_blazer_qty.setText(""+(int)iron_blazer);
            iron_blazer_total.setText(""+r_iron_blazer*iron_blazer);
        }
        if(wash_only!=0)
        {
            wash_only_tr.setVisibility(View.VISIBLE);
            wash_only_qty.setText(""+wash_only);
            wash_only_total.setText(""+r_wash_only*wash_only);
        }
        if(wash_iron!=0)
        {
            wash_iron_tr.setVisibility(View.VISIBLE);
            wash_iron_qty.setText(""+wash_iron);
            wash_iron_total.setText(""+r_wash_iron*wash_iron);
        }
        if(shoe_nor!=0)
        {
            shoe_nor_tr.setVisibility(View.VISIBLE);
            shoe_nor_qty.setText(""+shoe_nor);
            shoe_nor_total.setText(""+shoe_nor*r_shoe_nor);
        }
        if(shoe_hl!=0)
        {
            shoe_hl_tr.setVisibility(View.VISIBLE);
            shoe_hl_qty.setText(""+shoe_hl);
            shoe_hl_total.setText(""+shoe_hl*r_shoe_hl);
        }

        if(shoe_l!=0)
        {
            shoe_l_tr.setVisibility(View.VISIBLE);
            shoe_l_qty.setText(""+shoe_l);
            shoe_l_total.setText(""+shoe_l*r_shoe_l);
        }
        if(shirt_dc!=0)
        {
            shirt_dc_tr.setVisibility(View.VISIBLE);
            shirt_dc_qty.setText(""+shirt_dc);
            shirt_dc_total.setText(""+shirt_dc*r_shirt_dc);
        }
        if(trouser_dc!=0)
        {
            trouser_dc_tr.setVisibility(View.VISIBLE);
            trouser_dc_qty.setText(""+trouser_dc);
            trouser_dc_total.setText(""+trouser_dc*r_trouser_dc);
        }
        if(kurta_dc!=0)
        {
            kurta_dc_tr.setVisibility(View.VISIBLE);
            kurta_dc_qty.setText(""+kurta_dc);
            kurta_dc_total.setText(""+kurta_dc*r_kurta_dc);
        }

        paid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.insert_into(str_c_name,str_c_phone,str_c_address,"0");
                db.insert_transaction(str_c_name,total_tv.getText().toString());
                Toast.makeText(Invoice.this, "Data Recorded", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Invoice.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        unpaid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Invoice.this,Unpaid_page.class);
                i.putExtra("name",getIntent().getStringExtra("c_name"));
                i.putExtra("phone",getIntent().getStringExtra("c_phone"));
                i.putExtra("bill",total_tv.getText().toString());
                db.insert_into(str_c_name,str_c_phone,str_c_address,""+total);
                db.insert_transaction(str_c_name,total_tv.getText().toString());
                startActivity(i);
            }
        });


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        normal_iron_t=Double.parseDouble(normal_iron_total.getText().toString());
        iron_lk_t=Double.parseDouble(iron_lk_total.getText().toString());
        iron_sari_t=Double.parseDouble(iron_sari_total.getText().toString());
        iron_blazer_t=Double.parseDouble(iron_blazer_total.getText().toString());
        wash_only_t=Double.parseDouble(wash_only_total.getText().toString());
        wash_iron_t=Double.parseDouble(wash_iron_total.getText().toString());
        shirt_dc_t =Double.parseDouble(shirt_dc_total.getText().toString());
        trouser_dc_t =Double.parseDouble(trouser_dc_total.getText().toString());
        kurta_dc_t =Double.parseDouble(kurta_dc_total.getText().toString());
        shoe_nor_t =Double.parseDouble(shoe_nor_total.getText().toString());
        shoe_hl_t =Double.parseDouble(shoe_hl_total.getText().toString());
        shoe_l_t =Double.parseDouble(shoe_l_total.getText().toString());
        certain_wash_t=Double.parseDouble(certain_wash_total.getText().toString());

        total=0;
        total=(normal_iron_t+iron_lk_t+iron_sari_t+iron_blazer_t+normal_str_iron_t+wash_only_t+wash_iron_t+ shirt_dc_t + trouser_dc_t +kurta_dc_t+ shoe_nor_t +
                shoe_hl_t + shoe_l_t +certain_wash_t);
        total_tv.setText(""+total);
    }

    @Override
    protected void onResume() {
        super.onResume();
        normal_iron_t=Double.parseDouble(normal_iron_total.getText().toString());
        iron_lk_t=Double.parseDouble(iron_lk_total.getText().toString());
        iron_sari_t=Double.parseDouble(iron_sari_total.getText().toString());
        iron_blazer_t=Double.parseDouble(iron_blazer_total.getText().toString());
        wash_only_t=Double.parseDouble(wash_only_total.getText().toString());
        wash_iron_t=Double.parseDouble(wash_iron_total.getText().toString());
        shirt_dc_t =Double.parseDouble(shirt_dc_total.getText().toString());
        trouser_dc_t =Double.parseDouble(trouser_dc_total.getText().toString());
        kurta_dc_t =Double.parseDouble(kurta_dc_total.getText().toString());
        shoe_nor_t =Double.parseDouble(shoe_nor_total.getText().toString());
        shoe_hl_t =Double.parseDouble(shoe_hl_total.getText().toString());
        shoe_l_t =Double.parseDouble(shoe_l_total.getText().toString());
        certain_wash_t=Double.parseDouble(certain_wash_total.getText().toString());


        total=0;
        total=(normal_iron_t+iron_lk_t+iron_sari_t+iron_blazer_t+normal_str_iron_t+wash_only_t+wash_iron_t+ shirt_dc_t + trouser_dc_t +kurta_dc_t+ shoe_nor_t +
                shoe_hl_t + shoe_l_t +certain_wash_t);
        total_tv.setText(""+total);
    }

    @Override
    protected void onStart() {
        super.onStart();
        normal_iron_t=Double.parseDouble(normal_iron_total.getText().toString());
        iron_lk_t=Double.parseDouble(iron_lk_total.getText().toString());
        iron_sari_t=Double.parseDouble(iron_sari_total.getText().toString());
        iron_blazer_t=Double.parseDouble(iron_blazer_total.getText().toString());
        wash_only_t=Double.parseDouble(wash_only_total.getText().toString());
        wash_iron_t=Double.parseDouble(wash_iron_total.getText().toString());
        shirt_dc_t =Double.parseDouble(shirt_dc_total.getText().toString());
        trouser_dc_t =Double.parseDouble(trouser_dc_total.getText().toString());
        kurta_dc_t =Double.parseDouble(kurta_dc_total.getText().toString());
        shoe_nor_t =Double.parseDouble(shoe_nor_total.getText().toString());
        shoe_hl_t =Double.parseDouble(shoe_hl_total.getText().toString());
        shoe_l_t =Double.parseDouble(shoe_l_total.getText().toString());
        certain_wash_t=Double.parseDouble(certain_wash_total.getText().toString());

        total=0;
        total=(normal_iron_t+iron_lk_t+iron_sari_t+iron_blazer_t+normal_str_iron_t+wash_only_t+wash_iron_t+ shirt_dc_t + trouser_dc_t +kurta_dc_t+ shoe_nor_t +
                shoe_hl_t + shoe_l_t +certain_wash_t);
        total_tv.setText(""+total);

    }
}