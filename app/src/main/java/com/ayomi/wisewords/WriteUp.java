package com.ayomi.wisewords;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WriteUp extends AppCompatActivity {

    EditText author, quotes;
    Button btnsubmit;

    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_up);

        author = findViewById(R.id.edtname);
        quotes = findViewById(R.id.edt_quotes);

        btnsubmit = findViewById(R.id.btnsubmit);

        database = FirebaseDatabase.getInstance();


        //myRef.setValue("Hello, World!");

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!(author.getText().toString().equals("") || quotes.getText().toString().equals(""))){
                    getValues();
                    //setContentView(R.layout.activity_main2);
                } else{
                    Toast.makeText(WriteUp.this, "All field required", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void getValues(){

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Write Ups");

        String uniqueId = myRef.push().getKey();

        Quotes user = new Quotes();
        user.setName(author.getText().toString());
        user.setQuotes(quotes.getText().toString());

        myRef.child(uniqueId).setValue(user);
        Toast.makeText(WriteUp.this, "Data Inputed...",Toast.LENGTH_SHORT).show();

    }

    public void btnView(View view) {
    }

    public void btnSubmit(View view) {
    }
}