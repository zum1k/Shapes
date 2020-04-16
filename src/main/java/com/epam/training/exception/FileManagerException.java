package com.epam.training.exception;

import java.io.IOException;

public class FileManagerException extends IOException {
    public FileManagerException(String path, IOException ex) {
        super(path, ex);
    }
}
