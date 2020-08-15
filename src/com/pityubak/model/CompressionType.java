package com.pityubak.model;

import com.pityubak.service.CompressAsState;
import com.pityubak.service.CompressState;
import com.pityubak.service.DecompressAsState;
import com.pityubak.service.DecompressState;
import com.pityubak.service.State;

/**
 *
 * @author Pityubak
 */
public enum CompressionType {
    COMPRESS("Compress", new CompressState()),
    DECOMPRESS("Decompress", new DecompressState()),
    COMPRESS_AS("Compress as...", new CompressAsState()),
    DECOMPRESS_AS("Decompress as...", new DecompressAsState());

    private final String name;
    private final State state;

    private CompressionType(String porcess, State state) {
        this.name = porcess;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }

    
}
