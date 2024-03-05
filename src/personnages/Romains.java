package personnages;
import java.util.Arrays;

public class Romains{
	private String nom;
	private int force;
	private Equipement[] equipements ;
	private int nbEquipement=0;
	public Romains(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.equipements=new Equipement[2];
		assert force>=0 : "Erreur";
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + "]"; 
	}
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}
	public void sEqupier(Equipement equipement) {
		if (nbEquipement >= 2) {
			System.out.println("Le soldat "+nom+" est déjà bien protégé");
		} else {
			equipements[nbEquipement];
		}
	}
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois ("asterix",8) ;
		Romains obelix = new Romains ("obelix",9) ;
		System.out.println(obelix);
		System.out.println(asterix);
		asterix.parler("Hello") ;
		asterix.frapper(obelix) ;
		System.out.println(Equipement.CASQUE);
		System.out.println(Arrays.toString(obelix.equipements));
	
	}
}
