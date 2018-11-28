package com.lark.xw.business.main.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;
import com.lark.xw.business.main.di.module.LoginModule;
import com.lark.xw.business.main.mvp.ui.fragment.login.LoginFragment;

import dagger.Component;

@FragmentScope
@Component(modules = LoginModule.class, dependencies = AppComponent.class)
public interface LoginComponent {
    void inject(LoginFragment fragment);
}