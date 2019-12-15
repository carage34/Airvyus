package com.example.airvyus.view;

import android.app.Activity;
import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

public class MyPopupMenu extends PopupMenu {
    private Context act;
    private View v;
    private int position;

    public MyPopupMenu(Context cxt, View v, int position) {
        super(cxt, v);
        this.act = cxt;
        this.v = v;
        this.position = position;
    }

    interface OnMenuItemClickListener {
        boolean onItemClick(MenuItem item, int position);
    }
}
