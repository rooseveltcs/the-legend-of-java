import java.io.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.awt.event.ActionEvent.*;
import java.awt.event.ActionListener.*;
import java.awt.event.KeyEvent.*;
import java.awt.event.KeyListener.*;
import java.awt.event.MouseEvent.*;
import java.awt.event.MouseListener.*;
import java.awt.event.MouseMotionListener.*;
import java.awt.Component.*;
import java.awt.Frame.*;
import javax.swing.*;
import java.lang.*;
import java.lang.Object.*;
import java.awt.Toolkit.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
public class Story {
   int historyAxis = 50;
   DrawingPanel hpanel = new DrawingPanel(700, 700);
   Graphics gh = hpanel.getGraphics();
   int yAxis = 50;
   int count = 0;
   Scanner intro = new Scanner(System.in);
   DrawingPanel panel = new DrawingPanel(600, 700);
   Graphics g = panel.getGraphics();
   JFrame frame = new JFrame();
   Scanner history = new Scanner(System.in);
   public void Introduction () throws FileNotFoundException {
      hpanel.setVisible(false);
      intro = new Scanner(new File("intro.txt"));
      history = new Scanner(new File("ShortHistory.txt"));
      Font introFont = new Font("Verdana", Font.BOLD, 18);
      g.setFont(introFont);
      Font defaultFont = new Font("Verdana", Font.BOLD, 12);      
      panel.setBackground(Color.BLACK);
      g.setColor(Color.WHITE);
      g.fillRect(0, 0, 25, 700);
      g.fillRect(575, 0, 25, 700);
      g.fillRect(0, 0, 600, 25);
      g.fillRect(0, 675, 600, 25);
      g.drawString("The Story Of Java", 200, 100);
      panel.sleep(3500);
      g.setColor(Color.BLACK);
      g.fillRect(25, 25, 550, 650);
      count++;
      panel.addKeyListener(new introkey());
      g.setColor(Color.WHITE);
      g.setFont(defaultFont);
      g.setFont(defaultFont);
      frame.setBackground(Color.BLACK);
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.setTitle("Are you ready?");
      JButton yesButton = new JButton();
      yesButton.setText("Yes");
      yesButton.setBackground(Color.WHITE);
      yesButton.addActionListener(new UserClickedYes());
      frame.add(yesButton);
      JButton noButton = new JButton();
      noButton.setText("No");
      noButton.setBackground(Color.WHITE);
      noButton.addActionListener(new UserClickedNo());
      frame.add(noButton);
      frame.setLayout(new FlowLayout());
      frame.pack();
      frame.setLocation(600, 100);
   }

   public class UserClickedYes implements ActionListener { 
      public void actionPerformed(ActionEvent event) {
         JOptionPane.showMessageDialog(null, "Very well. I must first tell you about \n the events leading up to \n this very moment.");
         frame.setVisible(false);
         panel.setVisible(false);      
         ChooseConcept();
      }
            
   }
   
   public class UserClickedNo implements ActionListener { 
      public void actionPerformed(ActionEvent event) {
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         JOptionPane.showMessageDialog(null, "Very well... \n I guess I'll just sleep then...");
         panel.setVisible(false);
         frame.dispose();
         
         }
            
   }
  
   public void ChooseConcept () {
      hpanel.setVisible(true);
      hpanel.addKeyListener(new UpKey());
      hpanel.setBackground(Color.BLACK);
      gh.setColor(Color.WHITE);
      gh.fillRect(0, 0, 25, 700);
      gh.fillRect(675, 0, 25, 700);
      gh.fillRect(0, 0, 700, 25);
      gh.fillRect(0, 675, 700, 25);
      
   }
      
  
   public class UpKey implements KeyListener {
      public void keyPressed(KeyEvent event) {
         if (history.hasNext()) {
            String line = history.nextLine();
            gh.drawString(line, 30, historyAxis);
            historyAxis = historyAxis + 20;
         }
         else{
         Doors();
         } 
         
      }
         
      public void keyReleased(KeyEvent event) {
      }
      public void keyTyped(KeyEvent event) {
      }
   }

   public class introkey implements KeyListener {
      public void keyPressed(KeyEvent event) {
         if (intro.hasNext()) {
            String line = intro.nextLine();
            g.drawString(line, 30, yAxis);
            yAxis = yAxis + 20;
         } 
         
         else {
            panel.sleep(1000);
            frame.setVisible(true);
         }
      }
      
      public void keyReleased(KeyEvent event) {
      }
      public void keyTyped(KeyEvent event) {
      }
   }

   public void Doors () {
      try{
      BufferedImage door = ImageIO.read(new File("closeddoor1.jpg"));
      hpanel.sleep(500);
      gh.setColor(Color.BLACK);
      gh.fillRect(0, 0, 700, 700);
      gh.setColor(Color.WHITE);
      gh.fillRect(0, 0, 25, 700);
      gh.fillRect(675, 0, 25, 700);
      gh.fillRect(0, 0, 700, 25);
      gh.fillRect(0, 675, 700, 25);
      gh.drawImage(door, 27+50, 100, 100, 200, Color.BLACK, null); 
      gh.drawImage(door, 233+50, 100, 100, 200, Color.BLACK, null);
      gh.drawImage(door, 466+50, 100, 100, 200, Color.BLACK, null);
      }catch(IOException e){
         System.out.println(e);
      }
         
  }
}



