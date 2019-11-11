package com.example.douban.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.douban.di.module.BookModule;
import com.example.douban.mvp.contract.BookContract;

import com.jess.arms.di.scope.FragmentScope;
import com.example.douban.mvp.ui.fragment.BookFragment;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 11/11/2019 10:29
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
@Component(modules = BookModule.class, dependencies = AppComponent.class)
public interface BookComponent {
    void inject(BookFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        BookComponent.Builder view(BookContract.View view);

        BookComponent.Builder appComponent(AppComponent appComponent);

        BookComponent build();
    }
}