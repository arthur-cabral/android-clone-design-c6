package com.example.projectdesignc6.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.projectdesignc6.R
import com.example.projectdesignc6.databinding.FragmentRegisterBinding
import com.example.projectdesignc6.model.UserModel
import com.example.projectdesignc6.viewmodel.RegisterViewModel

class RegisterFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.buttonRegister.setOnClickListener(this)

        return root
    }

    override fun onClick(v: View?) {
        if (v != null) {
            if (v.id == binding.buttonRegister.id) {
                val name = binding.editName.text.toString()
                val email = binding.editEmail.text.toString()
                val cpf = binding.editCpf.text.toString()
                val password = binding.editPassword.text.toString()

                val model = UserModel(0, name, email, cpf, password)
                viewModel.registerUser(model)
                Toast.makeText(context, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
                val transaction = activity?.supportFragmentManager?.beginTransaction()
                transaction?.replace(R.id.container_register_form_activity, AppFragment())
                transaction?.commit()
            }

            else if (v.id == binding.textLogin.id) {
                val transaction = activity?.supportFragmentManager?.beginTransaction()
                transaction?.replace(R.id.container_register_form_fragment, LoginFragment())
                transaction?.commit()
            }
        }
    }
}