package com.example.airvyus.controller;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import com.example.airvyus.model.api.Account;
import com.example.airvyus.view.AccountsActivity;
import com.example.airvyus.view.EditActivity;

import java.util.List;

public class MenuItemController implements MenuItem.OnMenuItemClickListener {
    private List<Account> accounts;
    private MyAdapter myAdapter;
    private AccountsActivity context;

    public MenuItemController(List<Account> accountList, AccountsActivity context, MyAdapter myAdapter) {
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
            Intent intent = new Intent(context, EditActivity.class);
            intent.putExtra("id", position);
            intent.putExtra("email", myAdapter.getEmail(position));
            intent.putExtra("position", myAdapter.getPosition(position));
            intent.putExtra("pseudo", myAdapter.getPseudo(position));
            System.out.println("BLA88 " + myAdapter.getEmail(position));
            context.startForResult(intent);
        }
        return true;
    }
}
