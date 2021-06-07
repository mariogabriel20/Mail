package com.example.mail;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class MailFragment extends Fragment {

    private TextView mailText;
    private TextView mensaje;

    public MailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mail, container, false);
        mensaje = inflater.inflate(R.layout.item_db, container, false).findViewById(R.id.textViewID);
        mensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("clickeaste en falabella");
                String txt = mensaje.getText().toString();
                DetailsFragment detailsFragment = new DetailsFragment();
                detailsFragment.ChangeText(txt);
                System.out.println(txt);
            }
        });
        mailText = (TextView) view.findViewById(R.id.mail);
        mailText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                //MailFragment mailFragment = this;
                DetailsFragment detailsFragment = new DetailsFragment();
                ///FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction transaction = MailFragment.this.getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.mailFragment, detailsFragment).addToBackStack(null).commit();
                ////mail.setTextColor(Color.rgb(255,255,255));
            }
        });

        return view;
    }

}