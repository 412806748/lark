package com.lark.xw.business.main.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;
import com.lark.xw.business.main.di.module.ContactsModule;
import com.lark.xw.business.main.mvp.ui.fragment.ContactsFragment;

import dagger.Component;

@FragmentScope
@Component(modules = ContactsModule.class, dependencies = AppComponent.class)
public interface ContactsComponent {
    void inject(ContactsFragment fragment);
}