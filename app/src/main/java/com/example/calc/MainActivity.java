package com.example.calc;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText_a;
    EditText editText_b;
    EditText editText_x;
    TextView textView_sum;
    Button buttonSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_a = (EditText) findViewById(R.id.editText_a);
        editText_b = (EditText) findViewById(R.id.editText_b);
        editText_x = (EditText) findViewById(R.id.editText_x);
        textView_sum = (TextView) findViewById(R.id.textView_sum);
        buttonSum = (Button) findViewById(R.id.buttonSum);

        View.OnKeyListener myKeyListener = new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (editText_a.getText().toString().trim().equals("") ||
                        editText_b.getText().toString().trim().equals("")||
                        editText_x.getText().toString().trim().equals("")){
                    buttonSum.setEnabled(false);
                } else {
                    buttonSum.setEnabled(true);
                }
                return false;
            }
        };

        buttonSum.setEnabled(false);
        editText_a.setOnKeyListener(myKeyListener);
        editText_b.setOnKeyListener(myKeyListener);
        editText_x.setOnKeyListener(myKeyListener);

        if (savedInstanceState != null) {
            textView_sum.setText(savedInstanceState.getString("c"));
            buttonSum.setEnabled(true);
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("c", textView_sum.getText().toString());
    }

        public void onClick(View v) {
        double a, b, c, x;

        try {
            a = Double.valueOf(editText_a.getText().toString().trim());
            b = Double.valueOf(editText_b.getText().toString().trim());
            x = Double.valueOf(editText_x.getText().toString().trim());

            if (x < 3)
                c = (x * (Math.pow(a,2) + Math.pow(b,2))) / (6 * a);
            else
                c = x * (1 - a * b);

            textView_sum.setText(String.valueOf(c));

        } catch (Exception e) {
            textView_sum.setText("Неверные входные данные для расчета!");
        }

    }

}
