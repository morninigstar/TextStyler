/*
 * Created by Sujoy Datta. Copyright (c) 2018. All rights reserved.
 *
 * To the person who is reading this..
 * When you finally understand how this works, please do explain it to me too at sujoydatta26@gmail.com
 * P.S.: In case you are planning to use this without mentioning me, you will be met with mean judgemental looks and sarcastic comments.
 */

package com.morningstar.textstyler.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.morningstar.textstyler.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.CustomRecyclerViewHolder> {

    private View view;
    private Context context;

    public CustomRecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CustomRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item_recycler,null);
        return new CustomRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomRecyclerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class CustomRecyclerViewHolder extends RecyclerView.ViewHolder{

        public CustomRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
