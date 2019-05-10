package com.example.laboratorio03_04.Actividades.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

import com.example.laboratorio03_04.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_VideoView) {
            // Handle the camera action
            Toast.makeText(getApplicationContext(), "Widget: VideoView", Toast.LENGTH_SHORT).show();
            abrirVideoView();
        } else if (id == R.id.nav_SearchView) {
            Toast.makeText(getApplicationContext(), "Widget: SearchView", Toast.LENGTH_SHORT).show();
            abrirSearchView();
        } else if (id == R.id.nav_ProgressBar) {
            Toast.makeText(getApplicationContext(), "Widget: ProgressBar Circular", Toast.LENGTH_SHORT).show();
            abrirProgressBarCircular();
        } else if (id == R.id.nav_ProgressBarHorizontal) {
            Toast.makeText(getApplicationContext(), "Widget: ProgressBar Horizontal", Toast.LENGTH_SHORT).show();
            abrirProgressBarHorizontal();
        } else if (id == R.id.nav_RatingBar) {
            Toast.makeText(getApplicationContext(), "Widget: RatingBar", Toast.LENGTH_SHORT).show();
            abrirRatingBar();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void abrirVideoView(){
        Intent intent = new Intent(this, VideoViewActivity.class);
        startActivity(intent);
    }

    public void abrirProgressBarHorizontal(){
        Intent intent = new Intent(this, ProgressBarHActivity.class);
        startActivity(intent);
    }

    public void abrirProgressBarCircular(){
        Intent intent = new Intent(this, ProgressBarCircularActivity.class);
        startActivity(intent);
    }

    public void abrirRatingBar(){
        Intent intent = new Intent(this, RatingBarActivity.class);
        startActivity(intent);
    }

    public void abrirSearchView(){
        Intent intent = new Intent(this, SearchViewActivity.class);
        startActivity(intent);
    }
}
