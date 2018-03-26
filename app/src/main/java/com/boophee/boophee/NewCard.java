package com.boophee.boophee;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_card);
        apiService = APIUtils.getAPIService();
        editTextAns =findViewById(R.id.card_ans);
        editTextQue =findViewById(R.id.card_que);
        Button button ;
        button =findViewById(R.id.card_submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Que = editTextQue.getText().toString();
                String Ans = editTextAns.getText().toString();
                apiService.savePost(Que,Ans).enqueue(new Callback<Item>() {
                    @Override
                    public void onResponse(Call<Item> call, Response<Item> response) {
                        Toast.makeText(NewCard.this,"sucess",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Item> call, Throwable t) {
                    Log.e("rest Api",t.toString());
                    }
                });
            }
        });

    }
}
