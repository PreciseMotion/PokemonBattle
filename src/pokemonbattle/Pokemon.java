package pokemonbattle;

import java.util.Scanner;

/**
 * Class to create, initialize, and store a Pokemon and their moves. 
 * TODO: Add status effects. (after adding abilities)
 * @version 4.0 
 * @author Andrew Kassab
*/
public class Pokemon
{
    
    private String name;
    private int pokeID;
    private int health;
    private int maxHealth;
    private String[] type;
    private int attack;
    private int spAttack;
    private int defense;
    private int spDefense;
    private int speed;
    private Move[] moves = new Move[4];
    private Move activeMove;
    
    public Pokemon(String n, int ID, String[] a, int h, int att, int def, int spAtt, int spDef, int s, Move[] m){
        name = n;
        pokeID = ID;
        health = h;
        type = a;
        attack = att;
        spAttack = spAtt;
        defense = def;
        spDefense = spDef;
        speed = s;
        moves = m;
        maxHealth = h;
    }
    
    
    public String getName(){
        return name;
    }
    
    public int getHealth(){
        return health;
    }
    
    public int getMaxHealth() {
    	return maxHealth;
    }
    
    public void setHealth(int h){
        health = h;
    }
    
    public String[] getType(){
        return type;
    }
    
    public int getSpeed(){
        return speed;
    }   
    
    public Move[] getMoves() {
    	return moves;
    }
    
    public Move getActiveMove() {
    	return activeMove;
    }
    
    public int getAttack() {
    	return attack;
    }
    public void setAttack(int a) {
    	attack = a;
    }
    
    public int getSpAttack() {
    	return spAttack;
    }
    public void setSpAttack(int spA) {
    	spAttack = spA;
    }
    
    public int getDefense() {
    	return defense;
    }
    public void setDefense(int d) {
    	defense = d;
    }
    
    public int getSpDefense() {
    	return spDefense;
    }
    public void setSpDefense(int spD) {
    	spDefense = spD;
    }
    
    public int getPokeID() {
		return pokeID;
	}

	/**
     * Sets activeMove to null before next turn.
     */
    public void resetMove() {
    	activeMove = null;
    }
    
    /**
     * Prints the Pokemon's move list and their current 
     * PP values. 
     */
    public void printMoves() {
    	System.out.printf("%-20s%-10s%-8s%-11s%-8s%n","Attack","Type","Power","Accuracy","PP");
    	System.out.println("-------------------------------------------------------");
    	for (int i = 0; i < moves.length; i++) {
    		System.out.printf("%-20s%-10s%-8s%-11s%-8s%n", moves[i].getName(), moves[i].getType(), 
    				moves[i].getDamage(), (int) moves[i].getAccuracy() + "%", moves[i].getPP() + "/" 
    						+ moves[i].getMaxPP());
    	}
    }   
    
    /**
     * Handles move selection for trainer.
     * @return the move selected
     */
    public void selectMove(Trainer t) {
    	
    	Scanner keyboard = new Scanner(System.in);
    	printMoves();
    	String selection;
    	System.out.println();
    	System.out.print("Select a move for " + name + " (by name), or enter swap to switch Pokemon: ");
    	     		
		selection = keyboard.nextLine();
		for (int i = 0; i < moves.length; i++) {
			if (selection.equalsIgnoreCase(moves[i].getName())) {
				if (moves[i].hasPP()) {
					System.out.println();
					activeMove = moves[i];
					return;
				}
				else {
					System.out.println("Out of power points, please try again.");
					System.out.println();
					selectMove(t);
				}
			}
				// Chooses to switch out Pokemon
				// TODO: Add ability to cancel and return to move selection
			if (selection.equalsIgnoreCase("swap")) {
				System.out.println();
				t.selectPokemon();
				return;
			}
		}
		
	    System.out.println("Invalid move, please try again.");    
	    selectMove(t);
    }
    
    /**
     * Checks if a Pokemon can battle (if it is above 0 health)
     * @return true if Pokemon can be called to battle
     */
    public boolean canBattle() {
    	if (health > 0) {
    		return true;
    	}
    	else return false;
    }
    
    /**
     * TODO: Create Pokemon Factory
     */
    
}
