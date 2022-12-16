package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText email;
    private EditText  pwd;
    private EditText pwd2;
    private Button btn;
    private ProgressBar pb;
    int count=0;
    Timer timer;

    List<String> l = new ArrayList<>(List.of("ilyesrezgui46@gmail.com","ilyes.rezgui@etudiant-isi.utm.tn","xx@gmail.com"));
    //String[] tab={"ilyesrezgui46@gmail.com","ilyes.rezgui@etudiant-isi.utm.tn","xx@gmail.com","yy@gmail.com"};
    //int l=tab.length;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activity_main howa esm el ficher xml mteena
        setContentView(R.layout.activity_main);


        username=(EditText) findViewById(R.id.username);
        email=(EditText) findViewById(R.id.email);
        pwd=(EditText) findViewById(R.id.pwd);
        pwd2=(EditText) findViewById(R.id.pwd2);
        btn=(Button) findViewById(R.id.button);
        pb=(ProgressBar) findViewById(R.id.pb) ;
        timer = new Timer();


        //btn howa esm el objet
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String un= username.getText().toString();
                String pw= pwd.getText().toString();
                String pass2= pwd2.getText().toString();
                String em= email.getText().toString();





                //String found="Welcome To Myymle-Community";
                // lengh_short is the time the toast is gonna be shown and it is equal to 2 seconds , lengh-long is equal to 3.5
                if (un.isEmpty()){
                    Toast.makeText(MainActivity.this,"you have to fill the Username", Toast.LENGTH_SHORT).show();


                }
                else if (pw.isEmpty()){
                    Toast.makeText(MainActivity.this,"you have to fill the Password", Toast.LENGTH_SHORT).show();


                }
                else if (!(pw.equals(pass2))){
                    Toast.makeText(MainActivity.this,"Both passwords needs to be identic", Toast.LENGTH_SHORT).show();


                }else if (em.isEmpty()) {
                    Toast.makeText(MainActivity.this,"Fill the email space", Toast.LENGTH_SHORT).show();


                }
                else{


                for (int i = 0;i<l.size(); i++){

                    if (l.get(i).equals(em)){
                        Toast.makeText(MainActivity.this,"Email ", Toast.LENGTH_SHORT).show();
                        break;
                        // length-short represent le temps eli tooked fih el popup

                    }
                    else{

                        l.add(em);
                        Toast.makeText(MainActivity.this,l.get(l.size()-1),Toast.LENGTH_SHORT).show();

                        TimerTask timerTask =new TimerTask(){

                            @Override
                            public void run() {

                                count++;

                                pb.setProgress(count);
                                if (count==1000){
                                    timer.cancel();

                                }
                            }
                        };
                        timer.schedule(timerTask,0,5);
                        // the period heya el periode between each task and it is specified n millseconds



                        Intent intent= new Intent(MainActivity.this, Activity2.class);
                        startActivity(intent);




                    }


                }}






            }});





    }




}