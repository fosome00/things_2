package com.tthings.things_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.tthings.things_2.Adapter.BtnAdapter;
import com.tthings.things_2.AlertDialog.RemoteNameDialog;
import com.tthings.things_2.Common.Remote1;
import com.tthings.things_2.data.IRRemoteBtnCustom;

import java.util.ArrayList;

public class add_remote_custom extends AppCompatActivity implements RemoteNameDialog.Reply{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_remote_custom);

        final int rows = 4;
        final int column = 10;



        ArrayList<IRRemoteBtnCustom> data = new ArrayList<>();

        if (Remote1.data.size() == 0)
        {
            for (int i = 0; i < 3*10; i++ ){

                Remote1.data.add(new IRRemoteBtnCustom(R.drawable.ic_add_black_24dp));

            }
        }

        final AppCompatActivity context = this;

        RecyclerView recyclerView = findViewById(R.id.rvBtnList);
        recyclerView.setLayoutManager(new GridLayoutManager(this,rows-1));
        RecyclerView.Adapter adapter = new BtnAdapter(this,data);
        Remote1.adapter = adapter;
       // recyclerView.setMotionEventSplittingEnabled(false);
        recyclerView.setAdapter(adapter);

        Button add = findViewById(R.id.AddRemoteToRemoteList);
        Button cancel = findViewById(R.id.cancelAddingToRemote);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),Remote.class);
                intent.putExtra("position",-1);
                Remote1.activity = context;
                startActivity(intent);



            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Remote1.data.clear();
                finish();
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Remote1.click = true;
        Remote1.data.clear();
    }

    @Override
    public void reply_wait(String text) {
       /* finish();


        RemoteList.addRemote(Remote1.data,text, Remote1.last_position);
        Remote1.data.clear();
        Remote1.name = null;
        Remote1.last_position = -1;
*/
    }

    @Override
    public void save() {

        finish();
    }
}
