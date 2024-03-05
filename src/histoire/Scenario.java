package histoire;
import personnages.* ;


public class Scenario {

	public static void main(String[] args) {
		//TODO créer un main permettant de tester la classe Gaulois
		Gaulois asterix = new Gaulois ("asterix",8) ;
		Gaulois obelix = new Gaulois ("obelix",25) ;
		Druide panoramix = new Druide ("panoramix",5,10);
		panoramix.parler(" Je vais aller préparer une petite potion... ");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		asterix.boirePotion(panoramix.getForcePotion());
		Romains minus = new Romains ("minus",6) ;
		asterix.parler("Bonjour à tous") ;
		minus.parler(" UN GAU... UN GAUGAU...") ;
		asterix.frapper(minus) ;

	}
}
