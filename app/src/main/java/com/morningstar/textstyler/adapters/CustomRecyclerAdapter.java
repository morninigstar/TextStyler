/*
 * Created by Sujoy Datta. Copyright (c) 2018. All rights reserved.
 *
 * To the person who is reading this..
 * When you finally understand how this works, please do explain it to me too at sujoydatta26@gmail.com
 * P.S.: In case you are planning to use this without mentioning me, you will be met with mean judgemental looks and sarcastic comments.
 */

package com.morningstar.textstyler.adapters;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.morningstar.textstyler.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.CustomRecyclerViewHolder> {

    private View view;
    private Context context;
    private ArrayList<Typeface> fontArraylist;
    private String text;

    public CustomRecyclerAdapter(Context context, ArrayList<Typeface> arrayList, String string) {
        this.context = context;
        this.fontArraylist = arrayList;
        this.text = string;
    }

    @NonNull
    @Override
    public CustomRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item_recycler,null);
        return new CustomRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomRecyclerViewHolder holder, int position) {
        holder.textView.setTypeface(fontArraylist.get(position));

        if (!TextUtils.isEmpty(text))
            holder.textView.setText(text);

        holder.itemNumber.setText(String.valueOf(position + 1));

        holder.copyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(text)) {
                    ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clipData = ClipData.newPlainText("copied_text", text);
                    clipboardManager.setPrimaryClip(clipData);
                    Snackbar snackbar = Snackbar.make(view, "Copied", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                } else
                    Toast.makeText(context, "Nothing to copy", Toast.LENGTH_SHORT).show();
            }
        });

        holder.shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(text)) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT, text);
                    context.startActivity(Intent.createChooser(intent, "Share Text"));
                } else {
                    Toast.makeText(context, "Nothing to share", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return fontArraylist.size();
    }

    class CustomRecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        TextView itemNumber;
        CircleImageView shareButton, copyButton;

        CustomRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            itemNumber = itemView.findViewById(R.id.itemNumber);
            shareButton = itemView.findViewById(R.id.shareButton);
            copyButton = itemView.findViewById(R.id.copyButton);
        }
    }
}
