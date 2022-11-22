package com.example.projectdesignc6.views

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.projectdesignc6.databinding.FragmentAppBinding
import com.example.projectdesignc6.viewmodel.AppViewModel

class AppFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentAppBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val viewModel = ViewModelProvider(this).get(AppViewModel::class.java)

        _binding = FragmentAppBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.buttonProfile.setOnClickListener(this)

        val textViewBalance: TextView = binding.textBalanceValue
        viewModel.textBalance.observe(viewLifecycleOwner) {
            textViewBalance.text = it
        }
        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View) {
        if (v.id == binding.buttonProfile.id) {
            val intent = Intent(this.context, RegisterFormActivity::class.java)
            startActivity(intent)
        }
    }
}

