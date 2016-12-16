package be.tvde.lambdas.example1;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by tomvde on 25/11/2016.
 */
public class JavaFileFilter implements FileFilter {

    private static final String JAVA_ENTENSION = ".java";

    public boolean accept(File file) {
        return file.getName().endsWith(JAVA_ENTENSION);
    }
}
