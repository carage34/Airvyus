package com.example.airvyus.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.airvyus.R;
import com.example.airvyus.controller.AccountController;
import com.example.airvyus.controller.MyAdapter;
import com.example.airvyus.controller.PageAdapter;
import com.example.airvyus.model.api.Account;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class AccountsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private AccountController ac;
    private List<Account> accountList = new ArrayList<>();
    private MenuItem connecter;
    private MenuItem modifier;
    private MenuItem supprimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_accounts);
        ac = new AccountController();
        accountList = ac.getAccounts();
        configureViewPagerAndTabs(accountList);
    }

    public void configureViewPagerAndTabs(List<Account> accountList){
        //Get ViewPager from layout
        ViewPager pager = (ViewPager)findViewById(R.id.viewPager);
        //Set Adapter PageAdapter and glue it together
        PageAdapter pa = new PageAdapter(getSupportFragmentManager());
        pa.setList(accountList, this);
        pager.setAdapter(pa);

        //Get TabLayout from layout
        TabLayout tabs= (TabLayout)findViewById(R.id.tablayout);
        //Glue TabLayout and ViewPager together
        tabs.setupWithViewPager(pager);
        //Design purpose. Tabs have the same width
        tabs.setTabMode(TabLayout.MODE_FIXED);
    }

    public void startForResult(Intent intent) {
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ac = new AccountController();
        accountList = ac.getAccounts();
        mAdapter = new MyAdapter(accountList, this, recyclerView);
        recyclerView.setAdapter(mAdapter);
    }
}
