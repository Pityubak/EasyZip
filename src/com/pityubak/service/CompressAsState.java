package com.pityubak.service;

import com.pityubak.compression.Compression;
import com.pityubak.compression.ZipCompression;
import com.pityubak.model.Zip;

/**
 *
 * @author Pityubak
 */
public class CompressAsState extends State {

    @Override
    public Compression createCompression() {
        Zip zip = new Zip(sourcePath, destination);
        return new ZipCompression(zip);
    }

}
