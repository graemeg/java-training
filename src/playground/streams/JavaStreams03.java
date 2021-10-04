package playground.streams;

import java.util.stream.IntStream;

// 3. Integer Stream with sum
public class JavaStreams03 {
	public static void main(String[] args) {

		System.out.println(
			IntStream			// IntStream result is an argument to println()
					.range(1, 5)	// integers 1-4, with 5 exclusive
					.sum());		// sum all the numbers
		System.out.println();
	}
}

// jedit settings :elasticTabstops=false:encoding=UTF-8: