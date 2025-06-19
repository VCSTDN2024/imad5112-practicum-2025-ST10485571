package vcmsa.ci.momolo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btnPlaylist: Button
    private lateinit var btnStart: Button
    private lateinit var btnExit: Button
    private lateinit var editTextUserInput: EditText

    companion object {
        const val EXTRA_PLAYLIST_SONGS = "vcmsa.ci.momolo.EXTRA_PLAYLIST_SONGS"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnPlaylist = findViewById(R.id.button)
        btnStart = findViewById(R.id.button2)
        btnExit = findViewById(R.id.button3)
        editTextUserInput = findViewById(R.id.editTextText)

        btnPlaylist.setOnClickListener {
            val playlistName = editTextUserInput.text.toString().trim()
            if (playlistName.isNotEmpty()) {
                val playlisttoPass = playlistName.lowercase()

                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra(EXTRA_PLAYLIST_SONGS, playlistName)
            } else {
                editTextUserInput.error = "Please enter a playlist name"
                Toast.makeText(this, "Please enter a playlist name", Toast.LENGTH_SHORT).show()
            }

        }
        btnExit.setOnClickListener() {
            finishAffinity()
        }
        btnStart.setOnClickListener() {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra(EXTRA_PLAYLIST_SONGS, editTextUserInput.text.toString())
            startActivity(intent)
        }
    }
}