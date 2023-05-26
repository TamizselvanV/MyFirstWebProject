package com.in28minutes.springbootproject.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	@RequestMapping("sayHello")
	@ResponseBody
	public String sayHello() {

		return "Hello! What are you learning today???";
	}

	@RequestMapping("sayHelloHTML")
	@ResponseBody
	public String sayHelloHTML() {

		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My First HTML Page</title>");
		sb.append("</head>");
		sb.append("<body>My first HTML Body</body>");
		sb.append("</html>");
		return sb.toString();
	}

	@RequestMapping("say-Hello-JSP")
	public String sayHelloJSP() {

		return "sayHello";
	}
}
