package xframe.nio.channel;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

/**
 *
 * @author Apress
 */
public class Main {

//    public static void main(String[] args) {
//
//        Path path = Paths.get("C:/", "MovistarOpen.txt");
//        ByteBuffer buffer_1 = ByteBuffer.wrap("Great players participate in our tournament, like: Tommy Robredo, Fernando Gonzalez, Jose Acasuso or Thomaz Bellucci.".getBytes());
//        ByteBuffer buffer_2 = ByteBuffer.wrap("Gonzalez".getBytes());
//
//        try (SeekableByteChannel seekableByteChannel = (Files.newByteChannel(path, EnumSet.of(StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE)))) {
//
//            seekableByteChannel.position(seekableByteChannel.size());
//            
//            while (buffer_1.hasRemaining()) {
//                seekableByteChannel.write(buffer_1);
//            }
//
//            seekableByteChannel.position(301);
//            
//            while (buffer_2.hasRemaining()) {
//                seekableByteChannel.write(buffer_2);
//            }
//            
//            buffer_1.clear();
//            buffer_2.clear();
//
//        } catch (IOException ex) {
//            System.err.println(ex);
//        }
//    }
	
//	public static void main(String[] args) {
//
//        Path path = Paths.get("C:", "rafaelnadal/tournaments/2009", "BNP.txt");
//        
//        System.out.println("The file/directory indicated by path: " + path.getFileName());
//        System.out.println("Root of this path: " + path.getRoot());
//        System.out.println("Parent: " + path.getParent());
//        System.out.println("Number of name elements is path: " + path.getNameCount());
//        for (int i = 0; i < path.getNameCount(); i++) {
//            System.out.println("Name element " + i + " is: " + path.getName(i));
//        }
//        System.out.println("Subpath (0,3): " + path.subpath(0, 3));
//    }
	
	
//	   public static void main(String[] args) {
//
//	        Path path = Paths.get("/rafaelnadal/tournaments/2009", "BNP.txt");
//
//	        //convert path to String
//	        String path_to_string = path.toString();
//	        System.out.println("Path to String: " + path_to_string);
//
//	        //convert path to an URI (browser format)
//	        URI path_to_uri = path.toUri();
//	        System.out.println("Path to URI: " + path_to_uri);
//
//	        //convert relative path to absolute path
//	        Path path_to_absolute_path = path.toAbsolutePath();
//	        System.out.println("Path to absolute path: " + path_to_absolute_path.toString());
//
//	        //convert path to "real" path
//	        try {           
//	            Path real_path = path.toRealPath(LinkOption.NOFOLLOW_LINKS);
//	            System.out.println("Path to real path: " + real_path);
//	        } catch (IOException e) {
//	            System.err.println(e);
//	        }
//
//	        //convert path to File object
//	        File path_to_file = path.toFile();
//	        Path file_to_path = path_to_file.toPath();
//	        System.out.println("Path to file name: " + path_to_file.getName());
//	        System.out.println("File to path: " + file_to_path.toString());
//	    }
	
//	public static void main(String[] args) {
//
//        Path path01 = Paths.get("BNP.txt");
//        Path path02 = Paths.get("AEGON.txt");
//        Path path03 = Paths.get("/tournaments/2009/BNP.txt");
//        Path path04 = Paths.get("/tournaments/2011");
//
//        Path path01_to_path02 = path01.relativize(path02);
//        System.out.println(path01_to_path02);
//
//        Path path02_to_path01 = path02.relativize(path01);
//        System.out.println(path02_to_path01);
//
//        Path path03_to_path04 = path03.relativize(path04);
//        System.out.println(path03_to_path04);
//
//        Path path04_to_path03 = path04.relativize(path03);
//        System.out.println(path04_to_path03);
//    }
	
	public static void main(String[] args) {

        //Java 6 solution
        File[] roots = File.listRoots();
        for (File root : roots) {
            System.out.println(root);
        }
        System.out.println("----------------------------------");
        //Java 7 solution
        Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
        for (Path name : dirs) {
            System.out.println(name);
        }
    }
}