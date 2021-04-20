package playground.streams;

import java.util.stream.*;

// 2. Integer Stream with skip
public class JavaStreams02 {
	public static void main(String[] args) {
		IntStream
			.range(1, 10)	// numbers 1-9. 10 is exclusive.
			.skip(5)	// skip the first 5
			.forEach(x -> System.out.println(x));	// our terminal operation - a lambda expression to print each number
		System.out.println();
	}
}

// jedit settings  :elasticTabstops=true:encoding=UTF-8: