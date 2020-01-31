package com.example.study;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    private TextView sub ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        //어디선가 intent로 날라온 화면이 있다면 가져온 내용 얻겠다.
        Intent intent = getIntent();
        String str = intent.getStringExtra("getId");

        sub = findViewById(R.id.sub_text);
        String str1 = sub.getText().toString();

        sub.setText("아이디 " + str + str1);



    }
}
