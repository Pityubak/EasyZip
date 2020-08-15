package com.pityubak.service;

import com.pityubak.compression.Compression;
import com.pityubak.compression.ZipDecompression;
import com.pityubak.model.Zip;
import java.io.File;

/**
 *
 * @author Pityubak
 */
public class DecompressAsState extends State {

    @Override
    public Compression createCompression() {
        File file = new File(destination);
        if (file.mkdir()) {
            Zip zip = new Zip(sourcePath, destination);
            return new ZipDecompression(zip);
        }
        Zip zip = new Zip(sourcePath, sourcePath);
        return new ZipDecompression(zip);
    }

}
