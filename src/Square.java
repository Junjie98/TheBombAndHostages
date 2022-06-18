public class Square {
    private String squareValue;
    private boolean bombExist = false; //default as false
    private boolean peopleAround = false;//default as false

    public Square(boolean bombValue){
        this.squareValue = "-";
        this.bombExist = bombValue;
    }

    public void setSquareBomb(boolean value){
        this.bombExist=value;
    }

    public boolean getSquareBomb(){
        return bombExist;
    }

    public void setPeopleAround(boolean value){
        this.peopleAround = value;
    }

    public String toString() {

        if(peopleAround == true && bombExist==false){
            squareValue = "P";
            return String.format("%1s %2s","",squareValue);
        }
		if(bombExist==false && peopleAround==false) {
            return String.format("%1s %2s","",squareValue);   
		}else{
            squareValue = "B";
            return String.format("%1s %2s","",squareValue);
		}
	}
}
