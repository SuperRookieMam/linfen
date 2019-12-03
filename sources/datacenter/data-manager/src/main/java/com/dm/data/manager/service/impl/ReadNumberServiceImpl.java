package com.dm.data.manager.service.impl;

import com.dm.data.manager.entity.ReadNumber;
import com.dm.data.manager.repository.ReadNumberRepository;
import com.dm.data.manager.service.ReadNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ReadNumberServiceImpl extends ApiServiceImpl<ReadNumber> implements ReadNumberService {
    @Autowired
    private ReadNumberRepository readNumberRepository;

    @Override
    public Integer findNumberBySourceId(Long sourceId) {
        Optional<ReadNumber> readNumber = readNumberRepository.findBySourceId(sourceId);
        if (readNumber.isPresent()) {
            return readNumber.get().getNumber();
        } else {
            ReadNumber readNumber2 = new ReadNumber();
            readNumber2.setSourceId(sourceId);
            readNumberRepository.save(readNumber2);
            return readNumberRepository.findBySourceId(sourceId).get().getNumber();
        }
    }

    @Override
    @Transactional
    public ReadNumber addOne(Long sourceId) {
        Optional<ReadNumber> readNumberOptional = readNumberRepository.findBySourceId(sourceId);
        if (readNumberOptional.isPresent()) {
            ReadNumber readNumber = readNumberOptional.get();
            readNumber.setNumber(readNumber.getNumber() + 1);
            return readNumberRepository.save(readNumber);
        } else {
            ReadNumber readNumber2 = new ReadNumber();
            readNumber2.setSourceId(sourceId);
            return readNumberRepository.save(readNumber2);
        }
    }

}
