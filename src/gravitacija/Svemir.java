package gravitacija;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JPanel;

public class Svemir extends JPanel implements Runnable{
	
/*neutralisanje upozorenja*/
	private static final long serialVersionUID = 1L;

/*konstruktor*/
	public Svemir(boolean pocetak){
		this.pocetak = pocetak;
		addMouseListener(new MouseListener() {

/*ukoliko je pritisnut bilo koji taster misa promenice se gravitacija*/
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if(svemirac.isImapodlogu(postojidole(),postojigore(),smer)!=0){
					if(smer){
						smer = false;
						svemirac.gore();

					}
					else{
						smer = true;
						svemirac.dole();
					}
				}
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
/*Generisanje prepreka na slucajan nacin*/
		Random r = new Random();
		for(int j = 0; j < 100; j ++){
			
/*Generisanje random koordinata*/
			listadonjih.add(r.nextInt(30000)+800);  
			listagornjih.add(r.nextInt(30000)+800);
		}
		
/*Sortira koordinate*/
		Collections.sort(listadonjih);
		Collections.sort(listagornjih);
		
		/*Pravi instance prepreka i smesta ih u array list*/
		for(int j = 0; j < 100; j ++){
			donje.add(new Prepreke((int)listadonjih.get(j)));
			gornje.add(new Prepreke((int)listagornjih.get(j)));
		}
	}
	
/* slika platno  */	
	public void paint(Graphics g) {
		if(level<6 && !svemirac.kraj() && !pocetak){													/* ukoliko nije kraj igre */
			super.paint(g);																	
			i++;																			//  cuva informaciju koje je po redu iscrtavanje
			stanje = i % 80; 																//  odredjuje koja slika karaktera ce se iscrtati da bi se dobila iluzija pokreta
			poeni += i%20==0 ? 1:0;															//  racuna poene, svako dvadeseto iscrtavanje povecava poene za jedan	
			level+= margine.nivogore(svemirac.getPocetakX());								//	ukoliko karakter prodje kroz vrata nivo-a povecava mu se nivo
			pozadina.slikaj(g);																// 	iscrtava pozadinu, margine, karaktera, prepreke	
			margine.slikaj(g);
			if(svemirac.isImapodlogu(postojidole(),postojigore(),smer)!=0){
				if(smer)
					svemirac.slikajdole(g, stanje);
				else 
					svemirac.slikajgore(g, stanje);
			}
			else{
				if(smer){
					svemirac.dole();
					svemirac.slikajskok(g, stanje);
				}
				else{
        			svemirac.gore();
        			svemirac.slikajskok(g, stanje);
        		}
			}
			for(int j = 0; j < 100; j ++){
				donje.get(j).slikajdole(g);
				gornje.get(j).slikajgore(g);
			}
			Font mali = new Font("Times new roman", Font.BOLD, 20);                         // ispisuje trenutno stanje poena i nivo-a
			g.setColor(Color.red);
			g.setFont(mali);
			g.drawString("Poeni : " + poeni,50, 25);
			g.drawString("Nivo : " + level,250, 25);
		}
		else if(pocetak) pozadina.slikajpp(g);
		else{																				// ukoliko jeste kraj ispisati broj poena
			pozadina.slikaj(g);
			Font veliki = new Font("Times new roman", Font.BOLD, 40);
			g.setColor(Color.red);
			g.setFont(veliki);
			g.drawString("Tvoj rezultat : " + poeni,150, 100);
		}
			Toolkit.getDefaultToolkit().sync();
			g.dispose();
	}
	
	
	
	public void addNotify() {
        super.addNotify();
        animator = new Thread(this);
        animator.start();
    }
	
/* izvrsava pomeranja i repaint */		
    public void run() {
        long prevremena, vremenskarazlika, spavanje;
        prevremena = System.currentTimeMillis();
        while (true) {
            margine.pomerimargine();				// pomera margine
            for(int i = 0; i < 100; i ++){			// pomera gornje i donje prepreke
    			donje.get(i).pomeriPrepreku();
    			gornje.get(i).pomeriPrepreku();
    		}
            udariouprepreku();
            repaint();

            vremenskarazlika = System.currentTimeMillis() - prevremena;
            spavanje = DELAY - level - vremenskarazlika;

            if (spavanje < 0)
                spavanje = 2;
            try {
                Thread.sleep(spavanje);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }

            prevremena = System.currentTimeMillis();
        }
    }
    
/* da li je donja prepreka usla u karakterov prostor */
	int postojidole(){
		for(int j = 0; j < 100; j ++){
			if((donje.get(j).getPozicija() < svemirac.getPocetakX() + svemirac.getSirina()) &&
					(donje.get(j).getPozicija() > svemirac.getPocetakX() - 41)) return 1;
		}
		return 0;
	}

/* da li je gornja prepreka usla u karakterov prostor */
	int postojigore(){
		for(int j = 0; j < 100; j ++){
			if((gornje.get(j).getPozicija() < svemirac.getPocetakX() + svemirac.getSirina()) &&
					(gornje.get(j).getPozicija() > svemirac.getPocetakX() - 40)) return 1;
		}
		return 0;
	}
	
/* ako udari u prepreku pomera se unazad jednu poziciju*/
	void udariouprepreku(){
		if(postojigore() == 1 && (svemirac.isImapodlogu(postojidole(),postojigore(),smer)==1 || svemirac.zapeogore()  == 1) && svemirac.getPocetakY() <= margine.getKoordinataGornje()+80)
			svemirac.unazad();
		if(postojidole() == 1 && (svemirac.isImapodlogu(postojidole(),postojigore(),smer) == 1 || svemirac.zapeodole() == 1) && svemirac.getPocetakY()+70 >= margine.getKoordinataDonje()-40)
			svemirac.unazad();
		
	}
	
	public void resetovanje(){
		i = 0;
		poeni = 0;
		level = 1;
		svemirac.setPocetakX(200);
		svemirac.setPocetakY(320);
		margine.resetNivoi();
		smer = true;
		pocetak = false;
/*Generisanje prepreka na slucajan nacin*/
		Random r = new Random();
		for(int j = 0; j < 100; j ++){
			
/*Generisanje random koordinata*/
			listadonjih.set(j,r.nextInt(30000)+800);  
			listagornjih.set(j,r.nextInt(30000)+800);
		}
		
/*Sortira koordinate*/
		Collections.sort(listadonjih);
		Collections.sort(listagornjih);
		for(int j = 0; j < 100; j ++){
			donje.set(j,new Prepreke((int)listadonjih.get(j)));
			gornje.set(j,new Prepreke((int)listagornjih.get(j)));
		}
	}
	
	

	private Pozadina pozadina = new Pozadina();						// instanca pozadine
	private final int DELAY = 6;									// vreme pauze izmedju 2 iscrtavanja
	private Thread animator;	
	private int i = 0;												// brojac iscrtavanja
	private int poeni = 0;											// broj poena
	private int stanje;												// trenutno stanje karaktera
	private int level = 1;											// trenutni nivo
    private Margine margine = new Margine();						// instanca margina
    private Svemirac svemirac = new Svemirac();						// instanca karaktera
    private boolean smer = true;									// smer gravitacije
    ArrayList<Prepreke> gornje = new ArrayList<Prepreke>();			// gornje prepreke
    ArrayList<Prepreke> donje = new ArrayList<Prepreke>();			// donje prepreke
    ArrayList<Integer>listadonjih = new ArrayList<Integer>();		// koordinate donjih prepreka
    ArrayList<Integer> listagornjih = new ArrayList<Integer>();		// koordinate gornjih prepreka
    private boolean pocetak;
}
