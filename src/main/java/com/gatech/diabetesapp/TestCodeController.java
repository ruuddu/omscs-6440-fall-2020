package com.gatech.diabetesapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestCodeController {

    @Autowired
    TestCodeService testCodeService;

    @RequestMapping("/")
    public String index() {
        return "Hello there";
    }

//    @CrossOrigin(origins = "https://limitless-wildwood-48331.herokuapp.com/")
    @CrossOrigin
    @GetMapping(value = "/getAllTestCode")
    public List<TestCode> findAll() {
        return testCodeService.findAll();
    }

    @PostMapping(value = "/testCode")
//    @CrossOrigin(origins = "https://limitless-wildwood-48331.herokuapp.com/")
    @CrossOrigin
    public TestCode addTestCode(@RequestBody TestCode testCode) {
        return testCodeService.addCode(testCode);
    }

    @PutMapping(value = "/testCode")
    @CrossOrigin(origins = "https://limitless-wildwood-48331.herokuapp.com/")
    public TestCode updateTestCode(@RequestBody TestCode testCode) {
        return testCodeService.updateCode(testCode);
    }

//    @DeleteMapping(value = "/")
//    public ResponseEntity removeTestCode(@RequestParam(value = "id") Long id) {
//        testCodeRepository.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
}
