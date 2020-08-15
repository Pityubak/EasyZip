package com.pityubak.service;

import com.pityubak.compression.Compression;
import com.pityubak.compression.ZipDecompression;
import com.pityubak.model.Zip;
import java.io.File;
import java.util.regex.Pattern;

/**
 *
 * @author Pityubak
 */
public class DecompressState extends State {

    @Override
    public Compression createCompression() {
        String[] dest = sourcePath.split(Pattern.quote(File.separator));
        String destinationPath = sourcePath.replace(dest[dest.length - 1], "");
        Zip zip = new Zip(sourcePath, destinationPath);
        return new ZipDecompression(zip);
    }

}
