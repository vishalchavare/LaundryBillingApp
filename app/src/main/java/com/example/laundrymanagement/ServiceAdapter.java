package com.example.laundrymanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class ServiceAdapter extends ArrayAdapter<Item> {
    private Context ct;
    private ArrayList<Item> arr;
    public ServiceAdapter(@NonNull Context context, int resource, @NonNull List<Item> objects) {
        super(context, resource, objects);
        this.ct=context;
        this.arr=new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent)
    {
        if(convertView==null)
        {
            LayoutInflater i=(LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =i.inflate(R.layout.activity_list_items,null);
        }
        if(arr.size()>0)
        {
            Item d=arr.get(position);
            ImageView imgSer=convertView.findViewById(R.id.img_ser);
            imgSer.setImageResource(d.image);

            TextView tvSer=convertView.findViewById(R.id.tv_ser);
            tvSer.setText(d.name);

            TextView numSer=convertView.findViewById(R.id.num_ser);
            numSer.setText(d.numItem+" Services");
        }
        return convertView;
    }
}

