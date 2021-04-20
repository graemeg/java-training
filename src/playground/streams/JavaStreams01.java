package playground.streams;

import java.util.stream.IntStream;

// 1. Integer streams
public class JavaStreams01 {

	public static void main(String[] args) {
		IntStream
			.rangeClosed(1, 9)	// numbers 1-9 inclusive
			.forEach(System.out::print);	// our terminal operation - print each number
		System.out.println();
	}

}

// jedit settings  :elasticTabstops=true:encoding=UTF-8:
