package lexers;

public interface Lexer {
	/*
	 * restituisce il prossimo lessema a partire dalla posizione corrente nella linea e avanza
	 * nella linea; 
	 * restituisce null se nessun lessema valido viene riconosciuto, la posizione corrente rimane invariata
	 * 
	 */
	String next();

	/*
	 * restituisce il gruppo del lessema appena riconosciuto definito dall'espressione regolare associata
	 * al lexer
	 * solleva java.lang.IllegalStateException se prima 
	 * - next() non e` stato chiamato
	 * - oppure next() e` stato chiamato, ma ha restituito null
	 * - oppure reset(String line) e` stato chiamato
	 */	
	
	int group();

	/*
	 * restituisce true solo quando la posizione corrente non e` in fondo alla linea
	 */
	
	boolean hasNext();

	/*
	 * cambia la linea del lexer e aggiorna la posizione corrente al suo inizio
	 */
	
	void reset(String line);

}
