package Repository;

import Model.User;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by siyanda on 8/19/14.
 */
public interface DatasourceDAO {

    public void createUser(User user);
    public void updateUser(User user);
    public User findUserById(int id);
    public void deleteUser(User user);
    public List<User> getUser();
}
