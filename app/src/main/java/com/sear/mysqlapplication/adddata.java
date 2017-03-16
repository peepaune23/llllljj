package com.sear.mysqlapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class adddata extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddata);
        final EditText newTodoListText = (EditText) findViewById(R.id.editTextAddTask);
        final Button newTodoListButton = (Button) findViewById(R.id.btnAddNewTask);
        newTodoListButton.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v)
            {
                TodoList todoList = new TodoList();
                todoList.setTaskname(String.valueOf(newTodoListText.getText()));
                TodoListDAO todoListDAO = new TodoListDAO(getApplicationContext());
                todoListDAO.open();
                todoListDAO.add(todoList);
                todoListDAO.close();
                finish();

            }
        }
        );
    }
}
