package com.tthings.things_2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tthings.things_2.Adapter.SingleRemoteDisplayAdapter;
import com.tthings.things_2.AlertDialog.RemoteNameDialog;
import com.tthings.things_2.Common.Remote1;
import com.tthings.things_2.Common.RemoteList;

public class Remote extends AppCompatActivity implements RemoteNameDialog.Reply{

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Button backBtn;
    Button readBtn;
    Button saveBtn;
    LinearLayout layoutBtn;
    private Context context = this;

    private int position;
    private int default_icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote);
       default_icon = R.drawable.ic_add_white_24dp;

        Bundle bundle = getIntent().getExtras();
    if(bundle == null)
    {

    }
    else{
        position = Integer.parseInt(bundle.get("position").toString());

        if (position == -1)
        {

            layoutBtn = findViewById(R.id.btnSingleDisplayRemote);
            layoutBtn.setVisibility(View.VISIBLE);
            backBtn = findViewById(R.id.backBtnSingleDisplayRemote);

            backBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            readBtn = findViewById(R.id.readBtnSingleDisplayRemote);
            readBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(getBaseContext(), "write code to read",Toast.LENGTH_LONG).show();
                }
            });
            saveBtn = findViewById(R.id.saveBtnSingleDisplayRemote);
            saveBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RemoteNameDialog remoteNameDialog = new RemoteNameDialog();
                    remoteNameDialog.show(((AppCompatActivity)context).getSupportFragmentManager(), "Remote Name");

                }
            });

        }

        recyclerView = findViewById(R.id.rvSingleRemote);
        adapter = new SingleRemoteDisplayAdapter(this, position,default_icon,(ImageView) findViewById(R.id.ledOnClick));
        layoutManager = new GridLayoutManager(this, 3);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }

    }

    @Override
    public void reply_wait(String text) {
        finish();


        RemoteList.addRemote(Remote1.data,text, Remote1.last_position);
        Remote1.data.clear();
        Remote1.name = null;
        Remote1.last_position = -1;
    }

    @Override
    public void save() {
        Remote1.activity.finish();
        Remote1.activity = null;
    }


}
