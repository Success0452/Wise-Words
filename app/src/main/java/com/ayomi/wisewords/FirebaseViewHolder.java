package com.ayomi.wisewords;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FirebaseViewHolder extends RecyclerView.ViewHolder {

    public TextView author,quotes;

    public FirebaseViewHolder(@NonNull View itemView) {
        super(itemView);

        author = itemView.findViewById(R.id.view_author);
        quotes = itemView.findViewById(R.id.view_quote);

    }
}