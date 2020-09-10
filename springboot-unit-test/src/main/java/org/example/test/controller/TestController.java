package org.example.test.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/10 20:17
 */
@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping("/hi")
    public ResponseEntity<Object> hi(@RequestParam String name) {
        return ResponseEntity.ok("hi " + name);
    }

    @PostMapping("/hello")
    public ResponseEntity<Object> hello(@RequestBody Map<String, Object> map) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("msg", "hello " + map.get("name"));

        return ResponseEntity.ok()
                             .contentType(MediaType.APPLICATION_JSON_UTF8)
                             .body(result);
    }
}
