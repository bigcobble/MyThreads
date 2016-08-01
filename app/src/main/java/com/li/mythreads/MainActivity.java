package com.li.mythreads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private Button changebt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changebt = (Button) findViewById(R.id.changetext_bt);
        changebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.changetext_bt:
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                text.setText("hello sdx！");
                            }
                        }).start();
                        break;
                    default:break;

                }
            }
        });
    }
}
