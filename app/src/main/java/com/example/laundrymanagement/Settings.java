
package com.example.laundrymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

public class Settings extends AppCompatActivity {

    Spinner lang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        lang=findViewById(R.id.spinner);
        String langs[]={"HINDI","ENGLISH","MARATHI"};
        ArrayAdapter<String> adapter =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,langs);
        lang.setAdapter(adapter);
    }
}