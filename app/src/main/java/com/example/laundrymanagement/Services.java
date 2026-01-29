package com.example.laundrymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class Services extends AppCompatActivity {
    Item iron, wash, wash_iron, shoe, dry_cleaning, sofa, hard;
    Dialog iron_service_dialog;
    Dialog wash_service_dialog;
    Dialog wash_iron_service_dialog;
    Dialog shoe_cleaning_service_dialog;
    Dialog dry_cleaning_service_dialog;

    Button nor_plus, nor_minus;
    EditText iron_nor_et, iron_lk_et, iron_sari_et, iron_blazer_et,wash_only_et,wash_iron_et,shoe_nor_et,shoe_hl_et,shoe_l_et;
    EditText shirt_dc_et,trouser_dc_et,kurta_dc_et;
    ListView lv_service;

    double iron_nor=0, iron_lk=0, iron_sari=0, iron_blazer=0;
    double wash_only=0,wash_iron_1=0;
    double shoe_nor=0,shoe_hl=0,shoe_l=0;
    double shirt_dc=0,trouser_dc=0,kurta_dc=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        iron_service_dialog = new Dialog(this);
        wash_service_dialog = new Dialog(this);
        wash_iron_service_dialog = new Dialog(this);
        shoe_cleaning_service_dialog=new Dialog(this);
        dry_cleaning_service_dialog=new Dialog(this);

        lv_service = findViewById(R.id.lv_service);

        ArrayList<Item> arr = new ArrayList<>();

        iron = new Item(R.drawable.iron, 04, "Iron");
        wash = new Item(R.drawable.wash, 01, "Wash Only");
        wash_iron = new Item(R.drawable.wash_iron, 01, "Wash + Iron");
        shoe = new Item(R.drawable.shoes, 03, "Shoe Cleaning");
        dry_cleaning = new Item(R.drawable.dry_cleaning, 01, "Dry Cleaning");
        sofa = new Item(R.drawable.sofa_cleaning, 01, "Sofa Cleaning");
        hard = new Item(R.drawable.hard_wash, 01, "Hard Wash");
        arr.add(iron);
        arr.add(wash);
        arr.add(wash_iron);
        arr.add(shoe);
        arr.add(dry_cleaning);
        arr.add(sofa);
        arr.add(hard);

        ServiceAdapter adapter = new ServiceAdapter(this, 0, arr);
        lv_service.setAdapter(adapter);


        lv_service.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object o = lv_service.getItemAtPosition(i);
                if (o.equals(iron)) {
                    iron_service_dialog.setContentView(R.layout.iron_service);

                    iron_nor_et = iron_service_dialog.findViewById(R.id.iron_nor_et);
                    iron_lk_et = iron_service_dialog.findViewById(R.id.iron_lk_et);
                    iron_sari_et = iron_service_dialog.findViewById(R.id.iron_sari_et);
                    iron_blazer_et = iron_service_dialog.findViewById(R.id.iron_blazer_et);

                    iron_nor_et.setText(""+(int)iron_nor);
                    iron_lk_et.setText(""+(int)iron_lk);
                    iron_sari_et.setText(""+(int)iron_sari);
                    iron_blazer_et.setText(""+(int)iron_blazer);

                    iron_service_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    iron_service_dialog.show();

                } else if (o.equals(wash)) {
                    wash_service_dialog.setContentView(R.layout.wash_only_service);

                    wash_only_et=wash_service_dialog.findViewById(R.id.wash_only_et);

                    if(wash_only==0)
                    {
                        wash_only_et.setText("");
                    }
                    else
                    {
                        wash_only_et.setText(""+wash_only);
                    }
                    wash_service_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    wash_service_dialog.show();
                } else if (o.equals(wash_iron)) {

                    wash_iron_service_dialog.setContentView(R.layout.wash_iron_service);
                    wash_iron_et=wash_iron_service_dialog.findViewById(R.id.wash_iron_et);

                    if(wash_iron_1==0)
                    {
                        wash_iron_et.setText("");
                    }
                    else
                    {
                        wash_iron_et.setText(""+wash_iron_1);
                    }
                    wash_iron_service_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    wash_iron_service_dialog.show();
                } else if (o.equals(shoe)) {
                    shoe_cleaning_service_dialog.setContentView(R.layout.shoe_cleaning_service);
                    shoe_nor_et = shoe_cleaning_service_dialog.findViewById(R.id.shoe_nor_et);
                    shoe_hl_et = shoe_cleaning_service_dialog.findViewById(R.id.shoe_hl_et);
                    shoe_l_et = shoe_cleaning_service_dialog.findViewById(R.id.shoe_l_et);

                    shoe_nor_et.setText(""+(int)shoe_nor);
                    shoe_hl_et.setText(""+(int)shoe_hl);
                    shoe_l_et.setText(""+(int)shoe_l);

                    shoe_cleaning_service_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    shoe_cleaning_service_dialog.show();
                } else if (o.equals(dry_cleaning)) {
                    dry_cleaning_service_dialog.setContentView(R.layout.dry_cleaning_service);
                    shirt_dc_et=dry_cleaning_service_dialog.findViewById(R.id.shirt_dc_et);
                    trouser_dc_et=dry_cleaning_service_dialog.findViewById(R.id.trouser_dc_et);
                    kurta_dc_et=dry_cleaning_service_dialog.findViewById(R.id.kurta_dc_et);

                    shirt_dc_et.setText(""+(int)shirt_dc);
                    trouser_dc_et.setText(""+(int)trouser_dc);
                    kurta_dc_et.setText(""+(int)kurta_dc);

                    dry_cleaning_service_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dry_cleaning_service_dialog.show();


                } else if (o.equals(sofa)) {

                } else if (o.equals(hard)) {

                } else {

                }


            }
        });


    }

    public void iron_norPlus(View view) {

        int count = Integer.parseInt(iron_nor_et.getText().toString());
        if (count < 0) {
            count = 0;
        } else {
            count++;
        }

        iron_nor_et.setText("" + count);


    }

    public void iron_norMinus(View view) {
        int count = Integer.parseInt(iron_nor_et.getText().toString());
        if (count <= 0) {
            count = 0;
        } else {
            count--;
        }

        iron_nor_et.setText("" + count);
    }

    public void iron_lkPlus(View view) {

        int count = Integer.parseInt(iron_lk_et.getText().toString());
        if (count < 0) {
            count = 0;
        } else {
            count++;
        }

        iron_lk_et.setText("" + count);


    }

    public void iron_lkMinus(View view) {
        int count = Integer.parseInt(iron_lk_et.getText().toString());
        if (count <= 0) {
            count = 0;
        } else {
            count--;
        }

        iron_lk_et.setText("" + count);
    }

    public void iron_sariPlus(View view) {

        int count = Integer.parseInt(iron_sari_et.getText().toString());
        if (count < 0) {
            count = 0;
        } else {
            count++;
        }

        iron_sari_et.setText("" + count);


    }

    public void iron_sariMinus(View view) {
        int count = Integer.parseInt(iron_sari_et.getText().toString());
        if (count <= 0) {
            count = 0;
        } else {
            count--;
        }

        iron_sari_et.setText("" + count);
    }

    public void iron_blazerPlus(View view) {

        int count = Integer.parseInt(iron_blazer_et.getText().toString());
        if (count < 0) {
            count = 0;
        } else {
            count++;
        }

        iron_blazer_et.setText("" + count);


    }

    public void iron_blazerMinus(View view) {
        int count = Integer.parseInt(iron_blazer_et.getText().toString());
        if (count <= 0) {
            count = 0;
        } else {
            count--;
        }

        iron_blazer_et.setText("" + count);
    }


    public void shoe_norPlus(View view)
    {
        int count=Integer.parseInt(shoe_nor_et.getText().toString());
        if(count<0)
        {
            count=0;
        }
        else
        {
            count++;
        }
        shoe_nor_et.setText(""+count);
    }
    public void shoe_norMinus(View view)
    {
        int count=Integer.parseInt(shoe_nor_et.getText().toString());
        if(count<=0)
        {
            count=0;
        }
        else
        {
            count--;
        }
        shoe_nor_et.setText(""+count);
    }

    public void shoe_hl_Plus(View view)
    {
        int count=Integer.parseInt(shoe_hl_et.getText().toString());
        if(count<0)
        {
            count=0;
        }
        else
        {
            count++;
        }
        shoe_hl_et.setText(""+count);
    }
    public void shoe_hl_Minus(View view)
    {
        int count=Integer.parseInt(shoe_hl_et.getText().toString());
        if(count<=0)
        {
            count=0;
        }
        else
        {
            count--;
        }
        shoe_hl_et.setText(""+count);
    }

    public void shoe_l_Plus(View view)
    {
        int count=Integer.parseInt(shoe_l_et.getText().toString());
        if(count<0)
        {
            count=0;
        }
        else
        {
            count++;
        }
        shoe_l_et.setText(""+count);
    }

    public void shoe_l_Minus(View view)
    {
        int count=Integer.parseInt(shoe_l_et.getText().toString());
        if(count<=0)
        {
            count=0;
        }
        else
        {
            count--;
        }
        shoe_l_et.setText(""+count);
    }


    public void shirt_dcPlus(View view)
    {
        int count=Integer.parseInt(shirt_dc_et.getText().toString());
        if(count<0)
        {
            count=0;
        }
        else
        {
            count++;
        }
        shirt_dc_et.setText(""+count);
    }

    public void shirt_dcMinus(View view)
    {
        int count=Integer.parseInt(shirt_dc_et.getText().toString());
        if(count<=0)
        {
            count=0;
        }
        else
        {
            count--;
        }
        shirt_dc_et.setText(""+count);
    }
    public void trouser_dcPlus(View view)
    {
        int count=Integer.parseInt(trouser_dc_et.getText().toString());
        if(count<0)
        {
            count=0;
        }
        else
        {
            count++;
        }
        trouser_dc_et.setText(""+count);
    }

    public void trouser_dcMinus(View view)
    {
        int count=Integer.parseInt(trouser_dc_et.getText().toString());
        if(count<=0)
        {
            count=0;
        }
        else
        {
            count--;
        }
        trouser_dc_et.setText(""+count);
    }
    public void kurta_dcPlus(View view)
    {
        int count=Integer.parseInt(kurta_dc_et.getText().toString());
        if(count<0)
        {
            count=0;
        }
        else
        {
            count++;
        }
        kurta_dc_et.setText(""+count);
    }

    public void kurta_dcMinus(View view)
    {
        int count=Integer.parseInt(kurta_dc_et.getText().toString());
        if(count<=0)
        {
            count=0;
        }
        else
        {
            count--;
        }
        kurta_dc_et.setText(""+count);
    }

    public void iron_total(View view)
    {
        iron_nor = Double.parseDouble(iron_nor_et.getText().toString());
        iron_lk = Double.parseDouble(iron_lk_et.getText().toString());
        iron_sari = Double.parseDouble(iron_sari_et.getText().toString());
        iron_blazer = Double.parseDouble(iron_blazer_et.getText().toString());
        iron_service_dialog.hide();

    }

    public void wash_only_total(View view)
    {
        if(! wash_only_et.getText().toString().isEmpty())
        {
            wash_only = Double.parseDouble(wash_only_et.getText().toString());
            wash_service_dialog.hide();
        }

    }

    public void wash_iron_total(View view)
    {
        if(! wash_iron_et.getText().toString().isEmpty())
        {
            wash_iron_1 = Double.parseDouble(wash_iron_et.getText().toString());
            wash_iron_service_dialog.hide();
        }

    }

    public void shoe_total(View view) {
        shoe_nor = Double.parseDouble(shoe_nor_et.getText().toString());
        shoe_hl = Double.parseDouble(shoe_hl_et.getText().toString());
        shoe_l = Double.parseDouble(shoe_l_et.getText().toString());
        shoe_cleaning_service_dialog.hide();

    }

    public void dc_total(View view) {
        shirt_dc = Double.parseDouble(shirt_dc_et.getText().toString());
        trouser_dc = Double.parseDouble(trouser_dc_et.getText().toString());
        kurta_dc = Double.parseDouble(kurta_dc_et.getText().toString());
        dry_cleaning_service_dialog.hide();

    }
        public void invoice_Page(View v)
    {
        Intent in_page=new Intent(Services.this,Invoice.class);
        in_page.putExtra("iron_nor",iron_nor);
        in_page.putExtra("iron_lk",iron_lk);
        in_page.putExtra("iron_sari",iron_sari);
        in_page.putExtra("iron_blazer",iron_blazer);
        in_page.putExtra("wash_only",wash_only);
        in_page.putExtra("wash_iron",wash_iron_1);
        in_page.putExtra("shoe_nor",shoe_nor);
        in_page.putExtra("shoe_hl",shoe_hl);
        in_page.putExtra("shoe_l",shoe_l);
        in_page.putExtra("shirt_dc",shirt_dc);
        in_page.putExtra("trouser_dc",trouser_dc);
        in_page.putExtra("kurta_dc",kurta_dc);
        in_page.putExtra("c_name",getIntent().getStringExtra("c_name"));
        in_page.putExtra("c_phone",getIntent().getStringExtra("c_phone"));
        in_page.putExtra("c_address",getIntent().getStringExtra("c_address"));
        startActivity(in_page);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        iron_nor=0;
        iron_lk=0;
        iron_sari=0;
        iron_blazer=0;
        wash_only=0;
        wash_iron_1=0;
        shoe_nor=0;
        shoe_hl=0;
        shoe_l=0;
        shirt_dc=0;
        trouser_dc=0;
        kurta_dc=0;
    }
}