package com.pet.travel.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.pet.travel.R;

/**
 * Created by caojian on 16/10/24.
 */
public class MyProgressDialog extends Dialog {
    public MyProgressDialog(Context context) {
        super(context, R.style.Dialog_loading_noDim);
        init();
    }

    private void init() {
        View view= LayoutInflater.from(getContext()).inflate(R.layout.layout_network_loading,null);
        view.setBackgroundResource(android.R.color.transparent);
        setContentView(view);
    }
}
