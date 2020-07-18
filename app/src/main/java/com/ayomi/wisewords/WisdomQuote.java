package com.ayomi.wisewords;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class WisdomQuote extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<SetQuotes> arrayList;
    private FirebaseRecyclerOptions<SetQuotes> options;
    private FirebaseRecyclerAdapter<SetQuotes,FirebaseViewHolder> adapter;
    private DatabaseReference databaseReference;

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisdom_quote);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList = new ArrayList<SetQuotes>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Wisdom Quotes");
        //offline
        databaseReference.keepSynced(true);

        options = new FirebaseRecyclerOptions.Builder<SetQuotes>().setQuery(databaseReference,SetQuotes.class).build();

        adapter = new FirebaseRecyclerAdapter<SetQuotes, FirebaseViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseViewHolder firebaseViewHolder, int i, @NonNull final SetQuotes setQuotes) {

                firebaseViewHolder.author.setText(setQuotes.getName());
                firebaseViewHolder.quotes.setText(setQuotes.getQuotes());

                firebaseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(WisdomQuote.this, Motivational.class);
                        intent.putExtra("name", setQuotes.getName());
                        intent.putExtra("quotes",setQuotes.getQuotes());

                        startActivity(intent);
                    }
                });

            }

            @NonNull
            @Override
            public FirebaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new FirebaseViewHolder(LayoutInflater.from(WisdomQuote.this).inflate(R.layout.row,parent,false));
            }
        };



        recyclerView.setAdapter(adapter);
    }
}