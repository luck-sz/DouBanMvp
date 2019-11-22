package com.example.douban.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.douban.di.module.MoreListModule;
import com.example.douban.mvp.contract.MoreListContract;

import com.jess.arms.di.scope.FragmentScope;
import com.example.douban.mvp.ui.fragment.more.MoreListFragment;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 11/22/2019 14:19
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
@Component(modules = MoreListModule.class, dependencies = AppComponent.class)
public interface MoreListComponent {
    void inject(MoreListFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        MoreListComponent.Builder view(MoreListContract.View view);

        MoreListComponent.Builder appComponent(AppComponent appComponent);

        MoreListComponent build();
    }
}