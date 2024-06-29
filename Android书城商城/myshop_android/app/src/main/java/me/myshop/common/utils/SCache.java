package me.myshop.common.utils;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * SharedPreferences存储
 */
public class SCache {
    private SharedPreferences s;

    public SCache(Context c) {
        this(c, null);
    }

    public SCache(Context c, String name) {
        if (c != null)
            if (name!=null)
                name = "app_save_" + c.getPackageName();
        s = c.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    public void remove(String k) {
        if (s != null) {
            s.edit().remove(k).commit();
        }
    }

    public void putString(String k, String v) {
        if (s != null) {
            s.edit().putString(k, v).commit();
        }
    }

    public String getString(String k, String defV) {
        if (s != null && s.contains(k)) {
            return s.getString(k, defV);
        }
        return defV;
    }

    public void putInt(String k, int v) {
        if (s != null) {
            s.edit().putInt(k, v).commit();
        }
    }

    public int getInt(String k, int defV) {
        if (s != null && s.contains(k)) {
            return s.getInt(k, defV);
        }
        return defV;
    }

    public void putBoolean(String k, boolean v) {
        if (s != null) {
            s.edit().putBoolean(k, v).commit();
        }
    }

    public boolean getBoolean(String k, boolean defV) {
        if (s != null && s.contains(k)) {
            return s.getBoolean(k, defV);
        }
        return defV;
    }
}
