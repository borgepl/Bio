package com.deborger.bio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.deborger.bio.data.Bio;
import com.deborger.bio.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private final Bio mBio = new Bio();

//    private EditText enterHobbies;
//    private TextView hobbies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setContentView(R.layout.activity_main);
//        enterHobbies = findViewById(R.id.enterHobbies);
//        hobbies = findViewById(R.id.hobbiesText);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBio.setName(getString(R.string.name));
        mBinding.setBio(mBio);
        mBinding.doneButton.setOnClickListener(this::addHobbies);

    }

    public void addHobbies(View view) {

//        hobbies.setText(String.format("Hobbies : %s", enterHobbies.getText().toString().trim()));
//        hobbies.setVisibility(view.VISIBLE);

        mBio.setHobbies(String.format("Hobbies : %s", mBinding.enterHobbies.getText().toString().trim()));

        // mBinding.hobbiesText.setText(String.format("Hobbies : %s", mBinding.enterHobbies.getText().toString().trim()));
        mBinding.invalidateAll();
        mBinding.hobbiesText.setVisibility(view.VISIBLE);

        // Hide Keyboard
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}