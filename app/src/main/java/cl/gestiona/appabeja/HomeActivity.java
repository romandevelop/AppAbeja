package cl.gestiona.appabeja;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;
    private TabLayout tabs;
    private ViewPager pager;
    private AdapterPager adapterPager;
    private NavigationView navigationView;

    public static ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Cargando...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgressStyle(0);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabs = (TabLayout) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pager);

        navigationView = (NavigationView) findViewById(R.id.navigation);

        setSupportActionBar(toolbar);

        adapterPager = new AdapterPager(getSupportFragmentManager());
        pager.setAdapter(adapterPager);
        tabs.setupWithViewPager(pager);

        tabs.getTabAt(0).setIcon(R.drawable.ic_abeja4);
        tabs.getTabAt(1).setIcon(R.drawable.ic_flower4);
        tabs.getTabAt(2).setIcon(R.drawable.ic_work4);
        tabs.setTabTextColors(Color.DKGRAY,Color.BLACK);

        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
        toggle.getDrawerArrowDrawable().setColor(Color.BLACK);//color of menu
        drawer.setDrawerListener(toggle);


        toggle.syncState();

        eventoDrawer();


    }

    public class AdapterPager extends FragmentPagerAdapter{
        public AdapterPager(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new FamiliaAbejasFragment();
                case 1:
                    return new PlantasFragment();
                case 2:
                    return new EspacioFragment();
            }

            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "FAMILIA";
                case 1:
                    return "PLANTAS";
                case 2:
                    return "TRABAJO";
            }
            return null;
        }
    }


    private void eventoDrawer() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                 switch (item.getItemId()) {
                     case R.id.item1:
                         showPage("http://www.abejasnativaschile.cl");
                         break;
                     case R.id.item3:
                         showPage("http://www.escuelabasicatalca.cl");
                         break;
                     case R.id.item4:
                         showPage("https://www.liceosantamartatalca.cl");
                         break;
                     case R.id.item5:
                         showPage("http://www.colegioconstitucion.cl/conocenos/infraestructura.php");
                         break;
                     case R.id.item6:
                         showPage("http://www.conicyt.cl/explora/");
                         break;
                     case R.id.item7:
                         showPage("http://www.explora.cl/ohiggins");
                         break;
                     case R.id.item8:
                         showPage("http://www.abejasnativaschile.cl/wp-content/uploads/2016/05/libro-guia-de-campo-1.pdf");
                         break;
                 }
                drawer.closeDrawers();
                return true;
            }
        });
    }



    private void showPage(String url){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }


    public void testProgress(){
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Cargando...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgressStyle(0);
        progressDialog.show();

    }


}
