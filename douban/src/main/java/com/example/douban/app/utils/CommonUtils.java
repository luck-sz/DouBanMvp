package com.example.douban.app.utils;

import android.content.Context;
import android.content.res.Resources;


/**
 * Created by jingbin on 2016/11/22.
 * 获取原生资源
 */
public class CommonUtils {

    public static String getString(Context context, int resid) {
        return context.getResources().getString(resid);
    }

    public static float getDimens(Context context, int resId) {
        return context.getResources().getDimension(resId);
    }

}
