package com.example.fooddelivery;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fooddelivery.Common.Common;
import com.example.fooddelivery.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignIn extends AppCompatActivity {

    EditText phone,password;
    Button btnSignIn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        password=(MaterialEditText)findViewById(R.id.password);
        phone=(MaterialEditText)findViewById(R.id.phone);
        btnSignIn2=(Button)findViewById(R.id.btnSignIn2);


        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user=database.getReference("User");


        btnSignIn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(SignIn.this);
                mDialog.setMessage("Please wait, veryfing credentials");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Se verifica daca userul exista
                        if (dataSnapshot.child(phone.getText().toString()).exists()) {


                        //Se primeste informatia utilizatorului
                        mDialog.dismiss();
                        User user = dataSnapshot.child(phone.getText().toString()).getValue(User.class);
                        user.setPhone(phone.getText().toString());

                        if (user.getPassword().equals(password.getText().toString())) {
                            {
                                Intent homeIntent = new Intent(SignIn.this,Home.class);
                                Common.currentUser=user;
                                startActivity(homeIntent);
                                finish();
                            }

                        } else {
                            Toast.makeText(SignIn.this, "Wrong password!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                        {
                            mDialog.dismiss();
                            Toast.makeText(SignIn.this,"The number you entered is not registered",Toast.LENGTH_LONG).show();
                        }
                }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });


    }
}
