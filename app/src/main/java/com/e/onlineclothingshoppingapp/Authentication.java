package com.e.onlineclothingshoppingapp;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

import static android.content.Context.MODE_APPEND;
import static android.content.Context.MODE_PRIVATE;
import static android.widget.Toast.LENGTH_LONG;

public class Authentication {
    private String username, password, email, name;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean Login(){
        return true;
    }

    public boolean Register(Activity activity){
        try {
            PrintStream printStream = new PrintStream(activity.openFileOutput("auth.txt", MODE_PRIVATE | MODE_APPEND));
            printStream.println(name + "->" + username + "->" + email + "->" + password);
            return true;
        }catch (IOException e){
            Log.d("OnlineShoppingApp","Error: "+e.toString());
            e.printStackTrace();
            return false;
        }
    }

}
