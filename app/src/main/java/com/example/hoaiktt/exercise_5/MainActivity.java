package com.example.hoaiktt.exercise_5;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mBtnShowSumActivity;
    public static String mAddress = "sum://example.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnShowSumActivity = (Button) findViewById(R.id.btnShowSumActivity);
        mBtnShowSumActivity.setOnClickListener(new CallSumActivity());
    }

    private class CallSumActivity implements View.OnClickListener{

        @Override
        public void onClick(View view) {
               Uri mUriSumActivity = Uri.parse(mAddress);
               Intent mItent = new Intent(Intent.ACTION_VIEW,mUriSumActivity);
               startActivity(mItent);
        }
    }
}
