package com.pityubak.compression;

import com.pityubak.model.Zip;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author Pityubak
 */
public class ZipDecompression implements Compression {

    private final Zip unzippedObject;

    public ZipDecompression(Zip unzippedObject) {
        this.unzippedObject = unzippedObject;
    }

    @Override
    public void execute() {

        final String source = unzippedObject.getSource();
        final String destination = unzippedObject.getDestination();
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(source))) {
            ZipEntry entry = zipInputStream.getNextEntry();
            File destinationDir = new File(destination);
            while (entry != null) {
                File newFile = avoidZipSlip(destinationDir, entry);
                FileOutputStream fileOutputStream = new FileOutputStream(newFile);
                byte[] fragments = new byte[1024];
                int length;
                while ((length = zipInputStream.read(fragments)) > 0) {
                    fileOutputStream.write(fragments, 0, length);

                }
                entry = zipInputStream.getNextEntry();
            }
            zipInputStream.closeEntry();
        } catch (IOException ex) {

        }

    }

    private File avoidZipSlip(File destination, ZipEntry entry) throws IOException {
        File file = new File(destination, entry.getName());
        String destinationPath = destination.getCanonicalPath();
        String destinationFilePath = file.getCanonicalPath();

        if (!destinationFilePath.startsWith(destinationPath + File.separator)) {
            throw new RuntimeException();
        }
        return file;
    }

}
