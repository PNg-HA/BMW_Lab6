package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Register extends AppCompatActivity {
    private EditText etUsername, etPassword, etEmail;
    private Button btnRegister;

    Connection con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        btnRegister = findViewById(R.id.button3);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etUsername = findViewById(R.id.username);
                etPassword = findViewById(R.id.password);
                etEmail = findViewById(R.id.email);
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Register.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    ConSQL c = new ConSQL();
                    con = c.conclass();
                    if (c != null) {
                        try {

                            String sqlstatement = "INSERT INTO [User] (Username, Password, Email) VALUES ('" + username + "', '" + password + "', '" + email + "');";
                            Statement smt = con.createStatement();
                            smt.executeUpdate(sqlstatement);
                            Intent i = new Intent(Register.this, MainActivity.class);
                            startActivity(i);
                            con.close();
                        } catch (Exception e) {
                            Log.e("Error: ", e.getMessage());
                        }
                    }
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}