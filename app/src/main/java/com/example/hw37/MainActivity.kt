package com.example.hw37

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.hw37.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FragmentAListener {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }
    private fun setup() {
       binding.button.setOnClickListener {
           val text = binding.etText.text.toString()
           val fragment =Fragment1()
           val args = Bundle()
           args.putString("string",text)
           fragment.arguments = args

           supportFragmentManager
               .beginTransaction()
               .add(R.id.fragment_container,fragment,Fragment1.TAG)
               .commit()
       }
    }
    override fun showToast() {
        Toast.makeText(this, "Fragment A told me to do this",Toast.LENGTH_LONG).show()
    }
}