/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fantasyfootballdraft;

/**
 *
 * @author Vinnie
 */
import java.util.*;
public class StartUp {
	
	private static int counter = 0;
	private static ArrayList<Player> players = new ArrayList<Player>(10);
        private static Player whoDraftedHim = null;
        private static String playerDrafted = "";
        
        public static StartUp instance;
        
        public static StartUp getInstance(){
            if(instance == null){
                instance = new StartUp();                            
		players.add(new Player("vinnie")); players.add(new Player("derek"));
		players.add(new Player("chris")); players.add(new Player("ryan"));
		players.add(new Player("devin")); players.add(new Player("keith"));
		players.add(new Player("tk")); players.add(new Player("vince"));
		players.add(new Player("john")); players.add(new Player("brandon"));
                
		Collections.shuffle(players);

		for(int i = 0; i<players.size(); i++){
			Player p = players.get(i);
			p.setDraftOrder(i+1);
			p.setBudget(200);
		}
            }
            return instance;
        }
        
        private StartUp(){
        }
        
        public Player getWhoDraftedHim(){
            return whoDraftedHim;
        }
        
        public String getPlayerDrafted(){
            return playerDrafted;
        }

        public ArrayList<Player> getPlayers(){
            return players;
        }
        
        //need to set nextToBid and counter
        public void getNextPlayerToBid(){
            boolean isThereAnyone = true;
            Player p = players.get(counter);
            int temp = 1;
            while(isThereAnyone && temp<10){
                if(p.canDraft()){
                    FFUI.nextToBid.setText(p.getName());
                    findOnDeckPlayerPosition();
                    counter = increaseCount(counter); 
                    isThereAnyone = false;
                }      
                else{
                    counter = increaseCount(counter); 
                    p = players.get(counter);
                }
                temp++;
            }          
        }
        
        private static void findOnDeckPlayerPosition(){
            boolean isAnyoneAvailable = true;
            int tempCounter = increaseCount(counter);
            Player onDeck = players.get(tempCounter);
            int temp = 1;
            while(isAnyoneAvailable && temp<10){
                if(onDeck.canDraft()){
                    FFUI.onDeck.setText(onDeck.getName());
                    isAnyoneAvailable = false;
                }
                else{
                    FFUI.onDeck.setText("");
                    tempCounter = increaseCount(tempCounter);
                    onDeck = players.get(tempCounter);
                }
                temp++;
            }
        }
        
        public void begin(){
            getNextPlayerToBid(); 
        }
        
	public int getPlayerNameIndex(String name){
		int playerIndex = -999;
		for(int i = 0; i<players.size(); i++){
			if(name.equalsIgnoreCase(players.get(i).getName())){
				playerIndex = i;
				break;
			}
		}
		return playerIndex;
	}
	
	private static int increaseCount(int count){
		return count==9 ? 0 : count+1;
	}
}

