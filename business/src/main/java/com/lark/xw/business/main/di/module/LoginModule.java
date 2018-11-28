package com.lark.xw.business.main.di.module;

import com.jess.arms.di.scope.FragmentScope;
import com.lark.xw.business.main.mvp.contract.ContactsContract;
import com.lark.xw.business.main.mvp.model.LoginModel;

import dagger.Module;
import dagger.Provides;


@Module
public class LoginModule {
    private ContactsContract.View view;

    /**
     * 构建MainModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public LoginModule(ContactsContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    ContactsContract.View provideMainView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    ContactsContract.Model provideMainModel(LoginModel model) {
        return model;
    }
}