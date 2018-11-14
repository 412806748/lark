package com.lark.xw.business.main.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jess.arms.di.component.AppComponent;
import com.lark.xw.business.R;
import com.lark.xw.business.main.di.component.DaggerContactsComponent;
import com.lark.xw.business.main.di.module.ContactsModule;
import com.lark.xw.business.main.mvp.contract.ContactsContract;
import com.lark.xw.business.main.mvp.presenter.ContactsPresenter;
import com.lark.xw.core.fragments.MvpBaseFragment;

public class ContactsFragment extends MvpBaseFragment<ContactsPresenter> implements ContactsContract.View {
    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerContactsComponent.builder()
                .appComponent(appComponent)
                .contactsModule(new ContactsModule(this))
                .build()
                .inject(this);


    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return null;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void setData(@Nullable Object data) {

    }

    @Override
    public void showMessage(@NonNull String message) {

    }

    @Override
    public Object setLayout() {
        return R.layout.fragment_contacts;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }

    @Override
    public int setTitleBar() {
        return R.id.id_toolbar;
    }

    @Override
    public int setStatusBarView() {
        return 0;
    }

    @Override
    public void post(Runnable runnable) {

    }
}
