package com.lark.xw.business.main.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;
import com.lark.xw.business.main.di.module.UserModule;
import com.lark.xw.business.main.mvp.ui.fragment.user.UserFragment;

import dagger.Component;

@FragmentScope
@Component(modules = UserModule.class, dependencies = AppComponent.class)
public interface UserComponent {
    void inject(UserFragment userFragment);
}