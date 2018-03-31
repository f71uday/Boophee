package com.boophee.boophee;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.RelativeLayout;

import com.boophee.boophee.retrofit.Data;
import com.boophee.boophee.retrofit.DataResponse;
import com.boophee.boophee.retrofit.api.ApiClient;
import com.boophee.boophee.retrofit.api.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;
import in.arjsna.swipecardlib.SwipeCardView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by uday on 30/1/18.
 */
public class CardSwipeActivity extends AppCompatActivity {

    private ArrayList<Data> al;
    private CardsAdapter arrayAdapter;


    FloatingActionButton floatingActionButton;
    RecyclerView flingContainer1,flingContainer2;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipe_card);

        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        flingContainer1 = findViewById(R.id.card_stack_view1);
        flingContainer1.setLayoutManager(new LinearLayoutManager(this ));

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchCards();
                swipeRefreshLayout.setRefreshing(false);
                Toasty.success(getApplicationContext(),"All Cards Updated").show();
            }
        });

        //API call
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<DataResponse> call = apiInterface.getAllCards();
        call.enqueue(new Callback<DataResponse>() {

            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
               List<Data> data = response.body().getData();

                flingContainer1.setAdapter( new CardsAdapter(data,R.layout.page_item,getApplicationContext()));
                Log.e("api",data.size()+"");


            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {

            }
        });

        floatingActionButton = findViewById(R.id.new_card);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CardSwipeActivity.this,NewCard.class));
                finish();
            }
        });
  }

    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menu_li)
        {
            startActivity(new Intent(CardSwipeActivity.this,Licence.class));
        }
        if (item.getItemId() ==R.id.notifications)
        {
            startActivity(new Intent(CardSwipeActivity.this,Notifications.class));
        }
        return true;
    }



    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void fetchCards()
    {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<DataResponse> call = apiInterface.getAllCards();
        call.enqueue(new Callback<DataResponse>() {

            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                List<Data> data = response.body().getData();

                flingContainer1.setAdapter( new CardsAdapter(data,R.layout.page_item,getApplicationContext()));
                Log.e("api",data.size()+"");

            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {

            }
        });
    }
}