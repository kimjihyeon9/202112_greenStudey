package myweb;

import static spark.Spark.*;

// spark 자료
// https://sparkjava.com/documentation#getting-started

public class HelloSpark {

	public static void main(String[] args) {
		get("/hello", (req, res) -> "hello spark word");
		
		get("/main", (req, res) -> {
			return "<h1>hello spark world</h>";
		});
		
		get("/member/:user/:message", (req, res) -> {
			return String.format("user:%s, message:%s\n", req.params(":user"), req.params(":message"));
		});
	}

}
