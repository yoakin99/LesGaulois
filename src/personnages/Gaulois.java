package personnages;

import java.util.Iterator;


public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nbtrophees;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
		}
	
	//public void frapper(Romains romain) {
	//	System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
	//	romain.recevoirCoup(force / 3*(effetPotion));
	//}
	public void frapper(Romains romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] nouveautrophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; nouveautrophees != null && i < nouveautrophees.length; i++,nbtrophees++) {
			this.trophees[nbtrophees] = nouveautrophees[i];
		}
		}
	public void boirePotion (int forcePotion) {
		effetPotion += forcePotion;
		parler("Merci Druide, je sens que ma force est "+forcePotion+" fois décuplée.");
	}
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	public static void main(String[] args) {
		//TODO créer un main permettant de tester la classe Gaulois
		Gaulois asterix = new Gaulois ("asterix21",8) ;
		Romains obelix = new Romains ("obelix",8) ;
		System.out.println(asterix);
		System.out.println(asterix.toString());
		asterix.prendreParole() ;
		asterix.parler("Hello") ;
		//asterix.frapper(obelix) ;
		asterix.boirePotion(6);

	}
}