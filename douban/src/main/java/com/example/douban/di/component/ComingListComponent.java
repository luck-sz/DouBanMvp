package com.example.douban.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.example.douban.mvp.contract.ComingListContract;
import com.example.douban.mvp.ui.fragment.more.ComingListFragment;
import com.jess.arms.di.component.AppComponent;

import com.example.douban.di.module.ComingListModule;

import com.jess.arms.di.scope.FragmentScope;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 11/18/2019 16:38
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
@Component(modules = ComingListModule.class, dependencies = AppComponent.class)
public interface ComingListComponent {
    void inject(ComingListFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        ComingListComponent.Builder view(ComingListContract.View view);

        ComingListComponent.Builder appComponent(AppComponent appComponent);

        ComingListComponent build();
    }
}