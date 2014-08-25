package usage;

import Model.User;
import Repository.DatasourceDAO;
import Repository.Imp.DatasourceDAOImpl;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.example.myapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siyanda on 8/22/14.
 */
public class ListVIew extends Activity {



    //private List<Map<String,String>> contactList = new ArrayList<Map<String,String>>();
    List<User> listCon = new ArrayList<User>();
    ListView listView;
    DatasourceDAO dao = new DatasourceDAOImpl(this);


    public class CustomList extends ArrayAdapter<String> {
        private final User con = new User();
        private final Activity context;
        private final String[] surname;
        private final String[] cellPhone;
        public CustomList(Activity context,
                          String[] surname, String[] cellPhone) {
            super(context, R.layout.list_view, surname);
            this.context = context;
            this.surname = surname;
            this.cellPhone = cellPhone;
        }
        @Override
        public View getView(final int position, final View view, final ViewGroup parent) {

            LayoutInflater inflater = context.getLayoutInflater();
            View rowView= inflater.inflate(R.layout.list_view, null, true);
            TextView surnamea = (TextView) rowView.findViewById(R.id.surnmeCustom);
            TextView cellPhonea = (TextView) rowView.findViewById(R.id.cellPhneNumCustom);
            Button moreDetails = (Button) rowView.findViewById(R.id.moreDetCustom);
            surnamea.setText(surname[position]);
            cellPhonea.setText(cellPhone[position]);

            moreDetails.setTag(surnamea.getText().toString());

            moreDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent next = new Intent(ListVIew.this, ViewContacts.class);
                    String value = (String)v.getTag();

                    next.putExtra("listView", value);
                    startActivity(next);

                }
            });
            return rowView;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_users);

        listCon = dao.getUser();


        String[] surname = new String[listCon.size()];
        String[] cellphone = new String[listCon.size()];

        surname(surname);
        cellphone(cellphone);


        CustomList adapter = new
                CustomList(this, surname, cellphone);

        listView = (ListView) findViewById(R.id.listView_users);
       // listView = (ListVIew, R.layout.listview_user);

        listView.setAdapter(adapter);


        registerForContextMenu(listView);
    }

    private void surname(String[] surname){
        int count = 0;
        for (User con : listCon){
            surname[count] = con.getLastname();
            count++;
        }

    }

    private void cellphone(String[] cellphone){
        int count = 0;
        for (User con : listCon){
            cellphone[count] = con.getCellnumber();
            count++;
        }

    }
}