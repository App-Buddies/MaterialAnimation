package com.example.admin.materialanimation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView imgLogo, imgProfilePic;
    private TextView txvShared;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgLogo = (ImageView) findViewById(R.id.imgSmartherdLogo);
        imgProfilePic = (ImageView) findViewById(R.id.imgAnnie);
        txvShared = (TextView) findViewById(R.id.txvSharedElement);

    }

    public void checkRippleAnimation(View view) {
        Intent intent = new Intent(this, RippleActivity.class);
        startActivity(intent);
    }

    public void sharedElementTransition(View view) {
        Pair[] pairs = new Pair[3];
        pairs[0] = new Pair<View, String>(imgLogo, "logo_shared");
        pairs[1] = new Pair<View, String>(imgProfilePic, "profile_pic_shared");
        pairs[2] = new Pair<View, String>(txvShared, "smartherd_shared");

        ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(this, pairs);

        Intent intent = new Intent(this, SharedElementActivity.class);
        startActivity(intent, activityOptions.toBundle());
    }


    public void explodeTransitionByCode(View view) {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(this, TransitionActivity.class);
        intent.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.ExplodeJava);
        intent.putExtra(Constants.KEY_TITLE, "Explode By Java");
        startActivity(intent, options.toBundle());

    }

    public void explodeTransitionByXML(View view) {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(this, TransitionActivity.class);
        intent.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.ExplodeXML);
        intent.putExtra(Constants.KEY_TITLE, "Explode By Xml");
        startActivity(intent, options.toBundle());

    }

    public void slideTransitionByCode(View view) {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(this, TransitionActivity.class);
        intent.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.SlideJava);
        intent.putExtra(Constants.KEY_TITLE, "Slide By Java");
        startActivity(intent, options.toBundle());

    }

    public void slideTransitionByXML(View view) {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(this, TransitionActivity.class);
        intent.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.SlideXML);
        intent.putExtra(Constants.KEY_TITLE, "Explode By Xml");
        startActivity(intent, options.toBundle());


    }

    public void fadeTransitionByJava(View view) {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(this, TransitionActivity.class);
        intent.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.FadeJava);
        intent.putExtra(Constants.KEY_TITLE, "Fade By Java");
        startActivity(intent, options.toBundle());


    }

    public void fadeTransitionByXML(View view) {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(this, TransitionActivity.class);
        intent.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.FadeXML);
        intent.putExtra(Constants.KEY_TITLE, "Fade By Xml");
        startActivity(intent, options.toBundle());

    }


}
