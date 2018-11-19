package com.lark.xw.core.ui.icon;

import com.joanzapata.iconify.Icon;

/**
 * 自定义字体图标
 * Created by jx on 2018/5/3.
 */

public enum LarkIcons implements Icon {
    icon_down('\ue619');
    private char character;


    LarkIcons(char c) {
        character = c;
    }


    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
