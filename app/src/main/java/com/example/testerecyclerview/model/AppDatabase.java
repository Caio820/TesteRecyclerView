package com.example.testerecyclerview.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ListItem.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ItemDao itemDao();
}