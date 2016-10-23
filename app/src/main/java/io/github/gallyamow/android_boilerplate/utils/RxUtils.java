package io.github.gallyamow.android_boilerplate.utils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public final class RxUtils {
    /**
     * Трансформер observable для выполнения асинхронных действий с получением результата в main thread.
     */
    public static <T> Observable.Transformer<T, T> async() {
        return observable -> observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
