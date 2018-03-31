package com.boophee.boophee;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.boophee.boophee.retrofit.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by uday on 30/1/18.
 */

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.CardViewHolder> {
    private final List<Data> cards;
    private final int rowlayout;
    Context context;
    public static class CardViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout cardsLayout;
        RelativeLayout card_backgroung;
        TextView textView_que;
        ImageView imageView_share;
        ImageView imageView_heart;
        TextView textView_ans;
        int heart_state=0;


        public CardViewHolder(View v) {
            super(v);
            cardsLayout = (RelativeLayout) v.findViewById(R.id.Relative_card);
            textView_que = v.findViewById(R.id.helloText_1);
            imageView_heart = v.findViewById(R.id.like_heart);
            card_backgroung = v.findViewById(R.id.card_image);
            imageView_share = v.findViewById(R.id.share_card);
        }

    }
    public  CardsAdapter(List<Data> data , int rowlayout, Context context)
    {
        this.cards =data;
        this.rowlayout = rowlayout;
        this.context = context;

    }
    @Override
    public CardsAdapter.CardViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(rowlayout, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CardsAdapter.CardViewHolder holder, int position) {
        holder.textView_que.setText(cards.get(position).getQue());
        holder.imageView_heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.imageView_heart.setImageResource(R.drawable.heart_red);
            }
        });
        if (position%2==0)
        {
            holder.card_backgroung.setBackgroundColor(Color.parseColor("#F9A825"));
        }
        if (position%3==0)
        {
            holder.card_backgroung.setBackgroundColor(Color.parseColor("#00ACC1"));
        }

        holder.imageView_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = holder.textView_que.getText().toString();
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Your revision card is here by Boophee");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                context.startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });

    }

    @Override
    public int getItemCount() {
        return cards.size();
    }
}