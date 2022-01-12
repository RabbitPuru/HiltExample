package tongtong.lapin.dagger2.hiltexample.fragment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import tongtong.lapin.dagger2.hiltexample.R
import tongtong.lapin.dagger2.hiltexample.fragment.viewmodel.FragmentExampleViewModel

@AndroidEntryPoint
class ExampleFragment : Fragment() {
    private val viewModel: FragmentExampleViewModel by activityViewModels() // Shared with Activity

    private var playerNum: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        playerNum = arguments?.getInt(PLAYER_NUM)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_example, container, false).apply {
            initView(findViewById(R.id.score), findViewById(R.id.action), playerNum)
        }
    }

    private fun initView(textView: TextView, button: Button, playerNum: Int?) {
        if (playerNum == 1) {
            viewModel.player1Score.observe(this) {
                textView.text = it.toString()
            }

            button.setOnClickListener {
                viewModel.addPlayer1Score()
            }
        } else {
            viewModel.player2Score.observe(this) {
                textView.text = it.toString()
            }
            button.setOnClickListener {
                viewModel.addPlayer2Score()
            }
        }
    }

    companion object {
        private const val PLAYER_NUM = "PLAYER_NUM"

        @JvmStatic
        fun newInstance(playerNum: Int) = ExampleFragment().apply {
            arguments = Bundle().apply {
                putInt(PLAYER_NUM, playerNum)
            }
        }
    }
}