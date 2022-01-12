package tongtong.lapin.dagger2.hiltexample.basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import tongtong.lapin.dagger2.hiltexample.R
import tongtong.lapin.dagger2.hiltexample.basic.viewmodel.ExampleViewModel
import javax.inject.Inject

@AndroidEntryPoint
class BasicActivity : AppCompatActivity() {
    private val viewModel : ExampleViewModel by viewModels()
    @Inject
    lateinit var exampleModel: ActivityExampleModel // Annotation "Inject" cannot be with "private"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)

        findViewById<TextView>(R.id.sample_text_1).text = viewModel.getSingletonExampleValue()
        findViewById<TextView>(R.id.sample_text_2).text = exampleModel.getValue()
        findViewById<TextView>(R.id.sample_text_3).text = viewModel.getViewModelExampleValue()
    }
}