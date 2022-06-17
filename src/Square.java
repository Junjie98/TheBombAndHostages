public class Square {
    private String squareValue;
    private boolean bombExist = false; //default as false
    private int numOfBombs = 0; //default 0. To keep track of how many bombs are there within the 2D array.

    public Square(boolean bombValue){
        this.squareValue = "-";
        this.bombExist = bombValue;
    }

    public void setSquareBomb(boolean value){
        this.bombExist=value;
    }

    public String toString() {
		String name = "";
		// for(int i=0; i<numOfPlayer; i++) {
		// 	name += playersInArray.get(i).toString();
		// }
		if(bombExist==false) { // Only print delta with non 0 value
		return  String.format("%2s %2s", name,squareValue) ;
		} else {
			return  String.format("%1s %2s ", name, "B") ;
		}
	}
}
