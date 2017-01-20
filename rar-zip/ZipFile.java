package com.shenwei;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

public class ZipFile {
	private static final File WILL_BE_ZIPED_FILE_1 =new File("C:\\Users\\shenw1\\Downloads\\201605017.rar");
	private static final File WILL_BE_ZIPED_FILE_2 =new File("C:\\Users\\shenw1\\Downloads\\201605018.rar");
	private static String NEW_ZIP_FILE = "C:\\codes\\unRar\\new.zip";
	
	public static void main(String[] args){
		File[] zipFile = {WILL_BE_ZIPED_FILE_1,WILL_BE_ZIPED_FILE_2};
		File newfile = new File(NEW_ZIP_FILE);
		ZipFile.ZipFiles(zipFile,newfile);
		System.out.println("hello word");
	}
	
	public static void ZipFiles(File[] srcfile, File zipfile) {
        byte[] buf = new byte[1024];
        try {
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
                    zipfile));
            for (int i = 0; i < srcfile.length; i++) {
                FileInputStream in = new FileInputStream(srcfile[i]);
                out.putNextEntry(new ZipEntry(srcfile[i].getName()));
//                String str = srcfile[i].getName();
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                out.closeEntry();
                in.close();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
