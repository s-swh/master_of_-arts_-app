package com.wd.master_of_arts_app.io;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/8 10:55
 */
public class FileNameSelector implements FilenameFilter {
    String extension = ".";
    public FileNameSelector(String fileExtensionNoDot) {
        extension += fileExtensionNoDot;
    }

    @Override

    public boolean accept(File dir, String name) {
        return name.endsWith(extension);
    }

}
