package com.lark.xw.core.app.utils.dimen;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.lark.xw.core.app.LarkConfig;

/**
 * Created by xdj on 2018/1/30.
 */

public class DimenUtil {
    public static int getScreenWidth() {
        final Resources resources = LarkConfig.getApplicationContext().getResources();
        final DisplayMetrics metrics = resources.getDisplayMetrics();
        return metrics.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = LarkConfig.getApplicationContext().getResources();
        final DisplayMetrics metrics = resources.getDisplayMetrics();
        return metrics.heightPixels;
    }
}
