package com.example.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.entity.User;

import java.util.List;

public class StateAdapter extends ArrayAdapter<User> {

    private LayoutInflater inflater;
    private int layout;
    private List<User> users;

    public StateAdapter(Context context, int resource, List<User> users){
        super(context, resource, users);
        this.users = users;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent){
        View view=inflater.inflate(this.layout, parent, false);

        ImageView photoView = view.findViewById(R.id.photo);
        TextView nameView = view.findViewById(R.id.name);
        TextView genderView = view.findViewById(R.id.gender);

        User user = users.get(position);

        photoView.setImageResource(user.getPhoto());
        nameView.setText(user.getName());
        genderView.setText(user.getGender());

        return view;
    }
}
