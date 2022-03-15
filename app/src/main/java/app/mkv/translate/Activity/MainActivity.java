package app.mkv.translate.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import app.mkv.translate.Fragment.HomeFragment;
import app.mkv.translate.Fragment.FavoriteFragment;
import app.mkv.translate.Fragment.SearchFragment;
import app.mkv.translate.R;

public class MainActivity extends AppCompatActivity {

    ChipNavigationBar nb_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();

        itemClicked();

        navihationBottom();


    }

    private void initView(){

        nb_main = findViewById(R.id.nb_main);

    }

    private void itemClicked(){


    }



    private void navihationBottom(){

        nb_main.setItemSelected(R.id.nb_home, true);
        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_main, homeFragment);
        fragmentTransaction.commit();

        nb_main.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                if (i == R.id.nb_home){
                    HomeFragment homeFragment = new HomeFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fl_main, homeFragment);
                    fragmentTransaction.commit();
                }


                if (i == R.id.nb_favorite){
                    FavoriteFragment favoriteFragment = new FavoriteFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fl_main, favoriteFragment);
                    fragmentTransaction.commit();
                }

                if (i == R.id.nb_search){
                    SearchFragment searchFragment = new SearchFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fl_main, searchFragment);
                    fragmentTransaction.commit();
                }
            }
        });

    }


}