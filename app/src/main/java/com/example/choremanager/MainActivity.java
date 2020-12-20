package com.example.choremanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class MainActivity extends AppCompatActivity {
    //Initalize variabl
    BottomNavigationView bottomNavigationView;
    Deque<Integer> integerDeque = new ArrayDeque<>(4);
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign variable
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Add home fragment in deque list
        integerDeque.push(R.id.bn_home);
        //Load home fragment
        loadFragment(new home());
        //Set home as default fragment
        bottomNavigationView.setSelectedItemId(R.id.bn_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        //Get selected item id
                        int id = item.getItemId();
                        //Check condition
                        if(integerDeque.contains(id)){
                            //When deque list contains selected id
                            //Check condition
                            if(id == R.id.bn_home) {
                                //When selected id is equal to home fragment id
                                //Check condition
                                if(integerDeque.size() != 1){
                                    //When deque list size is not equal to 1
                                    //Check condition
                                    if(flag){
                                        //When flag value is true
                                        //Add home fragment in deque list
                                        integerDeque.addFirst(R.id.bn_home);
                                        //Set flag is equal to false
                                        flag = false;
                                    }
                                }
                            }
                            //Remove selected id from deque list
                            integerDeque.remove(id);
                        }
                        //Push selected id in deque list
                        integerDeque.push(id);
                        //Load fragment
                        loadFragment(getFragment(item.getItemId()));
                        //return true
                        return true;
                    }
                }
        );
    }

    private Fragment getFragment(int itemId) {
        switch(itemId){
            case R.id.bn_home:
                //Set checked home fragment
                bottomNavigationView.getMenu().getItem(0).setChecked(true);
                //Return home fragment
                return new home();
            case R.id.bn_calendar:
                //Set checked calendar fragment
                bottomNavigationView.getMenu().getItem(1).setChecked(true);
                //Return calendar fragment
                return new Calendar();
            case R.id.bn_settings:
                //Set checked settings fragment
                bottomNavigationView.getMenu().getItem(2).setChecked(true);
                //Return settings fragment
                return new settings();
            case R.id.bn_test:
                //Set checked testing fragment
                bottomNavigationView.getMenu().getItem(3).setChecked(true);
                //Return testing fragment
                return new addChore();
        }
        //Set checked default home fragment
        bottomNavigationView.getMenu().getItem(1).setChecked(true);
        //Return home fragment
        return new home();
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment, fragment, fragment.getClass().getSimpleName())
                .commit();
    }

    /*@Override
    public void onBackPressed() {
        //Pop to previous fragment
        integerDeque.pop();
        //Check condition
        if(!integerDeque.isEmpty()){
            loadFragment(getFragment(integerDeque.peek()));
        }else {
            finish();
        }


    }*/
}