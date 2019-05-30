package assistant.genuinecoder.s_assistant.main.communication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import assistant.genuinecoder.s_assistant.R;

public class CommunicationActivity extends AppCompatActivity {
    private EditText cEditTextTo;
    private EditText cEditTextSubject;
    private EditText cEditTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication);

        cEditTextTo = findViewById(R.id.edit_text_to);
        cEditTextSubject = findViewById(R.id.edit_text_subject);
        cEditTextMessage = findViewById(R.id.edit_text_message);

        Button buttonSendEmail = findViewById(R.id.button_send_email);
        buttonSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });

    }

    private void sendEmail() {
        String recipientList = cEditTextTo.getText().toString();
        String[] recipients = recipientList.split(",");

        String subject = cEditTextSubject.getText().toString();
        String message = cEditTextMessage.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client:"));
    }
}
