package com.al.tobangla.utils;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by sayemkcn on 3/30/17.
 */

public class TypeFace {
    protected TypeFace() {
    }

    public enum Name {
        SIYAM_RUPALI("fonts/Siyamrupali.ttf"),
        SOLAIMANLIPI("fonts/Solaimanlipi.ttf");

        private String value;

        Name(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static Typeface getTypeface(Context context, TypeFace.Name typeface) {
        return Typeface.createFromAsset(context.getAssets(), typeface.getValue());
    }

    public static Typeface getDefault(Context context) {
        return Typeface.createFromAsset(context.getAssets(), Name.SIYAM_RUPALI.getValue());
    }

}
