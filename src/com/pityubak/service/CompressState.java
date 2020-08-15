package com.pityubak.service;

import com.pityubak.compression.Compression;
import com.pityubak.compression.ZipCompression;
import com.pityubak.model.Zip;

/**
 *
 * @author Pityubak
 */
public class CompressState extends State {
 
    @Override
    public Compression createCompression() {
        Zip zip = new Zip(sourcePath, sourcePath);
        return new ZipCompression(zip);
    }

}
