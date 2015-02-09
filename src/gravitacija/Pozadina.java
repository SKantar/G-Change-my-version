package gravitacija;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


public class Pozadina {

/*konstruktor*/
	public Pozadina(){
		pozadina = Toolkit.getDefaultToolkit().getImage("slike/pozadina/pozadina.jpg");
		pocetnapozadina = Toolkit.getDefaultToolkit().getImage("slike/pozadina/pozadinaa.jpg");
		vidljiva = true;
	}
	
/*Slikanje pozadine*/
	public void slikaj(Graphics g){
		if(vidljiva)
			g.drawImage(pozadina,0,0,800,600,null);
	}

/*Slikanje pocetne pozadine*/
	public void slikajpp(Graphics g){
		if(vidljiva)
			g.drawImage(pocetnapozadina,0,0,800,600,null);
	}
	
/*Geteri i Seteri za vidljivost pozadine*/
	public boolean isVidljiva() {
		return vidljiva;
	}
	
	public void setVidljiva(boolean vidljiva) {
		this.vidljiva = vidljiva;
	}



	private boolean vidljiva; 			// da li je pozadina vidljiva na platnu
	private Image pozadina;
	private Image pocetnapozadina;	            // slika pozadine
}		
