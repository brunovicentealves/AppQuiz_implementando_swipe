package com.bruno.appquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout tela;
    private AlertDialog  alerta;
    private TextView tvPergunta,tvNumero,tvSim,tvNao,tvResposta;
    private int contador ,acertou;

    Pergunta per[];






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        contador =-1;
        acertou=0;
        tvResposta = findViewById(R.id.tvresposta);
        tvSim=findViewById(R.id.tvsim);
        tvNao=findViewById(R.id.tvnao);
        tvPergunta = findViewById(R.id.tvPergunta);
        tvNumero = findViewById(R.id.tvnumero);
        tela = findViewById(R.id.tela);

         per = new Pergunta[5];

         Pergunta pergunta = new Pergunta("Presidente atual do brasil é Jair Bolsonaro ?",true);

         per[0]=pergunta;

        Pergunta pergunta1 = new Pergunta(" Quem inventou a lampada foi Nikolas Tesla ?",false);

        per[1]=pergunta1;

        Pergunta pergunta2 = new Pergunta(" Brasil tem amazaonia?",true);

        per[2]=pergunta2;

        Pergunta pergunta3 = new Pergunta(" Pedro Alvares Cabral descobriu o Brasil ?",true);

        per[3]=pergunta3;

        Pergunta pergunta4 = new Pergunta(" Assunto da redação do enem 2019 foi sobre preconceito ?",false);

        per[4]=pergunta4;



        tela.setOnTouchListener(new OnSwipeTouchListener(this){

            @Override
            public void onSwipeBottom() {

                super.onSwipeBottom();

                per[contador].setResposta(false);
                tvNao.setText("Não");
                tvSim.setText("");

            }

            @Override
            public void onSwipeTop() {

                super.onSwipeTop();



                per[contador].setResposta(true);

                tvSim.setText("Sim");
                tvNao.setText("");
            }

            @Override
            public void onSwipeLeft() {

                super.onSwipeLeft();
                if(contador<4){
                    contador++;
                }else{

                    tvPergunta.setText("");
                    tvNao.setText("");
                    tvSim.setText("");
                    for (int i=0 ;i<4;i++){
                        if (per[i].getRespostacerta()==per[i].getResposta()){
                            acertou++;


                    }
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                    builder.setTitle("Respostas Certas");
                    builder.setMessage("Você Acertou : "+acertou);
                     alerta = builder.create();

                     alerta.show();


                    acertou=0;

                }
                tvNumero.setText(String.valueOf(contador));
                tvPergunta.setText(per[contador].getPergunta());
                tvNao.setText("");
                tvSim.setText("");


            }

            @Override
            public void onSwipeRight() {


                super.onSwipeRight();
                if(contador>0){
                    contador--;
                }

                tvNumero.setText(String.valueOf(contador));
                tvPergunta.setText(per[contador].getPergunta());
                tvNao.setText("");
                tvSim.setText("");

            }
        });
    }

}
