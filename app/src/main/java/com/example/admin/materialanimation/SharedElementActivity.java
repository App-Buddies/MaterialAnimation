package com.example.admin.materialanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SharedElementActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_shared_element);
        initPage();
    }

    private void initPage() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Shared Element Transition");
        final RelativeLayout relativeLayout = findViewById(R.id.click_reveal);
        Button btnExit = (Button) findViewById(R.id.exit_button);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAfterTransition();
            }
        });
        relativeLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                makeCircularRevealAnimation(relativeLayout);
            }
        });
    }


    @Override
    public boolean onNavigateUp() {
        finishAfterTransition();
        return true;

    }


    private void makeCircularRevealAnimation(RelativeLayout relativeLayout) {
        final TextView textDesc = (TextView) findViewById(R.id.textDesc);

        int centerX = (relativeLayout.getLeft() + relativeLayout.getRight());
        int centerY = (relativeLayout.getTop() + relativeLayout.getBottom());

        float radius = Math.max(textDesc.getWidth(), textDesc.getHeight()) * 2.0f;

        if (textDesc.getVisibility() == View.INVISIBLE) {
            textDesc.setVisibility(View.VISIBLE);
            textDesc.setText("AppBuddies");
            ViewAnimationUtils.createCircularReveal(textDesc, centerX, centerY, 0, radius).start();
        } else {
            Animator animator = ViewAnimationUtils.createCircularReveal(textDesc, centerX, centerY, radius, 0);
            animator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    textDesc.setVisibility(View.INVISIBLE);
                }
            });
            animator.start();
        }


    }
}
