package com.example.douban.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.douban.di.module.DetailModule;
import com.example.douban.mvp.contract.DetailContract;

import com.jess.arms.di.scope.ActivityScope;
import com.example.douban.mvp.ui.activity.DetailActivity;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 12/03/2019 11:26
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = DetailModule.class, dependencies = AppComponent.class)
public interface DetailComponent {
    void inject(DetailActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        DetailComponent.Builder view(DetailContract.View view);

        DetailComponent.Builder appComponent(AppComponent appComponent);

        DetailComponent build();
    }
}