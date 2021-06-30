package javaBasic;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public class Topic_07_File_Path {
	public static void main(String[] args) {
		
		String projectLocation= System.getProperty("user.dir");
		String fileName1= "flower1.jpg";
		String fileName2="flower2.jpg";
		String fileName1Path= projectLocation+getDirectorySlash("uploadFile")+fileName1;
		String fileName2Path= projectLocation+getDirectorySlash("uploadFile")+fileName2;
		System.out.println(fileName1Path);
		System.out.println(fileName2Path);
	}
	public static String getDirectorySlash(String folderName) {
		String separator= FileSystems.getDefault().getSeparator();
		separator= System.getProperty("file.separator");
		return File.separator +folderName+ File.separator;
	}
}
