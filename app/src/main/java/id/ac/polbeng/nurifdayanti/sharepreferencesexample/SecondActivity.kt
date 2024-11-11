package id.ac.polbeng.nurifdayanti.sharepreferencesexample

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.ac.polbeng.nurifdayanti.sharepreferencesexample.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ganti nama file sesuai kebutuhan
        val filename = "$packageName TESTFILE"
        val pref = getSharedPreferences(filename, Context.MODE_PRIVATE)

        binding.btnLoad.setOnClickListener {
            val firstName = pref.getString("firstName", "No First Name")
            val lastName = pref.getString("lastName", "No Last Name")
            binding.tvOutput.text = "$firstName $lastName"
        }
    }

    override fun onResume() {
        super.onResume()
        binding.tvOutput.text = "Click Button Load Data"
    }
}