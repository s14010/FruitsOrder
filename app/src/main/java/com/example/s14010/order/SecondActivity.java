package com.example.s14010.order;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //「確認」ボタンの設置
        Button btnPickUp = (Button)this.findViewById(R.id.bt_check);
        btnPickUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences data = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = data.edit();

                TextView tvName = (TextView)findViewById(R.id.tv_name);
                TextView tvAdd =(TextView)findViewById(R.id.tv_address);
                TextView tvMonth = (TextView)findViewById(R.id.tv_month);
                TextView tvDay = (TextView)findViewById(R.id.tv_day);
                TextView tvGender = (TextView)findViewById(R.id.tv_gender);
                TextView tvApple = (TextView)findViewById(R.id.tv_apple);
                TextView tvOrange = (TextView)findViewById(R.id.tv_orange);
                TextView tvPeach = (TextView)findViewById(R.id.tv_peach);

                editor.putString("NAME", tvName.getText().toString());
                editor.putString("ADD", tvAdd.getText().toString());
                editor.putString("MONTH", tvMonth.getText().toString());
                editor.putString("DAY", tvDay.getText().toString());
                editor.putString("GENDER", tvGender.getText().toString());
                editor.putString("APPLE", tvApple.getText().toString());
                editor.putString("ORANGE", tvOrange.getText().toString());
                editor.putString("PEACH", tvPeach.getText().toString());

                editor.apply();

                writeToFile();

                writeToTable(false);



                Intent intent = new Intent(SecondActivity.this, CheckActivity.class);
                startActivity(intent);
            }
        });

        //「戻る」ボタンの設置
        Button btnNoDinner = (Button)this.findViewById(R.id.bt_back);
        btnNoDinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void writeToFile(){
        OutputStream out;

        TextView tvName = (TextView)findViewById(R.id.tv_name);
        TextView tvAdd =(TextView)findViewById(R.id.tv_address);
        TextView tvMonth = (TextView)findViewById(R.id.tv_month);
        TextView tvDay = (TextView)findViewById(R.id.tv_day);
        TextView tvGender = (TextView)findViewById(R.id.tv_gender);
        TextView tvApple = (TextView)findViewById(R.id.tv_apple);
        TextView tvOrange = (TextView)findViewById(R.id.tv_orange);
        TextView tvPeach = (TextView)findViewById(R.id.tv_peach);

        try {
            out = openFileOutput("test.txt",MODE_PRIVATE);
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(out,"UTF-8"));

            //追記する
            writer.append(tvName.getText().toString()+ ",");
            writer.append(tvAdd.getText().toString() + ",");
            writer.append(tvMonth.getText().toString() + ",");
            writer.append(tvDay.getText().toString() + ",");
            writer.append(tvGender.getText().toString() + ",");
            writer.append(tvApple.getText().toString() + ",");
            writer.append(tvOrange.getText().toString() + ",");
            writer.append(tvPeach.getText().toString() + "\n");
            writer.close();
        } catch (IOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
    }

    private void writeToTable(boolean overwrite){

        TextView tvName = (TextView)findViewById(R.id.tv_name);
        TextView tvAdd =(TextView)findViewById(R.id.tv_address);
        TextView tvMonth = (TextView)findViewById(R.id.tv_month);
        TextView tvDay = (TextView)findViewById(R.id.tv_day);
        TextView tvGender = (TextView)findViewById(R.id.tv_gender);
        TextView tvApple = (TextView)findViewById(R.id.tv_apple);
        TextView tvOrange = (TextView)findViewById(R.id.tv_orange);
        TextView tvPeach = (TextView)findViewById(R.id.tv_peach);

        ContentValues vals = new ContentValues();
        vals.put("name",tvName.getText().toString());
        vals.put("address",tvAdd.getText().toString());
        vals.put("month",tvMonth.getText().toString());
        vals.put("day",tvDay.getText().toString());
        vals.put("gender",tvGender.getText().toString());
        vals.put("apple",tvApple.getText().toString());
        vals.put("orange",tvOrange.getText().toString());
        vals.put("peach",tvPeach.getText().toString());

        String whereClause = "id = 1";
        String [] whereArgs = null;

        DBHelper dbh = new DBHelper(this);
        SQLiteDatabase db = dbh.getWritableDatabase();

        try{
            db.insert(DBHelper.TABLENAME, "", vals);
        }finally{
            db.close();
        }
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

}