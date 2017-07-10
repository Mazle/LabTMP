package com.example.user.labtmp;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by user on 20.06.2017.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {
    public abstract Fragment createFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = createFragment();

     //   if (fragment==null) {
      //      fragment = createFragment();
        fm.beginTransaction().
                add(R.id.frameContainer, fragment)
                .commit();


      //   }


    }
}
