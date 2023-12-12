package lexers;

import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineLexer implements Lexer {

	private final Matcher matcher;
	private MatchResult result; // risultato dell'ultimo match che ha avuto successo; definito solo se il metodo
								// 'reset()' non è stato chiamato

	private MatchResult getResult() {
		if (this.result == null)
			throw new IllegalStateException();
		return this.result;
	}

	protected LineLexer(String line, String regEx) {
		this.matcher = Pattern.compile(regEx).matcher(line);
	}

	public static LineLexer withLineRegex(String line, String regEx) {
		return new LineLexer(line, regEx);
	}

	public static LineLexer withRegex(String regEx) {
		return new LineLexer("", regEx);
	}

	public String next() {
		// completare
		this.result = null;
		if(!this.matcher.lookingAt()) return null;
		this.result = this.matcher.toMatchResult();
		this.matcher.region(this.matcher.end(), this.matcher.regionEnd());
		return result.group();
	}

	public int group() {
		// completare
		MatchResult res = this.getResult();
		int groups = res.groupCount();
		for(int group = 1; group <= groups; group++) {
			if(res.group(group) != null) return group;
		}
		throw new AssertionError("Unexpected Error");
	}

	public boolean hasNext() {
		// completare
		return this.matcher.regionStart() < this.matcher.regionEnd();
	}

	public void reset(String line) {
		// completare
		
	}
}