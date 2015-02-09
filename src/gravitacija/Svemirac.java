package gravitacija;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Svemirac {

/*crtanje karaktera kada "hoda" po donjoj liniji */
	public void slikajdole(Graphics g2, int b){
		if(b<20) g2.drawImage(slika_dole1,pocetakX,pocetakY,sirina,visina,null);
		else if(b<40) g2.drawImage(slika_dole2,pocetakX,pocetakY,sirina,visina,null);
		else if(b<60) g2.drawImage(slika_dole3,pocetakX,pocetakY,sirina,visina,null);
		else if(b<80) g2.drawImage(slika_dole4,pocetakX,pocetakY,sirina,visina,null);
	}
	
/*crtanje karaktera kada "hoda" po gornjoj liniji */
	public void slikajgore(Graphics g2, int b){
		if(b<20) g2.drawImage(slika_gore1,pocetakX,pocetakY,sirina,visina,null);
		else if(b<40) g2.drawImage(slika_gore2,pocetakX,pocetakY,sirina,visina,null);
		else if(b<60) g2.drawImage(slika_gore3,pocetakX,pocetakY,sirina,visina,null);
		else if(b<80) g2.drawImage(slika_gore4,pocetakX,pocetakY,sirina,visina,null);
	}
	
/*crtanje karaktera kada je u skoku*/
	public void slikajskok(Graphics g2, int b){
		if(b<20) g2.drawImage(slika_skok1,pocetakX,pocetakY,sirina,visina,null);
		else if(b<40) g2.drawImage(slika_skok2,pocetakX,pocetakY,sirina,visina,null);
		else if(b<60) g2.drawImage(slika_skok3,pocetakX,pocetakY,sirina,visina,null);
		else if(b<80) g2.drawImage(slika_skok4,pocetakX,pocetakY,sirina,visina,null);
	}


/*da li karakter ima podlogu pod sobom, odnosno 
 da li je potrebno da mu se menja "Y" koordinata*/
	public int isImapodlogu(int a, int b, boolean c) {
		if ((pocetakY == 320-a*40 && c) || (pocetakY == 150+b*40 && !c)) return 2;
		if(pocetakY ==320 || pocetakY ==150 ) return 1;
		return 0;
	}

/*da li je karakter zapeo o prepreku*/
	public int zapeogore(){
			if(pocetakY >= 150 && pocetakY < 190) return 1;
			return 0;
	}
	
	public int zapeodole(){
		if(pocetakY <= 320 && pocetakY > 280) return 1;
		return 0;
}
	
	
/*kretanje karaktera duz "X" ose*/
	public void unazad(){
		pocetakX--;
	}
	
/*kretanje karaktera duz "Y" ose*/
	public void gore(){
		pocetakY--;
	}
	public void dole(){
		pocetakY++;
	}

/*da li je karakter izguran sa prozora, da li je kraj igre*/
public boolean kraj(){
		return pocetakX < -40 ? true:false;
	}


/*Geteri i Seteri*/
	public int getSirina() {
		return sirina;
	}

	public int getVisina() {
		return visina;
	}
	
	public int getPocetakY() {
		return pocetakY;
	}
	
	public int getPocetakX() {
		return pocetakX;
	}
	
	public void setPocetakX(int pocetakX) {
		this.pocetakX = pocetakX;
	}

	public void setPocetakY(int pocetakY) {
		this.pocetakY = pocetakY;
	}




	/*Slike koje ilustruju kretanje karaktera svemirom*/
	private final Image slika_dole1 = Toolkit.getDefaultToolkit().getImage("slike/svemirac/dole1.png");
	private final Image slika_dole2 = Toolkit.getDefaultToolkit().getImage("slike/svemirac/dole2.png");
	private final Image slika_dole3 = Toolkit.getDefaultToolkit().getImage("slike/svemirac/dole3.png");
	private final Image slika_dole4 = Toolkit.getDefaultToolkit().getImage("slike/svemirac/dole4.png");
	private final Image slika_skok1 = Toolkit.getDefaultToolkit().getImage("slike/svemirac/skok1.png");
	private final Image slika_skok2 = Toolkit.getDefaultToolkit().getImage("slike/svemirac/skok2.png");
	private final Image slika_skok3 = Toolkit.getDefaultToolkit().getImage("slike/svemirac/skok3.png");
	private final Image slika_skok4 = Toolkit.getDefaultToolkit().getImage("slike/svemirac/skok4.png");
	private final Image slika_gore1 = Toolkit.getDefaultToolkit().getImage("slike/svemirac/gore1.png");
	private final Image slika_gore2 = Toolkit.getDefaultToolkit().getImage("slike/svemirac/gore2.png");
	private final Image slika_gore3 = Toolkit.getDefaultToolkit().getImage("slike/svemirac/gore3.png");
	private final Image slika_gore4 = Toolkit.getDefaultToolkit().getImage("slike/svemirac/gore4.png");
	
	private int pocetakX = 200; // Pocetna X koordinata karaktera
	private int pocetakY = 320; // Pocetna Y koordinata karaktera
	private int sirina = 50;    // Sirina karaktera
	private int visina = 70;	// Visina Karaktera

}
