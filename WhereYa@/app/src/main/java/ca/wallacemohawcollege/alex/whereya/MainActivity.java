package ca.wallacemohawcollege.alex.whereya;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.microsoft.windowsazure.mobileservices.*;

import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.table.*;
import com.microsoft.azure.storage.table.TableQuery.*;

import java.net.MalformedURLException;

// Include the following imports to use table APIs

public class MainActivity extends AppCompatActivity {
    // Define the connection-string with your values.

    public static final String storageConnectionString =
            "DefaultEndpointsProtocol=https;AccountName=whereyaat;AccountKey=OMXc0lB7LHaq1j4fW0kdi/KZ+Jt1xlsC6wM3HfBXDfNb1l7kZLhzZ/kDHq37OXr8dl1rRj3sHHSDfMkXnyFsaQ==";
    private MobileServiceClient mClient;

    FragmentManager fragmentManager = getFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        try {
            mClient = new MobileServiceClient(
                    "https://whereryatservice20170405042706.azurewebsites.net",
                    this
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
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
        //new TableCreate().execute();

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pullInfo info = new pullInfo();
               // info.execute();
              //  String value = info.getValue();
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


    }

}

