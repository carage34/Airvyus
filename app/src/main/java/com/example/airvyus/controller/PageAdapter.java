package com.example.airvyus.controller;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.airvyus.model.api.Account;
import com.example.airvyus.view.AccountsActivity;
import com.example.airvyus.view.MainActivity;
import com.example.airvyus.view.PageFragment;
import com.example.airvyus.view.SampleTwo;

import java.util.List;

public class PageAdapter extends FragmentPagerAdapter {
    private int nbTab;
    private List<Account> list;
    private AccountsActivity actt;
    public PageAdapter(FragmentManager fm) {
        super(fm);
        nbTab = 2;
        //this.list = streamerList;
    }

    public void setList(List<Account> listt, AccountsActivity act) {
        this.list = listt;
        this.actt = act;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch(position) {
            case 0:
                return PageFragment.newInstance(list, actt);
            case 1:
                return SampleTwo.newInstance();
        }
        return fragment;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Comptes";
            case 1:
                return "Utilisateurs";
            default:
                return null;
        }
    }
    public int getCount() {
        return nbTab;
    }
}
