package com.example.apprunner.User.menu7_check_reward.Adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apprunner.R;
import com.example.apprunner.ResultQuery;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EventCheckStatusAdapter extends RecyclerView.Adapter<EventCheckStatusAdapter.Holder> {

    List<ResultQuery> eventList;
    Context context;

    public EventCheckStatusAdapter(Context context,List<ResultQuery> eventList) {
        this.context = context;
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public EventCheckStatusAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_event_check_status,parent,false);
        return new EventCheckStatusAdapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventCheckStatusAdapter.Holder holder, int position) {
        final ResultQuery event = eventList.get(position);
        final Intent intent = ((Activity) context).getIntent();
        final String type = intent.getExtras().getString("type");
        final String first_name = intent.getExtras().getString("first_name");
        final String last_name = intent.getExtras().getString("last_name");
        final int id_user = intent.getExtras().getInt("id_user");
        Picasso.with(context).load(event.getPic_event()).into(holder.iv_image);
        holder.tv_event_name_menu_event_user.setText(event.getName_event());
        holder.tv_producer_name_menu_event_user.setText(event.getName_producer());
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView iv_image;
        TextView tv_event_name_menu_event_user,tv_producer_name_menu_event_user;
        Button btn_statics;
        public Holder(@NonNull View itemView) {
            super(itemView);
            iv_image = (ImageView)itemView.findViewById(R.id.iv_image);
            tv_event_name_menu_event_user = (TextView)itemView.findViewById(R.id.tv_event_name_menu_event_user);
            tv_producer_name_menu_event_user = (TextView)itemView.findViewById(R.id.tv_producer_name_menu_event_user);
            btn_statics = (Button)itemView.findViewById(R.id.btn_statics);
        }
    }
}