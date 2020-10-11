package com.gatech.diabeteschecker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @CrossOrigin(origins = "https://limitless-wildwood-48331.herokuapp.com/")
    public TestCode addTestCode(@RequestBody TestCode testCode) {
        return testCodeService.addCode(testCode);
    }

    @PutMapping(value = "/testCode")
    @CrossOrigin(origins = "https://limitless-wildwood-48331.herokuapp.com/")
    public TestCode updateTestCode(@RequestBody TestCode testCode) {
        return testCodeService.updateCode(testCode);
    }
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
