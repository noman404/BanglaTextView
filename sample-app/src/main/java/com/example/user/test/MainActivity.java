package com.example.user.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.al.tobangla.utils.ProcessType;
import com.al.tobangla.views.BNTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        byProgrammatically();
    }

    private void byProgrammatically() {
        LinearLayout parentLayout = findViewById(R.id.parent);

        BNTextView bnTextView = new BNTextView(this);
        bnTextView.setProcessType(ProcessType.NUMBER);
        bnTextView.setText("1234564");

        parentLayout.addView(bnTextView);
    }
}
