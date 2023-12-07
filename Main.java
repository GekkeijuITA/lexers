package lexers;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Lexer lexer = LineLexer.withRegex("([a-zA-Z][\\w\\d]*)|(\\d+)|(\\s+)");
		while (scanner.hasNextLine()) {
			lexer.reset(scanner.nextLine());
			while (lexer.hasNext()) {
				String l = lexer.next();
				if (l != null) {
					System.out.println("lexeme: '" + l + "'" + " group: " + lexer.group());
				} else {
					System.err.println("error, skipping the line");
					break;
				}
			}
		}
		scanner.close();
	}

}
