package com.example.mail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private boolean isMultiPanel;
    private Button btnCreate;
    private MailDBHelper mailHelper;
    private SQLiteDatabase db;
    private List<Mail> mail;
    private ListView listView;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setMultiPanel();

        listView = (ListView) findViewById(R.id.listView);
        mail = new ArrayList<Mail>();
        btnCreate = (Button) findViewById(R.id.buttonCreate);

        btnCreate.setOnClickListener(v -> {
            create();
            update();
        });

        mailHelper = new MailDBHelper(this, "DBTest", null, 1);
        db = mailHelper.getWritableDatabase();

        adapter = new MyAdapter(this, mail, R.layout.item_db);
        listView.setAdapter(adapter);

        update();
    }

    private List<Mail> getAllMail(){
        //Seleccionamos todos los registros de la tabla Mail
        Cursor cursor = db.rawQuery("select * from Mail", null);
        List<Mail> list = new ArrayList<Mail>();
        if(cursor.moveToFirst()){
            while (cursor.isAfterLast()==false){
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String nombre = cursor.getString(cursor.getColumnIndex("nombre"));
                String asunto = cursor.getString(cursor.getColumnIndex("asunto"));

                list.add(new Mail(id,nombre,asunto));
                cursor.moveToNext();
            }
        }
        return list;
    }

    public void create(){
        if(db != null){
            ContentValues nuevoRegistro = new ContentValues();
            nuevoRegistro.put("nombre","Falabella");
            nuevoRegistro.put("asunto","Super Oferta");
            db.insert("Mail",null,nuevoRegistro);
        }
    }

    private void update() {
        mail.clear();
        mail.addAll(getAllMail());
        adapter.notifyDataSetChanged();
    }

    public void setMultiPanel(){
        isMultiPanel = (getSupportFragmentManager().findFragmentById(R.id.detailsFragment) != null);
    }
}