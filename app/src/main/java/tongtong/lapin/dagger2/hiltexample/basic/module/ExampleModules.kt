package tongtong.lapin.dagger2.hiltexample.basic

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class) // For all components
class SingletonExampleModule {
    @Provides
    fun provideExampleModel() = SingletonExampleModel()
}

@Module
@InstallIn(ActivityComponent::class) // For Activities and Fragments
class ActivityExampleModule {
    @Provides
    fun provideExampleModel() = ActivityExampleModel()
}

@Module
@InstallIn(ViewModelComponent::class) // For ViewModels
class ViewModelExampleModule {
    @Provides
    fun provideExampleModel() = ViewModelExampleModel()
}