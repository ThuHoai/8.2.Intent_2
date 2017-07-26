package com.example.hoaiktt.exercise_5;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button mBtnShowSumActivity, mBtnShowWithData;
    private String mAddress = "sum://example.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnShowSumActivity = (Button) findViewById(R.id.btnShowSumActivity);
        mBtnShowSumActivity.setOnClickListener(new CallSumActivity());
        mBtnShowWithData = (Button) findViewById(R.id.btnShowWithData);
        mBtnShowWithData.setOnClickListener(new SendDataToSumActivity());
    }

    private String makeDataRamdomToSumActivity(){
        String value_X = String.format("X=%s", String.valueOf(Math.random()));
        String value_Y = String.format("Y=%s", String.valueOf(Math.random()));
        return String.format("%s?%s&%s",mAddress,value_X,value_Y);
    }

    private String makeAddressToSumActivity(){
        EditText edtXInput = (EditText) findViewById(R.id.edtX);
        EditText edtYInput = (EditText) findViewById(R.id.edtY);
        String value_X = String.format("X=%s", edtXInput.getText().toString());
        String value_Y = String.format("Y=%s", edtYInput.getText().toString());
        return String.format("%s?%s&%s",mAddress,value_X,value_Y);
    }

    private class CallSumActivity implements View.OnClickListener{

        @Override
        public void onClick(View view) {
               Uri mUriSumActivity = Uri.parse(mAddress);
               Intent mItent = new Intent(Intent.ACTION_VIEW,mUriSumActivity);
               startActivity(mItent);
        }
    }

    private class SendDataToSumActivity implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Uri mUriSumActivity2 = Uri.parse(makeAddressToSumActivity());
            Intent mData = new Intent(Intent.ACTION_VIEW,mUriSumActivity2);
            startActivity(mData);
        }
    }


}
