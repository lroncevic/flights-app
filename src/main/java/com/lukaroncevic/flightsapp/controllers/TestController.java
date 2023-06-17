package com.lukaroncevic.flightsapp.controllers;

import com.lukaroncevic.flightsapp.dto.TestDto;
import com.lukaroncevic.flightsapp.form.TestForm;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/test")
@RestController
public class TestController {

    @GetMapping("get")
    public String testGet(){
        return "OK";
    }

    @GetMapping("get/{param}")
    public String testGetWithParam(@PathVariable String param){
        return param;
    }

    @GetMapping("getResponse")
    public ResponseEntity<String> testResponseGet(){
        return ResponseEntity
                .internalServerError()
                .header("testHeader", "example")
                .body("Error");
    }

    @GetMapping("getDto")
    public ResponseEntity<TestDto> testGetDto(){
        TestDto testDto = new TestDto();
        testDto.setName("Name");
        testDto.setDescription("Example");

        return ResponseEntity
                .ok()
                .body(testDto);
    }

    @PostMapping("post")
    public ResponseEntity<TestDto> testPostWithParam(@RequestBody @Valid TestForm testForm){
        TestDto testDto = new TestDto();
        testDto.setName(testForm.getName());
        testDto.setDescription(testForm.getDescription());
        testDto.setOrder(testForm.getOrder());

        return ResponseEntity
                .ok()
                .body(testDto);
    }
}
