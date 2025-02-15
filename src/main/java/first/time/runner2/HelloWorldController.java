package first.time.runner2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello")
    public String helloWorld() {
        return "HelloWorld";
    }

    @GetMapping(path = "/hello2")
    @ResponseStatus(HttpStatus.ACCEPTED)
    // The @ResponseStatus annotation in Spring is used to mark a method or an exception class with a specific HTTP status code that should be sent in the HTTP response.
    // When applied to a method, it will instruct Spring to automatically set the status code for the HTTP response whenever that method is called.
    public String helloWorld2() {
        return "HelloWorld2";
    }

    @PostMapping("/post")
    public String post(@RequestBody String message) {
        return "Request accepted and message is: " + message;
    }

    // Assuming Order is a custom class
    @PostMapping("/post-order")
    public String postOrder(@RequestBody Order order) {
        return "Request accepted and order is: " + order.toString();
    }

    @PostMapping("/post-order-record")
    public String postRecord(@RequestBody OrderRecord order) {
        return "Request accepted and order is: " + order.toString();
    }

    @GetMapping(path = "/hello/{user-name}")
    public String pathVar(@PathVariable("user-name") String userName) {
        return "my value= "+ userName;
    }
    @GetMapping(path = "/hellop")
    public String paramVar(@RequestParam("user-name") String userName) {
        return "my value= "+ userName;
    }
}
