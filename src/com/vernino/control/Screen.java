package com.vernino.control;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class Screen extends JFrame {
	private static final long serialVersionUID = 1L;
	private ArrayList<JComponent> components;
	
	//Quick variables for accessing components. ORDER OF CREATION IS IMPORTANT.
	final int OUT = 0;
	final int IN = 1;
	
	final Font ALERT = new Font("Courier", Font.BOLD, 14);
	final Font NORMAL = new Font("Courier", Font.PLAIN, 14);
	
	public Screen() throws HeadlessException {
	}
	
	public Screen(String title) throws HeadlessException {
		super(title);
		components = new ArrayList<JComponent>();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//add components here.
		components.add(createOutBox());
		components.add(createInBox());
		this.getContentPane().add(components.get(OUT), BorderLayout.CENTER);
		this.getContentPane().add(components.get(IN), BorderLayout.PAGE_END);
		
		//Sets the enter key to sending input.
		this.setKeyBinds();
		
		//Cleans it up and makes it visible.
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	//Creates the output box.
	protected JTextArea createOutBox(){
		JTextArea outBox = new JTextArea("Starting...");
		outBox.setPreferredSize(new Dimension(1200,600));
		outBox.setBackground(Color.BLACK);
		outBox.setForeground(Color.GREEN);
		outBox.setEditable(false); 
		outBox.setFont(NORMAL);
		return outBox;
	}
	
	//Creates the input box.
	protected JTextArea createInBox(){
		JTextArea inBox = new JTextArea("");
		inBox.setPreferredSize(new Dimension(800,25));
		inBox.setFont(NORMAL);
		inBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		return inBox;
	}
	
	//See above.
	protected void setKeyBinds(){
		@SuppressWarnings("serial")
		Action submit = new AbstractAction() {
		    public void actionPerformed(ActionEvent e) {
		    	((JTextArea) components.get(OUT)).setText(null);
				String in = ((JTextArea) components.get(IN)).getText();
				userPrint(in);
				Main.sendCommand(in);
				((JTextArea) components.get(IN)).setText(null);
				components.get(IN).requestFocusInWindow();
		    }
		};
		components.get(IN).getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "Submit");
		components.get(IN).getActionMap().put("Submit", submit);
	}
	
	//Used to replicated user input on the output box.
	private void userPrint(String s){
		JComponent out = components.get(OUT);
		((JTextArea) out).append("> "+s.toUpperCase());
	}
	
	//Normal printing
	void print(String s){
		JComponent out = components.get(OUT);
		out.setFont(NORMAL);
		out.setForeground(Color.GREEN);
		((JTextArea) components.get(OUT)).append("\n\n" + s);
	}
	
	//Urgent printing.
	void alert(String s){
		JComponent out = components.get(OUT);
		out.setFont(ALERT);
		out.setForeground(Color.RED);
		((JTextArea) out).append("\n\n" + s);
	}
	
	//The welcom message goes in here. I separated it because it looked nasty as a variable.
	private String welcome(){
		return "Running version 0.1!";
		
	}
}
