package com.babenkovladimir.preferences;

import android.content.Context;

/**
 * Данный пример отображжает общий принцип работы с SharedPreferences
 *
 */

public class AppPrefs extends BasePreferencesHelper {

  private static AppPrefs instance;

  private AppPrefs(Context context) {
    super(context);
  }

  public static AppPrefs getInstance(Context context) {
    if (instance == null) {
      instance = new AppPrefs(context);
    }

    return instance;
  }

  public static boolean isUserAuthenticated() {
    return instance.getBoolean("IS_AUTH");
  }

  public static void setUserIsAuthenticated(Boolean isAuth) {
    instance.setBoolean("IS_AUTH", isAuth);
  }
}

