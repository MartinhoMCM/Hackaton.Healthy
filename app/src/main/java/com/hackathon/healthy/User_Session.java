package com.hackathon.healthy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by martinhocorreiamussamba on 24/11/18.
 */

public class User_Session {

    private SharedPreferences pref;
    SharedPreferences.Editor editor;

    private Context context;

    private  int private_mode=0;

    private static final String PREFER_NAME="Registration";

    private static final String IS_USER_LOGIN="IsUserLoggedIn";

    public static final String KEY_USER_EMAIL="user_email";
    public static final String KEY_USER_PASS="user_password";

    public User_Session(Context context)
    {
        this.context =context;
        pref =context.getSharedPreferences(PREFER_NAME,private_mode);
        editor =pref.edit();

    }

    public void createUserLoginSession(String email, String pass)
    {
        editor.putBoolean(IS_USER_LOGIN, true);
        editor.putString(KEY_USER_EMAIL,email );
        editor.putString(KEY_USER_PASS, pass);
        editor.commit();
        }

        public  boolean CheckLogin()
        {
            if(!this.isUserLoggedIn())
            {
                Intent intent = new Intent(context, SonFragment.class);
             //   ((MainActivity) getActivity()).startActivity(intent);
              intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
              intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);

              context.startActivity(intent);
                return true;
            }
           return false;
        }

        public HashMap<String, String> getUserDetails()
        {
            HashMap<String, String> user=new HashMap<>();

            user.put(KEY_USER_EMAIL, pref.getString(KEY_USER_EMAIL, null));
            user.put(KEY_USER_PASS, pref.getString(KEY_USER_PASS, null));

            return user;
        }

        public void LogoutUser()
        {
            editor.clear();
            editor.commit();

            Intent intent = new Intent(context,SonFragment.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(intent);

        }

        public boolean isUserLoggedIn()
        {
            return  pref.getBoolean(IS_USER_LOGIN, false);
        }
}
