package com.pityubak.service;

import com.pityubak.model.CompressionType;
import javafx.util.StringConverter;

/**
 *
 * @author Pityubak
 */
public class CompressionTypeConverter extends StringConverter<CompressionType> {

    @Override
    public String toString(CompressionType t) {
        return t.getName();
    }

    @Override
    public CompressionType fromString(String name) {
        for (CompressionType type : CompressionType.values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        return null;
    }

}
