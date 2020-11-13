package unitescode;

public class LanceurEvaluateur {

	public static void main(String[] args) {
		
		int nbArgs = args.length;
		if(nbArgs == 2) {
			try {
				String cours = args[0];
				String examen = args[1];
				String niveau = EvaluateurNiveau.evaluerNiveau(cours, examen);
				System.out.println("Niveau étudiant : " + niveau);
			}
			catch (ExceptionNoteHorsBornes enhb) {
				System.out.println("Note(s) hors bornes : cours [0..25], examen [0..75]");
			}
			catch (ExceptionNoteNonEntiere enne) {
				System.out.println("Note(s) non entière(s)");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("2 arguments attendus : cours et examen");
		}
	}
}
