import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


import handler.Pair;

public class Read {
    private int valueX;
    private int valueY;
    private String location = "";
    ArrayList <Pair<Integer,Integer>> coordsPairList = new ArrayList <>();
    // public ArrayList<Pair<Integer, Integer>> player1UnitsPosition = new ArrayList<>();
    

    public Read(String fileLocation){
        this.location = fileLocation;
    }
    public ArrayList <Pair<Integer,Integer>> readCoordinate(){
        BufferedReader readInTxt;
        System.out.println("Retrieving intel....");

        try {
                     String cordsLine;
                     readInTxt = new BufferedReader(new FileReader(this.location));
                     //Capture all class data
                     while (true){
                        cordsLine = readInTxt.readLine();
                        if (cordsLine==null||cordsLine.isBlank()){
                           break;
                        }
                        cordsLine = String.valueOf(cordsLine).replace("o;?","");
                        String[] split_line_class = cordsLine.split(",");
                        String coordX = split_line_class[0];
                        split_line_class[1] = String.valueOf(split_line_class[1]).replace(" ", "");
                        String coordY = split_line_class[1];

                        valueX = Integer.parseInt(coordX);
                        valueY = Integer.parseInt(coordY);
                        coordsPairList.add(new Pair<>(valueX, valueY)); //store the coordiantes into a pair arraylist and return.

                     }
                     readInTxt.close();
                  } catch (IOException e) {
                     e.printStackTrace();
                     System.err.println("File unreadable, check the path or parameter passed to create class method ");
            
                  } finally {
                      System.err.println("Data has been successfully loaded!");
                  }
        return coordsPairList;
    }
}
