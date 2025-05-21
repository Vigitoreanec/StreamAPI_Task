package org.top.httpparamsexample;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("params")
public class HttpParamsExampleController {

    @GetMapping("get-params")
    public String getParams(@RequestParam Integer a, @RequestParam String b) {
        return "[get-params] received: a = " + a + "; b = " + b + ";";
    }

    @PostMapping("post-params")
    public String postParams(@RequestParam Integer a, @RequestParam String b) {
        return "[post-params] received: a = " + a + "; b = " + b + ";";
    }

    @GetMapping("url-param/{v}")
    public String urlParam(@PathVariable Integer v) {
        return "[url-param] received: v = " + v + ";";
    }

    @GetMapping("header")
    public String header(@RequestHeader("X-Data") String data) {
        return "[header] received: data = " + data + ";";
    }

    @PostMapping("body")
    public String body(@RequestBody String data) {
        return "[body] received: data = " + data + ";";
    }
}
