package controller;

public class User {
    public String user_name;
    private String password = null;
    private String f_type = "user"; //checks is user or supplier //by default is an user

    public User(String user_name, String password, String f_type) {
        this.user_name = user_name;
        this.password = password;
        this.f_type = f_type;
    }

    public void setUsername(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String f_type) {
        this.f_type = f_type;
    }

    public String getRole()
    {
        return this.f_type;
    }
    public String getName()
    {
        return this.user_name;
    }
    public String getPassword()
    {
        return this.password;
    }

    @Override
    public boolean equals(Object user) {
        if (this == user)
            return true;
        if (user == null || getClass() != user.getClass())
            return false;

        User obj = (User) user;
        System.out.println(((User) user).user_name+" " + this.user_name);
        if (!user_name.equals(obj.user_name))
            return false;
        if (!password.equals(obj.password))
            return false;
        if (!f_type.equals(obj.f_type))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return this.user_name +" " + this.password + " "+ this.f_type + "\n";
    }
}
