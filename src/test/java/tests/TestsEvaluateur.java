package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import unitescode.EvaluateurNiveau;
import unitescode.ExceptionNoteHorsBornes;
import unitescode.ExceptionNoteNonEntiere;

class TestsEvaluateur {

	@ParameterizedTest( name="Test limite avec cours={0} et examen={1} niveau attendu : {2}")
	@CsvSource({"0,0,D" ,
				"25,4,D" ,
				"0,30,C",
				"20,29,C",
				"20,30,B",
				"25,44,B",
				"25,45,A",
				"25,75,A"})
	void testLimite( String cours,String examen, String niveauAttendu ) throws ExceptionNoteNonEntiere, ExceptionNoteHorsBornes {
		String niveauObtenu = EvaluateurNiveau.evaluerNiveau( cours , examen );
	    assertEquals( niveauAttendu , niveauObtenu );
	}

	@ParameterizedTest( name="Test ExceptionNoteNonEntiere est lancée avec cours={0} et examen= {1}")
	@CsvSource({"10.25,20",
				"xxxx,20",
				"10,50.345",
				"10,exam"})
	public void testExceptionSiCoursOuExamenNonEntier( String cours, String examen) {
	    assertThrows( ExceptionNoteNonEntiere.class,
	    		() -> { EvaluateurNiveau.evaluerNiveau( cours , examen );});	
	
	}
	
	@ParameterizedTest( name="Test ExceptionNoteHorsBornes est lancée avec cours={0} et examen= {1}")
	@CsvSource({"-1,20",
				"26,20",
				"10,-1",
				"10,76"})
	public void testExceptionSiCoursOuExamenHorsBornes( String cours, String examen) {
	    assertThrows( ExceptionNoteHorsBornes.class,
	    		() -> { EvaluateurNiveau.evaluerNiveau( cours , examen );});	
	
	}
	
	
	
	
	
	
	
}
