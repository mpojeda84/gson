package com.mapr.demos.gson;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class CustomDirectoryWatcherExample {
 
    public static void main(String[] args) throws InterruptedException, IOException {


        while(true) {
            Path path = Paths.get("/mapr/dmitry001.hpe.com/user/mapr/tmp/folder");
            Files.list(path).forEach(file -> {

            });
        }


    }
}