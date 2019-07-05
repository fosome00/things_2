package com.tthings.things_2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tthings.things_2.Common.RemoteList;
import com.tthings.things_2.R;
import com.tthings.things_2.Remote;
import com.tthings.things_2.data.CustomRemote;

public class frontDisplayAdapter extends RecyclerView.Adapter<frontDisplayAdapter.ViewHOlder> {

    private Context context;
    private CustomRemote remote;


    public frontDisplayAdapter(Context context) {
        this.context = context;


    }

    @NonNull
    @Override
    public ViewHOlder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rv_list_remote, viewGroup, false);
        return new ViewHOlder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHOlder viewHOlder, int i) {

        if (RemoteList.getRemote(i).getName()!= null)
            viewHOlder.textView.setText(RemoteList.getRemote(i).getName());
        else
            viewHOlder.textView.setText(("THE REMOTE NAME IS NULL"));

    }

    @Override
    public int getItemCount() {
        return RemoteList.remotes.size();
    }

    public class ViewHOlder extends RecyclerView.ViewHolder{
        TextView textView;
        RelativeLayout relativeLayout;
        public ViewHOlder(@NonNull View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.rvRelativeLayoutForClick);
            textView = itemView.findViewById(R.id.rvRemoteNameDisplayList);

            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,Remote.class);
                    intent.putExtra("position",getAdapterPosition());
                    context.startActivity(intent);
                }
            });
        }
    }
}
