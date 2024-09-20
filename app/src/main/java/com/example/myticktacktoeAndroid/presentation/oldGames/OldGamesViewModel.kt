package com.example.myticktacktoeAndroid.presentation.game


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myticktacktoeAndroid.data.models.OldGame
import com.example.myticktacktoeAndroid.domain.usecases.GetOldGamesUseCase
import com.example.myticktacktoeAndroid.presentation.oldGames.OldGamesState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject

@HiltViewModel
class OldGamesViewModel @Inject constructor(
    private val getOldGamesUseCase: GetOldGamesUseCase
): ViewModel() {

    private val disposables: CompositeDisposable = CompositeDisposable()
    private val oldGamesLiveData: MutableLiveData<OldGamesState> = MutableLiveData()

    fun getOldGamesLiveData(): LiveData<OldGamesState> {
        return oldGamesLiveData
    }

    init{
        initState()
    }


    private fun initState(){
        val disposable: Disposable = getOldGamesUseCase()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { oldGamesLiveData.setValue(
                OldGamesState(it)
            ) }
        disposables.add(disposable)
    }
}