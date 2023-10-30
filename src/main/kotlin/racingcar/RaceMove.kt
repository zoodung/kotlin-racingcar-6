package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RaceMove (val moveChanceNumber: MutableList<Int> = mutableListOf()) {
    fun getMoveNumber(racerNameSize: Int) {
        for(i in INITIALIZATION until racerNameSize){
            val moveDecisionNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_MINIMUM, RANDOM_NUMBER_MAXIMUM)
            moveChanceNumber.add(judgeMoveOrStop(moveDecisionNumber))
        }
    }

    private fun judgeMoveOrStop(moveDecisionNumber: Int): Int {
        return when (moveDecisionNumber) {
            in STOP_MINIMUM..STOP_MAXIMUM -> STOP
            in MOVE_MINIMUM..MOVE_MAXIMUM -> MOVE
            else -> throw IllegalArgumentException(Message.MOVE_ERROR.messageText)
        }
    }
}