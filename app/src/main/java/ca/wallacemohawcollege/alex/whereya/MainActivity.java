package ca.wallacemohawcollege.alex.whereya;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
// Include the following imports to use table APIs
import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.table.*;
import com.microsoft.azure.storage.table.TableQuery.*;


import org.w3c.dom.Text;

import java.net.MalformedURLException;

public class MainActivity extends AppCompatActivity {
    // Define the connection-string with your values.




    FragmentManager fragmentManager = getFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        }
    @Override
    protected void onStart()
    {
        super.onStart();
        EditText username = (EditText)findViewById(R.id.suUser);
        EditText password = (EditText)findViewById(R.id.suPass);
        Button loginbtn = (Button)findViewById(R.id.subBtn);
        Button recover = (Button)findViewById(R.id.recover);
        Button register = (Button)findViewById(R.id.register);


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Home.class);
                startActivity(i);
            }
        });

        recover.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });
        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Register.class);
                startActivity(i);
            }
        });
        new TableCreate().execute();
    }

}

