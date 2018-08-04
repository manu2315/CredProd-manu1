package mx.com.finsol.cred_prod.credprod.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import mx.com.finsol.cred_prod.credprod.R;
import mx.com.finsol.cred_prod.credprod.ui.fragments.ClientAdditionalDataFragment;
import mx.com.finsol.cred_prod.credprod.ui.fragments.ClientDataFragment;
import mx.com.finsol.cred_prod.credprod.ui.fragments.ClientTelephoneFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,ClientDataFragment.OnFragmentInteractionListener,
ClientTelephoneFragment.OnFragmentInteractionListener,ClientAdditionalDataFragment.OnFragmentInteractionListener{

    DrawerLayout drawer;
    NavigationView navigationView;

    //Collapse ActionBar with ImageView Parallax Slide Animation
    Toolbar toolbar;
    AppBarLayout appBarLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    boolean ExpandedActionBar = true;
    //fragments
    public android.app.FragmentManager fragmentManager;
    int idFm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindUI();
        setFragmentByDefault();

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(Math.abs(verticalOffset)>200){
                    ExpandedActionBar=false;
                    collapsingToolbarLayout.setTitle("ClipCodes Android");
                    invalidateOptionsMenu();
                }else{
                    ExpandedActionBar = true;
                    collapsingToolbarLayout.setTitle("Hello, Im ClipCodes");
                    invalidateOptionsMenu();
                }
            }
        });

    }
    private void bindUI(){
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.ctoolbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void setFragmentByDefault()
    {
        ClientDataFragment fragment=new ClientDataFragment();
        //ClientTelephoneFragment fragment = new ClientTelephoneFragment();
        //fragmentClientAdditionalData fragment = new fragmentClientAdditionalData();
        changeFragment(fragment, navigationView.getMenu().getItem(0));
    }
    //Metodo para utilzarse con el menu de sandwich
    private void changeFragment(Fragment fragment, MenuItem item) {

        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
        //idFm=getSupportFragmentManager().getBackStackEntryCount();
        item.setCheckable(true);
        //getSupportActionBar().setTitle(item.getTitle());
        getSupportActionBar().setTitle("Datos del Cliente");
        drawer.closeDrawers();
    }
    public void fragmentClientData(){

        fragmentManager=getFragmentManager();

        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();

        ClientDataFragment fragment=new ClientDataFragment();

        idFm++;
        getSupportActionBar().setTitle("Datos del Cliente");
        transaction.replace(R.id.content_frame,fragment)
                .addToBackStack(null).commit();
    }
    public void fragmentClientAdditionalData(){

        fragmentManager=getFragmentManager();

        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();

        ClientAdditionalDataFragment fragment=new ClientAdditionalDataFragment();

        idFm++;
        getSupportActionBar().setTitle("Datos Adicionales");
        transaction.replace(R.id.content_frame,fragment)
                .addToBackStack(null).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void fragmentClienttelephone(){

        fragmentManager=getFragmentManager();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        ClientTelephoneFragment fragment = new ClientTelephoneFragment();
        idFm++;
        getSupportActionBar().setTitle("Teléfonos del Cliente");
        transaction.replace(R.id.content_frame,fragment).addToBackStack(null).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else if(getSupportFragmentManager().getBackStackEntryCount()>0){
            if(idFm>0) {
                getSupportFragmentManager().popBackStack();
                idFm--;
            }else
                super.onBackPressed();
        }
        else {
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

        //Ejemplo
/*
        boolean fragmentTransaction = false;
         fragment = null;

        //mNuEventos.setEnabled(false);

        switch (item.getItemId()) {

            case R.id.mnCalendario:
                fragment = new CalendarFragment();
                fragmentTransaction = true;
                //idFm=31;
                //fragmentID.push(idFm);
                break;

            case R.id.mnueventos:
                fragment = new EventoListFragment();
                fragmentTransaction = true;

                //idFm =32;
                //GPSstar();
                //fragmentID.push(idFm);
                break;

                */

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
