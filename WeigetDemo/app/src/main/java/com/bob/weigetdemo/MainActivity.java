package com.bob.weigetdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.bob.notificationlibrary.NotificationHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        NotificationHelper notificationHelper = new NotificationHelper();
        notificationHelper.show(this, R.mipmap.ic_launcher);
    }
}
