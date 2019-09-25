package com.example.testerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testerecyclerview.model.AppDatabase;
import com.example.testerecyclerview.model.ListItem;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button button = findViewById(R.id.buttonCadastro);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "database-name").allowMainThreadQueries().build();

                ListItem item = new ListItem();
                EditText textHead = findViewById(R.id.editTextHead);
                EditText textDesc = findViewById(R.id.editTextDesc);

                item.head = textHead.getText().toString();
                item.desc = textDesc.getText().toString();

                db.itemDao().insertAll(item);

                finish();
            }
        });

    }
}
