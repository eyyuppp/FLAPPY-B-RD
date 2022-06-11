package fllaybird;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sql.rowset.JoinRowSet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class oyun extends JPanel implements KeyListener,ActionListener{
  
	private Clip clip1,clip2;
	private BufferedImage image,image1,image2,image3;
	private int ku�x=50;
	private int ku�y=300;
	private Timer timer;
	private int yoly=465;
	private int ku�y_ekle=10;
	private int topy=300;
	private Random random;
	private int blok1=250;
	private int blok2=400;
	private int blok3=550;
	private int blok4=700;
	private int blok5=850;
	private int kayd�r1=1,kayd�r2=2,kayd�r3=3,kayd�r4=4,kayd�r5=5;
	private int say�;
	private int skor=0;
	private AudioInputStream yumruk;
	private ArrayList<Integer> eny�ksek_skor=new ArrayList<Integer>();
	private int en_b�y�k;
	//eny�ksek skor
	public void eny�ksek() {
		
		int skortut=Integer.valueOf(skor);
		 
		for (Integer integer : eny�ksek_skor) {
			integer=skortut;
		
		}
		for (Integer y�ksekskor : eny�ksek_skor) {
			
		}	
		
	}
	
	
	
	//ku� a�a�� s�rekli insin
	public  void a�a��in() {
		ku�y+=ku�y_ekle;
	
	}
	
	
	//skor artt�r
	public void skorHesapla() {
		if (blok1==0) {
			skor++;
		}
		else if (blok2==0) {
			skor++;
		}
		else if (blok3==0) {
			skor++;
		}
		else if (blok4==0) {
			skor++;
		}
		else if (blok5==0) {
			skor++;
		}
	}
	
	
	
	//oyun bittimi kontrolet
	public boolean kontrolet() {
		if (ku�y>439) {
			return true;
		}
	
	
if (new Rectangle(ku�x,ku�y,30, 30).intersects(new Rectangle(blok1, 0, 50, 250))) {
		
		return true;
	}	
if (new Rectangle(ku�x,ku�y,30, 30).intersects(new Rectangle(blok1, 350, 50, 115))) {
	
	return true;
}	
if (new Rectangle(ku�x,ku�y,30, 30).intersects(new Rectangle(blok2, 0, 50, 100))) {
	
	return true;
}	
if (new Rectangle(ku�x,ku�y,30, 30).intersects(new Rectangle(blok2, 180, 50, 285) )) {
	
	return true;
}	
if (new Rectangle(ku�x,ku�y,30, 30).intersects(new Rectangle(blok3, 0, 50, 270))) {
	
	return true;
}	
if (new Rectangle(ku�x,ku�y,30, 30).intersects(new Rectangle(blok3, 350, 50, 115))) {
	
	return true;
}	
if (new Rectangle(ku�x,ku�y,30, 30).intersects(new Rectangle(blok4, 0, 50, 40))) {
	
	return true;
}	
if (new Rectangle(ku�x,ku�y,30, 30).intersects(new Rectangle(blok4, 115, 50, 350))) {
	
	return true;
}	
if (new Rectangle(ku�x,ku�y,30, 30).intersects(new Rectangle(blok5, 0, 50, 320))) {
	
	return true;
}	
if (new Rectangle(ku�x,ku�y,30, 30).intersects(new Rectangle(blok5, 420, 50, 45))) {
	
	return true;

}	
	
	return false;
	}
	
	
	
	//bloklar� kayd�r
	public void blokkayd�r() {
		if (blok1<=0) {
			blok1=blok5+150;
		}
		else {
			blok1-=10;
		
		}
			if (blok2<=0) {
				blok2=blok1+150;
			}
			else {
				blok2-=10;
			}
			
			if (blok3<=0) {
				blok3=blok2+150;
			}
			else {
				blok3-=10;
			}
				if (blok4<=0) {
					blok4=blok3+150;
				}
				else {
					blok4-=10;			
				}
				if (blok5<=0) {
					blok5=blok4+150;
				}
				else {
					blok5-=10;
				}
	
	
	
	}
	public int getSkor() {
		return skor;
	}

	public void setSkor(int skor) {
		this.skor = skor;
	}

	public oyun() {
 timer =new Timer(100, this);
	
 setBackground(Color.white);
	
	 try {
		image=ImageIO.read(new FileImageInputStream(new File("ku�.4.gif")));
		image1=ImageIO.read(new FileImageInputStream(new File("a�a�1.jpg")));
		image2=ImageIO.read(new FileImageInputStream(new File("a�a�2.jpg")));
		image3=ImageIO.read(new FileImageInputStream(new File("a�a�3.jpg")));
		
	
		AudioInputStream m�zik=AudioSystem.getAudioInputStream(new File("bird.wav"));
	
	
	clip1=AudioSystem.getClip();
	 clip1.open(m�zik);
	clip1.start();
	
	
	 
	 
	 } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (UnsupportedAudioFileException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (LineUnavailableException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 try {
		AudioInputStream yumruk=AudioSystem.getAudioInputStream(new File("yumruk.wav"));
	

		clip2=AudioSystem.getClip();
		 clip2.open(yumruk);
		 
	 
	 } catch (UnsupportedAudioFileException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (LineUnavailableException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 timer.start();
	}


	
@Override
public void repaint() {
	
	super.repaint();
}
	
	
	@Override
	public void paint(Graphics g) {
	
		super.paint(g);
	g.drawImage(image3, blok2+20, 350, image.getWidth()/10, image.getHeight()/10,this);
	g.drawImage(image1, blok3+20, 340, image.getWidth()/8, image.getHeight()/8,this);
	g.drawImage(image2, blok4+20, 350, image.getWidth()/10, image.getHeight()/10,this);
	
	g.drawImage(image, ku�x, ku�y,30,30,this);
 
	
	g.setColor(Color.ORANGE);
	g.fillRect(0, yoly, 1000, 100);
	
	g.setColor(Color.green);
	g.fillRect(0, yoly, 1000, 40);
	
	g.setColor(Color.red);
    g.fillRect(blok1, 0, 50, 250);
 	g.fillRect(blok1, 350, 50, 115);
 	
 	g.fillRect(blok2, 0, 50, 100);
 	g.fillRect(blok2, 180, 50, 285);
	
 	g.fillRect(blok3, 0, 50, 270);
 	g.fillRect(blok3, 350, 50, 115);
	
	g.fillRect(blok4, 0, 50, 40);
	g.fillRect(blok4, 115, 50, 350);
	
	g.fillRect(blok5, 0, 50, 320);
	g.fillRect(blok5, 420, 50, 45);
	
	g.setColor(Color.BLACK);
	g.setFont(new Font("Arial", 1, 100));
	
	
	String skortut=String.valueOf(skor);
	g.drawString(skortut, 350, 100);
 	
	
	if (kontrolet()!=false) {
		
		clip1.stop();
		g.drawString("  GAME OVER", 28, 300);
	    
		clip2.start();
	    
		timer.stop();
	  
	}
	g.setFont(new Font("Arial", 1, 10));
	

	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	a�a��in();
	blokkayd�r();
	kontrolet();
	skorHesapla();
	repaint();	
	eny�ksek();
	
	}

	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}


	
	
	@Override
	public void keyPressed(KeyEvent e) {
		int c=e.getKeyCode();
		if (c==KeyEvent.VK_UP) {
			if (ku�y<=0) {
				ku�y+=30;
			}
			else if (ku�y>0) {
				ku�y-=55;
			}
	
		}
		else if (c==KeyEvent.VK_DOWN) {
			ku�y+=60;
		}
	
	}
	@Override
	public void keyReleased(KeyEvent e) {
	
		
	}
}
