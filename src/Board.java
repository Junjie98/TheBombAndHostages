import java.util.ArrayList;

import handler.Pair;

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

    public void locateAndCalculateSmallestRectRegion(ArrayList<Pair<Integer, Integer>> coordsPairs){
        int highestY = 0;
        int lowestY = this.columns;
        int highestX = 0;
        int lowestX = this.rows;

        int valueX;
        int valueY;

        for(int i = 0; i<coordsPairs.size(); i++){
            valueX = coordsPairs.get(i).getFirst();
            valueY = coordsPairs.get(i).getSecond();

            if(valueX < lowestX){
                lowestX = valueX;
            }
            if(valueY < lowestY){
                lowestY = valueY ;
            }
            if(valueX > highestX){
                highestX = valueX;
            }
            if(valueY > highestY){
                highestY = valueY;
            }

            gameBoard[valueX][valueY].setSquareBomb(true); //set intel of located bomb into the map(square).
        }
        //to surround the bomb in a rectangular region.
        highestX +=1;
        highestY +=1;
        lowestX -=1;
        lowestY -=1;

        System.out.println("Blastwall Coords (x,y):" + lowestX + "," + lowestY + " and " + highestX+ "," + highestY);
        System.out.println("Blastwall Coords (x,y):" + lowestX + "," + highestY + " and " + highestX + "," + lowestY);
    }

    public void locatePeopleRequiredEvacuation(ArrayList<Pair<Integer, Integer>> peopleCoordsPairs,ArrayList<Pair<Integer, Integer>> bombCoordsPairs){
        for(Pair<Integer,Integer> p:peopleCoordsPairs){
            gameBoard[p.getFirst()][p.getSecond()].setPeopleAround(true);

            //find nearby bomb
            boolean verified = false;
                for(int i = p.getFirst()-5; i <= p.getFirst()+5; i++) {
                    for(int j = p.getSecond()-5; j <= p.getSecond()+5; j++) {
                        if(i != p.getFirst() || j != p.getSecond()) { //ignore the center tile itself
                            if(i>=0 && j>=0 && gameBoard[i][j].getSquareBomb() && verified == false){
                                verified = true;
                                System.out.println("Coords(x,y):" + p.getFirst() + "," + p.getSecond() + "Requires to Evacuavated Immediately!");
                            }
                        }
                    }
                }
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
}
