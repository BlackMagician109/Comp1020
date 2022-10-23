/**
* Class Team
*
* COMP 1020 SECTION D01
* INSTRUCTOR Reyhaneh Ababzadeh
* ASSIGNMENT Assignment 1
* @author Shivam Sharma, 7885183
* @version 20-10-2022
*
* PURPOSE: Class Team is a collection of Players who play Laser Tag
*          games. Teams have maximum size, and players that come and
*          go from the team.
*/
public class Team {
    //Constant Variables
    final int maxTeamSize = 5;  //Maximum number of players a team can have.

    //Instance Variables
    Player[] teamPlayers = new Player[maxTeamSize]; //A partially-filled array to keep track of team players.
    int actualPlayers = 0;  //Actual number of players on the team.

    //Instance Methods
    /*This method adds a player to the team if the player is not already on the team and 
     * there is space left on the team.
     * 
     * Input: Player newOne (The player to add to the team.)
     * 
     * Output: Boolean (True if the player was added to the team.)
     */
    public boolean addMember(Player newOne){
        int i=0;
        if(teamFull()){
            return false;
        }
        else{
            for(; i<actualPlayers ; i++){
                if(teamPlayers[i].equals(newOne)){
                    return false;
                }
            }
            teamPlayers[i] = newOne;
            actualPlayers++;
            return true;
        }
    }

    /*This is the toString method to print the data from class Team.
     * 
     * Input: none
     * 
     * Output: String
     */
    public String toString(){
        String toPrint = "Team Members:\n";
        for(int i=0 ; i<actualPlayers ; i++){
            toPrint += i+1 + ": " + teamPlayers[i].getName() + "\n";
        }
        return toPrint;
    }

    /*This method checks to see if there are any common memnbers in
     * the two given teams.
     * 
     * Input: Team(team to compare)
     * 
     * Output: boolean(true if any player is on both teams)
     */
    public boolean hasCommonPlayers(Team other){
        for(int i=0; i<other.getRoster().length ; i++){
            for(int j=0 ; j<teamPlayers.length ; j++){
                if(teamPlayers[j] == other.getRoster()[i]){
                    return true;
                }
            }
        }
        return false;
    }

    /*This method returns a deep copy of the team. The returned array is 
     * the same size as the number of players.
     * 
     * Input: none
     * 
     * Output: Plyer[] (deep copy of the array with players on team)
     */
    public Player[] getRoster(){
        Player[] copy = new Player[teamPlayers.length];
        for(int i=0 ; i<copy.length ; i++){
            copy[i] = teamPlayers[i];
        }
        return copy;
    }

    /*This mehtod checks to see if the team is full.
     * 
     * Input: none
     * 
     * Output: Boolean(true if the team is full.)
     */
    public boolean teamFull(){
        return actualPlayers == maxTeamSize;
    }

    /*This mehtod removes a player from the team.
     * 
     * Input: Player toRemove(Player to be removed from the team.)
     * 
     * Output: boolean(true if the player was removed from the team.)
     */
    public boolean removePlayer(Player toRemove){
        for(int i=0; i<teamPlayers.length ; i++){
            if(teamPlayers[i]!=null && teamPlayers[i] == toRemove){
                for(int j=i+1 ; j<teamPlayers.length ; j++){
                    teamPlayers[j-1] = teamPlayers[j];
                }
                i--;
                actualPlayers--;
                return true;
            }
        }
        return false;
    }
}