package fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.e.onlineclothingshoppingapp.Authentication;
import com.e.onlineclothingshoppingapp.R;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import static android.content.Context.MODE_APPEND;
import static android.content.Context.MODE_PRIVATE;
import static android.widget.Toast.*;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment{

    private EditText etName, etUsername, etEmail, etPassword, etConfirm;
    private Button btnRegister;
//    private TextView linkLogin;
    private Boolean status = true;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register,container,false);

        etName = view.findViewById(R.id.etName);
        etUsername= view.findViewById(R.id.etUsername);
        etEmail = view.findViewById(R.id.etEmail);
        etPassword= view.findViewById(R.id.etPassword);
        etConfirm= view.findViewById(R.id.etConfirm);
        btnRegister= view.findViewById(R.id.btnRegister);
//        linkLogin = view.findViewById(R.id.linkLogin);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, username, email,password, confirm;

                name = etName.getText().toString();
                username= etUsername.getText().toString();
                email = etEmail.getText().toString();
                password= etPassword.getText().toString();
                confirm = etConfirm.getText().toString();

                Authentication auth = new Authentication();
                auth.setName(name);
                auth.setEmail(email);
                auth.setUsername(username);
                auth.setPassword(password);

                if(v.getId() == R.id.btnRegister){
                    if(password == confirm){
                        if(auth.Register(getActivity())){
                            Toast.makeText(getActivity(), "Successfully Created", LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(getActivity(), "Register Unsuccessful", LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getActivity(),"Password and Confirm password mismatch", LENGTH_LONG).show();
                    }
                }
            }
        });
//        linkLogin.setOnClickListener(this);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

}
