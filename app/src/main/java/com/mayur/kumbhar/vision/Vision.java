package com.mayur.kumbhar.vision;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Vision extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private Toolbar toolbar;
    private FragmentDrawer drawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vision);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        drawerFragment = (FragmentDrawer) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);
        displayView(0);
    }

    private void displayView(int i) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (i) {
            case 0:
                fragment = new CybermindFragment();
                title = getString(R.string.title_cyber);
                break;
            case 1:
                fragment = new ExpotechFragment();
                title = getString(R.string.title_expo);
                break;
            case 2:
                fragment = new robotech();
                title = getString(R.string.title_robo);
                break;
            case 3:
                fragment = new technozian();
                title = getString(R.string.tittle_techno);
                break;
            case 4:
                fragment = new ipd();
                title = getString(R.string.title_ipd);
                break;
            case 5:
                fragment = new press();
                title = "Press and Correspondence";
                break;
            case 6:
                fragment = new fianance();
                title = "Finance";
                break;
            case 7:
                fragment = new refreshment();
                title = "Refreshment";
                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();
            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_vision, menu);
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
            Intent intent = new Intent(Vision.this, deveoperMe.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_search) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String body = "Walchand College Of Engineering Sangli\n\nPresents VISION 16\n A national level technical event\n\n download the app and get full details of VISION 16\n\n http://goo.gl/wWX37R  ";
            intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
            intent.putExtra(android.content.Intent.EXTRA_TEXT, body);
            startActivity(Intent.createChooser(intent, "Share via"));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }


}
