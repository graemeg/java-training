package playground.jdk17;

public class BlockText {

	public static void main(String[] args) {
		String s = """
				This is some
				block text that
				is very easy to add to your code now.

				Interestingly, prefixed spaces are
				automatically remove, which is very cool.
				""";
		System.out.println(s);

		String response_template = """
				{
				  "name": "$name",
				  "surname": "$surname",
				  "address": [
				  	{
				  		"street": "10 Long Street",
				  		"city": "$city",
				  		"postcode": "SE1 5LX"
				  	}
				  ]
				}
				""";
		System.out.println("The response template:\n" + response_template);

		String response = response_template.replace("$name", "John")
				.replace("$surname", "Walker")
				.replace("$city", "London");
		System.out.println("The response:\n" + response);
	}

}
