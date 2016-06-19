package com.example.svgdemo;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView image;
    private ImageView icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.image);
        icon = (ImageView) findViewById(R.id.icon);
        findViewById(R.id.btn).setOnClickListener(this);
        findViewById(R.id.btn_show).setOnClickListener(this);

    }

    private void showAnim(ImageView image) {
//        Animatable drawable = (Animatable) image.getDrawable();
//        drawable.start();
        Drawable drawable = image.getDrawable();
        if(drawable instanceof Animatable){
            ((Animatable)drawable).start();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                showAnim(image);
                break;
            case R.id.btn_show:
                showAnim(icon);
                break;
            default:
                break;
        }
    }
}
