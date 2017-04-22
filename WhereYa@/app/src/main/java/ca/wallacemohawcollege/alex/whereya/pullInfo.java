package ca.wallacemohawcollege.alex.whereya;

import android.os.AsyncTask;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.table.CloudTable;
import com.microsoft.azure.storage.table.CloudTableClient;
import com.microsoft.azure.storage.table.TableQuery;

import java.util.ArrayList;

/**
 * Created by alex_ on 05/04/2017.
 */

public class pullInfo extends AsyncTask<ArrayList,Void,Void> {
    public static final String storageConnectionString =
            "DefaultEndpointsProtocol=https;AccountName=whereyaat;AccountKey=OMXc0lB7LHaq1j4fW0kdi/KZ+Jt1xlsC6wM3HfBXDfNb1l7kZLhzZ/kDHq37OXr8dl1rRj3sHHSDfMkXnyFsaQ==";

    public String getValue() {
        return value;
    }

    String value ;
    @Override
    protected Void doInBackground(ArrayList... params) {

//        try
//        {
//            // Define constants for filters.
//            final String PARTITION_KEY = "PartitionKey";
//            final String ROW_KEY = "RowKey";
//            final String TIMESTAMP = "Timestamp";
//
//            // Retrieve storage account from connection-string.
//            CloudStorageAccount storageAccount =
//                    CloudStorageAccount.parse(storageConnectionString);
//
//            // Create the table client.
//            CloudTableClient tableClient = storageAccount.createCloudTableClient();
//
//            // Create a cloud table object for the table.
//            CloudTable cloudTable = tableClient.getTableReference("users");
//
//            // Create a filter condition where the partition key is "Smith".
//            String partitionFilter = TableQuery.generateFilterCondition(
//                    PARTITION_KEY,
//                    TableQuery.QueryComparisons.EQUAL,
//                    "ADMIN");
//
//            // Specify a partition query, using "Smith" as the partition key filter.
//            TableQuery<userEntry> partitionQuery =
//                    TableQuery.from(userEntry.class)
//                            .where(partitionFilter);
//
//            // Loop through the results, displaying information about the entity.
//            for (userEntry entity : cloudTable.execute(partitionQuery)) {
//                value = entity.getPartitionKey();
//            }
//        }
//        catch (Exception e)
//        {
//            // Output the stack trace.
//            e.printStackTrace();
//        }
        return null;
    }



}
