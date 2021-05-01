package com.example.multablegame;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    final static int START_GAME = 1;
    final static int RETURN_LIST_ACTIVITY = 2;

    ListView list;
    int count;
    ArrayList<String> items;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstpage);

        list = (ListView) findViewById(R.id.listAns);
        items = new ArrayList<>();
        adapter = new ArrayAdapter(this.getApplicationContext(), android.R.layout.simple_list_item_1, items);
        list.setAdapter(adapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        int count = data.getIntExtra("count", -1);
        if(RESULT_OK == resultCode){
            items.add(count + "");
            adapter.notifyDataSetChanged();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.startGame:
                Intent it = new Intent(this, GameDisplay.class);
                startActivityForResult(it, START_GAME);
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}