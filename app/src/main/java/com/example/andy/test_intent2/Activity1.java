package com.example.andy.test_intent2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Activity1 extends AppCompatActivity {

    private TextView  m_tv_merge_NO ;
    private TextView  m_tv_merge_question;
    private RadioButton  m_tv_merge_radio_A;
    private RadioButton  m_tv_merge_radio_B;
    private RadioButton  m_tv_merge_radio_C;
    protected static CharSequence m_answers_1;
    public static final String BUNDLE_KEY_ANSWERS_1="com.andy.Android.answer_1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        initalSetColor();
        initalQuestion();
    }

    private void initalSetColor() {
        TextView view = (TextView) findViewById(R.id.tv_merge_setcolor);
        int color = getIntent().getIntExtra(Rest_color.BUNDLE_KEY_SETCOLOR, -1);
        if (color == -1) {
            return;
        }
        Toast.makeText(this, "恭喜您 顏色成功值入 Activity1 ", Toast.LENGTH_LONG).show();
        view.setBackgroundColor(color);
    }

    private void initalQuestion() {
        findID();
        setMessage();
    }

    private void findID() {
        m_tv_merge_NO = (TextView) findViewById(R.id.tv_merge_no);
        m_tv_merge_question = (TextView) findViewById(R.id.tv_merge_question);
        m_tv_merge_radio_A = (RadioButton) findViewById(R.id.tv_merge_radio_A);
        m_tv_merge_radio_B= (RadioButton) findViewById(R.id.tv_merge_radio_B);
        m_tv_merge_radio_C= (RadioButton) findViewById(R.id.tv_merge_radio_C);}

    private void setMessage(){
        m_tv_merge_NO.setText("1");
        m_tv_merge_question.setText(Html.fromHtml(getString(R.string.question_1)));
        m_tv_merge_radio_A.setText(Html.fromHtml(getString(R.string.question_1_radio_a)));
        m_tv_merge_radio_B.setText(Html.fromHtml(getString(R.string.question_1_radio_b)));
        m_tv_merge_radio_C.setText(Html.fromHtml(getString(R.string.question_1_radio_c)));}


    public void NEXT(View view) {
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra(Rest_color.BUNDLE_KEY_SETCOLOR, MainActivity.setColor);
        intent.putExtra(BUNDLE_KEY_ANSWERS_1,m_answers_1);
        startActivity(intent);}

    public void click(View view) {

        m_answers_1=view.getTag().toString();


    }
}

