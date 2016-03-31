package com.example.andy.test_intent2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    private TextView m_tv_merge_NO;
    private TextView m_tv_merge_question;
    private RadioButton m_tv_merge_radio_A;
    private RadioButton m_tv_merge_radio_B;
    private RadioButton m_tv_merge_radio_C;
    protected static CharSequence m_answers_3;
    public static final String BUNDLE_KEY_ANSWERS_3 = "com.andy.Android.answer_3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        initalColor();
        Toast.makeText(Activity3.this, "顏色初始化----->Activity3", Toast.LENGTH_SHORT).show();
    }

    private void initalColor() {
        Bundle bundle = getIntent().getExtras();
        int color = bundle.getInt(Rest_color.BUNDLE_KEY_SETCOLOR, -1);
        TextView view = (TextView) findViewById(R.id.tv_merge_setcolor);
        view.setBackgroundColor(color);
        initalQuestion();
    }

    private void initalQuestion() {
        findID();
        setMessage();
    }

    private void findID() {
        m_tv_merge_NO = (TextView) findViewById(R.id.tv_merge_no);
        m_tv_merge_question = (TextView) findViewById(R.id.tv_merge_question);
        m_tv_merge_radio_A = (RadioButton) findViewById(R.id.tv_merge_radio_A);
        m_tv_merge_radio_B = (RadioButton) findViewById(R.id.tv_merge_radio_B);
        m_tv_merge_radio_C = (RadioButton) findViewById(R.id.tv_merge_radio_C);
    }

    private void setMessage() {
        m_tv_merge_NO.setText("3");
        m_tv_merge_question.setText(Html.fromHtml(getString(R.string.question_3)));
        m_tv_merge_radio_A.setText(Html.fromHtml(getString(R.string.question_3_radio_a)));
        m_tv_merge_radio_B.setText(Html.fromHtml(getString(R.string.question_3_radio_b)));
        m_tv_merge_radio_C.setText(Html.fromHtml(getString(R.string.question_3_radio_c)));
    }

    public void NEXT(View view) {
        Intent intent = new Intent();
        intent.putExtra(Rest_color.BUNDLE_KEY_SETCOLOR, MainActivity.setColor);
        intent.putExtra(Activity1.BUNDLE_KEY_ANSWERS_1, Activity1.m_answers_1);
        intent.putExtra(Activity2.BUNDLE_KEY_ANSWERS_2, Activity2.m_answers_2);
        intent.putExtra(BUNDLE_KEY_ANSWERS_3,  m_answers_3);
        startActivity(intent);
    }

    public void click(View view) {
        m_answers_3 = view.getTag().toString();

    }

    public void MAIN(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra(Rest_color.BUNDLE_KEY_SETCOLOR, MainActivity.setColor);
        intent.putExtra(Activity1.BUNDLE_KEY_ANSWERS_1, Activity1.m_answers_1);
        intent.putExtra(Activity2.BUNDLE_KEY_ANSWERS_2, Activity2.m_answers_2);
        intent.putExtra(BUNDLE_KEY_ANSWERS_3,  m_answers_3);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);

    }
}