package com.example.laboratorio03_04.Actividades.Clases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.laboratorio03_04.Actividades.Activities.SearchViewActivity;
import com.example.laboratorio03_04.R;

import java.util.ArrayList;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<StudentsName> listaStudents;

    public ListViewAdapter(Context vContext) {
        this.context = vContext;
        inflater = LayoutInflater.from(context);
        this.listaStudents = new ArrayList<StudentsName>();
        this.listaStudents.addAll(SearchViewActivity.nombreListaEstudiantes);
    }

    public class ViewHolder{
        TextView name;
    }

    @Override
    public int getCount() {
        return SearchViewActivity.nombreListaEstudiantes.size();
    }

    @Override
    public Object getItem(int position) {
        return SearchViewActivity.nombreListaEstudiantes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {//con este metodo puedo cargar informacion en cada item
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);
            holder.name = (TextView) view.findViewById(R.id.name);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.name.setText(SearchViewActivity.nombreListaEstudiantes.get(position).getNombreAlumno());
        return view;
    }

    public void FiltroNombre(String txtNombre){
        txtNombre = txtNombre.toLowerCase(Locale.getDefault());
        SearchViewActivity.nombreListaEstudiantes.clear();
        if(txtNombre.length() == 0){
            SearchViewActivity.nombreListaEstudiantes.addAll(listaStudents);
        }else{
            for(StudentsName sn: listaStudents){
                if(sn.getNombreAlumno().toLowerCase(Locale.getDefault()).contains(txtNombre)){
                    SearchViewActivity.nombreListaEstudiantes.add(sn);
                }
            }
        }
        notifyDataSetChanged();
    }
}
