package com.example.douban.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.douban.di.module.MoreModule;
import com.example.douban.mvp.contract.MoreContract;

import com.jess.arms.di.scope.ActivityScope;
import com.example.douban.mvp.ui.activity.MoreActivity;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 11/18/2019 15:14
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = MoreModule.class, dependencies = AppComponent.class)
public interface MoreComponent {
    void inject(MoreActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        MoreComponent.Builder view(MoreContract.View view);

        MoreComponent.Builder appComponent(AppComponent appComponent);

        MoreComponent build();
    }
}