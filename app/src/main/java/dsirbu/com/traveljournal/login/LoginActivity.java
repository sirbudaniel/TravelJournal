package dsirbu.com.traveljournal.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import dsirbu.com.traveljournal.R;
import dsirbu.com.traveljournal.login.utils.Authentication;
import dsirbu.com.traveljournal.login.utils.EmailHelper;
import dsirbu.com.traveljournal.travel.TravelActivity;

public class LoginActivity extends AppCompatActivity {

    // the view fields should be global private variables
    private EditText mEditTextEmail;
    private EditText mEditTextPhone;
    private EditText mEditTextPassword;
    private CheckBox mCheckBoxAccept;


    // global private variable to build the object Authentication
    // based on the data filled in the form
    private Authentication mAuthentication;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // this method "setContentView" connects the current activity to the "activity_login" screen
        setContentView(R.layout.activity_login);

//        mAuth = FirebaseAuth.getInstance();
        mAuthentication = new Authentication();

        initView();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        try {
            FirebaseUser currentUser = mAuth.getCurrentUser();
        }
        catch (Exception e) {

        }
    }

    // get the views from the layout based on an unique id defined in the xml file
    private void initView() {
        mEditTextEmail = findViewById(R.id.edittext_email);
        mEditTextPhone = findViewById(R.id.edittext_phone);
        mEditTextPassword = findViewById(R.id.edittext_password);
        mCheckBoxAccept = findViewById(R.id.checkbox_accept);
    }

    // validate the content from the email EditText
    private boolean isEmailValid() {
        String email = mEditTextEmail.getText().toString();
        if (EmailHelper.isEmailValid(email)) {
            mAuthentication.setEmail(email);
            return true;
        } else {
            mEditTextEmail.setError(getResources().getString(R.string.error_email_input));
            return false;
        }
    }

    // validate the content from the phone EditText
    private boolean isPhoneValid() {
        String phone = mEditTextPhone.getText().toString();
        if (phone != null && !phone.isEmpty()) {
            mAuthentication.setPhone(phone);
            return true;
        } else {
            mEditTextPhone.setError(getResources().getString(R.string.error_phone_input));
            return false;
        }
    }

    // check if the checkbox is checked
    private boolean isAccepted() {
        if (mCheckBoxAccept.isChecked()) {
            mAuthentication.setAccepted(true);
            return true;
        } else {
            Toast.makeText(LoginActivity.this, getResources().getString(R.string
                    .error_is_accepted_input), Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean checkPasword() {
        String password = mEditTextPassword.getText().toString();
        if (password != null) {
            return true;
        }
        return false;
    }

    // implementation for the onClick event for the submit button
    public void btnSubmitOnClick(View view) {
        if (isEmailValid() && isPhoneValid() && isAccepted())
        {
            Intent intent = new Intent(LoginActivity.this, TravelActivity.class);
            intent.putExtra("email", mEditTextEmail.getText().toString());
            intent.putExtra("user", mEditTextPhone.getText().toString());
            startActivity(intent);
//
//            mAuth.signInWithEmailAndPassword(mEditTextEmail.getText().toString(), mEditTextPassword.getText().toString())
//                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if (task.isSuccessful()) {
//                                // Sign in success, update UI with the signed-in user's information
//                                FirebaseUser user = mAuth.getCurrentUser();
//                                Intent intent = new Intent(LoginActivity.this, TravelActivity.class);
//                                intent.putExtra("email", mEditTextEmail.getText().toString());
//                                intent.putExtra("user", mEditTextPhone.getText().toString());
//                                startActivity(intent);
//                            } else {
//                                // If sign in fails, display a message to the user.
//                                Toast.makeText(LoginActivity.this, "Authentication failed.",
//                                        Toast.LENGTH_SHORT).show();
//                            }
//
//                        }
//                    });
        }
    }
}
