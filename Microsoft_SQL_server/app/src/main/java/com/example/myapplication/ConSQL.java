package com.example.myapplication;
import android.annotation.SuppressLint;

import java.sql.Connection;
import java.sql.DriverManager;

import android.os.StrictMode;
import android.util.Log;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ConSQL {
    Connection con;
    @SuppressLint("NewApi")
    public Connection conclass(){
        StrictMode.ThreadPolicy a = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(a);
        String ConURL=null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConURL = "jdbc:jtds:sqlserver://192.168.133.1:1433;databaseName=UserDatabase;user=haianh;password=13062013;";
            con= DriverManager.getConnection(ConURL);
        }
        catch (Exception e){
            Log.e("Error", e.getMessage());

        }
        return con;
    }
}
