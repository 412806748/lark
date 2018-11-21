package com.lark.xw.core.fragments.bottom;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.joanzapata.iconify.widget.IconTextView;
import com.lark.xw.core.R;
import com.lark.xw.core.fragments.LarkFragment;
import com.lark.xw.core.fragments.WaitExitFragment;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import me.yokeyword.fragmentation.ISupportFragment;

/**
 * 底部fragment基础类
 */

public abstract class BaseBottomDelegate extends WaitExitFragment implements View.OnClickListener {
    private final ArrayList<LarkFragment> ITEM_DELEGATES = new ArrayList<>();
    private final ArrayList<BottomTabBean> TAB_BEANS = new ArrayList<>();
    private final LinkedHashMap<BottomTabBean, LarkFragment> ITEMS = new LinkedHashMap<>();
    private int mCurrentDelegate = 0;
    private int mIndexDelegate = 0;
    private int mClickedCole = Color.parseColor("#09C7F7");
    private AppCompatTextView itemMessage = null;

    public abstract LinkedHashMap<BottomTabBean, LarkFragment> setItems(ItemBuilder itemBuilder);

    LinearLayoutCompat mBottomBar = null;

    @Override
    public Object setLayout() {
        return R.layout.delegate_bottom;
    }


    public abstract int setIndexDelegate();

    public abstract int setClickedColor();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIndexDelegate = setIndexDelegate();
        if (setClickedColor() != 0) {
            mClickedCole = setClickedColor();
        }

        //初始化获取到的Items数据
        final ItemBuilder builder = new ItemBuilder();
        final LinkedHashMap<BottomTabBean, LarkFragment> items = setItems(builder);
        ITEMS.putAll(items);

        for (Map.Entry<BottomTabBean, LarkFragment> item : ITEMS.entrySet()) {
            final BottomTabBean tabBean = item.getKey();
            final LarkFragment itemDelegate = item.getValue();
            TAB_BEANS.add(tabBean);
            ITEM_DELEGATES.add(itemDelegate);
        }
    }


    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mBottomBar = rootView.findViewById(R.id.bottom_bar);
        //加载每个Ittem视图
        final int size = ITEMS.size();
        for (int i = 0; i < size; i++) {
            LayoutInflater.from(getContext()).inflate(R.layout.bottom_item_icon_text_layout, mBottomBar);
            final RelativeLayout item = (RelativeLayout) mBottomBar.getChildAt(i);
            //设置每个item的点击事件
            item.setTag(i);
            item.setOnClickListener(this);
            final IconTextView itemIcon = (IconTextView) item.getChildAt(0);
            final AppCompatTextView itemTitle = (AppCompatTextView) item.getChildAt(1);
            //获取第一个item的消息泡泡
            if (i == 0) {
                itemMessage = (AppCompatTextView) item.getChildAt(2);
                itemMessage.setVisibility(View.VISIBLE);
            }
            final BottomTabBean bean = TAB_BEANS.get(i);
            //初始化数据
            itemIcon.setText(bean.getICON());
            itemTitle.setText(bean.getTITLE());
            if (i == mIndexDelegate) {
                itemIcon.setTextColor(mClickedCole);
                itemTitle.setTextColor(mClickedCole);
            }


        }
        //加载所有fragment视图
        final ISupportFragment[] delegateArray = ITEM_DELEGATES.toArray(new ISupportFragment[size]);
        getSupportDelegate().loadMultipleRootFragment(R.id.bottom_bar_delegate_container, mIndexDelegate, delegateArray);

    }


    private void resetColor() {
        final int count = mBottomBar.getChildCount();
        for (int i = 0; i < count; i++) {
            final RelativeLayout item = (RelativeLayout) mBottomBar.getChildAt(i);
            //  item.setGravity(RelativeLayout.CENTER_IN_PARENT);
            final IconTextView itemIcon = (IconTextView) item.getChildAt(0);
            itemIcon.setTextColor(Color.parseColor("#666666"));
            final AppCompatTextView itemTitle = (AppCompatTextView) item.getChildAt(1);
            itemTitle.setTextColor(Color.parseColor("#666666"));
        }
    }

    @Override
    public void onClick(View view) {
        final int tag = (int) view.getTag();
        resetColor();
        final RelativeLayout item = (RelativeLayout) view;
        final IconTextView itemIcon = (IconTextView) item.getChildAt(0);
        itemIcon.setTextColor(mClickedCole);
        final AppCompatTextView itemTitle = (AppCompatTextView) item.getChildAt(1);
        itemTitle.setTextColor(mClickedCole);

        //
        getSupportDelegate().showHideFragment(ITEM_DELEGATES.get(tag), ITEM_DELEGATES.get(mCurrentDelegate));
        mCurrentDelegate = tag;

    }


    @SuppressLint("SetTextI18n")
    public void setMessageCount(int count) {
        if (itemMessage != null) {
            itemMessage.setText(count + "");
        }

    }


}
