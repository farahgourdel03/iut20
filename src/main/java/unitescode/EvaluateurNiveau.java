package unitescode;

public class EvaluateurNiveau {

	public static final int LIMITE_NIVEAU_D_C = 30;
	public static final int LIMITE_NIVEAU_C_B = 50;
	public static final int LIMITE_NIVEAU_B_A = 70;
	
	public static final String NIVEAU_A = "A";
	public static final String NIVEAU_B = "B";
	public static final String NIVEAU_C = "C";
	public static final String NIVEAU_D = "D";
	private static final int MIN_COURS = 0;
	private static final int MAX_COURS = 25;
	private static final int MIN_EXAMEN = 0;
	private static final int MAX_EXAMEN = 75;
	
	public static boolean estEntier( String valeur ) {
		try {
			Integer.parseInt( valeur );
			return true;
		} catch( NumberFormatException e) {
			return false;
		}
	}
	
	
	public static boolean estDansInterval( int valeur, int min, int max ) {
		assert min <= max;
		return min <= valeur && valeur <= max;
	}
	
	
	public static String evaluerNiveau(String cours, String examen) throws ExceptionNoteNonEntiere, ExceptionNoteHorsBornes {
		
		if ( ! estEntier( cours )) {
			throw new ExceptionNoteNonEntiere("Cours doit être un entier");
		}
		if ( ! estEntier( examen )) {
			throw new ExceptionNoteNonEntiere("Examen doit être un entier");
		}
		int icours = Integer.parseInt( cours );
		int iexamen = Integer.parseInt( examen );
		
		if ( ! estDansInterval( icours , MIN_COURS, MAX_COURS )) {
			throw new ExceptionNoteHorsBornes("Cours hors bornes");
		}
		
		if ( ! estDansInterval( iexamen , MIN_EXAMEN, MAX_EXAMEN )) {
			throw new ExceptionNoteHorsBornes("Examen hors bornes");
		}
		
		int somme = icours + iexamen;
		String niveau = "";
		if ( somme < LIMITE_NIVEAU_D_C ) {
			niveau = NIVEAU_D;
		}
		else if ( somme < LIMITE_NIVEAU_C_B ) {
			niveau = NIVEAU_C;
		}
		else if ( somme < LIMITE_NIVEAU_B_A ) {
			niveau = NIVEAU_B;
		}
		else {
			niveau = NIVEAU_A;
		}
		return niveau;
	}

}
