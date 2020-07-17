package com.ayomi.wisewords;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

public class SimpleOffline extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
