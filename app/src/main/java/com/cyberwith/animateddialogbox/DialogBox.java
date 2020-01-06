package com.cyberwith.animateddialogbox;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.annotation.NonNull;

public class DialogBox extends Dialog {

    private Button signButton;
    private Context context;
    public DialogBox(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_box_layout);

        signButton = findViewById(R.id.signButtonID);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation animation = AnimationUtils.loadAnimation(context,R.anim.button_animation);
                signButton.setVisibility(View.VISIBLE);
                signButton.setAnimation(animation);
            }
        }, 400);


        findViewById(R.id.okButtonID).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });


    }
}
