package com.example.douban.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.douban.di.module.ComingModule;
import com.example.douban.mvp.contract.ComingContract;

import com.jess.arms.di.scope.FragmentScope;
import com.example.douban.mvp.ui.fragment.ComingFragment;


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
@Component(modules = ComingModule.class, dependencies = AppComponent.class)
public interface ComingComponent {
    void inject(ComingFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        ComingComponent.Builder view(ComingContract.View view);

        ComingComponent.Builder appComponent(AppComponent appComponent);

        ComingComponent build();
    }
}