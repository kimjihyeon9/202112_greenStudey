package myweb;

import static spark.Spark.get;
import static spark.Spark.staticFiles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class UserController {

	public static void main_toArray(String[] args) {
		JSONObject user1 = new JSONObject();
		user1.put("name", "HONG");
		user1.put("email", "hong@a.com");
		user1.put("phone", "010-1111-1111");
		JSONObject user2 = new JSONObject();
		user2.put("name", "KIM");
		user2.put("email", "kim@a.com");
		user2.put("phone", "010-1111-2222");
		JSONArray users = new JSONArray();
		users.put(user1);
		users.put(user2);

		get("/users/", (req, res) -> {
			return users.toString(2);
		});
	}

	public static void main(String[] args) {
		staticFiles.location("/public"); // static public

		get("/home", (req, res) -> "hello word");

		// 템플릿을 사용한다
		// /resource/templates 아래에 템플릿 파일이 위치하도록 한다
		get("/users/list", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			model.put("message", "hello");
			model.put("user1", new UserDto("kim", "kim@kim.com", "010-1234-1234"));
			List<UserDto> users = new ArrayList<>();
			users.add(new UserDto("lee", "lee@lee.com", "010-1234-2345"));
			users.add(new UserDto("park", "park@park.com", "010-3456-2345"));
			users.add(new UserDto("an", "an@an.com", "010-1234-3456"));
			return render(model, "list.html");
		});
	} // end of main

	// declare this in a util-class
	public static String render(Map<String, Object> model, String templatePath) {
		return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
	}
}
