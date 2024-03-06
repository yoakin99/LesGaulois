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
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
	//	force -= forceCoup;
	//	if (force > 0) {
	//		parler("Aïe");
	//	} else {
	//		parler("J'abandonne...");
	//	}
		switch (force) {
		case 0:
			parler("Aïe");
		default:
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			break;
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}
	
	private int CalculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement!=0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;i++) {
				if (equipements[i] != null &&
						equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
			}
			;
		}
		texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
		}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		//TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (!(equipements[i] == null)) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
		nbEquipementEjecte++;
		equipements[i] = null;
			}
		}
		return equipementEjecte;
	}	
	
	public void sEqupier(Equipement equipement) {
		switch (nbEquipement) {
        case 2:
            System.out.println("Le soldat " + nom + " est déjà bien protégé !");
            break;
        case 1:
            if (equipements[0].equals(equipement)) {
                System.out.println("Le soldat " + nom + " possède déjà un " + equipement.toString() + " !");
            } else {
                equipements[nbEquipement] = equipement;
                nbEquipement++;
                System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.toString() + ".");
            }
            break;
        default:
            equipements[nbEquipement] = equipement;
            nbEquipement++;
            System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.toString() + ".");
            break;
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
