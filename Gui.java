/* Zack Sponaugle and Brandon Jerz
 * CSC 213 Search Engine Project
 */

package main_package;

import java.awt.*; 

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.event.*;

import javax.swing.WindowConstants;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Color;


import java.io.IOException;
import java.util.ArrayList;

import javax.swing.UIManager;

public class Gui extends Frame implements ActionListener {
	private JFrame GuiFrame;
	private static JPanel panel;
	private JTextField Textbox;
	private JButton addbutton;
	private JButton removebutton;
	private JButton loadButton;
	private JButton saveButton;
	private JButton searchbutton;
	private JButton quitbutton;
	private JButton listbutton;
	private JButton clearbutton;
	private JButton helpbutton;
	private JTextField textbox;
	private JList list;
	private DefaultListModel listmodel;
	private Organs2 methods = new Organs2();

	public Gui () {
		GuiFrame = new JFrame("Search Engine");
		GuiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GuiFrame.setSize(500, 490);
		GuiFrame.setResizable(false);
		GuiFrame.setLayout(new BorderLayout());

		JMenuBar bluemenu = new JMenuBar();
		bluemenu.setOpaque(true);
		bluemenu.setBackground(Color.BLUE);
		bluemenu.setPreferredSize(new Dimension(200, 20));

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(125, 100));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		addbutton = new JButton("Add");
		addbutton.setMaximumSize(new Dimension(150, 71));
		removebutton = new JButton("Remove");
		removebutton.setMaximumSize(new Dimension(150, 71));
		searchbutton = new JButton("Search");
		searchbutton.setMaximumSize(new Dimension(150, 71));
		listbutton = new JButton("List");
		listbutton.setMaximumSize(new Dimension(150, 71));
		clearbutton = new JButton("Clear");
		clearbutton.setMaximumSize(new Dimension(150, 71));
		helpbutton = new JButton("Help");
		helpbutton.setMaximumSize(new Dimension(150, 71));
		quitbutton = new JButton("Quit");
		quitbutton.setMaximumSize(new Dimension(150, 71));

		panel.add(addbutton);
		addbutton.addActionListener(this);
		panel.add(removebutton);
		removebutton.addActionListener(this);
		panel.add(searchbutton);
		searchbutton.addActionListener(this);
		panel.add(listbutton);
		listbutton.addActionListener(this);
		panel.add(clearbutton);
		clearbutton.addActionListener(this);
		panel.add(helpbutton);
		helpbutton.addActionListener(this);
		panel.add(quitbutton);
		quitbutton.addActionListener(this);
	

		JPanel panel2 = new JPanel();
		panel.setPreferredSize(new Dimension(125, 100));
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		textbox = new JTextField();

		JLabel textlabel = new JLabel();
		textlabel.setPreferredSize(new Dimension(5, 5));
		textlabel.setLabelFor(textbox);
		textbox.setMaximumSize(new Dimension(300, 30));
		listmodel = new DefaultListModel();
		list = new JList(listmodel);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		JScrollPane listscroller = new JScrollPane(list);
		listscroller.setMaximumSize(new Dimension(200, 300));
		
		saveButton = new JButton("Save");
		saveButton.setMaximumSize(new Dimension(150, 71));
		saveButton.addActionListener(this);
		panel.add(saveButton);
		
		loadButton = new JButton("Load");
		loadButton.setMaximumSize(new Dimension(150, 71));
		loadButton.addActionListener(this);
		panel.add(loadButton);
		GuiFrame.setVisible(true);

		panel2.add(Box.createRigidArea(new Dimension(0,5)));
		panel2.add(textbox);
		panel2.add(Box.createRigidArea(new Dimension(0,5)));
		panel2.add(listscroller);
		
		GuiFrame.getContentPane().add(panel2, BorderLayout.CENTER);
		GuiFrame.getContentPane().add(panel, BorderLayout.WEST);
		GuiFrame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==addbutton){
			System.out.println("Add button working");
			if(textbox.getText()==null){
				JOptionPane.showMessageDialog(GuiFrame, textbox.getText() + " has been successfully added!");
			}
			if(listmodel.capacity()>0){
				listmodel.clear();	
			}
			try {
				methods.addURL(textbox.getText());			
				JOptionPane.showMessageDialog(GuiFrame, textbox.getText() + " has been successfully added!");
				textbox.setText(null); // new
				
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(GuiFrame, "Oops! Something went wrong with the program. The URL you entered probably wasn't typed correctly or it doesn't exist. "
						+ "\n" + "If you need help, click the help button");
				textbox.setText(null); // new
			}

		}
		if(e.getSource()==removebutton){
			System.out.println("Remove button working");
			if(listmodel.capacity()>0){
				listmodel.clear();
			}
			if (JOptionPane.showConfirmDialog(GuiFrame, "Are you sure that you want to remove " + textbox.getText() + "?", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
				methods.remove(textbox.getText()); // new
				JOptionPane.showMessageDialog(GuiFrame, textbox.getText() + " has been successfully removed!");
				textbox.setText(null); // new
			}
			else{
				return;
			}

		}

		if(e.getSource()==searchbutton){
			System.out.println("Search button working");
			if(listmodel.capacity()>0){
				listmodel.clear();
			}
			if (methods.findURLs(textbox.getText()) == null){
				JOptionPane.showMessageDialog(GuiFrame, textbox.getText() + " wasn't found!");

			}
			else{
				for (int i = 0; i <= methods.findURLs(textbox.getText()).size()-1 ; i++) {
				     listmodel.addElement(methods.findURLs(textbox.getText()).get(i));
				}
			}
		}
		
		if(e.getSource()==saveButton){
			System.out.println("Save button working");
			Serialize.SerializeFHM();
			System.out.println("File saved.");
		}
		
		if(e.getSource()==loadButton){
			System.out.println("Load button working.");
			Deserialize.DeserializeFHM();
			System.out.println("File loaded.");
		}
		if(e.getSource()==listbutton){
			System.out.println("List button working");
			if(listmodel.capacity()>0){
				listmodel.clear();
			}
			
			if(methods.listURLs(textbox.getText())==null){
				JOptionPane.showMessageDialog(GuiFrame, "Oops! " + textbox.getText() + " that word isn't in the map!");
			}
			else{
				for (int i = 0; i <= methods.listURLs(textbox.getText()).size()-1 ; i++) {
				     listmodel.addElement(methods.listURLs(textbox.getText()).get(i));
				}
			}
		}
		
		if(e.getSource()==clearbutton){
			if(listmodel.capacity()>0){
				listmodel.clear();
			}
			textbox.setText(null);
		}
		if(e.getSource()==helpbutton){
			JOptionPane.showMessageDialog(GuiFrame, "Enter content into the small textbox"
					                     + "\n" +   "The larger textbox displays information"
					                     + "\n" +   "Add:  Adds valid URLS to the map"
					                     + "\n" +   "URL Format:  https://www.website.com"
					                     + "\n" +   "Remove:  Removes existing URL from map"
					                     + "\n" +   "Search:  Looks for all of the web pages containing the word the user entered and"
					                     + "\n"	+   "returns a list of WebPage objects the word is found in"
					                     + "\n" +   "List:  searchable data to find all of the web pages (e.g., URLs) it has processed that contain the word "
					                     + "\n" +	"the user entered and returns the matching URLS"
					                     + "\n" +	"Clear:  Clears the contents in the textbox"
					                     + "\n" +   "Help:  Displays information about the program"
					                     + "\n" +   "Quit:  Terminates the program");
		}	
		if(e.getSource()==quitbutton){
			if (JOptionPane.showConfirmDialog(GuiFrame, "Are you sure that you want to quit?", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
				System.exit(0);
			}
			else{
				return;
			}
		}
	}
}
