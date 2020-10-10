package com.gatech.diabeteschecker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ConditionController {
//    @Autowired
//    TestCodeRepository testCodeRepository;

    @RequestMapping("/")
    public String index() {
        return "Hello there";
    }

//    @GetMapping(value = "/")
//    public ResponseEntity index() {
//        return ResponseEntity.ok(testCodeRepository.findAll());
//    }

//    @GetMapping(value = "/bucket")
//    public ResponseEntity getBucket(@RequestParam(value = "id") Long id) {
//        Optional<TestCode> foundTestCode = testCodeRepository.findById(id);
//
//        if (foundTestCode.isPresent()) {
//            return ResponseEntity.ok(foundTestCode.get());
//        } else {
//            return ResponseEntity.badRequest().body("No bucket with specified id " + id + " found");
//        }
//    }
//
//    @PostMapping(value = "/")
//    public ResponseEntity addToTestCode(@RequestParam(value = "name") String name, @RequestParam(value = "description") String desc) {
//        return ResponseEntity.ok(testCodeRepository.save(new TestCode(name, desc)));
//    }
//
//    @PutMapping(value = "/")
//    public ResponseEntity updateTestCode(@RequestParam(value = "name") String name, @RequestParam(value = "id") Long id, @RequestParam(value = "description") String desc) {
//        Optional<TestCode> optionalTestCode = testCodeRepository.findById(id);
//        if (!optionalTestCode.isPresent()) {
//            return ResponseEntity.badRequest().body("No bucket with specified id " + id + " found");
//        }
//
//        TestCode foundTestCode = optionalTestCode.get();
//        foundTestCode.setName(name);
//        foundTestCode.setDescription(desc);
//
//        return ResponseEntity.ok(testCodeRepository.save(foundTestCode));
//    }
//
//    @DeleteMapping(value = "/")
//    public ResponseEntity removeTestCode(@RequestParam(value = "id") Long id) {
//        testCodeRepository.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
}
