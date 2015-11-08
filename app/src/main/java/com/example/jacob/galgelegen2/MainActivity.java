package com.example.jacob.galgelegen2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.startButton);
        start.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v == start){
            startActivity(new Intent(MainActivity.this, game.class));
        }
    }

}
