package com.example.app24;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView x1, x2, d;
    Button solve;
    EditText a, b, c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x1 = findViewById(R.id.x1);
        x2 = findViewById(R.id.x2);
        d = findViewById(R.id.D);
        solve = findViewById(R.id.button);
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        solve.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        String s1 = a.getText().toString();
        String s2 = b.getText().toString();
        String s3 = c.getText().toString();
        double a = Double.parseDouble(s1);
        double b = Double.parseDouble(s2);
        double c = Double.parseDouble(s3);
        boolean ok = !(a == 0 && b == 0 && c == 0);
        double D = b * b - 4 * a * c;
        d.setText(String.format(Locale.US, "D = %.4f", D));
        if (D == 0 && ok){
            double x = -1 * b / (2 * a);
            x1.setText(String.format(Locale.US, "x1 = %.4f", x));
            x2.setText(String.format(Locale.US, "x2 = %.4f", x));
        }
        else if (D < 0 && ok){
            x1.setText("NAN");
            x2.setText("NAN");
        }
        else if (D > 0 && ok){
            double x3 = (-1 * b + Math.sqrt(D))/ (2 * a);
            double x4 = (-1 * b - Math.sqrt(D))/ (2 * a);
            x1.setText(String.format(Locale.US, "x1 = %.4f", x3));
            x2.setText(String.format(Locale.US, "x2 = %.4f", x4));
        }
        else if (!ok){
            x1.setText(String.format(Locale.US, "x1 ∈ R"));
            x2.setText(String.format(Locale.US, "x2 ∈ R"));
        }


    }


}