package id.ac.polbeng.nurifdayanti.sharepreferencesexample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.ac.polbeng.nurifdayanti.sharepreferencesexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ganti nama file sesuai kebutuhan
        val filename = "$packageName TESTFILE"
        val pref = getSharedPreferences(filename, Context.MODE_PRIVATE)

        binding.btnSave.setOnClickListener {
            val editor = pref.edit()
            editor.putString("firstName", binding.etFirstName.text.toString())
            editor.putString("lastName", binding.etLastName.text.toString())
            editor.apply()
            Toast.makeText(this, "Saved Data!", Toast.LENGTH_LONG).show()
        }

        binding.btnLoad.setOnClickListener {
            val firstName = pref.getString("firstName", "")
            val lastName = pref.getString("lastName", "")
            val output = "$firstName $lastName"
            binding.etFirstName.setText(firstName)
            binding.etLastName.setText(lastName)
            binding.tvOutput.text = output
        }

        binding.btnSecondActivity.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        // Jika ingin mempertahankan data, hapus bagian ini
         binding.etFirstName.setText("")
        binding.etLastName.setText("")
         binding.tvOutput.text = ""
    }
}