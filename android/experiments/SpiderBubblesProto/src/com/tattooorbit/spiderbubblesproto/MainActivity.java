package com.tattooorbit.spiderbubblesproto;

import com.tattooorbit.spiderbubblesproto.chase.ChaseGame;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.ListActivity;
import android.content.Intent;

public class MainActivity extends ListActivity {

    String games[] = { "chase.ChaseGame", "Bounce" };
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, games));
    }

    @Override
    protected void onListItemClick(ListView list, View view, int position,
            long id) {
        super.onListItemClick(list, view, position, id);
        String gameName = games[position];
        try {
            Class clazz = Class
                    .forName("com.tattooorbit.spiderbubbles." + gameName);
            Intent intent = new Intent(this, clazz);
            startActivity(intent);
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
