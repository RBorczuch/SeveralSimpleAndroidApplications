package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] jokes = {R.string.joke1, R.string.joke2, R.string.joke3,
                   R.string.joke4, R.string.joke5, R.string.joke6,
                   R.string.joke7, R.string.joke8, R.string.joke9};
    int lastIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //nacisniecie przycisku Generuj po uruchomieniu aplikacji celem przygotowania i wyswietlenia losowego zartu
        Button btn = findViewById(R.id.btn_generate);
        btn.performClick();
    }

    public void btn_generate_handler(View view) {
        //wyszukanie textview o id = txt_joke
        TextView txt = findViewById( R.id.txt_joke );

        //zmienna w ktorej bedzie przechowywana wylosowany indeks
        int index;

        //losowanie liczby z przedzialu 0...8 do momentu az bedzie inna od ostatnio wylosowanej
        do{
            index = new Random().nextInt(9) + 0; // [0, 9] + 0 => [0, 8]
        }while( index == lastIndex );

        //zaktualizuj ostatnio wylosowana liczbe
        lastIndex = index;

        //ustaw zart o wylosowanym indeksie
        txt.setText( jokes[index] );
    }
}















































