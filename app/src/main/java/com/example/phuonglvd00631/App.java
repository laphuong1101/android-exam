package com.example.phuonglvd00631;

import android.app.Application;

public class App extends Application {
    private static App instance;
    private Database database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = new Database(this, "Exam.sqlite", null, 1);
    }

    public static App getInstance() {
        return instance;
    }

    public Database getDatabase() {
        return database;
    }
}
