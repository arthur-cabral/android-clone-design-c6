package com.example.projectdesignc6.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.projectdesignc6.R
import com.example.projectdesignc6.databinding.FragmentRegisterBinding
import com.example.projectdesignc6.viewmodel.LoginViewModel

class LoginFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)

        val root: View = binding.root

        binding.buttonRegister.setOnClickListener(this)

        return root
    }

    override fun onClick(v: View?) {
        if (v != null) {
            if (v.id == binding.textRegister.id) {
                val transaction = activity?.supportFragmentManager?.beginTransaction()
                transaction?.replace(R.id.container_register_form_fragment, RegisterFragment())
                transaction?.commit()
            }
        }
    }
}