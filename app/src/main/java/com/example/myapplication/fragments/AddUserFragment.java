package com.example.myapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.entity.User;
import com.example.myapplication.databinding.FragmentAddUserBinding;

public class AddUserFragment extends Fragment {
    FragmentAddUserBinding binding;
    public AddUserFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAddUserBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState){
        initSwitchGender();
        initCommitBtn();
    }

    private void initSwitchGender(){ //метод смены пола
        binding.userGender.setOnCheckedChangeListener((compoundButton, b) -> {
            if(!b)
                binding.userGender.setText("Male"); //если переключатель выключен - текст "Male"
            else binding.userGender.setText("Female"); //если переключатель включен - текст "Female"
        });
    }

    private void initCommitBtn(){ //метод добавления введенных данных
        binding.commitBtn.setOnClickListener((v)->{
            String name = binding.userName.getText().toString(); //получения введенного имени и добавления его в переменную name
            String gender = binding.userGender.getText().toString(); //получения значения переключателя пола
            if (name.equals("")) return; //если при нажатии на кнопку Add User поле с именем не запонено, пользователь не будет добавлен
            User user = new User(name, gender, R.drawable.quest); //создание нового юзера и доваление ему введенных данных
            FirstFragment.userList.add(user); // добаление юзера в userList
            getActivity().getSupportFragmentManager().popBackStack();// закрыть фрагмент и вернуться к предыдущему
        });
    }
}
