package com.fengniao.tabs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.one)
    public void tabOne(View view) {
        startActivity(new Intent(this, TabOneActivity.class));
    }

    @OnClick(R.id.two)
    public void tabTwo(View view) {
        startActivity(new Intent(this, TabTwoActivity.class));
    }
}
