package com.abdul.mtap3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.abdul.mtap3.databinding.ActivityDaggerBinding;
import com.abdul.mtap3.databinding.ActivityMainBinding;
import com.abdul.mtap3.di.DaggerMyComponent;
import com.abdul.mtap3.di.MyComponent;
import com.abdul.mtap3.di.SharedPrefModule;

import javax.inject.Inject;


public class DaggerActivity extends AppCompatActivity implements View.OnClickListener {


    EditText inUsername, inNumber;
    Button btnSave, btnGet;
    private MyComponent myComponent;
    @Inject
    SharedPreferences sharedPreferences;
    ActivityDaggerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_dagger);
         //val myName: MyName = MyName("Aleks Haecky")

        /*private lateinit var binding:
        ActivityMainBinding*/
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dagger);
        MyName myName = new MyName("abdul","ansari");
        binding.setUrName(myName);





        //initViews();
        myComponent = DaggerMyComponent.builder().sharedPrefModule(new SharedPrefModule(this)).build();
        myComponent.inject(this);


    }

    private void initViews() {
        btnGet = findViewById(R.id.btnGet);
        btnSave = findViewById(R.id.btnSave);
        inUsername = findViewById(R.id.inUsername);
        inNumber = findViewById(R.id.inNumber);
        btnSave.setOnClickListener(this);
        btnGet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnGet:
                inUsername.setText(sharedPreferences.getString("username", "default"));
                inNumber.setText(sharedPreferences.getString("number", "12345"));
                break;
            case R.id.btnSave:
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", inUsername.getText().toString().trim());
                editor.putString("number", inNumber.getText().toString().trim());
                editor.apply();
                break;

        }
    }
}