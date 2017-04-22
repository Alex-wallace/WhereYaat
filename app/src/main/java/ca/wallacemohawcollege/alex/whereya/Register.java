package ca.wallacemohawcollege.alex.whereya;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.table.CloudTable;
import com.microsoft.azure.storage.table.CloudTableClient;
import com.microsoft.azure.storage.table.TableOperation;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Register extends FragmentActivity {
    public static final String storageConnectionString =
            "DefaultEndpointsProtocol=http;" +
                    "AccountName=whereyaat;" +
                    "AccountKey=OMXc0lB7LHaq1j4fW0kdi/KZ+Jt1xlsC6wM3HfBXDfNb1l7kZLhzZ/kDHq37OXr8dl1rRj3sHHSDfMkXnyFsaQ==";
    Context thiscontext = this;
//    final EditText uName = (EditText) findViewById(R.id.rUser);
//    final EditText Email = (EditText) findViewById(R.id.rEmail);
//    final EditText Pass = (EditText) findViewById(R.id.rPassword);
//    EditText Conf = (EditText) findViewById(R.id.rConfirm);
//    final Spinner Country = (Spinner) findViewById(R.id.Country_spnr);
//    final RadioGroup gender = (RadioGroup) findViewById(R.id.genderGroup);
//    CheckBox Agree = (CheckBox) findViewById(R.id.Agree_chkbx);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText uName = (EditText) findViewById(R.id.rUser);
        final EditText Email = (EditText) findViewById(R.id.rEmail);
        final EditText Pass = (EditText) findViewById(R.id.rPassword);
        EditText Conf = (EditText) findViewById(R.id.rConfirm);
        final Spinner Country = (Spinner) findViewById(R.id.Country_spnr);
        final RadioGroup gender = (RadioGroup) findViewById(R.id.genderGroup);
        CheckBox Agree = (CheckBox) findViewById(R.id.Agree_chkbx);
        Button subbtn = (Button) findViewById(R.id.conBtn);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Intent intent = new Intent(thiscontext,SecurityQ.class);
        subbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ArrayList userinfo = new ArrayList();
                userinfo.add(uName.getText().toString());
                userinfo.add(Email.getText().toString());
                userinfo.add(Pass.getText().toString());
                userinfo.add(Country.getSelectedItem().toString());
                userinfo.add(String.valueOf(gender.getCheckedRadioButtonId()));
                Intent intent = new Intent(thiscontext, SecurityQ.class);
                Bundle extras = intent.getExtras();
                intent.putExtra("USER_INFO", userinfo);
                startActivity(intent);

            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();


    }
}
