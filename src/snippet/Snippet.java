package snippet;

public class Snippet {
	  private boolean play =false;
	    private int score= 0;
	    private int totalBricks=21;
	    private Timer time;
	    private int delay=2;
	    private int sliderX=310;
	    private int ballposX=120;
	    private int ballposY=350;
	    private int  ballXdir=-1;
	    private int ballYdir=-2;
	     private mapGenerator map;
	    public gameplay() {
	    	map= new mapGenerator(3,7);
	    	addKeyListener(this);
	    	setFocusable(true);
	    	setFocusTraversalKeysEnabled(false);
	    	time= new Timer(delay, this);
	    	time.start();
	    	
	    	
	    }
	    public void paint(Graphics g) {
	    	// background of frame 
	    	g.setColor(Color.black);
	    	g.fillRect(1, 1, 692, 592);
	    	
	       	// the bricks
	    	map.draw((Graphics2D)g);
	    	// borders
	    	g.setColor(Color.yellow);
	    	g.fillRect(0, 0, 3, 592);
	    	g.fillRect(0, 0, 692, 3);
	    	g.fillRect(691, 0, 3, 592);
	    	
	    	//the score 
	    	g.setColor(Color.white);
	    	g.setFont(new Font("serif",Font.BOLD,25));
	    	g.drawString(""+score,590,30);
	    	
	
	  //he padel
	    	g.setColor(Color.green);
	    	g.fillRect(sliderX, 550,100,8);
	    	
	    	// the ball
	    	g.setColor(Color.YELLOW);
	    	g.fillOval(ballposX, ballposY, 17, 17);
	    	//g.dispose();
	    	if(totalBricks<=0) {
	    		play=false;
	    		ballXdir=0;
	    		ballYdir=0;
	    		g.setColor(Color.green);
	    		g.setFont(new Font("serif", Font.BOLD,30));
	    		g.drawString("YOU WON, score: ",190,300);
	    		g.setFont(new Font("serif", Font.BOLD,20));
	    		g.drawString("Press ENTER to Restart ",190,350);
	    	}
	    	if(ballposY>570) {
	    		play=false;
	    		ballXdir=0;
	    		ballYdir=0;
	    		g.setColor(Color.RED);
	    		g.setFont(new Font("serif", Font.BOLD,30));
	    		g.drawString("GAME OVER, score: ",190,300);
	    		g.setFont(new Font("serif", Font.BOLD,20));
	    		g.drawString("Press ENTER to Restart ",190,350);
	    	}
	    	
	 
	    	
	    	}
	    
	  
	       
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			time.start();
			if(play) {
				if(new Rectangle(ballposX,ballposY,17,17).intersects(new Rectangle(sliderX,550,100,8))){
				 ballYdir=-ballYdir;	
				}
				A:for(int i=0; i<map.map.length;i++) {
					for(int j=0; j<map.map[0].length;j++) {
						if(map.map[i][j]>0) {
							int brickX= j* map.brickWidth+ 80;
							int brickY = i* map.brickheight+ 50;
							int brickWidth= map.brickWidth;
							int brickheight= map.brickheight;
							 Rectangle rect = new Rectangle( brickX, brickY, brickWidth, brickheight);
							 Rectangle ballRect=new  Rectangle(ballposX,ballposY,17,17);
							 Rectangle brickRect= rect;
							 if(ballRect.intersects(brickRect)) {
								 map.SetBrickValue(0,i,j);
								 totalBricks--;
								 score+=5;
							if(ballposX+19<= brickRect.x || ballposX+1>= brickRect.x +brickRect.width) {
								ballXdir=- ballXdir;
							}
							else {
								ballYdir=- ballYdir;
							}
							break A;
							 }
							 
						}
					}
				}
				ballposX+=ballXdir;
				ballposY+=ballYdir;
				if(ballposX<0) {
					ballXdir=-ballXdir;
				}
				if(ballposY<0) {
					ballYdir=-ballYdir;
				}
				if(ballposX>670 ) {
					ballXdir=-ballXdir;
				}
			}
			 
			repaint();
		}
	
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			}
	
		@Override
		public void keyPressed(KeyEvent e) {
			if((e.getKeyCode()== KeyEvent.VK_RIGHT) || (e.getKeyCode()==KeyEvent.VK_D)) {
				if(sliderX>=580) {
					sliderX=580;
				}else {
					moveright();
				}
			}
				if((e.getKeyCode()== KeyEvent.VK_LEFT) || (e.getKeyCode()==KeyEvent.VK_A)) {
					if(sliderX<=10) {
						sliderX=10;
					}else {
						moveleft();
					}
				}
			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				if(!play) {
					play= true;
					score=0;
					  sliderX=310;
					    ballposX=120;
					     ballposY=350;
					     ballXdir=-1;
					     ballYdir=-2;
					     totalBricks=21;
					 	map= new mapGenerator(3,7);
					 	repaint();
				}
			}
		}
	       public void moveright() {
			 play= true;
			 sliderX+=20;
			 return;
			}
			public void moveleft() {
				 play= true;
				 sliderX-=20;
				 return;
			}
	
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
		
		}
		
	
}

