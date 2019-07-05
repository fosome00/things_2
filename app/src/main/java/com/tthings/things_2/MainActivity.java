package com.tthings.things_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.tthings.things_2.Adapter.frontDisplayAdapter;
import com.tthings.things_2.Common.Remote1;
import com.tthings.things_2.Common.RemoteList;

public class MainActivity extends AppCompatActivity {


    /**
     * The {@link ViewPager} that will host the section contents.
     */
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    TextView emptyNotification;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getApplicationContext(), add_remote_custom.class);
                startActivity(intent);
                if (Remote1.data.size() > 0) {
                    Remote1.data.clear();
                }

            }
        });

        recyclerView = findViewById(R.id.rvMainRemoteOnDisplay);
        emptyNotification = findViewById(R.id.mainDisplayEmptyNotification);

        if (RemoteList.remotes.size() == 0)
        {
            emptyNotification.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }

        if (RemoteList.remotes.size() != 0)
        {
            emptyNotification.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }

        adapter = new frontDisplayAdapter(this);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (RemoteList.remotes.size() == 0) {
            emptyNotification.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }

        if (RemoteList.remotes.size() != 0) {
            emptyNotification.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            adapter.notifyDataSetChanged();
        }
    }
}


