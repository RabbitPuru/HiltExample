package tongtong.lapin.dagger2.hiltexample.basic.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import tongtong.lapin.dagger2.hiltexample.basic.SingletonExampleModel
import tongtong.lapin.dagger2.hiltexample.basic.ViewModelExampleModel
import javax.inject.Inject

@HiltViewModel
class ExampleViewModel @Inject constructor(
    private val example1: SingletonExampleModel,
    private val example2: ViewModelExampleModel
) : ViewModel() {
    fun getSingletonExampleValue() = example1.getValue()
    fun getViewModelExampleValue() = example2.getValue()
}