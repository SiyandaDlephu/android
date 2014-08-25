package usage;


import Model.User;
import Repository.DatasourceDAO;
import Repository.Imp.DatasourceDAOImpl;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.example.myapp.R;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by siyanda on 8/22/14.
 */
public class ViewContacts extends Activity {

    private EditText getContact;
    private String getCount;
    private List<User> userlist = new ArrayList<User>();
    int count = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_contacts);
        final DatasourceDAO dao = new DatasourceDAOImpl(this);
        userlist = dao.getUser();

        Intent getMsg = getIntent();
        getCount = getMsg.getStringExtra("listView");

        final EditText lname = (EditText) findViewById(R.id.txtLastname);
        final EditText cellPhoneNum = (EditText) findViewById(R.id.txtcellnum);
        final EditText emailAddress = (EditText) findViewById(R.id.txtemail);
        final EditText homeAddress = (EditText) findViewById(R.id.txtAddress);
        final EditText fname = (EditText) findViewById(R.id.txtfirstname);



        for (User con : userlist) {
            if (con.getLastname().equalsIgnoreCase(getCount)) {
                System.out.println("Record Found");
                break;
            }
            count++;
        }

        lname.setText(userlist.get(count).getLastname());
        cellPhoneNum.setText(userlist.get(count).getCellnumber());
        fname.setText(userlist.get(count).getFirstname());
        emailAddress.setText(userlist.get(count).getEmail());
        homeAddress.setText(userlist.get(count).getHomeaddress());
    }
}