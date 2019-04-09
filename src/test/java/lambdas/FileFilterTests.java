package lambdas;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;

import static org.junit.Assert.*;

public class FileFilterTests {
    @Test
    public void listFilesWithoutFilter(){
        File dir = new File("src/main/java");
        File[] files = dir.listFiles();
        for(File file : files){
            System.out.println(file);
        }
        assertEquals(19, files.length);
    }

    @Test
    public void listOnlyDirectories_usingAnonInnerClass() {
        File dir = new File("src/main/java");
        File[] directories = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        for (File file : directories){
            System.out.println(file);
        }
        assertEquals(11, directories.length);
    }

    @Test
    public void listOnlyDirectories_usingLambda() {
        File dir = new File("src/main/java");
        File[] directories = dir.listFiles(pathname -> pathname.isDirectory());
        for (File file : directories){
            System.out.println(file);
        }
        assertEquals(11, directories.length);
    }

    @Test
    public void listOnlyDirectories_usingMethodReference() {
        File dir = new File("src/main/java");
        File[] directories = dir.listFiles(File::isDirectory);
        for (File file : directories){
            System.out.println(file);
        }
        assertEquals(11, directories.length);
    }
}
