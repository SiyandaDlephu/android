package Model;

import java.sql.Struct;

/**
 * Created by siyanda on 8/19/14.
 */
public class User {

    private int id;
    private String firstname;
    private String lastname;
    private String cellnumber;
    private String email;
    private String homeaddress;

    public User(Builder builder)
    {
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.cellnumber = builder.cellnumber;
        this.email = builder.email;
        this.homeaddress = builder.homeaddress;
    }


    public User()
    {

    }

    public static class Builder
    {
        private int id;
        private String firstname;
        private String lastname;
        private String cellnumber;
        private String email;
        private String homeaddress;

        public Builder(String firstname, String lastname)
        {
            this.firstname = firstname;
            this.lastname = lastname;
        }
        public Builder id(int id)
        {
            this.id = id;
            return this;
        }

        public Builder cellnumber(String cellnumber)
        {
            this.cellnumber = cellnumber;
            return this;
        }

        public Builder email(String email)
        {
            this.email = email;
            return this;
        }

        public Builder homeaddress(String homeaddress)
        {
            this.homeaddress = homeaddress;
            return this;
        }

        public Builder builder(User user)
        {
            id = user.getId();
            firstname = user.getFirstname();
            lastname = user.getLastname();
            cellnumber = user.getCellnumber();
            email = user.getEmail();
            homeaddress = user.getHomeaddress();
            return this;
        }

        public User build()
        {
            return new User(this);
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setCellnumber(String cellnumber) {
        this.cellnumber = cellnumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }


    public String getCellnumber() {
        return cellnumber;
    }

    public String getEmail() {
        return email;
    }


    public String getHomeaddress() {
        return homeaddress;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
