package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Sign_in extends AppCompatActivity {
    public String getPassword;
    public String getEmail;
    private Button sign;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;


    public Sign_in(Integer email, Integer password,Integer ConfirmPassword) {

    }

    public Sign_in() {

    }
    EditText inputEmail,inputPassword,inputCConfirmPassword;
    Button Sign_in;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in1);

        inputEmail=findViewById(R.id.Email);
        inputPassword =findViewById(R.id.Password);
        inputCConfirmPassword =findViewById(R.id.ConfirmPassword);
         progressDialog = new ProgressDialog(this) ;
         mAuth= FirebaseAuth.getInstance();
         mUser = mAuth.getCurrentUser();
        sign = findViewById(R.id.sign);
        sign.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Sign_in.this, accueille.class);
                startActivity(intent);}
        });
        sign.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                PerforAuth();
            }

            private void PerforAuth() {
                String email=inputEmail.getText().toString();
                String password=inputPassword.getText().toString();
                String confirmPassword=inputCConfirmPassword.getText().toString();

                if (!email.matches(emailPattern)){
                    inputEmail.setError("enter correct email");

                } else if(password.isEmpty() || password.length()<6)
                {
                    inputPassword.setError("Enter proper Password");
                }
                else if(!password.equals(confirmPassword))
                {
                    inputCConfirmPassword.setError("Passord not match Both field");

                }else
                {


                    progressDialog.setMessage("please wait while Sign_in....");
                    progressDialog.setTitle("Sign_in ");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();

                   mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if(task.isSuccessful()){
                               progressDialog.dismiss();
                               sendUserTonexteActivity();
                               Toast.makeText(com.example.myapp.Sign_in.this,"Sign_in", Toast.LENGTH_LONG);
                           }
                               else
                           {
                               progressDialog.dismiss();
                               Toast.makeText(com.example.myapp.Sign_in.this,""+task.getException(),Toast.LENGTH_SHORT);
                           }
                       }

                       private void sendUserTonexteActivity() {
                           Intent intent=new Intent(com.example.myapp.Sign_in.this, accueille.class);
                           intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                           startActivity(intent);
                       }

                       });

                    };

            }});}}


