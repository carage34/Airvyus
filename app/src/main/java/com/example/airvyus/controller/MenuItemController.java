package com.example.airvyus.controller;

import android.content.Context;
import android.view.MenuItem;

import com.example.airvyus.model.api.Account;

import java.util.List;

public class MenuItemController implements MenuItem.OnMenuItemClickListener {
    private List<Account> accounts;
    private MyAdapter myAdapter;
    private Context context;

    public MenuItemController(List<Account> accountList, Context context, MyAdapter myAdapter) {
        this.accounts = accountList;
        this.context = context;
        this.myAdapter = myAdapter;
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int position = item.getIntent().getIntExtra("position", -1);
        System.out.println("BLA44 " + position);
        if(item.getTitle()=="Connecter") {
             item.setTitle("Deconnecter");
        }
        if(item.getTitle()=="Deconnecter") {
            item.setTitle(("Connecter"));
        }
        if(item.getTitle()=="Supprimer") {
            AccountController ac = new AccountController();
            ac.deleteAccount(position+"", context);
            myAdapter.removeAt(position);
        }

        if(item.getTitle()=="Modifier") {

        }
        return true;
    }
}
