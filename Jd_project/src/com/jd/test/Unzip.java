package com.jd.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Unzip {
	byte doc[] = null;
	String Filename = null;
	String UnZipPath = null;
	public Unzip(String filename , String unZipPath) {
		this.Filename = filename;
		this.UnZipPath = unZipPath;
		this.setUnZipPath(this.UnZipPath);
	}
	 public Unzip(String filename) {
		// TODO Auto-generated constructor stub
		 this.Filename=new String(filename);
		 this.UnZipPath=null;
		 this.setUnZipPath(this.UnZipPath);
	}
	private void setUnZipPath(String unzippath) {
		if(unzippath.endsWith("\\"))
			this.UnZipPath = new String(unzippath);
		else {
			this.UnZipPath = new String(unzippath+"\\");

		}
	}
	private void checkFilePath(String dirName)throws IOException {
		File dir = new File(dirName);
		if(!dir.exists())
			dir.mkdirs();
		
	}
	public void doUnZip() {
		try {
			ZipInputStream zipis =new ZipInputStream(new FileInputStream(Filename));
			ZipEntry fEntry = null;
			while((fEntry=zipis.getNextEntry())!=null) {
				if(fEntry.isDirectory())
					checkFilePath(UnZipPath+fEntry.getName());
				else {
					String fname = new String(UnZipPath+fEntry.getName());
					try {
						FileOutputStream outputStream =new FileOutputStream(fname);
						doc = new byte[512];
						int n;
						while((n=zipis.read(doc,0,512))!=-1) outputStream.write(doc,0,n);
						outputStream.close();
						outputStream=null;
						doc = null;
					} catch (Exception e) {
						// TODO: handle exception
					}finally {
						zipis.close();
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
}
