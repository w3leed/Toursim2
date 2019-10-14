package com.example.hassan.toursim;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.hassan.toursim.Places.ConnectFragment;
import com.example.hassan.toursim.Trip.FixturesFragment;
import com.example.hassan.toursim.gouvernoment.TableFragment;
import com.example.hassan.toursim.userlogin.Login;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static final String TAG = Main.class.getSimpleName();
    private ImageButton img_btn_side_menu;
    private DrawerLayout myDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        FragmentTransaction f=getSupportFragmentManager().beginTransaction();
        f.replace(R.id.fram_content,new ConnectFragment());
        f.commit();
        //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //  setSupportActionBar(toolbar);
        configureAllTripsButton();
        configureAllGovsButton();
        img_btn_side_menu = (ImageButton) findViewById(R.id.img_btn_side_menu);
        myDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        img_btn_side_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDrawer.openDrawer(GravityCompat.START);

            }
        });
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
       /* fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //  ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        //          this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //      drawer.addDrawerListener(toggle);
        //     toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
      displayselectitem(item.getItemId());
      return  true;
    }



    public void displayselectitem(int itemId)
    {
        Fragment fragment=null;
        //fragment=new ConnectFragment();
        switch (itemId)
        {
            case R.id.itemCategories:
                //   Snackbar.make(getWindow().getDecorView().findViewById(android.R.id.content), "Test", Snackbar.LENGTH_LONG)
                     //  .setAction("Action", null).show();

             fragment=new ConnectFragment();
                break;
            case R.id.itemGovs:
                // Snackbar.make(getWindow().getDecorView().findViewById(android.R.id.content), "Test", Snackbar.LENGTH_LONG)
                //.setAction("Ok", null).show();
                fragment=new FixturesFragment();
                break;
            case  R.id.itemCorporations:
                // do something
                fragment=new TableFragment();
               break;
            case R.id.itemTrips:
                Toast.makeText(this, "الرحلات............. ", Toast.LENGTH_LONG).show();
                // do something
            break;
            case R.id.itemInterests:
                Toast.makeText(this, "المفضلة............", Toast.LENGTH_LONG).show();
                // do something
              break;
            case R.id.itemSettings:
                startActivity(new Intent(Main.this, Settting.class));
               break;
            case R.id.itemLogout:

                // do something
                finish();
                startActivity(new Intent(Main.this, Login.class));
               break;

        }

       if(fragment!=null)
       {


           FragmentTransaction f=getSupportFragmentManager().beginTransaction();
           f.replace(R.id.fram_content,fragment);
           f.commit();
       }
       else {
           // error in creating fragment
           Log.e("BunBunUp", "MenuActivity - Error cuando se creo el fragment");
       }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
       drawer.closeDrawer(GravityCompat.START);
    }

    private void configureAllTripsButton() {

        Button btnAllTrips = (Button)findViewById(R.id.btnAllTrips);

        btnAllTrips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  startActivity(new Intent(MainActivity.this, TripsActivity.class));
                //  finish();
               // Toast.makeText(Main.this, "TripsActivity", Toast.LENGTH_SHORT).show();
                FragmentTransaction f=getSupportFragmentManager().beginTransaction();
                f.replace(R.id.fram_content,new FixturesFragment());
                f.commit();
            }
        });

    }
    private void configureAllGovsButton() {

        Button btnAllGovs= (Button)findViewById(R.id.btnAllGovs);

        btnAllGovs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   startActivity(new Intent(TripsActivity.this, MainActivity.class));
                // finish();
              //  Toast.makeText(Main.this, "btnAllGovsWWWWW", Toast.LENGTH_LONG).show();
                FragmentTransaction f=getSupportFragmentManager().beginTransaction();
                f.replace(R.id.fram_content,new ConnectFragment());
                f.commit();
            }
        });

    }
}
