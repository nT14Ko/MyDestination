package com.dest.mydestination;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView circle;
    private Random random = new Random();
    private int lastDir;
    private boolean spinning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circle = findViewById(R.id.imageViewCircle);
    }

    public void spin(View v) {
        if (!spinning) {
            int newDir = random.nextInt(1800);
            float pivotX = circle.getWidth() / 2;
            float pivotY = circle.getHeight() / 2;
            Animation rotate = new RotateAnimation(lastDir, newDir, pivotX, pivotY);
            rotate.setDuration(2500);
            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning = true;
                }
                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning = false;
                }
                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });
            lastDir = newDir;
            circle.startAnimation(rotate);
        }
    }
}