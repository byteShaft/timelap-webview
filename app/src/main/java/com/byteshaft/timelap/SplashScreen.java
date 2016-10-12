package com.byteshaft.timelap;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SplashScreen extends Activity implements View.OnClickListener {

    private Button mLoginButton;
    private Button mSupportButton;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mLoginButton = (Button) findViewById(R.id.button_login);
        mSupportButton = (Button) findViewById(R.id.button_support);
        mLoginButton.setOnClickListener(this);
        mSupportButton.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "double press BACK to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 1000);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_login:
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                break;

            case R.id.button_support:
                break;
        }
    }
}
