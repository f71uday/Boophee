package com.boophee.boophee;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
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
        TextView textView_que;
        TextView textView_ans;


        public CardViewHolder(View v) {
            super(v);
            cardsLayout = (RelativeLayout) v.findViewById(R.id.Relative_card);
            textView_que = v.findViewById(R.id.helloText_1);
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
    public void onBindViewHolder(CardsAdapter.CardViewHolder holder, int position) {
        holder.textView_que.setText(cards.get(position).getQue());
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }
}