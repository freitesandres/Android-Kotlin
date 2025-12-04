package com.freites.superandroidmaster.sintaxis.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.freites.superandroidmaster.databinding.ItemSuperheroBinding

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(
        superheroItemResponse: SuperheroItemResponse,
        onItemSelected: (String) -> Unit
    ) {
        // Nombre
        binding.tvSuperheroName.text = superheroItemResponse.name

        // Imagen con Glide
        Glide.with(binding.ivSuperhero.context)
            .load(superheroItemResponse.superheroImage.url)
            .into(binding.ivSuperhero)

        // Click
        binding.root.setOnClickListener {
            onItemSelected(superheroItemResponse.superheroId)
        }
    }
}
