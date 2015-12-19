package nz.bradcampbell.fourletters.redux.state

import android.support.annotation.LayoutRes
import nz.bradcampbell.dataparcel.DataParcel
import nz.bradcampbell.fourletters.R

@DataParcel
data class State(val paginationState: PaginationState = PaginationState(),
                 val gameState: GameState? = null,
                 val menuState: MenuState = MenuState())

data class PaginationState(val currentPage: Page = Page(R.layout.menu),
                      val history: List<Page> = listOf<Page>())

data class GameState(val answer: List<Letter> = emptyList(),
                val leftLetter: Letter,
                val topLetter: Letter,
                val rightLetter: Letter,
                val bottomLetter: Letter,
                val possibleAnswers: List<String>,
                val score: Int = 0,
                val finishTime: Long)

data class MenuState(val wordErrorDisplayed: Boolean = false)

data class Page(@LayoutRes var layoutId: Int)

public enum class Position(val index: Int) {
    LEFT(0),
    TOP(1),
    RIGHT(2),
    BOTTOM(3);

    companion object {
        public fun from(index: Int): Position {
            for (position in values()) {
                if (position.index == index) {
                    return position
                }
            }
            return LEFT
        }
    }
}

public data class Letter(val position: Position, val letter: Char)
