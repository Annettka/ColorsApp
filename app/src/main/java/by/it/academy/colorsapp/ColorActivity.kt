package by.it.academy.colorsapp

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class ColorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)
        val linearLayout = findViewById<LinearLayout>(R.id.certain_color)
        val colorHexCode = findViewById<TextView>(R.id.certain_color_hexCode)
        val copyButton = findViewById<Button>(R.id.copy_button)
        copyButton.setOnClickListener {
            val message = "Text is copied"
            val toast = Toast.makeText(applicationContext, message, Toast.LENGTH_LONG)
            toast.setGravity(Gravity.BOTTOM, 0, 0)
            toast.show()
            val stringYouExtracted = colorHexCode.text
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Copied Text", stringYouExtracted)
            clipboard.setPrimaryClip(clip)
        }

        if (intent.hasExtra("color")) {
            val color = intent.getStringExtra("color")
            if (intent.getStringExtra("color") == "#000000")
                colorHexCode.setTextColor(Color.WHITE)
            else colorHexCode.setTextColor(Color.BLACK)
            colorHexCode.text = intent.getStringExtra("color")
            linearLayout.setBackgroundColor(Color.parseColor(intent.getStringExtra("color")))
        }
    }
}