/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fantasyfootballdraft;

/**
 *
 * @author Vinnie
 */
public class Ben extends Position{
    
    private final int NUM_OF_STARTING_SPOTS = 6;

    @Override
    public int getStartingPosition() {
        int numRemaining = getNumOfStartingSpots() - super.getRosterSpot();
        return numRemaining < 0 ? 0 : numRemaining;
    }
    
    @Override
    public boolean isStarter(){
        return getStartingPosition() != 0;
    }

    @Override
    public int getNumOfStartingSpots() {
        return NUM_OF_STARTING_SPOTS;
    }  
    
    @Override
    public int getRosterSpot() {
        if(super.getRosterSpot() == 6){
            return 6;
        }
        return isStarter() ? super.getRosterSpot() : -999;
    }
}
