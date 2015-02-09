package gravitacija;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

public class Margine {
	
/*konstruktor*/	
	public Margine(){
		/*kreira 25 margina koje se vrte u krug*/
			for(int i = 0;i < 25; i ++)
				margine.add(i*40);
		
		/*kreira prolaze za nivoe*/
			nivoi.add(5000+ greska);
			nivoi.add(10000+greska);
			nivoi.add(15000+greska);
			nivoi.add(20000+greska);
			nivoi.add(25000+greska);
			nivoi.add(30000+greska);
			nivoi.add(35000+greska);
	}
	
/*pomera margine nakon svakog iscrtavanja za jednu poziciju unazad*/
	public void pomerimargine(){
		for(int i = 0;i < 25; i ++)
			margine.set(i,margine.get(i)-1 > -40 ? margine.get(i)-1 : 800); 
		for(int j = 0; j < nivoi.size(); j++)
			nivoi.set(j,nivoi.get(j)-1);
		}
	
/*slikanje margina*/
	public void slikaj(Graphics g){
		for(int i = 0;i < 25; i ++){
			g.drawImage(gornjamargina,margine.get(i),koordinataGornje,sirinamargine,visinamargine,null);
			g.drawImage(donjamargina,margine.get(i),koordinataDonje,sirinamargine,visinamargine,null);
		}
		for(int j = 0; j < nivoi.size(); j++)
			g.drawImage(krajnivoa, nivoi.get(j),koordinataGornje+visinamargine,20,koordinataDonje-koordinataGornje-40,null);
	}
	
/*Geteri i Seteri */
	public int getKoordinataDonje() {
		return koordinataDonje;
	}

	public int getKoordinataGornje() {
		return koordinataGornje;
	}

	public void resetNivoi() {
		nivoi.set(0, 5000+ greska);
		nivoi.set(1, 10000+ greska);
		nivoi.set(2, 15000+ greska);
		nivoi.set(3, 20000+ greska);
		nivoi.set(4, 25000+ greska);
		nivoi.set(5, 30000+ greska);
		nivoi.set(6, 35000+ greska);
		
	}

	public int nivogore(int pozicija) {
		for(int j = 0; j < nivoi.size(); j++)
			if(nivoi.get(j) == pozicija) return 1;
		return 0;
		}
	


	private ArrayList<Integer>margine = new ArrayList<Integer>(); 										 // koordinate margina
	private ArrayList<Integer>nivoi = new ArrayList<Integer>();	  										 // koordinate vrata za nivoe
	protected Image donjamargina = Toolkit.getDefaultToolkit().getImage("slike/margine/donja.gif"); 	 //slika donje margine
	protected Image gornjamargina = Toolkit.getDefaultToolkit().getImage("slike/margine/gornja.gif");    // slika gornje margine
	protected Image krajnivoa = Toolkit.getDefaultToolkit().getImage("slike/krajnivoa/krajnivoaa.gif");  // slika vrata novih nivoa
	private final static int koordinataDonje = 390; 													 // "Y" koordinata donje margine
	private final static int  koordinataGornje = 110; 													 // "Y" koordinata gornje margine
	private final static int sirinamargine = 40;														 // Sirina margine
	private final static int visinamargine = 40;														 // Visina margine
	protected final int greska = 350;
}
