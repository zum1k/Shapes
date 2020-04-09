package com.epam.training.factory.filemanager;




import java.io.IOException;
import java.util.List;

public interface FileManager {
    List<String> readStrings() throws  IOException;
}
