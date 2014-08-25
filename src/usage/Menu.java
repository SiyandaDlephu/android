package usage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.myapp.R;

/**
 * Created by siyanda on 8/22/14.
 */
public class Menu extends Activity implements View.OnClickListener{

    Button btnCreateContact, btnViewContacts;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        btnCreateContact = (Button)findViewById(R.id.btncreatecontact);
        btnViewContacts = (Button)findViewById(R.id.btnviewcontacts);

        btnCreateContact.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        if (view.getId()== R.id.btncreatecontact)
        {
            Intent intent = new Intent(getApplicationContext(),AddressBook.class);
            startActivity(intent);
        }
        if (view.getId()==R.id.btnviewcontacts)
        {
            Intent intent = new Intent(getApplicationContext(),ListVIew.class);
            startActivity(intent);
        }
    }
}