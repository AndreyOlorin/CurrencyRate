package com.example.tt_exchangerate.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tt_exchangerate.R
import com.example.tt_exchangerate.databinding.ItemForExchangeBinding
import com.example.tt_exchangerate.domain.model.CurrencyDomain

class Adapter(
    private val onClickListener: CourseOnClickListener
) : ListAdapter<CurrencyDomain, Adapter.ViewHolder>(CurrencyDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemForExchangeBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            onClickListener.onClick(position)
        }
    }

    class ViewHolder(private val binding: ItemForExchangeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(currency: CurrencyDomain) {
            binding.apply {
                abbreviation.text = currency.abbreviationName
                decryption.text = currency.decryptionName
                courseNow.text = currency.courseNow.toString()
                courseLast.text = currency.courseLast.toString()
            }
        }
    }

    class CurrencyDiffCallback : DiffUtil.ItemCallback<CurrencyDomain>() {
        override fun areItemsTheSame(oldItem: CurrencyDomain, newItem: CurrencyDomain): Boolean =
            oldItem.abbreviationName == newItem.abbreviationName

        override fun areContentsTheSame(oldItem: CurrencyDomain, newItem: CurrencyDomain): Boolean =
            oldItem == newItem
    }
}