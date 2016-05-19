package shapiro.mco364.tictactoe;

import java.util.List;
import java.util.Stack;

import shapiro.mco364.tictactoe.Board.Piece;

public class EnumerateBoards {

	public static void main(String[] args) {
		Board emptyBoard = new Board();
		int counter = 0;
		int xWinner = 0;
		int oWinner = 0;
		int ties = 0;

		Stack<Board> stack = new Stack<Board>();
		stack.push(emptyBoard);

		while (!stack.isEmpty()) {
			Board board = stack.pop();
			counter++;

			Piece winner = board.getWinner();
			if (winner != null) {
				if (winner == Piece.X) {
					xWinner++;
					continue;
				} else if (winner == Piece.O) {
					oWinner++;
					continue;
				}
			}

			List<Integer> posMoves = board.moves();

			if (posMoves.size() == 0) {
				ties++;
				continue;
			}

			for (Integer i : posMoves) {
				Board newBoard = new Board(board);
				newBoard.set(i, board.getActivePlayer());
				stack.push(new Board(newBoard));
			}
		}

		System.out.println("Possible boards: " + counter);
		System.out.println("X wins: " + xWinner);
		System.out.println("O wins: " + oWinner);
		System.out.println("Ties: " + ties);
		System.out.println("Leaves: " + (xWinner + oWinner + ties));

	}

}
