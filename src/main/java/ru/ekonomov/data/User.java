package ru.ekonomov.data;

import java.util.Date;

public class User
{
    private static int currentId=1;
    private int id;
    private String name;
    private int age;
    private boolean isAdmin;
    private Date createdDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    public int getAge()
    {
        return age;
    }

    public Date getCreatedDate()
    {
        return createdDate;
    }

    public int getId()
    {
        return id;
    }

    public boolean isAdmin()
    {
        return isAdmin;
    }

    public String getName()
    {
        return name;
    }

    public User(String name, Date createdDate) {
        this(18, createdDate, currentId++, false, name);
    }

    public User(int age, Date createdDate, int id, boolean isAdmin, String name)
    {
        this.age = age;
        this.createdDate = createdDate;
        this.id = id;
        this.isAdmin = isAdmin;
        this.name = name;
    }
}
