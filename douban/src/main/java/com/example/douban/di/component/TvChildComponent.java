package com.example.douban.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.douban.di.module.TvChildModule;
import com.example.douban.mvp.contract.TvChildContract;

import com.jess.arms.di.scope.FragmentScope;
import com.example.douban.mvp.ui.fragment.tv.TvChildFragment;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 11/14/2019 11:25
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
@Component(modules = TvChildModule.class, dependencies = AppComponent.class)
public interface TvChildComponent {
    void inject(TvChildFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        TvChildComponent.Builder view(TvChildContract.View view);

        TvChildComponent.Builder appComponent(AppComponent appComponent);

        TvChildComponent build();
    }
}