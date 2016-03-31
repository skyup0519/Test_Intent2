package com.example.andy.test_intent2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Rest_Message extends AppCompatActivity {
    private EditText m_tv_setMessage;
    public  static String BUNDLE_KEY_SETMESSAGE="com.example.andy.Android.setMessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest__message);
    }

    public void OK(View view) {

        m_tv_setMessage = (EditText)findViewById(R.id.edit_setMessage);
        CharSequence setMseeage = m_tv_setMessage.getText();

        Intent intent = new Intent();
        intent.putExtra(BUNDLE_KEY_SETMESSAGE,setMseeage);
        setResult(RESULT_OK,intent);
        finish();


    }

    public void BACK(View view) {

        setResult(RESULT_CANCELED);
        finish();

    }
}
