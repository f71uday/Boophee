package com.boophee.boophee;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import com.boophee.boophee.rest.APIService;
import com.boophee.boophee.rest.APIUtils;
import com.boophee.boophee.rest.Item;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by uday on 31/1/18.
 */

public class NewCard extends AppCompatActivity {
    APIService apiService;
    EditText editTextQue;
    EditText editTextAns;
    AutoCompleteTextView autoCompleteTextView;
    int difficulty =0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Revisor");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String[] tags = {"#physics","#chemestry","#Computer", "#maths","#english", "#daily", "#monthly","#imp"};
        setContentView(R.layout.activity_revisor);
        apiService = APIUtils.getAPIService();
        editTextAns =findViewById(R.id.revisor_ans_text);
        editTextQue =findViewById(R.id.revisor_ques_text);
      FloatingActionButton button;
        autoCompleteTextView = findViewById(R.id.revisor_tags);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,tags);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setThreshold(0);
        button =findViewById(R.id.revisor_add);
        SeekBar seekBar = findViewById(R.id.difficulty_seekbar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int difficulty = i/10;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(NewCard.this, CardSwipeActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
