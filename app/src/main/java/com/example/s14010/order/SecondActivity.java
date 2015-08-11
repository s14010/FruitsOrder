package com.example.s14010.order;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity
        implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button button = (Button)findViewById(R.id.bt_back);
        button.setOnClickListener(this);


    }

    @Override
    protected void onStart(){
        super.onStart();
        Bundle extra = getIntent().getExtras();

        if(extra != null){
            //付加情報からの入力データ取得
            String name = extra.getString("NAME");
            String add = extra.getString("ADD");
            String month = extra.getString("MONTH");
            String day = extra.getString("DAY");
            String gender = extra.getString("GENDER");
            String apple = extra.getString("APPLE");
            String orange = extra.getString("ORANGE");
            String peach = extra.getString("PEACH");

            //出力用
            TextView tvName = (TextView)findViewById(R.id.tv_name);
            TextView tvAdd =(TextView)findViewById(R.id.tv_address);
            TextView tvMonth = (TextView)findViewById(R.id.tv_month);
            TextView tvDay = (TextView)findViewById(R.id.tv_day);
            TextView tvGender = (TextView)findViewById(R.id.tv_gender);
            TextView tvApple = (TextView)findViewById(R.id.tv_apple);
            TextView tvOrange = (TextView)findViewById(R.id.tv_orange);
            TextView tvPeach = (TextView)findViewById(R.id.tv_peach);
            //出力用テキストオブジェクトに入力データを設定
            tvName.setText(name);
            tvAdd.setText(add);
            tvMonth.setText(month);
            tvDay.setText(day);
            tvGender.setText(gender);
            tvApple.setText(apple);
            tvOrange.setText(orange);
            tvPeach.setText(peach);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Log.d(getApplication().toString(), "onClick()");
        finish();
    }
}