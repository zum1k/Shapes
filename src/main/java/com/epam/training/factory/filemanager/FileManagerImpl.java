package com.epam.training.factory.filemanager;

import com.epam.training.exception.FileManagerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileManagerImpl implements FileManager {
    private static final Logger logger = LogManager.getLogger(FileManagerImpl.class);

    @Override
    public List<String> readStrings() throws FileManagerException {
        List<String> lines;
        Path path = Paths.get("src/main/resources/Points.txt");

        try (Stream<String> lineStream = Files.newBufferedReader(path).lines()) {
            lines = lineStream.collect(Collectors.toList());
        } catch (IOException ex) {
            logger.error("Ошибка чтения", ex);
            throw new FileManagerException("Ошибка чтения", ex);

        }
        logger.info("File read:" + lines);
        return lines;
    }

    List<String> readStrings(String path) throws FileManagerException {
        List<String> lines;
        Path filePath = Paths.get(path);

        try (Stream<String> lineStream = Files.newBufferedReader(filePath).lines()) {
            lines = lineStream.collect(Collectors.toList());
        } catch (IOException ex) {
            logger.error("Ошибка чтения", ex);
            throw new FileManagerException("Ошибка чтения", ex);

        }
        logger.info("File read:" + lines);
        return lines;
    }
}
