package com.jardelfama.meuapptva

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val channels = listOf(
        Channel(1, "TV Globo"),
        Channel(2, "SBT"),
        Channel(3, "Record"),
        Channel(4, "Band"),
        Channel(5, "RedeTV!"),
        Channel(6, "Cultura"),
        Channel(7, "Discovery"),
        Channel(8, "Cartoon Network")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerChannels)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ChannelAdapter(channels)
    }

    data class Channel(
        val number: Int,
        val name: String
    )

    private class ChannelAdapter(
        private val channels: List<Channel>
    ) : RecyclerView.Adapter<ChannelAdapter.ChannelViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_channel, parent, false)
            return ChannelViewHolder(view)
        }

        override fun onBindViewHolder(holder: ChannelViewHolder, position: Int) {
            val channel = channels[position]
            holder.channelNumber.text = channel.number.toString()
            holder.channelName.text = channel.name
        }

        override fun getItemCount(): Int = channels.size

        private class ChannelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val channelNumber: TextView = itemView.findViewById(R.id.channelNumber)
            val channelName: TextView = itemView.findViewById(R.id.channelName)
        }
    }
}
