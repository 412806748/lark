package com.lark.xw.core.ui.icon;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

/**
 * 自定义字体图标
 * Created by jx on 2018/5/3.
 */

public class FontLarkModule implements IconFontDescriptor {
    @Override
    public String ttfFileName() {
        return "iconfont.ttf";
    }

    @Override
    public Icon[] characters() {
        return LarkIcons.values();
    }
}
