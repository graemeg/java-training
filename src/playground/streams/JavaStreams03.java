package playground.streams;

import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
import java.util.*;
import java.nio.*;
import java.io.IOException;

// 3. Integer Stream with sum
public class JavaStreams03 {
	public static void main(String[] args) throws IOException {
		
		System.out.println(
			IntStream			// IntStream result is an argument to println() 
				.range(1, 5)	// integers 1-4, with 5 exclusive
				.sum());		// sum all the numbers
		System.out.println();
	}
}

// jedit settings  :elasticTabstops=false:encoding=UTF-8: