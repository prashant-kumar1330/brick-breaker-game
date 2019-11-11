package game;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JFrame.*;
public class BrickbreakerGame extends JFrame{

	public static void main(String[] args) {
	  JFrame obj = new JFrame();
	  gameplay game= new gameplay();
	  obj.setTitle("brick breaker game");
	  obj.setBounds(10,10,700,600);
      obj.setResizable(false);
      obj.setVisible(true);
      obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      obj.add(game);
	}

}
