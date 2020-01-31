package com.example.listview;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //데이터 준비
       /* ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i<30; i ++){
            data.add("data" + i);
        }
*/
        //가상의 데이터를 뷰에 데이터를 표시하게 해주는 거 : 어댑터
        //어댑터
        //어레이어댑터 : 배열이나 리스트를 뷰에다가 보여주는 기본적인 어댑터
       /* ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);

        //뷰
        ListView listView = findViewById(R.id.list_view);

        //뷰에 어댑터 꽂음
        listView.setAdapter(adapter);

        //클릭
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, position + "번째 아이템 선택", Toast.LENGTH_SHORT).show();
            }
        });
*/

       ArrayList<Weather> data = new ArrayList<>();
       data.add(new Weather("수원", "23도", "맑음"));
       data.add(new Weather("서울", "23도", "맑음"));
       data.add(new Weather("광주", "23도", "맑음"));
       data.add(new Weather("성남", "23도", "맑음"));
       data.add(new Weather("전주", "23도", "맑음"));
       data.add(new Weather("부산", "23도", "맑음"));
       data.add(new Weather("강릉", "23도", "맑음"));
       data.add(new Weather("대구", "23도", "맑음"));
       Adapter adapter = new Adapter(data);


       //뷰
        ListView view = findViewById(R.id.list_view);
        view.setAdapter(adapter);





    }
}
