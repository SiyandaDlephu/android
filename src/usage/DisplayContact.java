package usage;

import Model.User;
import Repository.DatasourceDAO;
import Repository.Imp.DatasourceDAOImpl;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.myapp.R;


/**
 * Created by Inathi-Zenande on 8/18/2014.
 */
public class DisplayContact extends Activity implements View.OnClickListener{
    Button btndetails, btnclose;
    EditText userName,userLastName,userPhone,userEmail,userAddress;
    DatasourceDAO dao = new DatasourceDAOImpl(this);

    @SuppressLint("NewApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_contact);

        //dao = new DatasourceDAOImpl(this);
        String[] datab = new String[6];


        Bundle intent = getIntent().getExtras();

        datab = intent.getStringArray("stuff");
        /*String name = intent.getStringExtra("name");
        String lastN = intent.getStringExtra("lastname ");
        String phonenumber = intent.getStringExtra("PhoneNumber ");
        String email = intent.getStringExtra("email");
        String address = intent.getStringExtra("address");*/


        userName = (EditText)findViewById(R.id.txtName);
        userLastName =(EditText)findViewById(R.id.txtLastname);
        userEmail = (EditText)findViewById(R.id.txtEmail);
        userPhone =(EditText)findViewById(R.id.txtPhonenumber);
        userAddress = (EditText)findViewById(R.id.txtAddress);

        userName.setText(datab[0]);
        userLastName.setText(datab[1]);
        userPhone.setText(datab[2]);
        userEmail.setText(datab[3]);
        userAddress.setText(datab[4]);

        /*userName.setText(name.toString());
        userLastName.setText(lastN.toString());
        userPhone.setText(phonenumber.toString());
        userEmail.setText(email.toString());
        userAddress.setText(address.toString());*/


    }

    public void onClick(View view)
    {
        if(view.getId()== R.id.btnDetails)
        {
            User user = new User();
            user.setFirstname(userName.getText().toString());
            user.setLastname(userLastName.getText().toString());
            user.setCellnumber(userPhone.getText().toString());
            user.setEmail(userEmail.getText().toString());
            user.setHomeaddress(userAddress.getText().toString());

            dao.createUser(user);

            // startActivity(new Intent(DisplayContact.this));


        }
        else if(view.getId() == R.id.btnClose)
        {
            Intent intent = new Intent(getApplicationContext(), AddressBook.class);
            startActivity(intent);
        }
    }
}