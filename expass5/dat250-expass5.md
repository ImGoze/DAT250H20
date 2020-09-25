# DAT250 - Expass 5 

### Experiment 1 - Getting started 
I created a *Spring Root Project* which I added the Web dependency in. I generated the .zip folder unzipped it, and run it in IntellIJ. 

I added the following code in ```DemoApplication.java```: 

```java
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
}
```
Running the application:

![](img/springRun.PNG)


opening ```http://localhost:8080/hello``` in browser outputs the following shown in the screenshot: 

![](img/helloWorld.PNG)

We can modify the ```name```-variable shown in the return statement, to customize what to be shown when *localhost:8080/hello* gets called. It looks something like this:

![](img/modifiedname.PNG)

### Experiment 2 - Spring Boot