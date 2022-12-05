package com.example.migraineapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


class CriseListAdapter : ListAdapter<Crise, CriseListAdapter.CriseViewHolder>(CrisesComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CriseViewHolder {
        return CriseViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CriseViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class CriseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val dateItemView: TextView = itemView.findViewById(R.id.dateTextView)
        private val intensiteItemView: TextView = itemView.findViewById(R.id.intensiteTextView)
        private val ainsItemView: TextView = itemView.findViewById(R.id.ainsTextView)
        private val triptansItemView: TextView = itemView.findViewById(R.id.triptansTextView)
        private val traitementDeFondItemView: TextView = itemView.findViewById(R.id.traitementsDeFondTextView)
        private val observationsItemView: TextView = itemView.findViewById(R.id.observationsTextView)

        fun bind(crise: Crise?) {
            if (crise != null) {
                dateItemView.text = crise.date
                intensiteItemView.text = crise.intensite
                ainsItemView.text = crise.ains
                triptansItemView.text = crise.triptans
                traitementDeFondItemView.text = crise.traitement
                observationsItemView.text = crise.observations
            }
        }


        companion object {
            fun create(parent: ViewGroup): CriseViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return CriseViewHolder(view)
            }
        }
    }

    class CrisesComparator : DiffUtil.ItemCallback<Crise>() {
        override fun areItemsTheSame(oldItem: Crise, newItem: Crise): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Crise, newItem: Crise): Boolean {
            return oldItem.date == newItem.date
        }
    }
}

