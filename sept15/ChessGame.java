package sept15;

import java.util.Scanner;

public class ChessGame {
	public static void main (String[] args){
		Scanner scanner = new Scanner(System.in);
		int configNum = scanner.nextInt();
		while (configNum > 0){
			int chessNum = scanner.nextInt();
			while (chessNum > 0){
				String[] elements = new String[3];
				String line = scanner.next();
				elements[0] = line;
				line = scanner.next();
				elements[1] = line;
				line = scanner.next();
				elements[2] = line;
				Piece piece = new Piece(Integer.parseInt(elements[1]), Integer.parseInt(elements[2]), elements[0].charAt(0));
				// get if the piece is threatened
				System.out.println(piece.type+" "+piece.x+" "+piece.y);
				chessNum--;
			}
			configNum--;
		}
		System.out.println("END OF OUTPUT");
	}
}
