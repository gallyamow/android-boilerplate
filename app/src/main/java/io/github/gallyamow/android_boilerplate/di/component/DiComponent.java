package io.github.gallyamow.android_boilerplate.di.component;

import io.github.gallyamow.android_boilerplate.App;
import io.github.gallyamow.android_boilerplate.di.module.AppModule;
import io.github.gallyamow.android_boilerplate.di.module.NetworkModule;

import javax.inject.Singleton;

/**
 * Dagger-компонент
 */
@dagger.Component(modules = {AppModule.class, NetworkModule.class})
@Singleton
public interface DiComponent {
    void inject(App app);
}
