package com.example.douban.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.example.douban.mvp.contract.TvContract;
import com.jess.arms.di.component.AppComponent;

import com.example.douban.di.module.TvModule;

import com.jess.arms.di.scope.FragmentScope;
import com.example.douban.mvp.ui.fragment.TvFragment;


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
@Component(modules = TvModule.class, dependencies = AppComponent.class)
public interface TvComponent {
    void inject(TvFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        TvComponent.Builder view(TvContract.View view);

        TvComponent.Builder appComponent(AppComponent appComponent);

        TvComponent build();
    }
}