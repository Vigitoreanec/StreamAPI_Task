package org.top.httpparamsexample;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tasks")
public class TaskController {

    @GetMapping("test")
    public String test() {
        return "server is running";
    }

    @PostMapping("factoreal")
    public String factoreal(@RequestParam Integer n) {
        if (n < 0 || n > 20) {
            return "'n' must be in range ['0:20']";
        }
        long fact = 1L;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        //return n + "! = " + fact;
        return String.format("%d! = %d", n, fact);
    }

    @GetMapping("convert")
    public String convert(@RequestParam String from, @RequestParam String to, @RequestParam Double value) {
//        throw new UnsupportedOperationException("Not supported yet.");
        long tempFrom = 1L;
        if (from.equals("кб")) tempFrom = 1024L;
        else if (from.equals("мб")) tempFrom = 1024L * 1024;
        else if (from.equals("гб")) tempFrom = 1024L * 1024 * 1024;
        else if (from.equals("тб")) tempFrom = 1024L * 1024 * 1024 * 1024;
        else if (!from.equals("б")) return "неправильные параметры";

        long tempTo = 1L;
        if (to.equals("кб")) tempTo = 1024L;
        else if (to.equals("мб")) tempTo = 1024L * 1024;
        else if (to.equals("гб")) tempTo = 1024L * 1024 * 1024;
        else if (to.equals("тб")) tempTo = 1024L * 1024 * 1024 * 1024;
        else if (!to.equals("б")) return "неправильные параметры";

        double result = value * tempFrom / tempTo;
        return String.format("%.2f %s = %.2f %s", value, from, result, to);
    }

    @GetMapping("compression")
    public String compression(@RequestParam String input) {

        if (input == null) {
            return "введите текст";
        }
        input = input.toLowerCase();
        StringBuilder result = new StringBuilder();
        int count = 1;
        char currentChar = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == currentChar) {
                count++;
            } else {
                if (count > 1) {
                    result.append(count);
                }
                result.append(currentChar);
                currentChar = input.charAt(i);
                count = 1;
            }
        }
        if (count > 1) {
            result.append(count);
        }
        result.append(currentChar);
        if (input.isEmpty()) {
            return "";
        }
        return result.toString();
    }

    @GetMapping("/circle/{radius}")
    public String circleArea(@PathVariable double radius) {
        if (radius <= 0) {
            return "Ошибка параметра";
        }

        // Площадь: π * r²
        // Длина окружности: 2 * π * r
        double area = Math.PI * radius * radius;
        double length = 2 * Math.PI * radius;
        return String.format("площадь: %.2f, длина окружности: %.2f",
                Math.round(area * 10000) / 10000.0,
                Math.round(length * 10000) / 10000.0);
    }

    @GetMapping("pythagor")
    public String pythagor(@RequestParam Integer a, @RequestParam Integer b) {
        //c² = a² + b²
        if (a <= 0 || b <= 0) {
            return "Ошибка: оба катета должны быть больше '0'";
        }
        double c = Math.sqrt(a*a + b*b);
        return String.format("Гипотенуза = %.3f", c);
    }
}
