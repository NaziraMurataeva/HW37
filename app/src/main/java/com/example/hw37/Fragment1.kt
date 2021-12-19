package com.example.hw37

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hw37.databinding.ActivityMainBinding
import com.example.hw37.databinding.FragmentABinding

class Fragment1 : Fragment(R.layout.fragment_a), EditTextSet {
     lateinit var binding: FragmentABinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


     binding = FragmentABinding.inflate(inflater,container,false)
        return binding.root
    }

    private lateinit var listener: FragmentAListener

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textFromArgument = arguments?.getString("string")

        binding.text1.text = textFromArgument

        binding.btnFrag.setOnClickListener {
            listener.showToast()
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentAListener) listener = context
    }
    companion object{
        const val TAG = "A"
    }

    override fun setTextToFragment() {
        TODO("Not yet implemented")
    }


}
