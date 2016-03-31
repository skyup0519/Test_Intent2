package com.example.andy.test_intent2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int INTENT_KEY_SETCOLOR=0;//傳令兵名子
    private int INTENT_KEY_SETMESSAGE=1;//傳令兵名子
    protected static int setColor; //從bundle.getInt(Rest_color.BUNDLE_KEY_SETCOLOR);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);}

    public void NEXT(View view) {
    Intent intent = new Intent(this,Activity1.class);
    intent.putExtra(Rest_color.BUNDLE_KEY_SETCOLOR, setColor);
    startActivity(intent);

    }

    public void SetColor(View view) {
        Intent intent = new Intent(this,Rest_color.class);
       startActivityForResult(intent, INTENT_KEY_SETCOLOR);}

    public void SetMessage(View view) {
        Intent intent = new Intent(this , Rest_Message.class);
        startActivityForResult(intent, INTENT_KEY_SETMESSAGE);}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    if (requestCode==INTENT_KEY_SETCOLOR){
        if(resultCode==RESULT_OK){

            Bundle bundle =data.getExtras();
            setColor =bundle.getInt(Rest_color.BUNDLE_KEY_SETCOLOR);
            TextView textView =(TextView)findViewById(R.id.tv_所要更改的項目);
            textView.setBackgroundColor(setColor);
            Toast.makeText(this, "恭喜您 顏色成功值入 MainActivity ", Toast.LENGTH_LONG).show();

        }}
        if (requestCode==INTENT_KEY_SETMESSAGE){
            if(resultCode==RESULT_OK){

                Bundle bundle =data.getExtras();
                CharSequence setMessage =bundle.getCharSequence(Rest_Message.BUNDLE_KEY_SETMESSAGE);
                TextView textView =(TextView)findViewById(R.id.tv_所要更改的項目);
                textView.setText(setMessage);

    }}}

}





