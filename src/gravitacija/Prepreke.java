package gravitacija;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Prepreke {
/* konstruktor */
	public Prepreke(int pozicija){
		vidljiva = true;
		this.pozicija = pozicija;
	}
	
/* slika donju prepreku */
	public void slikajdole(Graphics g){
		if(vidljiva)
			g.drawImage(donjaPrepreka,pozicija,koordinataDonje,sirinaPrepreke,visinaPrepreke,null);
	}
	
/* slika gornju prepreku */
	public void slikajgore(Graphics g){
		if(vidljiva)
			g.drawImage(gornjaPrepreka,pozicija,koordinataGornje,sirinaPrepreke,visinaPrepreke,null);
	}
	
/* pomera prepreku po "X" koordinatama */
	public void pomeriPrepreku(){
		this.pozicija--;
		if(pozicija == -40) vidljiva = false;
	}
	
/*Geteri i Seteri*/
	
	public int getPozicija() {
		return pozicija;
	}

	public void setPozicija(int pozicija) {
		this.pozicija = pozicija;
	}

	public boolean isVidljiva() {
		return vidljiva;
	}

	public void setVidljiva(boolean vidljiva) {
		this.vidljiva = vidljiva;
	}



	private int pozicija;																					// Pozicija prepreke
	protected Image donjaPrepreka = Toolkit.getDefaultToolkit().getImage("slike/prepreke/donja.gif"); 		// Slika donje prepreke
	protected Image gornjaPrepreka = Toolkit.getDefaultToolkit().getImage("slike/prepreke/gornja.gif");		// Slika gornje prepreke
	private final int koordinataDonje = 350;																// "Y" donje koordinata prepreke
	private final int  koordinataGornje = 150;																// "Y" gornje koordinata prepreke
	private final int sirinaPrepreke = 40;																	// Sirina prepreke
	private final int visinaPrepreke = 40;																	// Visina prepreke
	private boolean vidljiva;																				// Da li je vidjiva

}
