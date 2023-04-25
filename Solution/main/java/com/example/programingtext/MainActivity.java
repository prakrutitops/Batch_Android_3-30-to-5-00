package com.example.programingtext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableLayout t1=findViewById(R.id.table);
        TableRow row=new TableRow(this);
        TextView tv= new TextView(this);
        tv.setText("this is textview.");

        t1.addView(row);
        row.addView(tv);

    }
}
