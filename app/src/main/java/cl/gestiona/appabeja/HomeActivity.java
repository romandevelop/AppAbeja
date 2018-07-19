package cl.gestiona.appabeja;

import android.content.Intent;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabs = (TabLayout) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pager);

        navigationView = (NavigationView) findViewById(R.id.navigation);

        setSupportActionBar(toolbar);

        adapterPager = new AdapterPager(getSupportFragmentManager());
        pager.setAdapter(adapterPager);
        tabs.setupWithViewPager(pager);

        tabs.getTabAt(0).setIcon(R.drawable.icon_family);
        tabs.getTabAt(1).setIcon(R.drawable.icon_flower);
        tabs.getTabAt(2).setIcon(R.drawable.icon_work);

        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
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

}
