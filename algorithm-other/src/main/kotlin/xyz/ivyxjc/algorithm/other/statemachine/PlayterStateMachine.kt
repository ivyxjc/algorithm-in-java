package xyz.ivyxjc.algorithm.other.statemachine

import java.util.*

val STATE_PLAYING = 1
val STATE_PAUSED = 2
val STATE_STOPPED = 3
val STATE_AD = 4

interface IPlayer {
    fun request(flag: Int)

    fun setState(state: PlayerState)

    fun playVedio()

    fun pause()

    fun stop()

    fun showAD()
}

class VideoPlayer : IPlayer {
    var playerState: PlayerState = StoppedState(this)
    override fun request(flag: Int) {
        println("before action: ${playerState.toString()}")
        playerState.handler(flag)
        println("after action: ${playerState.toString()}")
    }

    override fun setState(state: PlayerState) {
        playerState = state
    }

    override fun playVedio() {
        println("play video!")
    }

    override fun pause() {
        println("pause video!")
    }

    override fun stop() {
        println("stop video!")
    }

    override fun showAD() {
        println("show ad!")
    }
}


abstract class PlayerState(val player: IPlayer) {
    companion object {
        val PLAY_OF_PAUSE = 0
        val STOP = 1
        val SHOW_AD = 2
    }

    abstract fun handler(action: Int)

    override fun toString(): String {
        return "current state: ${this::class.java.simpleName}"
    }
}

class StoppedState(player: IPlayer) : PlayerState(player) {
    override fun handler(action: Int) {
        when (action) {
            PLAY_OF_PAUSE -> {
                player.playVedio()
                player.setState(PlayingState(player))
            }
            else -> {
                throw IllegalArgumentException("ERROR Action: $action, current state: ${this::class.java.simpleName}")
            }
        }
    }
}

class PlayingState(player: IPlayer) : PlayerState(player) {
    override fun handler(action: Int) {
        when (action) {
            PLAY_OF_PAUSE -> {
                player.pause()
                player.setState(PlayingState(player))
            }
            STOP -> player.stop()
            SHOW_AD -> {
                player.showAD()
                player.setState(ShowAdState(player))
            }
            else -> {
                throw IllegalArgumentException("ERROR Action: $action, current state: ${this::class.java.simpleName}")
            }
        }

    }

}

class PauseState(player: IPlayer) : PlayerState(player) {
    override fun handler(action: Int) {
        when (action) {
            PLAY_OF_PAUSE -> {
                player.playVedio()
                player.setState(PlayingState(player))
            }
            STOP -> {
                player.stop()
                player.setState(StoppedState(player))
            }

            else -> {
                throw IllegalArgumentException("ERROR Action: $action, current state: ${this::class.java.simpleName}")
            }
        }
    }
}


class ShowAdState(player: IPlayer) : PlayerState(player) {

    override fun handler(action: Int) {
        when (action) {
            PLAY_OF_PAUSE -> {
                player.playVedio()
                player.setState(PlayingState(player))
            }
            else -> {
                throw IllegalArgumentException("ERROR Action: $action, current state: ${this::class.java.simpleName}")
            }

        }
    }
}

fun main() {
    val scnner = Scanner(System.`in`)
    val player = VideoPlayer()
    var i = -1
    do {
        i = scnner.nextInt()
        player.request(i)
    } while (true)

}

