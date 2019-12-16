package com.example.airvyus.controller;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.airvyus.R;
import com.example.airvyus.model.api.Account;
import com.example.airvyus.view.AccountsActivity;
import com.example.airvyus.view.MyPopupMenu;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    public static List<Account> values;
    private AccountsActivity context;
    private MenuItemController mic;
    private RecyclerView recyclerView;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{
        // each data item is just a string in this case
        private TextView txtHeader;
        private TextView txtFooter;
        private View layout;
        private ImageView img;


        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            img = (ImageView)v.findViewById(R.id.icon);

            v.setOnCreateContextMenuListener(this);

        }
        public ImageView getImage() {
            return this.img;
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            contextMenu.setHeaderTitle("Action");
            MenuItem connecter = contextMenu.add(Menu.NONE, view.getId(), 1, "Connecter");
            MenuItem modifier = contextMenu.add(Menu.NONE, view.getId(), 2, "Modifier");
            MenuItem supprimer = contextMenu.add(Menu.NONE, view.getId(), 3, "Supprimer");
            ViewHolder holder = (ViewHolder) recyclerView.getChildViewHolder(view);
            Intent data = new Intent();
            data.putExtra("position", values.get(holder.getAdapterPosition()).getId());
            connecter.setIntent(data);
            modifier.setIntent(data);
            supprimer.setIntent(data);
            connecter.setOnMenuItemClickListener(mic);
            modifier.setOnMenuItemClickListener(mic);
            supprimer.setOnMenuItemClickListener(mic);

        }


    }



    public void add(int position, Account item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Account> myDataset, AccountsActivity act, RecyclerView recyclerView) {
        values = myDataset;
        this.context = act;
        this.recyclerView = recyclerView;
        mic = new MenuItemController(values, context, this);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    interface OnItemEventListener {
        void onMoreClicked(View v, int position);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Account name = values.get(position);
        holder.txtHeader.setText(name.getNom());


        holder.txtFooter.setText("Position: " + name.getPosition());
        Glide.with(this.context.getBaseContext())
                .load(name.getUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.getImage());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

    public void removeAt(int position) {
        for(int i=0; i<values.size(); i++) {
            if(values.get(i).getId() == position) {
                remove(i);
                return;
            }
        }
        values.remove(position);
    }

    public void updateList(List<Account> list) {

    }

    public String getEmail(int id) {
        for(int i=0;i<values.size(); i++) {
            if(values.get(i).getId() == id) {
                return values.get(i).getEmail();
            }
        }
        return null;
    }

    public String getPseudo(int id) {
        for(int i=0;i<values.size(); i++) {
            if(values.get(i).getId() == id) {
                return values.get(i).getNom();
            }
        }
        return null;
    }

    public String getPosition(int id) {
        for(int i=0;i<values.size(); i++) {
            if(values.get(i).getId() == id) {
                return values.get(i).getPosition();
            }
        }
        return null;
    }
}
