package com.shenwei;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

public class UnZip {
	private static final String OLD_FILE = "C:\\codes\\unRar\\new.zip";
	private static final String UNZIP_OLD_FILE_TO_PATH = "C:\\codes\\unRar\\test\\";
	
	public static void main(String[] args){
		File oldfile = new File(OLD_FILE);
		UnZip.unZipFiles(oldfile,UNZIP_OLD_FILE_TO_PATH);
		System.out.println("success");
	}

    public static void unZipFiles(java.io.File zipfile, String descDir) {
        try {
            ZipFile zf = new ZipFile(zipfile);
            for (Enumeration entries = zf.getEntries(); entries
                    .hasMoreElements();) {
                ZipEntry entry = ((ZipEntry) entries.nextElement());
                String zipEntryName = entry.getName();
                InputStream in = zf.getInputStream(entry);
                OutputStream out = new FileOutputStream(descDir + zipEntryName);
                byte[] buf1 = new byte[1024];
                int len;
                while ((len = in.read(buf1)) > 0) {
                    out.write(buf1, 0, len);
                }
                System.out.println("success");
                in.close();
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
