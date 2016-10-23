package io.github.gallyamow.android_boilerplate.utils;

import android.support.annotation.NonNull;
import com.orhanobut.hawk.Hawk;

public final class Preferences {
    private static final String YOUR_SAVED_DATA_KEY = "your_saved_data_key";

    public void saveCurrentUserId(@NonNull String value) {
        Hawk.put(YOUR_SAVED_DATA_KEY, value);
    }

    @NonNull
    public String getCurrentUserId() {
        return Hawk.get(YOUR_SAVED_DATA_KEY, "");
    }
}
