package com.sear.mysqlapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        final TodoList editTodoList = (TodoList) getIntent().getSerializableExtra("editTodoList");
        final EditText editText = (EditText)findViewById(R.id.editText);
        editText.setText(editTodoList.getTaskname());

        Button btn_edit=(Button)findViewById(R.id.btn_edit);
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodoList edit = new TodoList();
                edit.setTaskid(editTodoList.getTaskid());
                edit.setTaskname(String.valueOf(editText.getText()));

                TodoListDAO todoListDAO = new TodoListDAO(getApplicationContext());
                todoListDAO.open();
                todoListDAO.update(edit);
                todoListDAO.close();
                finish();
            }
        });
    }
}
