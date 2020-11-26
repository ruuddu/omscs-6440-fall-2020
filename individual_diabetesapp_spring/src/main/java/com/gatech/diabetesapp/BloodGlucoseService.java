package com.gatech.diabetesapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloodGlucoseService {
    private final BloodGlucoseRepository bloodGlucoseRepository;

    @Autowired
    public BloodGlucoseService(BloodGlucoseRepository bloodGlucoseRepository) {
        this.bloodGlucoseRepository = bloodGlucoseRepository;
    }


    public List<BloodGlucose> findAll() {
        return bloodGlucoseRepository.findAll();
    }

    public BloodGlucose addRecord(BloodGlucose newRecord) {
//        BloodGlucose newRecord = new TestCode();
//        newCode.setCode(testCode.getCode());
//        newCode.setNormalLimit(testCode.getNormalLimit());
//        newCode.setPrediabetesMin(testCode.getPrediabetesMin());
//        newCode.setPrediabetesMax(testCode.getPrediabetesMax());
//        newCode.setDiabetesLimit(testCode.getDiabetesLimit());
        return bloodGlucoseRepository.save(newRecord);
    }

    public BloodGlucose deleteRecord(BloodGlucose bloodGlucose) {
//        Optional<TestCode> currentCode = bloodGlucoseRepository.findById(testCode.getId());
//        if (currentCode.isPresent()) {
//            TestCode existingCode = currentCode.get();
//            existingCode.setCode(testCode.getCode());
//            existingCode.setNormalLimit(testCode.getNormalLimit());
//            existingCode.setPrediabetesMin(testCode.getPrediabetesMin());
//            existingCode.setPrediabetesMax(testCode.getPrediabetesMax());
//            existingCode.setDiabetesLimit(testCode.getDiabetesLimit());
//            return bloodGlucoseRepository.save(existingCode);
//        } else {
//            return null;
//        }
        return null;
    }
}
