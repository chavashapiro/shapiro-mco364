package shapiro.mco364.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {

	public enum Piece {
		X, O, EMPTY
	}

	private Piece[] array = new Piece[9];
	private Piece activePlayer;

	public Board() {
		for (int i = 0; i < array.length; i++) {
			array[i] = Piece.EMPTY;
		}

		activePlayer = Piece.X;
	}

	public Board(Board other) {
		array = other.array.clone();
		activePlayer = other.activePlayer;
	}

	public Piece getWinner() {
		if (array[0] != Piece.EMPTY && array[0] == array[4] && array[4] == array[8]) {
			return array[0];
		} else if (array[2] != Piece.EMPTY && array[2] == array[4] && array[4] == array[6]) {
			return array[2];
		} else if (array[0] != Piece.EMPTY && array[0] == array[1] && array[1] == array[2]) {
			return array[0];
		} else if (array[3] != Piece.EMPTY && array[3] == array[4] && array[4] == array[5]) {
			return array[3];
		} else if (array[6] != Piece.EMPTY && array[6] == array[7] && array[7] == array[8]) {
			return array[6];
		} else if (array[0] != Piece.EMPTY && array[0] == array[3] && array[3] == array[6]) {
			return array[0];
		} else if (array[1] != Piece.EMPTY && array[1] == array[4] && array[4] == array[7]) {
			return array[1];
		} else if (array[2] != Piece.EMPTY && array[2] == array[5] && array[5] == array[8]) {
			return array[2];
		} else {
			return null;
		}
	}

	public void set(int index, Piece piece) {
		array[index] = piece;
		setActivePlayer(piece == Piece.X ? Piece.O : Piece.X);
	}

	public Piece getActivePlayer() {
		return activePlayer;
	}

	public void setActivePlayer(Piece activePlayer) {
		this.activePlayer = activePlayer;
	}

	public List<Integer> moves() {
		List<Integer> moves = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			if (array[i] == Piece.EMPTY) {
				moves.add(i);
			}
		}

		return moves;
	}

	public Piece get(int index) {
		return array[index];
	}

	public boolean isFull() {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == Piece.EMPTY) {
				return false;
			}
		}

		return true;
	}

	public String toString() {
		return array[0].name() + array[1].name() + array[2].name() + "\n" + array[3].name() + array[4].name()
				+ array[5].name() + "\n" + array[6].name() + array[7].name() + array[8].name();
	}
}
