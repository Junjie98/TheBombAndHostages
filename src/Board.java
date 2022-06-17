import java.util.ArrayList;

public class Board {
    
    private int rows; //x
    private int columns; //y
    private Square[][] gameBoard = new Square[0][0]; //initiate an empty square of array.

    public Board(int rows, int columns){ //constructor to build the size of the board.
        this.rows = rows;
        this.columns = columns;
    }

    public void createBoard(){
        Square[][] buildBoard = new Square[rows][columns];
		gameBoard = buildBoard;
		//int boardValue = 0; //gets the total number needed for board
		
		for(int i=0; i<rows; i++) { 
			for(int j=0; j<columns; j++) {		
                gameBoard[i][j]	= new Square(false);
			}
		}
    }

    public void initiateBombSearch(ArrayList<Pair<Integer, Integer>> coordsPairs){
        int valueXCoords;
        int valueYCoords;
        for(int i = 0; i<coordsPairs.size(); i++){
            // coordsPairs.get(i).getFirst();
            // coordsPairs.get(i).getSecond();
            gameBoard[coordsPairs.get(i).getFirst()][coordsPairs.get(i).getSecond()].setSquareBomb(true);
        }
    }

    public String toString() { //toString method to print out the Board object.
		String output = "";
		for(int i=0; i<rows; i++) {
			for(int j=0; j<columns;j++) {
				output += gameBoard[i][j].toString();
			}
			output += "\n";
		}
		return output;
	}

    public static void main(String[] args){
        Board playBoard = new Board(20,20);
        playBoard.createBoard();
        System.out.println(playBoard);
        Read readBombs = new Read("bombs.txt");
        ArrayList <Pair<Integer,Integer>> coordsPairList = new ArrayList <>();
        //coordsPairList = readBombs.readCordinate();
        playBoard.initiateBombSearch(readBombs.readCordinate());
        System.out.println(playBoard);
    }

}
