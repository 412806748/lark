package com.lark.xw.business.main.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.lark.xw.business.main.di.module.MainModule;

import com.jess.arms.di.scope.ActivityScope;
import com.lark.xw.business.main.mvp.ui.activity.MainActivity;

@ActivityScope
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {
    void inject(MainActivity activity);
}