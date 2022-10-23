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

    /*This method gives points to the team members of the winning team.
     * Losing team members are given 0 points.
     * 
     * Input: Team winner, int points
     * 
     * Output: none
     */
    public void awardWinner(Team winner, int points){
        for(int i=0; i<winner.getRoster().length ; i++){
            winner.getRoster()[i].addGameResult(pointsPerMember(winner, points));
        }
        if(winner.equals(teamTwo)){
            //Do nothing
        }
        else{
            for(int i=0 ; i<teamTwo.getRoster().length ; i++){
                teamTwo.getRoster()[i].addGameResult(0);
            }
        }
    }

    /*This is the toString method to print the output of Game object.
     * 
     * Input: none
     * 
     * Output: String
     */
    public String toString(){
        String toPrint = "";
        toPrint += "Team rosters:\n";
        for(int i=0 ; i<teamOne.getRoster().length ; i++){
            toPrint += teamOne.getRoster()[i].getName() + "\t\t" + teamTwo.getRoster()[i].getName() + "\n";
        }
        return toPrint;
    }

    //Helper Methods
    /*Helper method to calculate points given to each member of the winning team
     * 
     * Input: Team winner, int points
     * 
     * Output: int(Points to be recieved by each member of the winning team.)
     */
    private int pointsPerMember(Team winner, int points){
        return points/winner.getRoster().length;
    }
}
