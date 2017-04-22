package ca.wallacemohawcollege.alex.whereya;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.table.CloudTable;
import com.microsoft.azure.storage.table.CloudTableClient;
import com.microsoft.azure.storage.table.TableOperation;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class SecurityQ extends AppCompatActivity {
    Register register = new Register();
    private Intent reg = register.getIntent();
    public static final String storageConnectionString =
            "DefaultEndpointsProtocol=http;" +
                    "AccountName=whereyaat;" +
                    "AccountKey=OMXc0lB7LHaq1j4fW0kdi/KZ+Jt1xlsC6wM3HfBXDfNb1l7kZLhzZ/kDHq37OXr8dl1rRj3sHHSDfMkXnyFsaQ==";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_q);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    @Override
    protected void onStart() {
        super.onStart();
        Button regbtn = (Button)findViewById(R.id.registerbtn);
        final Spinner question = (Spinner)findViewById(R.id.questionspr);
        final EditText answer = (EditText)findViewById(R.id.securetxt);
        final EditText debug = (EditText) findViewById(R.id.debug);
        Intent intent = this.getIntent();

        //Bundle user = intent.getExtras().get("USER_INFO");
//        try {

            final ArrayList userArray = (ArrayList) intent.getExtras().get("USER_INFO");//user.getStringArray("USER_INFO");


        boolean pass = true;


        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.print("Hi");
                try {
                    //               values.add(answer.getText().toString());
                    String[] temp = new String[7];
                    int i = 0;
                    //temp.addAll(0,userArray);
                    for (Object items :
                            userArray) {
                        temp[i] = (String) items;
                        System.out.print(temp[i]);
                        ++i;
                    }
                    temp[i] = question.getSelectedItem().toString();
                    temp[i + 1] = answer.getText().toString();
                    //debug.setText(temp.get(temp.size()).toString());
                    ArrayList<String> export = new ArrayList<String>(7);
                    i = 0;
                    for (String items : temp
                            ) {
                        export.add(i, items);
                        ++i;
                    }


                    AsyncTask<ArrayList, Void, Void> execute = new AddUser().execute(export);

                    //execute.execute(temp);// wtf
                    AddUser addUser = new AddUser();
                    addUser.doInBackground();
                    Intent in = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(in);
                } catch (Exception e) {
                    debug.setText(e.getMessage().toString());
                }

//} catch (Exception e)
//{
////    debug.setText(e.getMessage().toString());
//}

            }
        });
    }
    protected Void createTable(String[] user_info) {
        String[] tableNames = {"users","meeting","location"};
        try
        {
            // Retrieve storage account from connection-string.
            CloudStorageAccount storageAccount =
                    CloudStorageAccount.parse(storageConnectionString);

            // Create the table client.
            CloudTableClient tableClient = storageAccount.createCloudTableClient();

            // Create the table if it doesn't exist.
            for (String name: tableNames
                    ) {
                CloudTable cloudTable = tableClient.getTableReference(name);
                cloudTable.createIfNotExists();
            }
        }
        catch (Exception e)
        {
            // Output the stack trace.
            e.printStackTrace();
        }

        return null;
    }

    protected void adduser(String[] user)
    {
        try
        {

            // Retrieve storage account from connection-string.
            CloudStorageAccount storageAccount =
                    CloudStorageAccount.parse(storageConnectionString);

            // Create the table client.
            CloudTableClient tableClient = storageAccount.createCloudTableClient();

            // Create a cloud table object for the table.
            CloudTable cloudTable = tableClient.getTableReference("users");

            // Parse Gender int
            int value = 0;
            try {
                value = Integer.parseInt(user[4]);
            }catch (Exception e){
                System.out.print(e.getMessage());
            }
            // Create a new customer entity.
            userEntry newUser = new userEntry((String)user[0],(String)user[1]);
            newUser.setPassword((String) user[2]);
            newUser.setCountry((String) user[3]);
            newUser.setGender((value));
            newUser.setQuestion((String) user[6]);
            newUser.setAnswer((String) user[7]);

            // Create an operation to add the new customer to the people table.
            TableOperation insertUser = TableOperation.insertOrReplace(newUser);

            // Submit the operation to the table service.
            cloudTable.execute(insertUser);

        }
        catch (Exception e)
        {
            // Output the stack trace.
            e.printStackTrace();
        }
    }
}
