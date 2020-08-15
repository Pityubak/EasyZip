package com.pityubak.compression;

import com.pityubak.model.Zip;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author Pityubak
 */
public class ZipCompression implements Compression {

    private final Zip zippedObject;

    public ZipCompression(Zip zippedObject) {
        this.zippedObject = zippedObject;
    }

    @Override
    public void execute() {
        final String destinationPath = zippedObject.getDestination();
        final String sourcePath = zippedObject.getSource();

        try {
            try (FileOutputStream fileOutputStream = new FileOutputStream(destinationPath + ".zip")) {

                try (ZipOutputStream zip = new ZipOutputStream(fileOutputStream)) {
                    File srcFile = new File(sourcePath);
                    try (FileInputStream fileInputStream = new FileInputStream(srcFile)) {
                        ZipEntry entry = new ZipEntry(srcFile.getName());
                        zip.putNextEntry(entry);
                        byte[] fragments = new byte[1024];
                        int length;
                        while ((length = fileInputStream.read(fragments)) >= 0) {
                            zip.write(fragments, 0, length);

                        }
                    }
                }
            }
        } catch (IOException exception) {
              
        }

    }

}
