package com.vernino.control;
/**
 * @author EESWEENEY
 *
 */
public class Main {

	static Screen frame;
	static GameSession session;
	
	public static void main(String[] args) {
		session = new GameSession();
		createScreen();
	}
	
	static void createScreen(){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame = new Screen("Test");
            }
        });	
	}
	
	static void sendCommand(String s){
		session.command(s);
	}

}
