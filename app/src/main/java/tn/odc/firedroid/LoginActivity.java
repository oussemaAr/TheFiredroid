package tn.odc.firedroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private EditText mEmail;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = findViewById(R.id.input_email);
        mPassword = findViewById(R.id.input_password);
    }


    /**
     * Make Login request
     */
    public void makeLogin(View view) {
        String sEmail = mEmail.getText().toString();
        String sPassword = mPassword.getText().toString();

    }

    /**
     * Start navigation to register activity
     */
    public void navigateRegister(View view) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        finish();
    }


    /**
     * Send Verification mail
     */
    private void sendVerificationEmail() {

    }
}