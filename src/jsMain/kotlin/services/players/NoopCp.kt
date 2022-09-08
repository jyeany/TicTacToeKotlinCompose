package services.players

import services.MoveModel

class NoopCp : IComputerPlayer {

    override fun makeMove(gameBoard: Array<CharArray>): MoveModel {
        return MoveModel(0, 0, '-')
    }

}