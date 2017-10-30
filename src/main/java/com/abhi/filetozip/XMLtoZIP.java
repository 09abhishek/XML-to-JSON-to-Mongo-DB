package com.abhi.filetozip;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class XMLtoZIP
{
    public static void main( String[] args )
    {
    	byte[] buffer = new byte[1024];

    	try{
    		String sourcefile="D:\\ExternalFileLink\\MN_0023.xml";
    		String destiantionfile="D:\\ExternalFileLink\\converted.zip";
    		
    		FileOutputStream fos = new FileOutputStream(destiantionfile);
    		ZipOutputStream zos = new ZipOutputStream(fos);
    		ZipEntry ze= new ZipEntry("demo.xml");
    		zos.putNextEntry(ze);
    		FileInputStream in = new FileInputStream(sourcefile);

    		int len;
    		while ((len = in.read(buffer)) > 0) {
    			zos.write(buffer, 0, len);
    		}
    		System.out.println("File zipped : " + destiantionfile);
    		in.close();
    		zos.closeEntry();

    		//remember close it
    		zos.close();

    		System.out.println("File Zipping Done check the given path");

    	}catch(IOException ex){
    	   ex.printStackTrace();
    	}
    }
}