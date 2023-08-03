/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fantasyfootballdraft;

/**
 *
 * @author Vinnie
 */
public abstract class Position {
    
    private int totalNum = 0;
    private int rosterSpot = 0;

    public int getStartersRemaining(int numOfStartingSpots) {
        int numberLeft = numOfStartingSpots - getRosterSpot();
        return numberLeft < 0 ? 0 : numberLeft;
    }
    
    public abstract int getStartingPosition();
    
    public abstract boolean isStarter();
    
    public abstract int getNumOfStartingSpots();
    
    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getRosterSpot() {
        return rosterSpot;
    }

    public void setRosterSpot(int rosterSpot) {
        this.rosterSpot = rosterSpot;
    }
    
    public void increaseRosterSpot(){
        setRosterSpot(this.rosterSpot + 1);
    }
    
    public void decreaseRosterSpot(){
        int temp = this.rosterSpot - 1;
        if(temp >= getTotalNum()){
            setRosterSpot(this.rosterSpot - 1);            
        }
    }
    
    public void increaseTotalNum(){
        setTotalNum(this.totalNum + 1);
    }
    
    public void decreaseTotalNum(){
        setTotalNum(this.totalNum - 1);
    }
}
