package com.example.study;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private EditText et_id;
    private Button btn_login;
    private Button btn_move;

    private String str ;

    private ImageView test;

    private ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) { //어플을 처음 시작했을 때
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_id = findViewById(R.id.et_id);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_id.setText("랄랄랄");

            }
        });

        //str = et_id.getText().toString(); //앱을 처음 실행했을 때 getText를 하면 내용이 없음


        btn_move = findViewById(R.id.btn_move);
        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = et_id.getText().toString(); //앱을 처음 실행했을 때 getText를 하면 내용이 없음

                //인텐드 사용
                Intent intent = new Intent(MainActivity.this, SubActivity.class); //현재 액티비티, 이동할 액티비티
                intent.putExtra("getId", str);
                startActivity(intent); //액티비티 시작해서 다른 화면으로 진입
            }
        });


        test = (ImageView) findViewById(R.id.test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "우왕우왕팝업창", Toast.LENGTH_SHORT).show();

            }
        });



        //리스트 뷰
        list = findViewById(R.id.list);


        List<String> data = new ArrayList<>();

        //데이터 리스트랑 - 리스트뷰를 연결하는게 어댑터

        //중간다리 어댑터에다가 데이터를 담게 된거임
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);

        //리스트뷰에다가 어댑터를 세팅
        list.setAdapter(adapter);


        data.add("데이터1입니다.");
        data.add("데이터2입니다.");
        data.add("데이터3입니다.");





        adapter.notifyDataSetChanged(); //저장 완료 , 지금 상태를 저장 하겠다

    }
}
