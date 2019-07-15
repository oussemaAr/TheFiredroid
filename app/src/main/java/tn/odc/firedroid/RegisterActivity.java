package tn.odc.firedroid;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import tn.odc.firedroid.model.User;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "RegisterActivity";

    private EditText mEmail;
    private EditText mPassword;
    private EditText mPseudo;
    private EditText mPhone;
    private ImageView mPicture;


    private Uri filePath;
    private final int PICK_IMAGE_REQUEST = 2000;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // init mAuth && mReference && storageReference


        mEmail = findViewById(R.id.input_email);
        mPassword = findViewById(R.id.input_password);
        mPseudo = findViewById(R.id.input_name);
        mPhone = findViewById(R.id.input_phone);
        mPicture = findViewById(R.id.profile_picture);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Uploading...");

    }

    /**
     * Called to create the account
     *
     * @param view
     */
    public void createAccount(View view) {
        String sEmail = mEmail.getText().toString();
        String sPassword = mPassword.getText().toString();
        progressDialog.show();

    }

    private void uploadPicture() {
        if (filePath != null) {

        }
    }

    /**
     * Create User
     *
     * @param url the image url
     */

    private void createUser(String url) {
        User user = new User();
        user.email = mEmail.getText().toString();
        user.phone = mPhone.getText().toString();
        user.pseudo = mPseudo.getText().toString();
        user.picture = url;


    }

    /**
     * Send verification email
     */
    private void sendVerificationEmail() {

    }

    /**
     * Navigate back to login
     */
    public void navigateLogin(View view) {
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        finish();
    }

    /**
     * Open Picture chooser for image
     */
    public void choosePicture(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    /**
     * Launched after the choose of the image
     */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                mPicture.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
