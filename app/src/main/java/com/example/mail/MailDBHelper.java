package com.example.mail;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MailDBHelper extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE Mail (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nombre TEXT, asunto TEXT)";

    public MailDBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.sqlCreate = sqlCreate;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Mail");
        sqLiteDatabase.execSQL(sqlCreate);
    }
}
