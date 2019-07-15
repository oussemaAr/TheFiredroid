package tn.odc.firedroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import tn.odc.firedroid.model.User;
import tn.odc.firedroid.utils.Utils;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";

    private FirebaseAuth mAuth;
    private DatabaseReference mReference;

    private TextView mName;
    private TextView mEmail;
    private TextView mNumber;

    private ImageView mPicture;
    private String currentUserUid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        // Init mAuth && mReference
        mName = findViewById(R.id.user_fullname);
        mEmail = findViewById(R.id.user_email);
        mNumber = findViewById(R.id.user_phone);
        mPicture = findViewById(R.id.user_picture);
        currentUserUid = mAuth.getCurrentUser().getUid();


        subscribeToTopic();
    }

    /**
     * This method is called to subscribe to group topic for push notification
     */
    private void subscribeToTopic() {

    }


    /**
     * Display user detail
     */
    private void displayUserData(User user) {
        Utils.localUid = mAuth.getUid();
        Utils.pseudo = user.pseudo;
        mName.setText(user.pseudo);
        mEmail.setText(user.email);
        mNumber.setText(user.phone);
        Glide.with(this)
                .load(user.picture)
                .into(mPicture);

    }

    /**
     * Navigate to conversation activity
     */
    public void joinConversation(View view) {
        startActivity(new Intent(ProfileActivity.this, ConversationActivity.class));
        finish();
    }
}
