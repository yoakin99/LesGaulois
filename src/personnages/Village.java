package personnages;

import java.util.Arrays;

public class Village {
	private String nom;
    private Chef chef;
    private Gaulois[] villageois;
    public int nbVillageois=0;
    
	public Village(String nom, int nbVillageoisMaximum , String nomChef, int forceChef) {
		this.nom = nom;
		villageois=new Gaulois[nbVillageoisMaximum];
		chef= new Chef(nomChef,forceChef,this);
	}
	
	public void setChef(Chef chef) {
        this.chef = chef;
    }

	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois]=gaulois;		
		nbVillageois++;
		
	}
	
	public Gaulois trouverHabitant(int numero) {
		return villageois[numero];
	}
	public void afficherVillageois() {
		System.out.println("Dans le village du chef "+chef.getNom()+"vivent les legendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- "+(villageois[i]).getNom());
		}
	}
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles",30) ;
		//Gaulois gaulois = village.trouverHabitant(30);
		//The value of the local variable gaulois is not used
		Chef abraracourcix = new Chef ("abraracourcix",6,village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois ("asterix",8) ;
		village.ajouterHabitant(asterix);
		//Gaulois gaulois = village.trouverHabitant(0);
		//System.out.println(gaulois);
		// null car aucun elememnt dans la deuxieme case de la liste
		Gaulois obelix = new Gaulois ("obelix",25) ;
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}
}
