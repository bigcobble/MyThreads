package com.li.mythreads;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private Button changebt;
    private static final int  Update_Flag = 1;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case Update_Flag:
                    text.setText("hello sdx！");
                    break;
                default:break;

            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.viewcontent);
        changebt = (Button) findViewById(R.id.changetext_bt);
        changebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.changetext_bt:
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                               Message message = new Message();
                                message.what = Update_Flag;
                                handler.sendMessage(message);
                            }
                        }).start();
                        break;
                    default:break;

                }
            }
        });
    }
}
