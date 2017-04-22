package ca.wallacemohawcollege.alex.whereya;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.Spinner;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.table.CloudTable;
import com.microsoft.azure.storage.table.CloudTableClient;
import com.microsoft.azure.storage.table.TableOperation;

import java.util.ArrayList;

/**
 * Created by Stephen on 12/8/2016.
 */
public class AddUser extends AsyncTask<ArrayList,Void,Void> {
    public static final String storageConnectionString =
            "DefaultEndpointsProtocol=http;" +
                    "AccountName=whereyaat;" +
                    "AccountKey=OMXc0lB7LHaq1j4fW0kdi/KZ+Jt1xlsC6wM3HfBXDfNb1l7kZLhzZ/kDHq37OXr8dl1rRj3sHHSDfMkXnyFsaQ==";

    @Override
    protected Void doInBackground(ArrayList... params) {
        ArrayList user = params.clone()[0];
        try
        {
            // Retrieve storage account from connection-string.
            CloudStorageAccount storageAccount =
                    CloudStorageAccount.parse(storageConnectionString);

            // Create the table client.
            CloudTableClient tableClient = storageAccount.createCloudTableClient();

            // Create a cloud table object for the table.
            CloudTable cloudTable = tableClient.getTableReference("users");

            // Create a new customer entity.
            userEntry newUser = new userEntry((String)user.get(0),(String)user.get(1));
            newUser.setPassword((String)user.get(3));
            newUser.setCountry((String) user.get(4));
            newUser.setGender((int) user.get(5));
            newUser.setQuestion((String) user.get(6));
            newUser.setAnswer((String) user.get(7));

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
        return null;
    }


}
