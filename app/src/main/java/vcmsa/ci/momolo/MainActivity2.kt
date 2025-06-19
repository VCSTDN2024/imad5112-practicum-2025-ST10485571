package vcmsa.ci.momolo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
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
    private lateinit var textViewAverageRating: TextView
    private lateinit var btnExit:Button

    private var currentPlaylist: String? = null
    private var currentPlaylistRating: Float? = null

    private val playlists = mapOf(
        "Momo's Private School" to listOf(
            "Myekeleni", "Soul to Soul", "Sabel", "Overflow", "Afrika Vuka", "Blue Moon", "Lately"
        ),
        "Ivy League" to listOf(
            "Ivy League", "Heart & Soul", "More Momo", "Treasure", "Amukelani", "Teka", "Song Cry"
        ),
        "Amukelani" to listOf(
            "Emaphupeni", "Art of Love", "Soweto Groove", "Fool Me", "Sukakude"
        ),
        "Kurhula" to listOf(
            "Ikhaya Lam", "Khawleza", "Violin Sounds", "Tears Of A Black Man", "Amalobolo"
        ),
        "Sewe" to listOf(
            "Joy Ride", "Bala", "Langa'elihle", "Lady Killer", "Jazz Cruise", "Umhlaba"
        ),
        "Ntsako" to listOf(
            "Uzumthande", "Vulani", "Intyatyambo", "Bo Gogo", "Bazali", "Zamalek"
        ),
        "Thato Ya Modimo" to listOf(
            "Peak Hour",
            "Take ME To The River",
            "Modimo",
            "Mkhuzeni",
            "Ndonwabile",
            "Flight Mode",
            "Sbeba",
        )
    )

    companion object {
        private const val TAG = "MainActivity2Debug"
    }




    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        Log.d(TAG, "onCreate started")

        btnDisplay = findViewById(R.id.button4)
        btnReturn = findViewById(R.id.button5)
        btnCalculate = findViewById(R.id.button6)
        textViewPlaylistName = findViewById(R.id.textView3)
        textViewPlaylistSongs = findViewById(R.id.textView4)
        ratingSpinner = findViewById(R.id.spinner)
        textViewAverageRating = findViewById(R.id.textView5)
        btnExit = findViewById(R.id.button7)

        //Set up the spinner adapter
        setupSpinnerRating()

        // Get the playlist name from the intent
        currentPlaylist = intent.getStringExtra(MainActivity.EXTRA_PLAYLIST_SONGS)
        Log.d(TAG, "Intent extra MainActivity.EXTRA_PLAYLIST_SONGS: $currentPlaylist")

        if (currentPlaylist != null && currentPlaylist!!.isNotEmpty()) {
            val displayPlaylistName = currentPlaylist!!.replaceFirstChar {
                if (it.isLowerCase())
                    it.titlecase() else it.toString()
            }
            // Display the playlist name
            textViewPlaylistName.text = "Playlist: $displayPlaylistName"
            btnDisplay.isEnabled = true   // Enable the "Display" button if a playlist is selected
            btnCalculate.isEnabled =
                true  // Enable the "Calculate" button if a playlist is selected
            ratingSpinner.isEnabled = true  // Enable the spinner if a playlist is selected
            Log.d(TAG, "Playlist '$currentPlaylist' loaded successfully.")
        } else {
            Log.e(TAG, "Error: No Playlist Selected or currentPlaylist is empty.")
            // Hide the playlist name and songs if no playlist is selected
            textViewPlaylistName.text = "Error: No Playlist Selected"
            textViewPlaylistSongs.text = "Please return to the main screen and select a playlist"
            btnDisplay.isEnabled = false  // Disable the "Display" button if no playlist is selected
            btnCalculate.isEnabled = false  // Disable the "Calculate" button if no playlist is selected
            ratingSpinner.isEnabled = false  // Disable the spinner if no playlist is selected
            textViewAverageRating.text = "Average Rating: N/A"


        }
        btnDisplay.setOnClickListener {
            Log.d(TAG, "btnDisplay clicked. Current playlist: $currentPlaylist")
            displayPlaylistSongs()
            //Reset average rating display when displaying a new playlist
            ratingSpinner.setSelection(0)  // Reset the spinner selection
            currentPlaylistRating = null  // Reset the rating for the current playlist
        }
        //Instruct the user to return to the main screen and select a playlist
        btnReturn.setOnClickListener() {
            Log.d(TAG, "btnReturn clicked")
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        btnExit.setOnClickListener() {
            Log.d(TAG, "btnExit clicked")
            finishAffinity()

        }
        btnCalculate.setOnClickListener {
            Log.d(TAG, "btnCalculate clicked. Current playlist: $currentPlaylist")
            calculateAndDisplayAverageRating()
        }


    }

    private fun setupSpinnerRating() {
        //Create an ArrayAdapter using the string array and a default spinner layout
        val ratings = arrayOf("Select Rating", "1", "2", "3", "4", "5")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ratings)
        //Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        //Apply the adapter to the spinner
        ratingSpinner.adapter = adapter
        Log.d(TAG, "Spinner setup complete.")
    }



    private fun displayPlaylistSongs() {
        if (currentPlaylist ==null) {
            Log.w(TAG, "displayPlaylistSongs: currentPlaylist is null or empty.")
            textViewPlaylistSongs.text = "Error: No Playlist Selected to display songs for"
            return

        }
        // Get the list of songs for the selected playlist
        val songs = playlists[currentPlaylist!!]

        if (songs != null && songs.isNotEmpty()) {
            //Display the list of songs
            val songsText = songs.joinToString(separator = "\n") { "- $it" }
            textViewPlaylistSongs.text = songsText
            Log.d(TAG, "Songs displayed for playlist: $currentPlaylist")
        } else {
            Log.w(TAG, "No songs found for playlist: $currentPlaylist")
            //Display an error message if no songs are found
            textViewPlaylistSongs.text = "Error: No songs found for this playlist '$currentPlaylist'. \n\n" +
                    "Tip: Check the spelling of the playlist name and try again. OR Please try enter playlists like 'Ivy League' or 'Kurhula'"

        }
    }
    private fun calculateAndDisplayAverageRating() {
        Log.d(TAG, "calculateAndDisplayAverageRating called.")
        if (currentPlaylistRating == null || currentPlaylist!!.isNotEmpty()) {
            Log.w(TAG, "calculate: No playlist loaded.")
            Toast.makeText(this, "Please select and display a playlist first", Toast.LENGTH_SHORT).show()
            textViewAverageRating.text = "Average Rating: N/A"
            return
        }
        val selectedRatingPosition = ratingSpinner.selectedItemPosition
        if (selectedRatingPosition == 0) {
            Toast.makeText(this, "Please select a rating from the spinner", Toast.LENGTH_SHORT).show()
            textViewAverageRating.text = "Average Rating: N/A"
            return
        }
        val selectedRatingString = ratingSpinner.selectedItem.toString()
        try {
            val selectedRating = selectedRatingString.toFloat()
            currentPlaylistRating = selectedRating

            val averageRating = currentPlaylistRating ?: 0.0f

            textViewAverageRating.text = "Average Rating: %.if / 5".format(averageRating)
            Toast.makeText(this, "Rating for '$currentPlaylist' is $averageRating", Toast.LENGTH_LONG).show()

        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Invalid rating value", Toast.LENGTH_SHORT).show()
            textViewAverageRating.text = "Average Rating: N/A"
        }
    }
}