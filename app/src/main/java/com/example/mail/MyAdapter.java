package com.example.mail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private List<Mail> list;
    private int layout;

    public MyAdapter(Context context, List<Mail> list, int layout) {
        this.context = context;
        this.list = list;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Mail getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if (view == null){
            view = LayoutInflater.from(context).inflate(layout, null);
            viewHolder = new ViewHolder();
            viewHolder.id = (TextView) view.findViewById(R.id.textViewID);
            viewHolder.nombre = (TextView) view.findViewById(R.id.textViewNombre);
            viewHolder.asunto = (TextView) view.findViewById(R.id.textViewAsunto);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Mail currentMail = list.get(i);

        viewHolder.id.setText(currentMail.getID()+"");
        viewHolder.nombre.setText("                "+currentMail.getNombre());
        viewHolder.asunto.setText("                                         "+currentMail.getAsunto());

        return view;
    }

    public class ViewHolder {
        TextView id;
        TextView nombre;
        TextView asunto;
    }
}
