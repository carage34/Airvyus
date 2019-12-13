package com.example.airvyus.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.airvyus.R;
import com.example.airvyus.controller.AccountController;
import com.example.airvyus.controller.MyAdapter;
import com.example.airvyus.model.api.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private AccountController ac;
    private List<Account> accountList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);

        ac = new AccountController();
        accountList = ac.getAccounts();

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        List<String> input = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            input.add("Test" + i);
        }// define an adapter
        mAdapter = new MyAdapter(accountList, this);
        recyclerView.setAdapter(mAdapter);
    }
}
