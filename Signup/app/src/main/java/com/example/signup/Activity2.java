package com.example.signup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends Activity {
    private EditText height;
    private EditText size;
    private Button btn2;
    private TextView resultat;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activity_main howa esm el ficher xml mteena
        setContentView(R.layout.activity2);
        EditText size=(EditText) findViewById(R.id.editTextNumber);
        EditText height=(EditText) findViewById(R.id.editTextNumber2);
        btn2=(Button) findViewById(R.id.button2);
        resultat=(TextView) findViewById(R.id.textView6);


    btn2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            //resultat.setText(res);
            Intent intent = new Intent(Activity2.this, Activity3.class);
            Bundle myData = new Bundle();
            // ajouter des éléments données <key,value> au conteneur
            myData.putString("height",height.getText().toString());
            myData.putString("size",size.getText().toString());
            intent.putExtras(myData);
            startActivityForResult(intent,101);


        }

});

        try {

                Intent data = getIntent();
                Bundle myResults = data.getExtras();
                String vresult = myResults.getString("value1");
                String vresult2 = myResults.getString("value2");
                System.out.println(vresult);
                resultat.setText("Value of Height " + vresult+" Value of Size " + vresult2);

        } catch (Exception e) {
            resultat.setText(" ");

        }

}



}