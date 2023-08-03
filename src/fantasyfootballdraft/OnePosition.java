/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fantasyfootballdraft;

/**
 *
 * @author Vinnie
 */
public class OnePosition extends Position{
    
    private final int NUM_OF_STARTING_SPOTS = 1;

    @Override
    public int getStartingPosition() {
        return super.getStartersRemaining(NUM_OF_STARTING_SPOTS);
    }
    
    @Override
    public boolean isStarter(){
        return getStartingPosition() != 0;
    }

    @Override
    public int getNumOfStartingSpots() {
        return NUM_OF_STARTING_SPOTS;
    }
}
