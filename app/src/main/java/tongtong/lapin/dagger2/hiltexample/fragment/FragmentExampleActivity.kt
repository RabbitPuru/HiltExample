package tongtong.lapin.dagger2.hiltexample.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import tongtong.lapin.dagger2.hiltexample.R
import tongtong.lapin.dagger2.hiltexample.fragment.fragments.ExampleFragment
import tongtong.lapin.dagger2.hiltexample.fragment.viewmodel.FragmentExampleViewModel

@AndroidEntryPoint
class FragmentExampleActivity : AppCompatActivity() {
    private val viewModel: FragmentExampleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_example)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.first_player, ExampleFragment.newInstance(1))
            replace(R.id.second_player, ExampleFragment.newInstance(2))
            commitAllowingStateLoss()
        }

        viewModel.scoreResult.observe(this) {
            findViewById<TextView>(R.id.text_result).text = getString(
                R.string.fragment_example_result_text,
                it.player1,
                it.player2,
                if (it.player1 > it.player2) 1 else 2
            )
        }
    }
}


