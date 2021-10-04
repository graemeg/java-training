package playground.streams;

import java.io.IOException;
import java.util.stream.Stream;

// 4. Stream.of, sorted and findFirst
public class JavaStreams04 {
	public static void main(String[] args) throws IOException {
		Stream.of("Ava", "Aneri", "Alberto")	// create a stream from these string values
				.sorted()	// sort them
				.findFirst()	// find the first one only
				.ifPresent(x -> System.out.println(x));	// if a value exists, print it
		System.out.println();
	}
}

// jedit settings :elasticTabstops=false:encoding=UTF-8: