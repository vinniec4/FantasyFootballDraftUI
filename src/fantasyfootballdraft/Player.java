/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fantasyfootballdraft;
/**
 *
 * @author Vinnie
 */
import java.util.ArrayList;
import javax.swing.JLabel;

public class Player {
    private int budget = 200;
    private int maxBid = 186;
    private int draftOrder;
    private String name;
    private ArrayList<String> roster = new ArrayList<String>();
    private int spotsToFill = 15;
    private Position qb = null;
    private Position wr = null;
    private Position rb = null;
    private Position te = null;
    private Position k = null;
    private Position def = null;
    private Position ben = null;
    private boolean canDraft = true;
    
    public String findRosterSpot(String position){
        Position spot = getPositionNumber(position);
        if(spot.isStarter()){
            spot.increaseRosterSpot();
            setCanDraft(true);
            return name + position.toUpperCase() + spot.getRosterSpot();
        }
        else{
            spot = this.getBen();
            spot.increaseRosterSpot();
            if(spot.getRosterSpot() == -999){                
                FFUI.printout("Bench is full. You can't have that player");
                setCanDraft(false);
                return "";
            }
            else{
                setCanDraft(true);
                return name + "B" + spot.getRosterSpot();                
            }
        }
    }
    
    public void undoRosterSpot(String position){
        Position spot = getPositionNumber(position);
        if(spot.getTotalNum() >= spot.getNumOfStartingSpots()){
            spot = getBen();
        }
        spot.decreaseRosterSpot();
    }
    
    public void increaseTotalNumOnRoster(String position){
        Position spot = getPositionNumber(position);
        spot.increaseTotalNum();
    }

    private Position getPositionNumber(String position){
        Position p = null;
        if("qb".equalsIgnoreCase(position)){
            p = this.getQb();
        }
        else if("wr".equalsIgnoreCase(position)){
            p = this.getWr();
        }
        else if("rb".equalsIgnoreCase(position)){
            p = this.getRb();
        }
        else if("fb".equalsIgnoreCase(position)){
            p = this.getRb();
        }
        else if("te".equalsIgnoreCase(position)){
            p = this.getTe();
        }
        else if("dst".equalsIgnoreCase(position)){
            p = this.getDef();
        }
        else if("k".equalsIgnoreCase(position)){
            p = this.getK();
        }
        return p;
    }
    
    public boolean handleBid(int bid){
        if(bid <= 0){
            FFUI.printout("Positive value only.");
            return false;
        }
        boolean returnValue = false;
        int temp = getBudget() - bid - getSpotsToFill() + 1;
        if(temp < 0 ){
            FFUI.printout("You don't have enough money to bid that!");
            returnValue = false;
        }
        else if(!isCanDraft()){
            returnValue = false;
        }
        else{
            this.subtractFromBudget(bid);
            this.spotsToFill--; // this needs to be before the calculation of maxBid
            if(this.spotsToFill == 0){
                this.maxBid = 0;
            } 
            else{
                this.maxBid = this.maxBid = getBudget() - getSpotsToFill() + 1;// this needs to be after calculation of spotsToFill
            }
            JLabel j = (JLabel)FFUI.getComponentByName(getBudgetName());
            j.setText("$  " + getBudget());
            j = (JLabel)FFUI.getComponentByName(getMaxBidLabelName());
            j.setText("$  " + getMaxBid());
            returnValue = true;
        }
        setCanDraft(true);
        return returnValue;
    }

    public int getSpotsToFill(){
        return spotsToFill;
    }

    public void setSpotsToFill(int spots){
        this.spotsToFill = spots;
    }

    public ArrayList<String> getRoster() {
            return roster;
    }

    public void setRoster(ArrayList<String> roster) {
            this.roster = roster;
    }

    public Player(String name){
            this.name = name;
    }

    public void subtractFromBudget(int bid){
            budget = budget-bid;
    }
    public String getName(){
            return this.name;
    }

    public void setName(String name){
            this.name = name;
    }
    public int getBudget() {
            return budget;
    }

    public void setBudget(int budget) {
            this.budget = budget;
    }

    public int getDraftOrder() {
            return draftOrder;
    }

    public void setDraftOrder(int draftOrder) {
            this.draftOrder = draftOrder;
    }

    public boolean canDraft(){
        return this.spotsToFill != 0;
    }
    
    public Position getBen() {
        if(!hasInstance(ben)){            
            ben = new Ben();
        }
        return ben;
    }

    public void setBen(Position ben) {
        this.ben = ben;
    }

    public Position getDef() {
        if(!hasInstance(def)){            
            def = new OnePosition();
        }
        return def;
    }

    public void setDef(Position def) {
        this.def = def;
    }

    public Position getK() {
        if(!hasInstance(k)){            
            k = new OnePosition();
        }
        return k;
    }

    public void setK(Position k) {
        this.k = k;
    }

    public Position getQb() {
        if(!hasInstance(qb)){            
            qb = new OnePosition();
        }
        return qb;
    }

    public void setQb(Position qb) {
        this.qb = qb;
    }

    public Position getRb() {
        if(!hasInstance(rb)){            
            rb = new RB();
        }
        return rb;
    }

    public void setRb(Position rb) {
        this.rb = rb;
    }

    public Position getTe() {
        if(!hasInstance(te)){            
            te = new OnePosition();
        }
        return te;
    }

    public void setTe(Position te) {
        this.te = te;
    }

    public Position getWr() {
        if(!hasInstance(wr)){            
            wr = new WR();
        }
        return wr;
    }

    public void setWr(Position wr) {
        this.wr = wr;
    }

    public String getBudgetName() {
        return getName() + "MoneyLeft";
    }
    
    public String getMaxBidLabelName(){
        return getName() + "MaxBid";
    }
    
    private boolean hasInstance(Position p){
        return p != null;
    }

    public boolean isCanDraft() {
        return canDraft;
    }

    public void setCanDraft(boolean canDraft) {
        this.canDraft = canDraft;
    }

    public int getMaxBid() {
        return maxBid;
    }

    public void setMaxBid(int maxBid) {
        this.maxBid = maxBid;
    }
}

