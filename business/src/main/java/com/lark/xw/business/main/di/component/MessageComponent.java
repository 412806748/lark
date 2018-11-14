package com.lark.xw.business.main.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.di.scope.FragmentScope;
import com.lark.xw.business.main.di.module.MainModule;
import com.lark.xw.business.main.di.module.MessageModule;
import com.lark.xw.business.main.mvp.ui.activity.MainActivity;
import com.lark.xw.business.main.mvp.ui.fragment.MessageFragment;

import dagger.Component;

@FragmentScope
@Component(modules = MessageModule.class, dependencies = AppComponent.class)
public interface MessageComponent {
    void inject(MessageFragment fragment);
}