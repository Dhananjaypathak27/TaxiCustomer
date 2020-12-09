package com.icanstudioz.taxicustomer.custom;


import androidx.multidex.MultiDexApplication;

import com.icanstudioz.taxicustomer.R;
import com.icanstudioz.taxicustomer.session.SessionManager;
import com.mapbox.mapboxsdk.Mapbox;




/**
 * Created by android on 15/3/17.
 */

public class MyApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
//        Fabric.with(this, new Crashlytics());
        Mapbox.getInstance(getApplicationContext(), getString(R.string.mapboxkey));
        SessionManager.initialize(getApplicationContext());

    }


}
