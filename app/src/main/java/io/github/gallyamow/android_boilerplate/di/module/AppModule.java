package io.github.gallyamow.android_boilerplate.di.module;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import io.github.gallyamow.android_boilerplate.App;

import javax.inject.Singleton;


/**
 * Dagger-модуль
 */
@Module
public class AppModule {
    private final App mApp;

    public AppModule(App app) {
        mApp = app;
    }

    @Provides
    @Singleton
    App provideApp() {
        return mApp;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mApp;
    }
}
