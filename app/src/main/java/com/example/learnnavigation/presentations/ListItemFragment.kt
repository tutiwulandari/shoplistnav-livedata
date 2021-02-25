package com.example.learnnavigation.presentations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.learnnavigation.models.ItemViewModel
import com.example.learnnavigation.R
import com.example.learnnavigation.utils.RecyclerAdapter
import com.example.learnnavigation.databinding.FragmentListItemBinding
import kotlinx.android.synthetic.main.fragment_list_item.*


class ListItemFragment : Fragment() {

    lateinit var viewModel: ItemViewModel
    lateinit var binding : FragmentListItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ItemViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListItemBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            val items = viewModel.getItem()
            adapter = RecyclerAdapter(items)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ListItemFragment()
    }
}