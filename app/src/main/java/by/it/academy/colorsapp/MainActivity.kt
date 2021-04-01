package by.it.academy.colorsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    companion object {
        val colorsList = mutableListOf(
            Color("IndianRed", "#CD5C5C"),
            Color("LightCoral", "#F08080"),
            Color("Salmon", "#FA8072"),
            Color("DarkSalmon", "#E9967A"),
            Color("LightSalmon", "#FFA07A"),
            Color("Crimson", "#DC143C"),
            Color("Red", "#FF0000"),
            Color("FireBrick", "#B22222"),
            Color("DarkRed", "#8B0000"),
            Color("Pink", "#FFC0CB"),
            Color("LightPink", "#FFB6C1"),
            Color("HotPink", "#FF69B4"),
            Color("DeepPink", "#FF1493"),
            Color("MediumVioletRed", "#C71585"),
            Color("PaleVioletRed", "#DB7093"),
            Color("Coral", "#FF7F50"),
            Color("Tomato", "#FF6347"),
            Color("OrangeRed", "#FF4500"),
            Color("DarkOrange", "#FF8C00"),
            Color("Orange", "#FFA500"),
            Color("Gold", "#FFD700"),
            Color("Yellow", "#FFFF00"),
            Color("LightYellow", "#FFFFE0"),
            Color("LemonChiffon", "#FFFACD"),
            Color("LightGoldenrodYellow", "#FAFAD2"),
            Color("PapayaWhip", "#FFEFD5"),
            Color("Moccasin", "#FFE4B5"),
            Color("PeachPuff", "#FFDAB9"),
            Color("PaleGoldenrod", "#EEE8AA"),
            Color("Khaki", "#F0E68C"),
            Color("DarkKhaki", "#BDB76B"),
            Color("Lavender", "#E6E6FA"),
            Color("Thistle", "#D8BFD8"),
            Color("Plum", "#DDA0DD"),
            Color("Violet", "#EE82EE"),
            Color("Orchid", "#DA70D6"),
            Color("Fuchsia", "#FF00FF"),
            Color("MediumOrchid", "#BA55D3"),
            Color("MediumPurple", "#9370DB"),
            Color("BlueViolet", "#8A2BE2"),
            Color("DarkViolet", "#9400D3"),
            Color("DarkOrchid", "#9932CC"),
            Color("DarkMagenta", "#8B008B"),
            Color("Purple", "#800080"),
            Color("Indigo", "#4B0082"),
            Color("SlateBlue", "#6A5ACD"),
            Color("DarkSlateBlue", "#483D8B"),
            Color("Cornsilk", "#FFF8DC"),
            Color("BlanchedAlmond", "#FFEBCD"),
            Color("Bisque", "#FFE4C4"),
            Color("NavajoWhite", "#FFDEAD"),
            Color("Wheat", "#F5DEB3"),
            Color("BurlyWood", "#DEB887"),
            Color("Tan", "#D2B48C"),
            Color("RosyBrown", "#BC8F8F"),
            Color("SandyBrown", "#F4A460"),
            Color("Goldenrod", "#DAA520"),
            Color("DarkGoldenRod", "#B8860B"),
            Color("Peru", "#CD853F"),
            Color("Chocolate", "#D2691E"),
            Color("SaddleBrown", "#8B4513"),
            Color("Sienna", "#A0522D"),
            Color("Brown", "#A52A2A"),
            Color("Maroon", "#800000"),
            Color("GreenYellow", "#ADFF2F"),
            Color("Chartreuse", "#7FFF00"),
            Color("LawnGreen", "#7CFC00"),
            Color("Lime", "#00FF00"),
            Color("LimeGreen", "#32CD32"),
            Color("PaleGreen", "#98FB98"),
            Color("LightGreen", "#90EE90"),
            Color("MediumSpringGreen", "#00FA9A"),
            Color("SpringGreen", "#00FF7F"),
            Color("MediumSeaGreen", "#3CB371"),
            Color("SeaGreen", "#2E8B57"),
            Color("ForestGreen", "#228B22"),
            Color("Green", "#008000"),
            Color("DarkGreen", "#006400"),
            Color("YellowGreen", "#9ACD32"),
            Color("OliveDrab", "#6B8E23"),
            Color("Olive", "#808000"),
            Color("DarkOliveGreen", "#556B2F"),
            Color("MediumAquamarine", "#66CDAA"),
            Color("DarkSeaGreen", "#8FBC8F"),
            Color("LightSeaGreen", "#20B2AA"),
            Color("DarkCyan", "#008B8B"),
            Color("Teal", "#008080"),
            Color("Cyan", "#00FFFF"),
            Color("LightCyan", "#E0FFFF"),
            Color("PaleTurquoise", "#AFEEEE"),
            Color("Aquamarine", "#7FFFD4"),
            Color("Turquoise", "#40E0D0"),
            Color("MediumTurquoise", "#48D1CC"),
            Color("DarkTurquoise", "#00CED1"),
            Color("CadetBlue", "#5F9EA0"),
            Color("SteelBlue", "#4682B4"),
            Color("LightSteelBlue", "#B0C4DE"),
            Color("PowderBlue", "#B0E0E6"),
            Color("LightBlue", "#ADD8E6"),
            Color("SkyBlue", "#87CEEB"),
            Color("LightSkyBlue", "#87CEFA"),
            Color("DeepSkyBlue", "#00BFFF"),
            Color("DodgerBlue", "#1E90FF"),
            Color("CornflowerBlue", "#6495ED"),
            Color("MediumSlateBlue", "#7B68EE"),
            Color("RoyalBlue", "#4169E1"),
            Color("Blue", "#0000FF"),
            Color("MediumBlue", "#0000CD"),
            Color("DarkBlue", "#00008B"),
            Color("Navy", "#000080"),
            Color("MidnightBlue", "#191970"),
            Color("White", "#FFFFFF"),
            Color("Snow", "#FFFAFA"),
            Color("Honeydew", "#F0FFF0"),
            Color("MintCream", "#F5FFFA"),
            Color("Azure", "#F0FFFF"),
            Color("AliceBlue", "#F0F8FF"),
            Color("GhostWhite", "#F8F8FF"),
            Color("WhiteSmoke", "#F5F5F5"),
            Color("Seashell", "#FFF5EE"),
            Color("Beige", "#F5F5DC"),
            Color("OldLace", "#FDF5E6"),
            Color("FloralWhite", "#FFFAF0"),
            Color("Ivory", "#FFFFF0"),
            Color("AntiqueWhite", "#FAEBD7"),
            Color("Linen", "#FAF0E6"),
            Color("LavenderBlush", "#FFF0F5"),
            Color("MistyRose", "#FFE4E1"),
            Color("Gainsboro", "#DCDCDC"),
            Color("LightGrey", "#D3D3D3"),
            Color("Silver", "#C0C0C0"),
            Color("DarkGrey", "#A9A9A9"),
            Color("Grey", "#808080"),
            Color("DimGrey", "#696969"),
            Color("LightSlateGrey", "#778899"),
            Color("SlateGrey", "#708090"),
            Color("DarkSlateGrey", "#2F4F4F"),
            Color("Black", "#000000")
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainFragment = MainFragment()
        val handbookFragment = HandbookFragment()
        val quizFragment = QuizFragment()

        setCurrentFragment(mainFragment)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_home -> setCurrentFragment(mainFragment)
                R.id.ic_guide -> setCurrentFragment(handbookFragment)
                R.id.ic_quiz -> setCurrentFragment(quizFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }

}