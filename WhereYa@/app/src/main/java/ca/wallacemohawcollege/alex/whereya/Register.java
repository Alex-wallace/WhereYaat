package ca.wallacemohawcollege.alex.whereya;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;

public class Register extends AppCompatActivity {
    public static final String storageConnectionString =
            "DefaultEndpointsProtocol=https;AccountName=whereyaat;AccountKey=OMXc0lB7LHaq1j4fW0kdi/KZ+Jt1xlsC6wM3HfBXDfNb1l7kZLhzZ/kDHq37OXr8dl1rRj3sHHSDfMkXnyFsaQ==";
    Context thiscontext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    protected void onStart() {
        super.onStart();
        final EditText uName = (EditText)findViewById(R.id.rUser);
        final EditText Email = (EditText)findViewById(R.id.rEmail);
        final EditText Pass = (EditText)findViewById(R.id.rPassword);
        EditText Conf = (EditText)findViewById(R.id.rConfirm);
        final Spinner Country = (Spinner)findViewById(R.id.Country_spnr);
        //final RadioGroup gender = (RadioGroup)findViewById(R.id.genderGroup);
        final RadioButton mselected = (RadioButton)findViewById(R.id.male_chkbx);
        final RadioButton fselected = (RadioButton)findViewById(R.id.female_chkbx);
        CheckBox Agree = (CheckBox)findViewById(R.id.Agree_chkbx);
        Button subbtn = (Button)findViewById(R.id.submit_btn);

        subbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList userinfo = new ArrayList();
                userinfo.add(uName.getText().toString());
                userinfo.add(Email.getText().toString());
                userinfo.add(Pass.getText().toString());
                userinfo.add(Country.getSelectedItem().toString());
                if(mselected.isChecked())
                {
                    userinfo.add("0");
                } else if(fselected.isChecked())
                {
                    userinfo.add("1");
                }else
                {
                    userinfo.add("-1");
                }

                Intent intent = new Intent(thiscontext,SecurityQ.class);
                intent.putExtra("USER_INFO",userinfo);
                startActivity(intent);

            }
        });
    }
}
