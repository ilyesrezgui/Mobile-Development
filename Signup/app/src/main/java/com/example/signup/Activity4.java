package com.example.signup;

import static com.example.signup.R.id.button3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class Activity4 extends AppCompatActivity {
    TextToSpeech tts;
    private EditText txt;
    private TextView textheader;
    private TextView textbody;
    private Button btnreader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_4);
        textheader=(TextView) findViewById(R.id.textView1);
        textbody=(TextView) findViewById(R.id.textView2);
        btnreader=(Button)findViewById(R.id.button3);
        Bundle b=getIntent().getExtras();

        String s=b.getString("header");

        textheader.setText(s);
        if (s.equals("\n        Type: Obesité sévere")){
            textbody.setText("Qu'est-ce que l'obésité sévère et morbide ? Selon l'Organisation Mondiale de la Santé (OMS), l'obésité qu'elle soit sévère ou morbide est définie comme «une accumulation anormale ou excessive de graisse qui peut nuire à la santé». L'obésité est reconnue comme une maladie chronique par l'OMS depuis 1997");
        }else if(s.equals("\n        Type: Obesité massive")){
            textbody.setText("L'obésité morbide : une maladie multifactorielle qui réduit l'espérance de vie. Votre indice de masse corporelle (IMC) dépasse les 40 ? Vous êtes considéré comme étant en situation d'«obésité morbide ». Cette maladie est en augmentation dans notre société de consommation actuelle.");
        }else if(s.equals("\n        Type: Obesité moderée")){
            textbody.setText("S'il se situe entre 30 et 35, il s'agit d'obésité modérée. C'est la forme d'obésité la moins grave mais il y'a tout de même des risques importants de maladies telles que le diabète, l'hypertension ou encore les cancers.");
        }else if(s.equals("\n        Type: Surpoids")){
            textbody.setText("Le surpoids et l'obésité se définissent comme une accumulation anormale ou excessive de graisse corporelle qui peut nuire à la santé. L'indice de masse corporelle (IMC) est une mesure simple du poids par rapport à la taille couramment utilisée pour estimer le surpoids et l'obésité chez l'adulte");
        }else if(s.equals("\n        Type: Normale")){
            textbody.setText("Le poids idéal ou poids normal est le poids d'une personne présentant une corpulence considérée comme normale ou moyenne dans une société donnée");
        }else if(s.equals("\n        Type: Maigreur")){
            textbody.setText("La maigreur pathologique augmente le risque de maladies diverses parmi lesquelles on peut citer les infections ou l'ostéoporose mais peut également être le symptôme de l'une d'elles. Elle peut être également un état non pathologique, c'est-à-dire constitutionnelle, stable et ne s'accompagnant d'aucun trouble.");
        }else if(s.equals("\n        Type: Famine")){
            textbody.setText("La famine est une situation dans laquelle la population d'une zone géographique donnée, ou seulement une partie de cette population, manque de nourriture.");
        }





        btnreader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tts= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {

                    @Override
                    public void onInit(int i) {

                        if (i==TextToSpeech.SUCCESS){
                            tts.setLanguage(Locale.ENGLISH);
                            // speech rate is 1 when the speech is normal , not a song ...
                            tts.setSpeechRate(1.0F);
                            // this one specifies what you want to speek

                            tts.speak("Thank you for trusting Us, Ilyes Rezgui", TextToSpeech.QUEUE_FLUSH, null,null);

                        }
                    }
                });
            }
        });
    }// the end of the on create


}