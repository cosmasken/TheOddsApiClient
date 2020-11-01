package com.harambeeapps.theoddsapiclient.utility;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;


import com.harambeeapps.theoddsapiclient.constants.AppConstant;

import java.util.ArrayList;

public class ActivityUtilities {

    private static ActivityUtilities sActivityUtilities = null;

    public static ActivityUtilities getInstance() {
        if (sActivityUtilities == null) {
            sActivityUtilities = new ActivityUtilities();
        }
        return sActivityUtilities;
    }

    public void invokeNewActivity(Activity activity, Class<?> tClass, boolean shouldFinish) {
        Intent intent = new Intent(activity, tClass);
        activity.startActivity(intent);
        if (shouldFinish) {
            activity.finish();
        }
    }

    public void subCategoryListActivity(Activity activity, Class<?> tClass, String key, String group,String details,String title, boolean shouldFinish) {
        Intent intent = new Intent(activity, tClass);
        intent.putExtra(AppConstant.BUNDLE_KEY_SPORT_KEY, key);
        intent.putExtra(AppConstant.BUNDLE_KEY_SPORT_GROUP, group);
        intent.putExtra(AppConstant.BUNDLE_KEY_SPORT_DETAILS, details);
        intent.putExtra(AppConstant.BUNDLE_KEY_SPORT_TITLE, title);
        activity.startActivity(intent);
        if (shouldFinish) {
            activity.finish();
        }
    }


}
