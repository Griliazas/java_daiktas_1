package com.example.android_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button txtButton = findViewById(R.id.btnText);
        Button clrButton = findViewById(R.id.btnColor);
        Button bgButton = findViewById(R.id.btnBackground);
        TextView text = findViewById(R.id.mainText);

        txtButton.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View v) {

                 text.setText(getString(R.string.txt_revealed));
             }

        });

        //comment for revert :(

        clrButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                text.setTextColor(ContextCompat.getColor(v.getContext(), R.color.purple));
            }

        });

        bgButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                text.setBackgroundColor(ContextCompat.getColor(v.getContext(), R.color.bright_purple));
            }

        });

        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}