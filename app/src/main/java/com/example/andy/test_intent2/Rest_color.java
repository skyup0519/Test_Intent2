package com.example.andy.test_intent2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

public class Rest_color extends AppCompatActivity {
private int  m_setcolot;
    public static String BUNDLE_KEY_SETCOLOR="com.example.andy.Android.setcolor";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_color);
    }
    public void InitialRadioButton() {
        RadioButton button = (RadioButton)findViewById(R.id.tv_RadioButton_red);
        m_setcolot=button.getCurrentTextColor();
    }


    public void RadioButton(View view) {
        RadioButton button = (RadioButton)view;
        m_setcolot=button.getCurrentTextColor();
    }


    public void OK(View view) {
        Intent intent = new Intent();
        intent.putExtra(BUNDLE_KEY_SETCOLOR,m_setcolot);
        setResult(RESULT_OK, intent);
        finish();

    }

    public void Back(View view) {
        setResult(RESULT_CANCELED);
        finish();

    }
}
