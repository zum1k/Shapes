package com.epam.training.exception;

import java.io.IOException;

public class RepositoryException extends IOException {
    public RepositoryException(String path, IOException ex) {
        super(path, ex);
    }
}
