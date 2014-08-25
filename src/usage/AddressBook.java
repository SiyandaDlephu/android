package usage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.myapp.R;

/**
 * Created by Inathi-Zenande on 8/18/2014.
 */
public class AddressBook extends Activity implements View.OnClickListener{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address_book);

        Button btnsave;
        Button btnclear;

        txtname = (EditText) findViewById(R.id.txtName);
        txtlastname = (EditText) findViewById(R.id.txtLastname);
        txtphonenumber = (EditText) findViewById(R.id.txtPhoneNumber);
        txtemail = (EditText) findViewById(R.id.txtEmail);
        txtaddress = (EditText) findViewById(R.id.txtAddress);

        btnsave = (Button) findViewById(R.id.btnSave);
        btnclear = (Button) findViewById(R.id.btnCancel);

        btnsave.setOnClickListener(this);
        btnclear.setOnClickListener(this);
    }

    EditText txtname, txtlastname, txtphonenumber, txtemail, txtaddress;
    //public final static String EXTRA_MESSAGE ="Welcome ";

    public void onClick(View view) {

        if (view.getId() == R.id.btnSave) {

            if(txtlastname.length()==0 && txtphonenumber.length()==0)
            {
                Toast.makeText(getApplicationContext(),"Last name and phone number cannot be empty",Toast.LENGTH_LONG).show();
            }
            else
            {
                Intent intent = new Intent(getApplicationContext(), DisplayContact.class);
                String[] datab = new String[6];

                /*String name = txtname.getText().toString();
                String lastname = txtlastname.getText().toString();
                String phonenumber = txtphonenumber.getText().toString();
                String email = txtemail.getText().toString();
                String address = txtaddress.getText().toString();*/

                datab[0] = txtname.getText().toString();
                datab[1] = txtlastname.getText().toString();
                datab[2] = txtphonenumber.getText().toString();
                datab[3] = txtemail.getText().toString();
                datab[4] = txtaddress.getText().toString();


                /*intent.putExtra("name ", name);
                intent.putExtra("lastname ", lastname);
                intent.putExtra("PhoneNumber ", phonenumber);
                intent.putExtra("Email ", email);
                intent.putExtra("Address ", address);*/

                intent.putExtra("stuff", datab);

                startActivity(intent);
            }
        }

         if (view.getId() == R.id.btnCancel) {
            txtname.getText().clear();
            txtlastname.getText().clear();
            txtphonenumber.getText().clear();
            txtemail.getText().clear();
            txtaddress.getText().clear();
        }
    }
}





