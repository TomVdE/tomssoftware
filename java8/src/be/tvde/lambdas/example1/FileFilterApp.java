package be.tvde.lambdas.example1;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by tomvde on 25/11/2016.
 */
public class FileFilterApp {
    public static void main(String [] args) {
        //FileFilter implemented as a class
        JavaFileFilter fileFilter = new JavaFileFilter();
        File dir = new File("d:/tmp");

        File[] files = dir.listFiles(fileFilter);



        //FileFilter implemented as an anonymous class
        FileFilter fileFilterAnonylous = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };
        files = dir.listFiles(fileFilterAnonylous);




        //FileFilter implemented as a Lambda
        FileFilter filterWithLamdas = (File file) -> file.getName().endsWith(".java");
        files = dir.listFiles(filterWithLamdas);
    }
}
