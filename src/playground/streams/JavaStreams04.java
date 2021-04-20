package playground.streams;

import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
import java.util.*;
import java.nio.*;
import java.io.IOException;

// 4. Stream.of, sortted and findFirst
public class JavaStreams04 {
	public static void main(String[] args) throws IOException {
		Stream.of("Ava", "Aneri", "Alberto")	// create a stream from these string values
			.sorted()	// sort them
			.findFirst()	// find the first one only
			.ifPresent(x -> System.out.println(x));	// if a value exists, print it
		System.out.println();
	}
}

// jedit settings  :elasticTabstops=false:encoding=UTF-8: