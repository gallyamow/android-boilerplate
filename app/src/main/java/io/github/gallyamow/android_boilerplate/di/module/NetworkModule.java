package io.github.gallyamow.android_boilerplate.di.module;

import dagger.Module;
import dagger.Provides;
import io.github.gallyamow.android_boilerplate.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import javax.inject.Singleton;
import java.util.concurrent.TimeUnit;

/**
 * Dagger-модуль
 */
@Module
public class NetworkModule {
    /**
     * Возвращает OkHttpClient.Builder с заданными значениями таймаутов.
     *
     * @return OkHttpClient.Builder
     */
    @Provides
    @Singleton
    OkHttpClient.Builder provideOkHttpClientBuilder() {
        final int CONNECT_TIMEOUT = 15;
        final int WRITE_TIMEOUT = 60;
        final int TIMEOUT = 60;

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS);

        // логируем для отладочной версии
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(logging);
        }

        return builder;
    }
}
