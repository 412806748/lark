package com.lark.xw.business.main.di.module;

import com.jess.arms.di.scope.FragmentScope;
import com.lark.xw.business.main.mvp.contract.MessageContract;
import com.lark.xw.business.main.mvp.model.MessageModel;

import dagger.Module;
import dagger.Provides;


@Module
public class MessageModule {
    private MessageContract.View view;

    /**
     * 构建MainModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MessageModule(MessageContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    MessageContract.View provideMainView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    MessageContract.Model provideMainModel(MessageModel model) {
        return model;
    }
}