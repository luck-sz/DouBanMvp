package com.example.douban.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.douban.di.module.PlayerModule;
import com.example.douban.mvp.contract.PlayerContract;

import com.jess.arms.di.scope.ActivityScope;
import com.example.douban.mvp.ui.activity.PlayerActivity;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 12/10/2019 16:54
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = PlayerModule.class, dependencies = AppComponent.class)
public interface PlayerComponent {
    void inject(PlayerActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        PlayerComponent.Builder view(PlayerContract.View view);

        PlayerComponent.Builder appComponent(AppComponent appComponent);

        PlayerComponent build();
    }
}