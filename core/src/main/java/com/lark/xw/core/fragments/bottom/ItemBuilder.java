package com.lark.xw.core.fragments.bottom;


import com.lark.xw.core.fragments.LarkFragment;

import java.util.LinkedHashMap;

/**
 * Created by jx on 2018/5/3.
 */

public final class ItemBuilder {
    private final LinkedHashMap<BottomTabBean, LarkFragment> ITEMS = new LinkedHashMap<>();


    static ItemBuilder builder() {
        return new ItemBuilder();
    }

    public final ItemBuilder addItem(BottomTabBean bean, LarkFragment delegate) {
        ITEMS.put(bean, delegate);
        return this;
    }

    public final ItemBuilder addItems(LinkedHashMap<BottomTabBean, LarkFragment> items) {
        ITEMS.putAll(items);
        return this;
    }

    public final LinkedHashMap<BottomTabBean, LarkFragment> buid() {
        return ITEMS;
    }

}
