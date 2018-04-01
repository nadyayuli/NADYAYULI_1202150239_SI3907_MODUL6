package com.example.nadyayulipratama.nadya_1202150239_modul6;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity implements TERBARU.OnFragmentInteractionListener,FOTOSAYA.OnFragmentInteractionListener {

private FirebaseAuth mAuth;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        mAuth = FirebaseAuth.getInstance();//important call
        if (mAuth.getCurrentUser() == null) {
        finish();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
final PagerAdapter adapter = new pagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }


        });
        }
}

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public boolean onCreateOptionMenu(Menu menu) {

            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            //getItemId() dari item dengan action_settings pada Menu
            if (item.getItemId() == R.id.action_settings) {
                //FirebaseAuth.getInstance() untuk signOut()
                mAuth.signOut();
                //Intent dari PopotoanHome ke MenuLogin
                startActivity(new Intent(Home.this, MainActivity.class));
                //finish
                finish();
            }
            //mengembalikan nilai boolean true
            return true;
        }}
