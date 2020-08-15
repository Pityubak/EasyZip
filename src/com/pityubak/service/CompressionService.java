package com.pityubak.service;

import com.pityubak.compression.Compression;
import com.pityubak.model.CompressionType;
import javafx.concurrent.Task;

/**
 *
 * @author Pityubak
 */
public class CompressionService {

    private CompressionType compressionType;

    public void execute() {
        Task<Void> compressionTask = new Task<>() {
            @Override
            protected Void call() throws Exception {
                createAndExcuteCompression();
                return null;
            }
        };
        new Thread(compressionTask).start();

    }

    private void createAndExcuteCompression() {
        if (compressionType != null) {
            for (CompressionType type : CompressionType.values()) {
                if (type.getName().equals(compressionType.getName())) {
                    State state = type.getState();
                    Compression compression = state.createCompression();
                    compression.execute();
                }
            }
        }
    }

    public void setCompressionType(CompressionType compressionType) {
        this.compressionType = compressionType;
    }
}
