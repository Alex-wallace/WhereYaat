package ca.wallacemohawcollege.alex.whereya;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.TableOperationCallback;

import java.net.MalformedURLException;
import java.util.ArrayList;

public class SecurityQ extends AppCompatActivity {
    private MobileServiceClient mClient;
    public static final String storageConnectionString =
            "DefaultEndpointsProtocol=https;AccountName=whereyaat;AccountKey=OMXc0lB7LHaq1j4fW0kdi/KZ+Jt1xlsC6wM3HfBXDfNb1l7kZLhzZ/kDHq37OXr8dl1rRj3sHHSDfMkXnyFsaQ==";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            mClient = new MobileServiceClient(
                    "http://whereryat.azurewebsites.net",
                    this
            );
        } catch (MalformedURLException e) {
            e.getMessage();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_q);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

    }
    @Override
    protected void onStart() {
        super.onStart();
        Button regbtn = (Button)findViewById(R.id.registerbtn);
        final Spinner question = (Spinner)findViewById(R.id.questionspr);
        final EditText answer = (EditText)findViewById(R.id.securetxt);

        final ArrayList values = getIntent().getParcelableArrayListExtra("USER_INFO");

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //values.add(question.getSelectedItem().toString());
                //values.add(answer.getText().toString());
                try {
                    final loginItems item = new loginItems();
                    item.setUsername((String) values.get(0));
                    item.setEmail((String) values.get(1));
                    item.setCountry((String) values.get(2));
                    try{item.setGender(Integer.parseInt(String.valueOf(values.get(3))));}catch (Exception e){item.setGender(-1);}
                    item.setQuestion(question.getSelectedItem().toString());
                    item.setAnswer(answer.getText().toString());
                    mClient.getTable(loginItems.class).insert(item,new TableOperationCallback<loginItems>() {
                        public void onCompleted(loginItems entity, Exception exception, ServiceFilterResponse response) {
                            if (exception == null) {
                                // Insert succeeded
                                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(i);
                            } else {
                                // Insert failed
                                Intent i = new Intent(getApplicationContext(), Register.class);
                                startActivity(i);
                            }
                        }
                    });/**/
//                    new TableCreate().execute();
//                    new AddUser().execute(values);
                }catch (Exception e)
                {
                    Intent i = new Intent(getApplicationContext(),Register.class );
                    startActivity(i);
                }

//                Intent i = new Intent(getApplicationContext(), MainActivity.class);
////                i.putExtra("user",)
//                startActivity(i);

            }
        });
    }

}
