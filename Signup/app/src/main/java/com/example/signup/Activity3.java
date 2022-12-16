package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {
    private TextView texth;
    private TextView texts;
    private TextView textr;
    private Button btn3;
    private Button btn4;
    private TextView type;
    private TextView type2;
    private TextView type3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        texth=(TextView) findViewById(R.id.textView);
        texts=(TextView) findViewById(R.id.textView2);
        textr=(TextView) findViewById(R.id.textView5);
        btn3=(Button) findViewById(R.id.button);
        btn4=(Button) findViewById(R.id.button2);

        Bundle b=getIntent().getExtras();
        String d=b.getString("height");
        String s=b.getString("size");

        texth.setText("\n        Your Height is equal to : "+s);
        texts.setText("\n        Your Size is equal to : "+d);

        double hei = Double.parseDouble(s);
        double siz = Double.parseDouble(d);

        double r = siz / (hei * hei);
        String res = "";
        if (r > 0.004) {
            res = "Obesité massive";
        } else if (r <= 0.004 && r > 0.0035) {
            res = "Obesité sévere";
        } else if (r <= 0.0035 && r > 0.003) {
            res = "Obesité moderée";
        } else if (r <= 0.003 && r > 0.0025) {
            res = "Surpoids";
        } else if (r <= 0.0025 && r > 0.00185) {
            res = "Normale";
        } else if (r <= 0.00185 && r > 0.00165) {
            res = "Maigreur";
        } else if (r <= 0.00165) {
            res = "Famine";
        }


        textr.setText("\n        Type: "+res);


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        Intent intent2 = new Intent(Activity3.this, Activity4.class);
        type=(TextView) findViewById(R.id.textView5);
        Bundle myData2 = new Bundle();
        // ajouter des éléments données <key,value> au conteneur
        myData2.putString("header",type.getText().toString());
        intent2.putExtras(myData2);
        startActivity(intent2);}
    });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(Activity3.this, Activity2.class);
                Bundle myData3 = new Bundle();
                myData3.putString("value1", String.valueOf(hei));
                myData3.putString("value2", String.valueOf(siz));

                intent3.putExtras(myData3);
                startActivity(intent3);
                // put extras dose not copy the bundle inside of the intent in order to pass its data through it
                // instead it creates a copy of the bundle and put it inside of the intent
                intent3.putExtras(myData3);

                setResult(Activity.RESULT_OK, intent3);
                // finish is used to end the activity it self
            finish();}
        });


    }
}

