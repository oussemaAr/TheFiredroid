package tn.odc.firedroid;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import tn.odc.firedroid.adapters.MessagesAdapter;
import tn.odc.firedroid.model.Message;

public class ConversationActivity extends AppCompatActivity {

    private static final String TAG = "ConversationActivity";

    private RecyclerView recyclerView;
    private EditText mMessage;

    private ArrayList<Message> messageArrayList = new ArrayList<>();
    private MessagesAdapter messagesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessage = findViewById(R.id.input_message);
        recyclerView = findViewById(R.id.recycler_view);
        messagesAdapter = new MessagesAdapter(this, messageArrayList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(messagesAdapter);
        retrieveData();


    }

    /**
     * Get Data from server
     */
    private void retrieveData() {

    }

    /**
     * Send Message to database
     */
    public void sendMessage(View view) {


    }
}
