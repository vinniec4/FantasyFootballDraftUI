/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fantasyfootballdraft;

/**
 *
 * @author Vinnie
 */
public class NFLPlayer {
    private String name;
    private String position;
    private int byeWeek;
    private String team;
    
    public NFLPlayer(String nflDBString){
        this.name = getName(nflDBString).trim();
        this.position = getPosition(nflDBString).trim();
        this.byeWeek = findByeWeek(nflDBString);
        this.team = getTeam(nflDBString).trim();
    }
    
    private static String getName(String nflPlayer){        
        int numOfSpaces = nflPlayer.split(" ").length - 4;
        if(numOfSpaces == 3){
            int lastSpace = nflPlayer.indexOf(" ");
            return nflPlayer.substring(0, lastSpace);
        }
        else if(numOfSpaces == 4){
            int lastSpace = nflPlayer.indexOf(" ", nflPlayer.indexOf(" ")+1);
            return nflPlayer.substring(0, lastSpace);            
        }
        else{
            int lastSpace = nflPlayer.indexOf(" ", nflPlayer.indexOf(" ", nflPlayer.indexOf(" ")+1)+2);
            return nflPlayer.substring(0, lastSpace);
        }
    }
    
    private static String getPosition(String nflPlayer){   
        int numOfSpaces = nflPlayer.split(" ").length - 4;
        if(numOfSpaces == 3){
            int firstSpace = nflPlayer.indexOf(" ");
            int lastSpace = nflPlayer.indexOf(" ", firstSpace+2);
            return nflPlayer.substring(firstSpace, lastSpace);
        }
        else if(numOfSpaces == 4){
            int firstSpace = nflPlayer.indexOf(" ", nflPlayer.indexOf(" ")+1);
            int lastSpace = nflPlayer.indexOf(" ", firstSpace+2);
            return nflPlayer.substring(firstSpace, lastSpace);
        }
        else{
            int firstSpace = nflPlayer.indexOf(" ", nflPlayer.indexOf(" ", nflPlayer.indexOf(" ")+1)+2);
            int lastSpace = nflPlayer.indexOf(" ", firstSpace+2);
            return nflPlayer.substring(firstSpace, lastSpace);
        }
    }
        
    private static int findByeWeek(String nflPlayer){
        return Integer.parseInt(nflPlayer.substring(nflPlayer.lastIndexOf(" "), nflPlayer.length()).trim());
    }
    
    private static String getTeam(String nflPlayer){   
        int numOfSpaces = nflPlayer.split(" ").length - 4;        
        if(numOfSpaces == 3){
            int firstSpace = nflPlayer.indexOf(" ", nflPlayer.indexOf(" ")+2);
            int lastSpace = nflPlayer.indexOf(" ", firstSpace+4);
            return nflPlayer.substring(firstSpace, lastSpace);            
        }
        else if(numOfSpaces == 4){
            int firstSpace = nflPlayer.indexOf(" ", nflPlayer.indexOf(" ", nflPlayer.indexOf(" ")+1)+2);
            int lastSpace = nflPlayer.indexOf(" ", firstSpace+2);
            return nflPlayer.substring(firstSpace, lastSpace);
        }
        else{
            int firstSpace = nflPlayer.indexOf(" ", nflPlayer.indexOf(" ", nflPlayer.indexOf("  ")+1)+2);
            int lastSpace = nflPlayer.indexOf(" ", firstSpace+2);
            return nflPlayer.substring(firstSpace, lastSpace);
        }
    }

    public int getByeWeek() {
        return byeWeek;
    }

    public void setByeWeek(int byeWeek) {
        this.byeWeek = byeWeek;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
