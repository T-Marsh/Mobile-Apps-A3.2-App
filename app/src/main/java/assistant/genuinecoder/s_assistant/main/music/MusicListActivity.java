package assistant.genuinecoder.s_assistant.main.music;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import assistant.genuinecoder.s_assistant.R;

public class MusicListActivity extends AppCompatActivity {

    public static final String EXTRA_NUMBER = "assistant.genuinecoder.s_assistant.EXTRA_NUMBER";
    Button btnOne;
    Button btnTwo;
    int songSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);

        btnOne = (Button) findViewById(R.id.playFirstSong);
        btnTwo = (Button) findViewById(R.id.playSecondSong);
    }

    public void playSongOne(View view) {
        songSelection = 1;

        Intent intent = new Intent(this, MusicActivity.class);
        intent.putExtra(EXTRA_NUMBER, songSelection);
        startActivity(intent);
    }

    public void playSongTwo(View view) {
        songSelection = 2;

        Intent intent = new Intent(this, MusicActivity.class);
        intent.putExtra(EXTRA_NUMBER, songSelection);
        startActivity(intent);
    }
}
