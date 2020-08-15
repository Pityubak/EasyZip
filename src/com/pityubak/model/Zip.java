package com.pityubak.model;

/**
 *
 * @author Pityubak
 */
public final class Zip {

    private final String source;
    private final String destination;

    public Zip(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }
}
