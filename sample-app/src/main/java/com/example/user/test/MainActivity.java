package com.example.user.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

        BNTextView bnTextView = new BNTextView(this);
        bnTextView.setProcessType(ProcessType.ORDINAL_INDICATOR_FOR_DATE);
        bnTextView.setText("1952/02/21");

        LinearLayout parentLayout = findViewById(R.id.parent);
        parentLayout.addView(bnTextView);
    }
}
