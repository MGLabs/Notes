package com.mglabs.notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Classe per il dettaglio della nota e per l'aggiunta di una nota.
 */
public class DetailActivity extends AppCompatActivity {

    EditText editText;
    int noteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        editText = (EditText) findViewById(R.id.editText);

        Intent intent = getIntent();
        noteId = intent.getIntExtra("noteId", -1);

        if (noteId != -1) {
            editText.setText(MainActivity.notes.get(noteId));   //setta il testo della nota se l'id esiste
        } else {
            MainActivity.notes.add("");
            noteId = MainActivity.notes.size() - 1;    //altrimenti crea una nuova nota
            MainActivity.adapter.notifyDataSetChanged();
        }

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.notes.set(noteId, String.valueOf(s));   //save the new note
                MainActivity.adapter.notifyDataSetChanged();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }
}
