package com.pityubak.service;

import com.pityubak.compression.Compression;

/**
 *
 * @author Pityubak
 */
public abstract class State {

    protected String sourcePath;
    protected String destination;

    public abstract Compression createCompression();

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
