package com.example.cronometro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int segundos = 0;
    private boolean inicio;
    private Button iniciar,parar,resetear,guarda;
    int cont = 0;
    String [] Datos = new String[5];




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciar = findViewById(R.id.Binicio);
        parar = findViewById(R.id.Bparar);
        resetear = findViewById(R.id.Breinicar);
        guarda = findViewById(R.id.Bguardar);
        for (int j = 0;j<5;j++){
            Datos[j] = "";
        }


        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inicio = true;
                runTime();
            }
        });

        parar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inicio = false;

            }
        });

        resetear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inicio = false;
                segundos = 0;
            }
        });

        guarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView datosTime = (TextView)findViewById(R.id.DatosCronometro);
                int horas = segundos / 3600;
                int minutos = (segundos % 3600) / 60;
                int secs = segundos % 60;
                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", horas, minutos, secs);

                Datos [cont] = time;
                String data = "";
                for (int i = 0;  i < 5;i++){
                    data += Datos[i]+"\n";

                }
                cont ++;
                if(cont>4){
                    cont = 0;
                }
                datosTime.setText(data);

            }
        });
    }


    private void runTime(){
        final TextView timeView = (TextView)findViewById(R.id.Cronometro);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int horas = segundos / 3600;
                int minutos = (segundos % 3600) / 60;
                int secs = segundos % 60;
                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", horas, minutos, secs);
                timeView.setText(time);
                if (inicio) {
                    segundos++;
            }
                handler.postDelayed(this,1000);
        };


        });
    }



}