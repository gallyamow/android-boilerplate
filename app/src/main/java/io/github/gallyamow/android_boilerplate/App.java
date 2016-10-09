package io.github.gallyamow.android_boilerplate;

import android.app.Application;
import com.orhanobut.hawk.Hawk;
import timber.log.Timber;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Hawk.init(this.getApplicationContext()).build();
        initTimber();
    }

    public void initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            // todo: CrashReportingTree
        }
    }
}
