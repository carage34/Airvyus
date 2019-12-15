package com.example.airvyus.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.airvyus.R;
import com.example.airvyus.controller.AccountController;
import com.example.airvyus.controller.MyAdapter;
import com.example.airvyus.model.api.Account;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

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
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        connecter = findViewById(R.id.connecter);
        modifier = findViewById(R.id.modifier);
        supprimer = findViewById(R.id.supprimer);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapter(accountList, this, connecter, modifier, supprimer, recyclerView);
        recyclerView.setAdapter(mAdapter);
    }
}
