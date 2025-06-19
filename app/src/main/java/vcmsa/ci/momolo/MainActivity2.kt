package vcmsa.ci.momolo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    private lateinit var btnDisplay: Button
    private lateinit var btnReturn: Button
    private lateinit var btnCalculate: Button
    private lateinit var textViewPlaylistName: TextView
    private lateinit var textViewPlaylistSongs: TextView
    private lateinit var ratingSpinner: Spinner

    private var currentPlaylist: String? = null

    private val playlists = mapOf(
        "Momo's Private School" to listOf("Myekeleni", "Soul to Soul", "Sabel", "Overflow", "Afrika Vuka", "Blue Moon", "Lately"
        ),
        "Ivy League" to listOf("Ivy League", "Heart & Soul", "More Momo", "Treasure", "Amukelani", "Teka", "Song Cry"
        ),
        "Amukelani" to listOf("Emaphupeni", "Art of Love", "Soweto Groove", "Fool Me", "Sukakude"
        ),
        "Kurhula" to listOf("Ikhaya Lam", "Khawleza", "Violin Sounds", "Tears Of A Black Man", "Amalobolo"
        ),
        "Sewe" to listOf("Joy Ride", "Bala", "Langa'elihle", "Lady Killer", "Jazz Cruise", "Umhlaba"
        ),
        "Ntsako" to listOf("Uzumthande", "Vulani", "Intyatyambo", "Bo Gogo", "Bazali", "Zamalek"
        ),
        "Thato Ya Modimo" to listOf("Peak Hour", "Take ME To The River", "Modimo", "Mkhuzeni", "Ndonwabile", "Flight Mode", "Sbeba",
        )
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        btnDisplay = findViewById(R.id.button4)
        btnReturn = findViewById(R.id.button5)
        btnCalculate = findViewById(R.id.button6)
        textViewPlaylistName = findViewById(R.id.textView4)
        textViewPlaylistSongs = findViewById(R.id.textView3)
        ratingSpinner = findViewById(R.id.spinner)

        // Get the playlist name from the intent
        currentPlaylist = intent.getStringExtra(MainActivity.EXTRA_PLAYLIST_SONGS)

        if (currentPlaylist != null && currentPlaylist!!.isNotEmpty()) {
            val displayPlaylistName = currentPlaylist!!.replaceFirstChar {
                if (it.isLowerCase())
                    it.uppercase() else it.toString()
            }
            // Display the playlist name
            textViewPlaylistName.text = "Playlist: $displayPlaylistName"
            btnDisplay.isEnabled = true   // Enable the "Display" button if a playlist is selected
        } else {
            // Hide the playlist name and songs if no playlist is selected
            textViewPlaylistName.text = "Error: No Playlist Selected"
            textViewPlaylistSongs.text = "Please return to the main screen and select a playlist"
            btnDisplay.isEnabled = false  // Disable the "Display" button if no playlist is selected

        }
        btnDisplay.setOnClickListener {
            displayPlaylistSongs()
        }
        //Instruct the user to return to the main screen and select a playlist
        btnReturn.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        btnCalculate.setOnClickListener {
            
        }

    }
    private fun displayPlaylistSongs() {
        if (currentPlaylist ==null) {
            textViewPlaylistSongs.text = "Error: No Playlist Selected to display songs for"
            return

        }
        // Get the list of songs for the selected playlist
        val songs = playlists[currentPlaylist!!]

        if (songs != null && songs.isNotEmpty()) {
            //Display the list of songs
            val songsText = songs.joinToString(separator = "\n") { "- $it" }
            textViewPlaylistSongs.text = songsText
        } else {
            //Display an error message if no songs are found
            textViewPlaylistSongs.text = "Error: No songs found for this playlist '$currentPlaylist'. \n\n" +
                    "Tip: Check the spelling of the playlist name and try again. OR Please try enter playlists like 'Ivy League' or 'Kurhula'"

        }
    }
}