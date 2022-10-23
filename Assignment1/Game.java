/**
* Class Game
*
* COMP 1020 SECTION D01
* INSTRUCTOR Reyhaneh Ababzadeh
* ASSIGNMENT Assignment 1
* @author Shivam Sharma, 7885183
* @version 20-10-2022
*
* PURPOSE: This class is a laser tag between two teams.
*/
public class Game {
    //Instance Variables
    private Team teamOne;   //First of the two teams in the laser tag game.
    private Team teamTwo;   //Second of the two teams in the laser tag game.

    //Constructor
    public Game(Team one, Team two){
        this.teamOne = one;
        this.teamTwo = two;
    }

    //Instance Methods
    /*This method checks to see if the given two teams can participate in a game.
     * 
     * Input: none
     * 
     * Output: Boolean(true if the teams can play against each other.)
     */
    public boolean validGame(){
        return !(teamOne.hasCommonPlayers(teamTwo))&&teamOne.teamFull()&&teamTwo.teamFull();
    }

    public void awardWinner(Team winner, int points){
        for(int i=0; i<winner.getRoster().length ; i++){
            winner.getRoster()[i].addGameResult(pointsPerMember(winner, points));
        }
        if(winner.equals(teamOne)){
            //Do nothing
        }
        else{
            for(int i=0 ; i<teamTwo.getRoster().length ; i++){
                teamTwo.getRoster()[i].addGameResult(0);
            }
        }
    }

    public String toString(){
        String toPrint = "";
        toPrint += "Team rosters:\n";
        for(int i=0 ; i<teamOne.getRoster().length ; i++){
            toPrint += teamOne.getRoster()[i].getName() + "\t" + teamTwo.getRoster()[i].getName() + "\n";
        }
        return toPrint;
    }
    //Helper Methods
    private int pointsPerMember(Team winner, int points){
        return points/winner.getRoster().length;
    }
}
