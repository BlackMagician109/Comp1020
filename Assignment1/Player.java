/**
* Class Player
*
* COMP 1020 SECTION D01
* INSTRUCTOR Reyhaneh Ababzadeh
* ASSIGNMENT Assignment 1
* @author Shivam Sharma, 7885183
* @version 20-10-2022
*
* PURPOSE: This is a class for player object that stores the player's name, number of games
*          played, and the average score of the player.
*/
public class Player{

    //Instance Variables
    private String name;    //User's Name
    private int gamesPlayed;//Number of games user has played
    private double avgScore;//Average score of the player

    //Constructor
    public Player(String name){
        this.name = name;
        this.gamesPlayed = 0;
        this.avgScore = 0;
    }

    //Instance Methods
    /*This method will increment the games played by one every 
     * time it is called and update the players average score.
     * 
     * Input: int newScore
     * 
     * Output: none(void)
     */
    public void addGameResult(int newScore){
        double currentScore = gamesPlayed*avgScore;
        gamesPlayed++;
        avgScore = (currentScore+newScore)/gamesPlayed;
    }

    /*This method checks if the two players are the same.
     * Two players are same if they have same name.
     * 
     * Input: Player other
     * 
     * Output: boolean
     */
    public boolean equals(Player other){
        return this.name==other.getName();
    }

    /*This is the toString method to print the output of Player object.
     * 
     * Input: none
     * 
     * Output: String
     */
    public String toString(){
        String toPrint = "";
        toPrint += "Player: " + this.name + " has played ";
        if(this.gamesPlayed == 0){
            toPrint += "no games";
        }
        else if(this.gamesPlayed == 1){
            toPrint += this.gamesPlayed + " game with an average of " + (int)this.avgScore;
        }
        else{
            toPrint += this.gamesPlayed + " games with an average of " + (int)this.avgScore;
        }

        return toPrint;
    }

    /*Accessor method getName returns the variable name of the
     * player object.
     * 
     * Input: none
     * 
     * Output: String name
     */
    public String getName(){
        return this.name;
    }
}