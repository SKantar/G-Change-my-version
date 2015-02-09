package gravitacija;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
public class Gravitacija extends JFrame {
	
	/*neutralisanje upozorenja*/
	private static final long serialVersionUID = 1L;

	Svemir svemir = new Svemir(true);
	public Gravitacija(){
		JMenuBar meni = new JMenuBar();
		setJMenuBar(meni);
		JMenu igra = new JMenu("Igra");
		JMenu pomoc = new JMenu("O igri");
		JMenuItem novaIgra = new JMenuItem("Nova igra");
		JMenuItem izlazak = new JMenuItem("Izlaz iz igre");
		JMenuItem uputstvo = new JMenuItem("O igri");
		JMenuItem autor = new JMenuItem("Autor");
		meni.add(igra);
		meni.add(pomoc);
		igra.add(novaIgra);
		igra.add(izlazak);
		pomoc.add(uputstvo);
		pomoc.add(autor);
		add(svemir);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Menjanje gravitacije");
		setResizable(false);
		setVisible(true);
		
		/* kad kliknemo na novu igru startuje se nova igra*/
		novaIgra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				svemir.resetovanje();
				//new Gravitacija();
			}
		});
		
		/* pritiskom na izlaz gasi se igra*/
		izlazak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		/* pritiskom na uputstvo za igru dobija otvara se novi prozor sa tekstom*/
		uputstvo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				uputstvoInfo();
			}
		});
		
		autor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				autorInfo();
			}
		});
	
	}
	public void uputstvoInfo() {
		JOptionPane.showMessageDialog(null,"Мењање гравитације јe веома једноставан концепт доведен до савршености. Мењање "+"\n"+
										   "гравитације на само једно дугме омогућава веома брз темпо игре. Са интересантном "+"\n"+
											"игривости игра постаје веома интензивна и заразна." + "\n\n" +
											"У главном моду игре морате да комплетирате пет нивоа, који ће ваше вештине доводити"+"\n"+
											"до крајњих граница у случајно осмишљеном нивоу."+
											"\n\n"+"Надам се да чете уживате у игрању ове игрице као што сам ја уживао стварајући је!") ;

	}
	
	public void autorInfo() {
		JOptionPane.showMessageDialog(null,"Слађан Кантар РН 05/12"+"\n"+
										   "Рачунарски факултет"+"\n"+
										   "skantar12@raf.edu.rs"+"\n"+
										   "0611513774\n"+
										   "мај,2013") ;

	}
	
	
	//Glavna metoda
	public static void main(String[] args) {
		new Gravitacija();

	}

}
