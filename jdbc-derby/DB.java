package com.example.phonebook;

import java.sql.*;
import java.util.ArrayList;


public class DB {
    final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    final String URL = "jdbc:derby:phonebookDB;create=true";

    Connection conn = null;
    Statement createStatement = null;
    DatabaseMetaData dbmd = null;

    public DB() {
//        try {
//            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try{
            conn = DriverManager.getConnection(URL);
            System.out.println("Successfully connected to the database.");
        }catch(Exception e){
            System.out.println("Failed to connect to the database.");
            System.out.println("" + e);
        }

        if(conn != null){
            try{
                createStatement = conn.createStatement();
            }catch(Exception e){
                System.out.println("" + e);
            }
        }

        try{
            dbmd = conn.getMetaData();
        }catch(Exception e){
            System.out.println("" + e);
        }

        try{
            ResultSet rs = dbmd.getTables(null, "APP", "CONTACTS", null);
            if(!rs.next()){
                createStatement.execute("CREATE TABLE CONTACTS(ID int PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), NAME varchar(40), PHONE varchar(40), EMAIL varchar(40))");
                System.out.println("The table is successfully created.");
            }else{
                System.out.println("The table is already exists.");
            }
        }catch(Exception e){
            System.out.println("The table is not created, because something went wrong.");
            System.out.println("" + e);
        }
    }

    public void addContact(Person p){
        try{
            PreparedStatement ps = conn.prepareStatement("INSERT INTO CONTACTS (NAME, PHONE, EMAIL) VALUES (?, ?, ?)");
            ps.setString(1, p.getName());
            ps.setString(2, p.getPhone());
            ps.setString(3, p.getEmail());
            ps.execute();
            System.out.println("The new contact is successfully added to the table.");
        }catch(Exception e){
            System.out.println("The new contact is not added to the table.");
            System.out.println("" + e);
        }
    }

    public ArrayList<Person> getContacts(){
        ArrayList<Person> contacts = null;
        try{
            contacts = new ArrayList<>();
            ResultSet rs = createStatement.executeQuery("SELECT * FROM CONTACTS");
            while(rs.next()){
                Integer id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String phone = rs.getString("PHONE");
                String email = rs.getString("EMAIL");
                contacts.add(new Person(id, name, phone, email));
            }
        }catch(Exception e){
            System.out.println("Something went wrong during the query method.");
            System.out.println("" + e);
        }
        return contacts;
    }

    public void deleteContact(int id){
        try{
            PreparedStatement ps = conn.prepareStatement("DELETE FROM CONTACTS WHERE ID = ?");
            ps.setInt(1, id + 1);
            ps.execute();
        }catch(Exception e){
            System.out.println("Something went wrong during the delete method.");
            System.out.println("" + e);
        }
    }

    public void updateContact(Person p){
        try{
            PreparedStatement ps = conn.prepareStatement("UPDATE CONTACTS SET NAME = ?, PHONE = ?, EMAIL = ? WHERE ID = ?");
            ps.setString(1, p.getName());
            ps.setString(2, p.getPhone());
            ps.setString(3, p.getEmail());
            ps.setInt(4, p.getId());
            ps.execute();
        }catch(Exception e){
            System.out.println("Something went wrong during the update.");
            System.out.println("" + e);
        }
    }
}
