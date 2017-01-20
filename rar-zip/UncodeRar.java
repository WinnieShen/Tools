package com.shenwei;

import java.io.File;
import java.io.FileOutputStream;


import com.github.junrar.Archive;
import com.github.junrar.rarfile.FileHeader;

public class UncodeRar{
	private static final String OLD_RAR_FILE = "C:\\Users\\shenw1\\Downloads\\201605017.rar";
	private static final String DIRECTORY_PATH = "C:\\codes\\unRar";
	
	public static void main(String[] args){
		UncodeRar.unRarFile(OLD_RAR_FILE,DIRECTORY_PATH);
		System.out.println("success");
	}

	public static void unRarFile(String srcRarPath, String dstDirectoryPath) {
        if (!srcRarPath.toLowerCase().endsWith(".rar")) {
            System.out.println("not rar file");
            return;
        }
        File dstDiretory = new File(dstDirectoryPath);
        if (!dstDiretory.exists()) {
            dstDiretory.mkdirs();
        }
        Archive a = null;
        try {
            a = new Archive(new File(srcRarPath));
            if (a != null) {
                a.getMainHeader().print();
                FileHeader fh = a.nextFileHeader();
                while (fh != null) {
                	String fileName = fh.getFileNameW().isEmpty()?fh.getFileNameString():fh.getFileNameW();
                    if (fh.isDirectory()) {
                        File fol = new File(dstDirectoryPath + File.separator
                                + fileName);
                        fol.mkdirs();
                    } else {
                        File out = new File(dstDirectoryPath + File.separator
                                + fileName.trim());
                        //System.out.println(out.getAbsolutePath());
                        try {
                            if (!out.exists()) {
                                if (!out.getParentFile().exists()) { 
                                    out.getParentFile().mkdirs();
                                }
                                out.createNewFile();
                            }
                            FileOutputStream os = new FileOutputStream(out);
                            a.extractFile(fh, os);
                            os.close();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    fh = a.nextFileHeader();
                }
                a.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}