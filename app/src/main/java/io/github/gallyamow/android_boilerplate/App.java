package io.github.gallyamow.android_boilerplate;

import android.app.Application;
import com.orhanobut.hawk.Hawk;
import io.github.gallyamow.android_boilerplate.di.component.DaggerDiComponent;
import io.github.gallyamow.android_boilerplate.di.component.DiComponent;
import io.github.gallyamow.android_boilerplate.di.module.AppModule;
import timber.log.Timber;

public class App extends Application {
    private static DiComponent sDiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initDi();

        Hawk.init(this.getApplicationContext()).build();
        initTimber();
    }

    private void initDi() {
        sDiComponent = DaggerDiComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static DiComponent di() {
        return sDiComponent;
    }

    /**
     * Для тестов
     */
    public void setComponent(DiComponent diComponent) {
        sDiComponent = diComponent;
    }

    private void initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            // todo: CrashReportingTree
        }
    }
}
