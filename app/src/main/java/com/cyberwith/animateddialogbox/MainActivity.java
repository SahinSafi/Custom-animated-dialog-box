package com.cyberwith.animateddialogbox;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.clickButtonID).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogBox dialogBox = new DialogBox(MainActivity.this);
                dialogBox.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialogBox.getWindow().getAttributes().windowAnimations = R.style.dialogAnimation;
                dialogBox.show();
            }
        });
    }
}
