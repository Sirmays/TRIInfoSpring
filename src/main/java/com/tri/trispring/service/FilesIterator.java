package com.tri.trispring.service;

import org.springframework.stereotype.Component;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class FilesIterator {

    public FilesIterator() {
    }

    public static List<String> filesSearch() {
        String path = "INPUTFILES";
        List<String> filestoparse = new ArrayList();
        File folder = new File(path);
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                File[] var4 = files;
                int var5 = files.length;

                for (int var6 = 0; var6 < var5; ++var6) {
                    File file = var4[var6];
                    if (file.isFile()) {
                        filestoparse.add(file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("The folder is empty.");
            }
        } else {
            System.out.println("The specified path is not a valid directory.");
        }
        return filestoparse;
    }


}
