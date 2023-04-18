package com.example.twonumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText edt1,edt2;
    Button btn;
    TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1=findViewById(R.id.edt1);
        edt2=findViewById(R.id.edt2);
        btn=findViewById(R.id.btn);
        txt1=findViewById(R.id.text);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int lowNum = Integer.parseInt(String.valueOf(edt1.getText()));
                int highNum = Integer.parseInt(String.valueOf(edt2.getText()));

                StringBuilder sb = new StringBuilder(String.valueOf(lowNum));
                for (int i = lowNum + 1; i <= highNum; i++) {
                    sb.append(", ").append(i);
                }

                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                i.putExtra("data",sb.toString());
                startActivity(i);


            }
        });
    }
}
