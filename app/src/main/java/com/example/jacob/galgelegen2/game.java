package com.example.jacob.galgelegen2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class game extends Activity implements View.OnClickListener {

    Galgelogik g;
    TextView ord, svar, result;
    Button guess, reset;
    ImageView billede;
    int forsog=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        g = new Galgelogik();
        ord = (TextView) findViewById(R.id.ordView);
        ord.setText(g.getSynligtOrd());
        svar = (TextView) findViewById(R.id.svarText);
        result = (TextView) findViewById(R.id.resultView);
        guess = (Button) findViewById(R.id.guessButton);
        reset = (Button) findViewById(R.id.resetButton);
        billede = (ImageView) findViewById(R.id.imageView);

        //Clicklisteners til knappen
        guess.setOnClickListener(this);
        reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v == guess) {
            //if (g.erSpilletVundet()) {
            //  result.setText("Tillykke, du vandt!");
            //}
            String svaret = svar.getText().toString();
            g.gætBogstav(svaret);
            if (g.erSidsteBogstavKorrekt()) {
                ord.setText(g.getSynligtOrd());
            } else {
                forsog++;
                if (forsog == 1) {
                    billede.setImageResource(R.drawable.forkert1);
                } else if (forsog == 2) {
                    billede.setImageResource(R.drawable.forkert2);
                } else if (forsog == 3) {
                    billede.setImageResource(R.drawable.forkert3);
                } else if (forsog == 4) {
                    billede.setImageResource(R.drawable.forkert4);
                } else if (forsog == 5) {
                    billede.setImageResource(R.drawable.forkert5);
                } else if (forsog == 6) {
                    billede.setImageResource(R.drawable.forkert6);
                    result.setText("Desværre, du tabte");
                }
            }
            svar.setText("");
            g.logStatus();
            if(g.erSpilletVundet()){
                result.setText("Tillykke, du har vundet!");
            }
        } else if (v == reset){
            //startActivity(new Intent(game.this, MainActivity.class));
            finish();
        }
    }
}
