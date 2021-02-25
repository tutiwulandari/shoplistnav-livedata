package com.example.learnnavigation.presentations

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.learnnavigation.utils.Items
import com.example.learnnavigation.components.LoadingDialog
import com.example.learnnavigation.databinding.FragmentAddItemBinding
import com.example.learnnavigation.models.AddItemFragmentViewModel
import com.example.learnnavigation.models.ItemViewModel
import com.example.learnnavigation.utils.ResourceStatus
import java.util.*


class AddItemFragment : Fragment() {
    private lateinit var sharedViewModel: ItemViewModel
    private lateinit var viewModel: AddItemFragmentViewModel
    lateinit var binding: FragmentAddItemBinding
    lateinit var loadingDialog: AlertDialog
    var items: Items? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        subscribe()
    }


    private fun initViewModel() {
        sharedViewModel = ViewModelProvider(requireActivity()).get(ItemViewModel::class.java)
        viewModel = ViewModelProvider(this).get(AddItemFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        loadingDialog = LoadingDialog.build(requireContext())
        binding = FragmentAddItemBinding.inflate(layoutInflater)
        binding.apply {
            etDate.setInputType(InputType.TYPE_NULL)
            etDate.setOnClickListener(View.OnClickListener {
                val datePickerDialog = activity?.let { it1 ->
                    DatePickerDialog(
                        it1, DatePickerDialog.OnDateSetListener
                        { view, year, monthOfYear, dayOfMonth ->
                            etDate.setText(
                                "$year/$monthOfYear/$dayOfMonth",
                                TextView.BufferType.EDITABLE
                            );
                        }, year, month, day
                    )
                }
                datePickerDialog?.show()
            })
            buttonadd.setOnClickListener {
                items = Items(
                    date = etDate.text.toString(),
                    name = etName.text.toString(),
                    quantity = etQty.text.toString(),
                    price = etPrice.text.toString()
                )
                viewModel.inputValidation(items!!)
            }
        }
        return binding.root
    }

    private fun subscribe() = viewModel.isValid.observe(this) {
        when (it.status) {
            ResourceStatus.LOADING -> {
                loadingDialog.show()
            }
            ResourceStatus.SUCCESS -> {
                sharedViewModel.addItem(items!!)
                loadingDialog.hide()
                clearInput()
                Toast.makeText(requireContext(), "data has been added", Toast.LENGTH_SHORT).show()
            }
            ResourceStatus.FAIL -> {
                loadingDialog.hide()
                Toast.makeText(
                    requireContext(),
                    it.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun clearInput() {
        binding.etDate.setText("")
        binding.etName.setText("")
        binding.etPrice.setText("")
        binding.etQty.setText("")
    }

}