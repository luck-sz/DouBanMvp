package com.example.douban.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.douban.di.module.HotListModule;
import com.example.douban.mvp.contract.HotListContract;

import com.jess.arms.di.scope.FragmentScope;
import com.example.douban.mvp.ui.fragment.HotListFragment;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 11/18/2019 15:34
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
@Component(modules = HotListModule.class, dependencies = AppComponent.class)
public interface HotListComponent {
    void inject(HotListFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        HotListComponent.Builder view(HotListContract.View view);

        HotListComponent.Builder appComponent(AppComponent appComponent);

        HotListComponent build();
    }
}