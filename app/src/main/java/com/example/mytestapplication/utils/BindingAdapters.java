package com.example.mytestapplication.utils;

import android.databinding.BindingAdapter;
import android.text.TextWatcher;
import android.widget.EditText;

public class BindingAdapters {
    @BindingAdapter("textChangedListener")
    public static void setMovementMethod(EditText editText, TextWatcher textWatcher) {
        editText.addTextChangedListener(textWatcher);
    }
}
