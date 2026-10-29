package com.jardelfama.meuapptva

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

class MainActivity : AppCompatActivity() {

    private lateinit var listViewChannels: ListView
    private lateinit var playerView: PlayerView
    private lateinit var exoPlayer: ExoPlayer

    private val channels = listOf(
        Channel(1, "TV Globo", "https://storage.googleapis.com/exoplayer-test-media-1/mkv/android-screens-64.mp4"),
        Channel(2, "SBT", "https://storage.googleapis.com/exoplayer-test-media-1/mkv/android-screens-64.mp4"),
        Channel(3, "Record", "https://storage.googleapis.com/exoplayer-test-media-1/mkv/android-screens-64.mp4"),
        Channel(4, "Band", "https://storage.googleapis.com/exoplayer-test-media-1/mkv/android-screens-64.mp4"),
        Channel(5, "RedeTV!", "https://storage.googleapis.com/exoplayer-test-media-1/mkv/android-screens-64.mp4"),
        Channel(6, "Cultura", "https://storage.googleapis.com/exoplayer-test-media-1/mkv/android-screens-64.mp4")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listViewChannels = findViewById(R.id.listViewChannels)
        playerView = findViewById(R.id.playerView)

        exoPlayer = ExoPlayer.Builder(this).build()
        playerView.player = exoPlayer

        val channelNames = channels.map { "${it.number} - ${it.name}" }
        listViewChannels.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            channelNames
        )

        listViewChannels.setOnItemClickListener { _, _, position, _ ->
            playChannel(channels[position].streamUrl)
        }

        playChannel(channels.first().streamUrl)
    }

    private fun playChannel(url: String) {
        exoPlayer.setMediaItem(MediaItem.fromUri(url))
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true
    }

    override fun onDestroy() {
        playerView.player = null
        exoPlayer.release()
        super.onDestroy()
    }

    private data class Channel(
        val number: Int,
        val name: String,
        val streamUrl: String
    )
}
