package com.common.system.service.impl;

import com.common.system.service.SequenceService;
import com.common.system.util.sequence.Sequence;
import org.springframework.stereotype.Service;

/**
 * 
 */
@Service
public class SequenceServiceImpl implements SequenceService {
    private Sequence sequence = new Sequence(0, 0);
    @Override
    public String getSequenceId() {
        return String.valueOf(sequence.nextId());
    }
}
