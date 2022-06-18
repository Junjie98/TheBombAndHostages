public class Main {
    public static void main(String[] args) {
        Board playBoard = new Board(25,25);
        playBoard.createBoard();
        System.out.println(playBoard);
        Read readBombs = new Read("bombs.txt");
        playBoard.locateAndCalculateSmallestRectRegion(readBombs.readCoordinate());
        Read readPeople = new Read("people.txt");
        playBoard.locatePeopleRequiredEvacuation(readPeople.readCoordinate(),readBombs.readCoordinate());
        System.out.println(playBoard);
    }

}
