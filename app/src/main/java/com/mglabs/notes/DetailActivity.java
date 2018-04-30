package com.mglabs.notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class DetailActivity extends AppCompatActivity {

    EditText noteText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        noteText = (EditText) findViewById(R.id.editText);

        Intent intent = getIntent();
        int noteId = intent.getIntExtra("noteId", -1);

        if (noteId != -1) {
            noteText.setText(MainActivity.notes.get(noteId));
        }

    }
}
