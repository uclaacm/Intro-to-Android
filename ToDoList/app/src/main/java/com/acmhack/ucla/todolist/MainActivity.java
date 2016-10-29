



package com.acmhack.ucla.todolist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private Button addItem;
    private EditText input;
    private ListView todoList;

    // Use these to store our todoList Items

    private ArrayList<String> todoListArray;
    private ArrayAdapter<String> todoListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addItem = (Button) findViewById(R.id.button);
        input = (EditText) findViewById(R.id.editText);
        todoList = (ListView) findViewById(R.id.listView);

        //set up array and array adapater
        todoListArray = new ArrayList<String>();
        todoListAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                todoListArray
        );
        todoList.setAdapter(todoListAdapter);

        //respond to our button presses

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String current_input = input.getText().toString().trim();
                if(current_input.isEmpty()){
                    return;
                }
                todoListAdapter.add(current_input);
                input.setText("");
            }
        });

    }



}
