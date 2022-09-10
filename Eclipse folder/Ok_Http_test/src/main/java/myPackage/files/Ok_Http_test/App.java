package myPackage.files.Ok_Http_test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import io.github.techgnious.IVCompressor;
import io.github.techgnious.dto.IVSize;
import io.github.techgnious.dto.ImageFormats;
import io.github.techgnious.exception.ImageException;

public class App 
{
    public static void main( String[] args) throws ImageException, IOException 
    {
    	IVCompressor compressor = new IVCompressor();
      
    	BufferedInputStream file=new BufferedInputStream(new FileInputStream("c:\\users\\prabhu k\\desktop\\nemp\\new1.jpg"));
    	IVSize customRes=new IVSize(); 
    	customRes.setWidth(400);
    	customRes.setHeight(300);
   
    	byte buff[]=file.readAllBytes();
    	compressor.resizeImageWithCustomRes(buff,ImageFormats.JPEG,customRes);
    
    	BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream("c:\\users\\prabhu k\\desktop\\nemp\\new2.jpg"));
    	out.write(buff);
    }
}
