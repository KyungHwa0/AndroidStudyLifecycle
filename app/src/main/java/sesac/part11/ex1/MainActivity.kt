package sesac.part11.ex1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.VideoView

class MainActivity : AppCompatActivity() {

    var count = 0
    lateinit var editView: EditText
    lateinit var countView: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countView = findViewById(R.id.countView)
        val button = findViewById<Button>(R.id.button)
        editView = findViewById(R.id.edit)

        button.setOnClickListener {
            count ++
            countView.text = "$count"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
        outState.putString("edit", editView.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt("count")
        countView.setText("$count")
        editView.setText(savedInstanceState.getString("edit"))
    }
}