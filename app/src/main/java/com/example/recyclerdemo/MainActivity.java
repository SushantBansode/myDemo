package com.example.recyclerdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.rv);
        ArrayList<DateDay> arrayList=new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd");
        SimpleDateFormat day = new SimpleDateFormat("EEEE");
        Date date = new Date();
         String currentDate=formatter.format(date);
         DateDay dateDay=new DateDay();
        dateDay.setDate(currentDate);
        dateDay.setDay(day.format(date).substring(0,3));
        arrayList.add(dateDay);
        for(int i=1;i<=6;i++){
            DateDay dateDay1=new DateDay();
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, i);
            String newDate = formatter.format(cal.getTime());
            System.out.println("Incremnted current date by one: "+newDate+day.format(cal.getTime()).substring(0,3));
            dateDay1.setDate(newDate);
            dateDay1.setDay(day.format(cal.getTime()).substring(0,3));
            arrayList.add(dateDay1);
        }
        customAdapter=new CustomAdapter(this,arrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);
        rv.setLayoutManager(mLayoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(customAdapter);


    }
}
