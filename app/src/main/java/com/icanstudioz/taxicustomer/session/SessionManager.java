package com.icanstudioz.taxicustomer.session;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.icanstudioz.taxicustomer.acitivities.LoginActivity;
import com.icanstudioz.taxicustomer.pojo.User;


import java.util.HashMap;

import static com.mapbox.mapboxsdk.Mapbox.getApplicationContext;


/**
 * Created by android on 9/3/17.
 */


public class SessionManager {
    // Shared Preferences
    static SharedPreferences pref;

    // Editor for Shared preferences
    //SharedPreferences.Editor editor;

    // Context
    //Context _context;

    // Shared pref mode
    //int PRIVATE_MODE = 0;

    static SessionManager app;

    // Sharedpref file name
    private static final String PREF_NAME = "taxiapp";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    // User name (make variable public to access from outside)
    public static final String KEY_NAME = "name";
    public static final String AVATAR = "avatar";
    public static final String KEY_MOBILE = "mobile";
    public static final String KEY_PAYPALID = "paypal_id";
    public static final String KEY_VEHICLE = "vehicle";
    public static final String GCM_TOKEN = "gcm_token";


    // Email address (make variable public to access from outside)

    public static final String KEY_EMAIL = "email";
    public static final String FARE_UNIT = "unit";
    public static final String COST = "cost";
    public static final String LOGIN_AS = "login_as";
    public static final String USER_ID = "user_id";
    public static final String IS_ONLINE = "false";
    public static String KEY = "key";
    public static final String USER = "user";

    // vehicle info variables

    public static final String BRAND = "brand";
    public static final String MODEL = "model";
    public static final String YEAR = "year";
    public static final String COLOR = "color";

    public static final String DRivingLicence = "licence";
    public static final String VehicleInsurance = "insurance";
    public static final String VehicleNo = "no";
    public static final String VehiclePermit = "permit";
    public static final String VehicleRegistartion = "registration";
    private int name;
    private String avatar;
    private String email;


    public static void setGcmToken(String gcmToken) {

        SharedPreferences.Editor prefsEditor = pref.edit();
        prefsEditor.putString(GCM_TOKEN, gcmToken);
        prefsEditor.commit();
    }

    public SessionManager() {
    }

    public static void initialize(Context context) {
        if (pref == null)
            pref = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);


    }

    /*public static SessionManager getInstance(Context context) {
        if (app == null) {
            app = new SessionManager();

        }
        app.setrPref();
        return (app);
    }*/

    public String getGcmToken() {
        return pref.getString(GCM_TOKEN, null);
    }

    public static void setStatus(String staus) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(IS_ONLINE, staus);
        editor.commit();
    }

    public static String getStatus() {

        return pref.getString(IS_ONLINE, null);
    }

    public static void setUser(String user) {
        SharedPreferences.Editor prefsEditor = pref.edit();
        prefsEditor.putString(USER, user);
        prefsEditor.commit();
    }

    public static void setIsLogin() {
        SharedPreferences.Editor prefsEditor = pref.edit();
        prefsEditor.putBoolean(IS_LOGIN, true);
        prefsEditor.commit();

    }

 /*   public SharedPreferences getPref() {
        pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = pref.edit();
        return pref;
    }

    public SharedPreferences.Editor getDb() {
        pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = pref.edit();
        return editor;
    }*/

    public static User getUser() {
        Gson gson = new Gson();
        return gson.fromJson(pref.getString(USER, null), User.class);

    }

    public void setpaypalId(String k) {
        SharedPreferences.Editor prefsEditor = pref.edit();
        prefsEditor.putString(KEY_PAYPALID, k);
        prefsEditor.commit();
    }


    public static void setKEY(String k) {
        SharedPreferences.Editor prefsEditor = pref.edit();
        prefsEditor.putString(KEY, k);
        prefsEditor.commit();
    }

    public static String getKEY() {
        return getUser() == null ? "" : getUser().getKey();
    }

    /*public SharedPreferences setPref(Context context) {

        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        return pref;

    }*/

 /*   public SharedPreferences setrPref() {
        pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = pref.edit();
        return pref;
    }*/
    // Constructor

    public static void setUnit(String unit) {
        SharedPreferences.Editor prefsEditor = pref.edit();
        prefsEditor.putString(FARE_UNIT, unit);
        prefsEditor.commit();
    }

    public static void setCost(String unit) {
        SharedPreferences.Editor prefsEditor = pref.edit();
        prefsEditor.putString(COST, unit);
        prefsEditor.commit();
    }

    public static String getUnit() {

        return pref.getString(FARE_UNIT, null);
    }

    /*  *//**
     * Create login session
     *//*
    public void createLoginSession(String name, String email, String user, String avatar, String mobile, String vehicle) {
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing name in pref
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_MOBILE, mobile);
        editor.putString(KEY_VEHICLE, vehicle);
        // Storing email in pref
        editor.putString(KEY_EMAIL, email);
        editor.putString(USER_ID, user);
        editor.putString(AVATAR, avatar);


        // commit changes
        editor.commit();
    }

    public void setVehicleInfo(String brand, String model, String year, String color, String licence,
                               String insurance, String no, String permit, String registration) {

        editor.putString(BRAND, brand);
        editor.putString(MODEL, model);
        editor.putString(YEAR, year);
        editor.putString(COLOR, color);

        editor.putString(DRivingLicence, licence);
        editor.putString(VehicleInsurance, insurance);
        editor.putString(VehicleNo, no);
        editor.putString(VehiclePermit, permit);
        editor.putString(VehicleRegistartion, registration);
        editor.commit();
    }

    */

    /**
     * Check login method wil checkky user login status
     * If false it will redirect user to login page
     * Else won't do anything
     */
    public void checkLogin(Context _context) {
        // Check login status
        if (!this.isLoggedIn()) {
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, LoginActivity.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            _context.startActivity(i);
        }

    }



    public static String getUserId() {
        return getUser()==null?"":getUser().getUser_id();
    }

    /**
     * Clear session details
     */


    public static void logoutUser(Context _context) {
        SharedPreferences.Editor prefsEditor = pref.edit();
        prefsEditor.putBoolean(IS_LOGIN, false);
        prefsEditor.clear();
        prefsEditor.commit();
        Intent i = new Intent(_context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        _context.startActivity(i);
    }

    /**
     * Quick checkky for login
     **/
    // Get Login State
    public static boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }

    public static String getName() {
        return getUser()==null?"":getUser().getName();
    }

    public static String getAvatar() {
        return getUser()==null?"":getUser().getAvatar();
    }

    public static void setAvatar(String avatar) {


    }



}
