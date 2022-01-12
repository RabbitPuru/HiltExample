package tongtong.lapin.dagger2.hiltexample.fragment.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FragmentExampleViewModel @Inject constructor() : ViewModel() {
    val player1Score = MutableLiveData<Int>()
    val player2Score = MutableLiveData<Int>()
    val scoreResult = MediatorLiveData<ScoreResult>().apply {
        addSource(player1Score) { score ->
            value = ScoreResult(score, player2Score.value ?: 0)
        }
        addSource(player2Score) { score ->
            value = ScoreResult(player1Score.value ?: 0, score)
        }
    }

    fun addPlayer1Score() {
        player1Score.postValue(player1Score.value?.let { it + 1 } ?: 1)
    }

    fun addPlayer2Score() {
        player2Score.postValue(player2Score.value?.let { it + 1 } ?: 1)
    }

    data class ScoreResult(val player1: Int, val player2: Int)
}