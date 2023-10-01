package com.example.myapplication.fragments;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.adapters.StateAdapter;

import com.example.myapplication.entity.User;
import com.example.myapplication.databinding.FragmentItemListBinding;

import java.util.ArrayList;
import java.util.List;


public class FirstFragment extends Fragment {
    public FirstFragment(){
        super(R.layout.fragment_first);
    }
    public StateAdapter userAdapter;
    public static List<User> userList = new ArrayList<>();
    private FragmentItemListBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState); setUser();}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentItemListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        userListInit();
        AddUserBtnInit();
    }
    private void userListInit(){
        userAdapter = new StateAdapter(
                getContext(),
                R.layout.list_item,
                userList);
        binding.userList.setAdapter(userAdapter);
        binding.userList.setOnItemClickListener((adapterView, view, i, l) -> {
            Toast.makeText(getContext(), String.valueOf(i), Toast.LENGTH_LONG).show();
        });
        
    }
    public void setUser() {
        userList.add(new User("Anti-mage", "male", R.drawable.antimage));
        userList.add(new User("Shadow Fiend", "male", R.drawable.sf));
        userList.add(new User("Phantom Assassin", "female", R.drawable.pa));
        userList.add(new User("Ursa", "male", R.drawable.ursa));
        userList.add(new User("Windranger", "female", R.drawable.wr));
    }
    
    private void AddUserBtnInit(){ 
        binding.addUserBtn.setOnClickListener((view)->{
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_fragment, new AddUserFragment(), "add_user")
                    .addToBackStack(null)
                    .commit();
        });
    }
}
