package com.example.laboratorio03_04.Actividades.Activities;

import android.app.LauncherActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.laboratorio03_04.Actividades.Clases.ListViewAdapter;
import com.example.laboratorio03_04.Actividades.Clases.StudentsName;
import com.example.laboratorio03_04.R;

import java.util.ArrayList;

public class SearchViewActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    /*
    *
    * Parsania H. Listview With Searchview Android Studio Example, 05/05/2019, sitio web demonuts: https://demonuts.com/listview-searchview/
    *
    * */
    private ListView list;
    private ListViewAdapter adapter;
    private SearchView editsearch;
    private String[] studentList;
    public static ArrayList<StudentsName> nombreListaEstudiantes = new ArrayList<StudentsName>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getString(R.string.title_SearchView));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);

        list = (ListView) findViewById(R.id.listView);
        editsearch = (SearchView) findViewById(R.id.searchField);

        studentList = new String[]{"David Guzmán", "Steven Villalobos", "Adrian Picado", "Juan de Dios Murillo",
                                    "Leonardo Hidalgo", "Adriana Herrera", "Erickson López", "Andrea Rojas"};
        nombreListaEstudiantes = new ArrayList<>();
        for(int i = 0; i < studentList.length; i++){
            StudentsName sn = new StudentsName(studentList[i]);
            nombreListaEstudiantes.add(sn);
        }

        adapter = new ListViewAdapter(this);
        list.setAdapter(adapter);
        editsearch.setOnQueryTextListener(this);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), nombreListaEstudiantes.get(position).getNombreAlumno(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String txt = newText;
        adapter.FiltroNombre(txt);
        return false;
    }
}
