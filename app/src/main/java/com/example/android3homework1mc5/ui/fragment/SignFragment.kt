package com.example.android3homework1mc5.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android3homework1mc5.R
import com.example.android3homework1mc5.databinding.FragmentSignBinding
import com.example.android3homework1mc5.ui.viewmodels.SignModel

class SignFragment : Fragment() {

    private lateinit var viewModel: SignModel
    private var _binding: FragmentSignBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(SignModel::class.java)

        binding.btnSave.setOnClickListener {
            val username = binding.etName.text.toString()
            val age = binding.etAge.text.toString().toInt()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            viewModel.registerUser(username, age, email, password)

            findNavController().navigate(R.id.action_signFragment_to_homeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}