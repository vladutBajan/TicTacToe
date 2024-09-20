package com.example.myticktacktoeAndroid.presentation.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myticktacktoeAndroid.data.repositories.UserRepository
import com.example.myticktacktoeAndroid.domain.usecases.InitGameUseCase
import com.example.myticktacktoeAndroid.domain.usecases.ResetScoreUseCase
import com.example.myticktacktoeAndroid.domain.usecases.UserTappedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val initGameUseCase: InitGameUseCase,
    private val userTappedUseCase: UserTappedUseCase,
    private val resetScoreUseCase: ResetScoreUseCase
    ): ViewModel() {

    private val disposables: CompositeDisposable = CompositeDisposable()
    private val gameLiveData: MutableLiveData<GameState> = MutableLiveData()

    fun getGameLiveData(): LiveData<GameState> {
        return gameLiveData
    }

    init{
        initState()
    }


    private fun initState(){
            val disposable: Disposable = initGameUseCase()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    gameLiveData.setValue(
                        GameState(
                            userRepository.getPlayer1Name(),
                            userRepository.getPlayer2Name(),
                            it.player1GamesWon,
                            it.player2GamesWon,
                            it.playerToGo(),
                            it.isGameFinished(),
                            it.board
                        )
                    )
                }
            disposables.add(disposable)
    }

    fun onUserTapped(row: Int, column: Int){
        val disposable: Disposable =
            userTappedUseCase(row, column).observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                gameLiveData.setValue(
                    GameState(
                        userRepository.getPlayer1Name(),
                        userRepository.getPlayer2Name(),
                        it.player1GamesWon,
                        it.player2GamesWon,
                        it.playerToGo(),
                        it.isGameFinished(),
                        it.board
                    )
                )
            }
        disposables.add(disposable)

    }

    fun restart() {
        val disposable: Disposable =
            initGameUseCase().observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    gameLiveData.setValue(
                        GameState(
                            userRepository.getPlayer1Name(),
                            userRepository.getPlayer2Name(),
                            it.player1GamesWon,
                            it.player2GamesWon,
                            it.playerToGo(),
                            it.isGameFinished(),
                            it.board
                        )
                    )
                }
        disposables.add(disposable)
    }

    fun resetScore(){
        val disposable: Disposable = resetScoreUseCase().observeOn(AndroidSchedulers.mainThread()).subscribe()
        disposables.add(disposable)
    }

}