package com.example.andy.test_intent2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        initalColor();
    }

    private void initalColor(){
        Bundle bundle = getIntent().getExtras();
        int color = bundle.getInt(Rest_color.BUNDLE_KEY_SETCOLOR,-1);
        if (color==-1){return;}

        TextView view =(TextView)findViewById(R.id.tv_merge_setcolor);
        view.setBackgroundColor(color);



    }


    public void MAIN(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        Activity1.ActivitySB_1.delete(10, Activity1.ActivitySB_1.length());

    }

    public void AnswerTotal(View view) {

        Toast.makeText(Activity4.this, Activity1.ActivitySB_1.toString(), Toast.LENGTH_SHORT).show();
    }
}
