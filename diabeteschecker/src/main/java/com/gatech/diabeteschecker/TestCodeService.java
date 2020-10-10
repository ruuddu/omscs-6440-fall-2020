package com.gatech.diabeteschecker;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestCodeService {
    private final TestCodeRepository testCodeRepository;

    @Autowired
    public TestCodeService(TestCodeRepository testCodeRepository) {
        this.testCodeRepository = testCodeRepository;
    }


    public List<TestCode> findAll() {
        return testCodeRepository.findAll();
    }

    public TestCode addCode(TestCode testCode) {
        TestCode newCode = new TestCode();
        newCode.setCode(testCode.getCode());
        newCode.setNormalLimit(testCode.getNormalLimit());
        newCode.setPrediabetesMin(testCode.getPrediabetesMin());
        newCode.setPrediabetesMax(testCode.getPrediabetesMax());
        newCode.setDiabetesLimit(testCode.getDiabetesLimit());
        return testCodeRepository.save(newCode);
    }

    public TestCode updateCode(TestCode testCode) {
        Optional<TestCode> currentCode = testCodeRepository.findById(testCode.getId());
        if (currentCode.isPresent()) {
            TestCode existingCode = currentCode.get();
            existingCode.setCode(testCode.getCode());
            existingCode.setNormalLimit(testCode.getNormalLimit());
            existingCode.setPrediabetesMin(testCode.getPrediabetesMin());
            existingCode.setPrediabetesMax(testCode.getPrediabetesMax());
            existingCode.setDiabetesLimit(testCode.getDiabetesLimit());
            return testCodeRepository.save(existingCode);
        } else {
            return null;
        }
    }

}
