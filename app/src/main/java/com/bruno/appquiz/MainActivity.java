package com.bruno.appquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout tela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tela.findViewById(R.id.tela);


        tela.setOnTouchListener(new OnSwipeTouchListener(this){

            @Override
            public void onSwipeBottom() {
                super.onSwipeBottom();
            }

            @Override
            public void onSwipeTop() {
                super.onSwipeTop();
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
            }
        });



    }
}
