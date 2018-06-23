package com.example.asus1.myqqnew;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class XiaoxiActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiaoxi);

        Button bn = (Button) findViewById(R.id.back);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
