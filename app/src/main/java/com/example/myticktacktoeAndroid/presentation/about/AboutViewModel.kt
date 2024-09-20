package com.example.myticktacktoeAndroid.presentation.game
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myticktacktoeAndroid.presentation.about.AboutState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.example.myticktacktoeAndroid.BuildConfig

@HiltViewModel
class AboutViewModel @Inject constructor(): ViewModel() {

    private val aboutLiveData: MutableLiveData<AboutState> = MutableLiveData()

    fun getAboutLiveData(): LiveData<AboutState> {
        return aboutLiveData
    }

    init{
        aboutLiveData.setValue(
            AboutState(
                buildVersion = BuildConfig.VERSION_NAME
            )
        )
    }
}