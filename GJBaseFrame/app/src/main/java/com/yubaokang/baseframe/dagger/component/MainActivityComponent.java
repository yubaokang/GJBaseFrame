package com.yubaokang.baseframe.dagger.component;

import com.yubaokang.baseframe.dagger.module.ActivityModule;
import com.yubaokang.baseframe.dagger.module.MainActivityModule;
import com.yubaokang.baseframe.dagger.scopes.ActivityScope;
import com.yubaokang.baseframe.views.activitys.MainActivity;

import dagger.Component;

/**
 * Created by ybk on 2016/3/1.
 */
@ActivityScope
//3 指明Component在哪些Module中查找依赖
@Component(dependencies = AppComponent.class, modules = {MainActivityModule.class, ActivityModule.class})
public interface MainActivityComponent extends ActivityComponent {
    void inject(MainActivity mainActivity);
}
