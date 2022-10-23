/**
* Class Location
*
* COMP 1020 SECTION D01
* INSTRUCTOR Reyhaneh Ababzadeh
* ASSIGNMENT Assignment 1
* @author Shivam Sharma, 7885183
* @version 20-10-2022
*
* PURPOSE: This class represents a locatin where laser tag games happen.
*/
public class Location {
    //Constant Variables
    final int maxMembers = 60;
    
    //Instance Variables
    private Game game;  //The game to be played.
    private Player[] members;  //Member of the location.
    private String address; //Address of the locaiton.
    private String name;    //Name of the location.
    private int totalMembers;   //Total number of members at the location.

    //Static Variables
    private static Location[] allLocations = new Location[60];
    private static int totalLocations = 0;

    //Constructor
    public Location(String name, String addresss){
        this.name = name;
        this.address = addresss;
        this.members = new Player[maxMembers];
        this.totalMembers = 0;
        totalLocations++;
    }

    //Static Mehtod
    public static String allLocationNames(){
        String allNames = "";
        allNames += "All location names:\n";
        for(int i=0 ; i<totalLocations ; i++){
            allNames += allLocations[i];
        }
        return allNames;
    }

    public static String whichLocations(Player who){
        String memberAt = "";
        memberAt += who + " is a member at:\n";
        for(int i=0 ; i<totalLocations ; i++){
            for(int j=0 ; j<allLocations[i].totalMembers ; j++){
                if(who.equals(allLocations[i].members[j])){
                    memberAt += allLocations[i].name + "\n";
                }
            }
        }
        return memberAt;
    }

    //Instance Method
    public void addMember(Player newbie){
        int i=0;
        boolean toAdd = true;
        for(; i<totalMembers ; i++){
            if(members[i].equals(newbie)){
                toAdd = false;
                break;
            }
        }
        if(toAdd){
            members[i] = newbie;
            totalMembers++;
        }
    }

    public String toString(){
        String toPrint = "";
        toPrint += "Membership list for " + this.name + ", " + this.address + " location\n";
        for(int i=0 ; i<totalMembers ; i++){
            toPrint += members[i].toString();
            toPrint += "\n";
        }
        return toPrint;
    }
}
