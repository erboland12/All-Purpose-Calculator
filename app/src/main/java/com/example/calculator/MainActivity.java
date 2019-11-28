package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.calculator.RecyclerViewActivities.ChemActivity;
import com.example.calculator.RecyclerViewActivities.GeoActivity;
import com.example.calculator.RecyclerViewActivities.MiscellaneousActivity;
import com.example.calculator.RecyclerViewActivities.PhysicsActivity;
import com.example.calculator.RecyclerViewActivities.TrigActivity;
import com.example.calculator.Settings.MyPreferenceFragment;
import com.example.calculator.Settings.SettingsActivity;
import com.google.android.material.navigation.NavigationView;

import static com.example.calculator.R.color.colorBlack;
import static com.example.calculator.R.color.colorBlue;
import static com.example.calculator.R.color.colorGold;
import static com.example.calculator.R.color.colorGreen;
import static com.example.calculator.R.color.colorLightBrown;
import static com.example.calculator.R.color.colorPurple;
import static com.example.calculator.R.color.colorWhite;
import static com.example.calculator.R.color.whiteHexSmoke;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    //Button initialization
    Button calculatorBtn;
    Button miscBtn;
    Button trigBtn;
    Button physBtn;
    Button chemBtn;
    Button geoBtn;

    //Drawer layout initialization
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    private SharedPreferences shared;
    public static boolean darkIsOn = false;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(returnDark() || AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            MainActivity.this.setTheme(R.style.darkTheme);
        }else{
            MainActivity.this.setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("");
        setNavigationViewListener();

        final MovePage m = new MovePage();

        //Sets up DrawerLayout and ActionBar
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.Open, R.string.Close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        calculatorBtn = findViewById(R.id.calcBtn);
        calculatorBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                m.moveActivity(MainActivity.this, CalculatorActivity.class);
            }
        });

        miscBtn = findViewById(R.id.miscButton);
        miscBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                m.moveActivity(MainActivity.this, MiscellaneousActivity.class);
            }
        });

        trigBtn = findViewById(R.id.trigBtn);
        trigBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.moveActivity(MainActivity.this, TrigActivity.class);
            }
        });

        physBtn = findViewById(R.id.physBtn);
        physBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.moveActivity(MainActivity.this, PhysicsActivity.class);
            }
        });

        chemBtn = findViewById(R.id.chemBtn);
        chemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.moveActivity(MainActivity.this, ChemActivity.class);
            }
        });

        geoBtn = findViewById(R.id.geoBtn);
        geoBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                m.moveActivity(MainActivity.this, GeoActivity.class);
            }
        });

        if(!returnDark()){
            calculatorBtn.setBackgroundColor(getResources().getColor(whiteHexSmoke));
            geoBtn.setBackgroundColor(getResources().getColor(colorGold));
            chemBtn.setBackgroundColor(getResources().getColor(colorGreen));
            trigBtn.setBackgroundColor(getResources().getColor(colorBlue));
            physBtn.setBackgroundColor(getResources().getColor(colorLightBrown));
            miscBtn.setBackgroundColor(getResources().getColor(colorPurple));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if(returnDark()){
//            Drawable draw = getResources().getDrawable(R.drawable.menu);
//            draw.mutate().setColorFilter(getResources().getColor(colorWhite), PorterDuff.Mode.MULTIPLY);
            getMenuInflater().inflate(R.menu.menu_icon, menu);
            for(int i = 0; i < menu.size(); i++){
                Drawable drawable = menu.getItem(i).getIcon();
                if(drawable != null) {
                    drawable.mutate();
                    drawable.setColorFilter(getResources().getColor(colorWhite), PorterDuff.Mode.SRC_ATOP);
                }
            }
        }else{
            getMenuInflater().inflate(R.menu.menu_icon, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_favorite) {
            mDrawerLayout.openDrawer(GravityCompat.START);
            //Toast.makeText(MainActivity.this, "Action clicked", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.menu_Geometry: {
                MovePage m = new MovePage();
                m.moveActivity(MainActivity.this, GeoActivity.class);
                break;
            }
            case R.id.menu_Chem: {
                MovePage m = new MovePage();
                m.moveActivity(MainActivity.this, ChemActivity.class);
                break;
            }
            case R.id.menu_Trig: {
                MovePage m = new MovePage();
                m.moveActivity(MainActivity.this, TrigActivity.class);
                break;
            }
            case R.id.menu_Phys: {
                MovePage m = new MovePage();
                m.moveActivity(MainActivity.this, PhysicsActivity.class);
                break;
            }
            case R.id.menu_Misc: {
                MovePage m = new MovePage();
                m.moveActivity(MainActivity.this, MiscellaneousActivity.class);
                break;
            }
            case R.id.menu_Calc: {
                MovePage m = new MovePage();
                m.moveActivity(MainActivity.this, CalculatorActivity.class);
                break;
            }
            case R.id.settings:{
                MovePage m = new MovePage();
                m.moveActivity(MainActivity.this, SettingsActivity.class);
                break;
            }
            case R.id.quit_app:{
                finish();
                System.exit(0);
            }
        }
        //close navigation drawer
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setNavigationViewListener() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private boolean returnDark(){
        shared = getSharedPreferences("DarkMode", MODE_PRIVATE);
        Log.d("Is Dark?", Boolean.toString(shared.getBoolean("darkMode", false)));
        return shared.getBoolean("darkMode", false);
    }

}
