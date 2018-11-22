package com.course.example.marquee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mealpricefield;
    private TextView answerfield;
    private Button button;
    private static final String tag = "Widgets";

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);

        mealpricefield = (EditText)findViewById(R.id.mealprice);
        answerfield = (TextView)findViewById(R.id.answer);

        button = (Button)findViewById(R.id.calculate);
        button.setOnClickListener(this);

        //start marquee
        TextView txtView=(TextView)findViewById(R.id.scroller);
        txtView.setSelected(true);
    }

    // Perform action on click
    public void onClick(View v) {
        try {

            Log.i(tag, "onClick invoked.");

            // grab the meal price from the UI
            String mealprice = mealpricefield.getText().toString();
            Log.i(tag, "mealprice is $" + mealprice);

            String answer;

            // check to see if the meal price includes a "$"
            if (mealprice.contains("$"))
                mealprice = mealprice.substring(1);


            float fmp = Float.parseFloat(mealprice);

            // let's give a nice tip -> 20%
            fmp = fmp * 1.2f;
            Log.i(tag, "Total Meal price is $" + fmp);

            // format our result
            answer = String.format("Full Price including tip is $%.2f", fmp);

            // display the answer
            answerfield.setText(answer);
            Log.i(tag, "onClick complete.");

        } catch (Exception e) {
            Log.e(tag, "Failed to Calculate Tip:" + e.getMessage());
            answerfield.setText("Failed to Calculate Tip:" + e.getMessage());
        }

    }
}
