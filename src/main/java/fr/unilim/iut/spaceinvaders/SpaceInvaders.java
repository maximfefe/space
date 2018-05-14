package fr.unilim.iut.spaceinvaders;

import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;

public class SpaceInvaders {

    private static final char MARQUE_VIDE = '.';
	private static final char MARQUE_VAISSEAU = 'V';
	private static final char MARQUE_FIN_LIGNE = '\n';
	int longueur;
    int hauteur;
	private Vaisseau vaisseau;

    public SpaceInvaders(int longueur, int hauteur) {
	   this.longueur = longueur;
	   this.hauteur = hauteur;
   }
    @Override
    public String toString() {
		return recupererEspaceJeuDansChaineASCII();
	}
	
    
    public String recupererEspaceJeuDansChaineASCII() {
		StringBuilder espaceDeJeu = new StringBuilder();
		for (int y = 0; y < hauteur; y++) {
			for (int x = 0; x < longueur; x++) {
				espaceDeJeu.append(recupererMarqueDeLaPosition(x, y));
			}
			espaceDeJeu.append(MARQUE_FIN_LIGNE);
		}
		return espaceDeJeu.toString();
	}
    private char recupererMarqueDeLaPosition(int x, int y) {
        char marque;
        if (this.aUnVaisseauQuiOccupeLaPosition(x, y))
           marque=MARQUE_VAISSEAU;
        else
           marque=MARQUE_VIDE;
        return marque;
	}
	private boolean aUnVaisseauQuiOccupeLaPosition(int y, int x) {
		return this.aUnVaisseau() && vaisseau.occupeLaPosition(x, y);
	}
	private boolean aUnVaisseau() {
		return vaisseau!=null;
	}
	public void positionnerUnNouveauVaisseau(int x, int y) {
		
		if ((x<0) || (x >= longueur))
			throw new HorsEspaceJeuException("Vous êtes en dehors de l'espace jeu");
		
		if ((y<0) || (y >= hauteur))
			throw new HorsEspaceJeuException("Vous êtes en dehors de l'espace jeu");
	
		vaisseau = new Vaisseau(x, y); 


	}
}