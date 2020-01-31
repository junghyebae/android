package com.example.mywebbrowser;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText myAddressEdit;
    private WebView myWebView;
    private Button myMoveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myAddressEdit = findViewById(R.id.address_edit);
        myWebView = findViewById(R.id.web_view);
        myMoveButton = findViewById(R.id.move_button);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        myWebView.setWebViewClient(new WebViewClient());

        myAddressEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH){ //돋보기 버튼을 눌렀을때
                    myMoveButton.callOnClick(); //버튼 눌린거랑 똑같이 활성화

                    //키보드 숨기기
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });
    }

    public void onClick(View view) {
        String address = myAddressEdit.getText().toString();

        if(address.startsWith("http://") == false){
            address = "http://" + address;
        }
        myWebView.loadUrl(address);
    }

    @Override //이전페이지로 돌아가기
    public void onBackPressed() {
        if(myWebView.canGoBack()){
            myWebView.goBack();
        }else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.manu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_back:
                myWebView.goBack();
                return true;
            case R.id.action_forward:
                myWebView.goForward();
                return true;
            case R.id.action_refresh:
                myWebView.reload();
                return true;
            case R.id.google:
                myWebView.loadUrl("http://www.google.com");
                return true;
            case R.id.daum:
                myWebView.loadUrl("http://www.daum.net");
                return true;
            case R.id.naver:
                myWebView.loadUrl("http://www.naver.com");

                return true;
            case R.id.dev_info:
                //팝업창 띄우기

        }

        return super.onOptionsItemSelected(item);
    }
}
