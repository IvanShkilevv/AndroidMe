/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

public class AndroidMeActivity extends AppCompatActivity {

    private BodyPartFragment headFragment;
    private final String HEAD_FRAGMENT= "headFragment" ;

    private BodyPartFragment bodyFragment;
    private final String BODY_FRAGMENT= "bodyFragment" ;

    private BodyPartFragment legsFragment;
    private final String LEGS_FRAGMENT= "legsFragment" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        if (savedInstanceState == null) {
            headFragment = new BodyPartFragment();
            headFragment.setImageListIDs(AndroidImageAssets.getHeads());
            int headIndex = getIntent().getIntExtra("headIndex", 0);
            headFragment.setImageListIndex(headIndex);

            bodyFragment = new BodyPartFragment();
            bodyFragment.setImageListIDs(AndroidImageAssets.getBodies());
            int bodyIndex = getIntent().getIntExtra("bodyIndex", 0);
            bodyFragment.setImageListIndex(bodyIndex);

            legsFragment = new BodyPartFragment();
            legsFragment.setImageListIDs(AndroidImageAssets.getLegs());
            int legIndex = getIntent().getIntExtra("legIndex", 0);
            legsFragment.setImageListIndex(legIndex);

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .add(R.id.body_container, bodyFragment)
                    .add(R.id.legs_container, legsFragment)
                    .commit();
        }
        else {
            headFragment = (BodyPartFragment) getSupportFragmentManager().getFragment(savedInstanceState, HEAD_FRAGMENT);
            bodyFragment = (BodyPartFragment) getSupportFragmentManager().getFragment(savedInstanceState, BODY_FRAGMENT);
            legsFragment = (BodyPartFragment) getSupportFragmentManager().getFragment(savedInstanceState, LEGS_FRAGMENT);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, HEAD_FRAGMENT, headFragment);
        getSupportFragmentManager().putFragment(outState, BODY_FRAGMENT, bodyFragment);
        getSupportFragmentManager().putFragment(outState, LEGS_FRAGMENT, legsFragment);
    }
}
