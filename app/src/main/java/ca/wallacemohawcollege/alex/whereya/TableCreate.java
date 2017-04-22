package ca.wallacemohawcollege.alex.whereya;

import android.os.AsyncTask;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.table.CloudTable;
import com.microsoft.azure.storage.table.CloudTableClient;


/**
 * Created by Stephen on 12/8/2016.
 */
public class TableCreate extends AsyncTask<Void,Void,Void> {

    public final String storageConnectionString =
            "DefaultEndpointsProtocol=http;" +
                    "AccountName=whereyaat;" +
                    "AccountKey=OMXc0lB7LHaq1j4fW0kdi/KZ+Jt1xlsC6wM3HfBXDfNb1l7kZLhzZ/kDHq37OXr8dl1rRj3sHHSDfMkXnyFsaQ==";
    @Override
    protected Void doInBackground(Void... params) {
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
}
