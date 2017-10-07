package com.example.admin.materialanimation;

import android.animation.TimeInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.Button;

public class TransitionActivity extends AppCompatActivity {
    Constants.TransitionType type;
    String toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        initPage();
        loadAnimation();
        getWindow().setAllowEnterTransitionOverlap(false);


    }

    @Override
    public boolean onNavigateUp() {
        finishAfterTransition();

        return true;
    }

    private void initPage() {

        type = (Constants.TransitionType) getIntent().getSerializableExtra(Constants.KEY_ANIM_TYPE);
        toolbarTitle = getIntent().getExtras().getString(Constants.KEY_TITLE);

        Button btnExit = (Button) findViewById(R.id.exit_button);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAfterTransition();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(toolbarTitle);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finishAfterTransition();
        return true;
    }

    public void loadAnimation() {
        switch (type) {
            case FadeJava:
                Fade fade = new Fade();
                fade.setDuration(1000);
                getWindow().setEnterTransition(fade);
                break;
            case FadeXML:
                Transition fsenterTansition = TransitionInflater.from(this).inflateTransition(R.transition.fade);
                getWindow().setEnterTransition(fsenterTansition);

                break;
            case SlideJava:
                Slide slide = new Slide();
                slide.setDuration(1000);
                slide.setSlideEdge(Gravity.TOP);
                slide.setInterpolator(new AnticipateOvershootInterpolator());
                getWindow().setEnterTransition(slide);
                break;
            case SlideXML:
                Transition senterTansition = TransitionInflater.from(this).inflateTransition(R.transition.slide);
                getWindow().setEnterTransition(senterTansition);

                break;
            case ExplodeJava:
                Explode explode = new Explode();
                explode.setDuration(1000);
                getWindow().setEnterTransition(explode);
                break;
            case ExplodeXML:
                Transition enterTansition = TransitionInflater.from(this).inflateTransition(R.transition.explode);
                getWindow().setEnterTransition(enterTansition);
                break;
        }
    }

}
