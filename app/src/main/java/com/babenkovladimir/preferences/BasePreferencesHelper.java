package com.babenkovladimir.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public abstract class BasePreferencesHelper {

  private SharedPreferences mPreferences;

  public BasePreferencesHelper(Context context) {
    mPreferences = context.getSharedPreferences("APP_SHARED_PREFERENCES", Context.MODE_PRIVATE);
  }

  protected void setString(String key, String string) {
    mPreferences.edit().putString(key, string).apply();
  }

  protected String getString(String key) {
    return mPreferences.getString(key, "");
  }

  protected void setBoolean(String key, Boolean value) {
    mPreferences.edit().putBoolean(key, value).apply();
  }

  protected boolean getBoolean(String key) {
    return mPreferences.getBoolean(key, false);
  }
}
