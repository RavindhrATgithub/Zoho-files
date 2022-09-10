package pack.files;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import io.github.techgnious.IVCompressor;
import io.github.techgnious.dto.IVAudioAttributes;
import io.github.techgnious.dto.IVSize;
import io.github.techgnious.dto.IVVideoAttributes;
import io.github.techgnious.dto.VideoFormats;
import io.github.techgnious.exception.ImageException;
import io.github.techgnious.exception.VideoException;

public class videoCompresser 
{
	 public static void main( String[] args) throws ImageException, IOException, VideoException 
	    {
	    	IVCompressor compressor = new IVCompressor();
	      
	    	BufferedInputStream file=new BufferedInputStream(new FileInputStream("c:\\users\\prabhu k\\desktop\\test video.mp4"));
	    	
	    	int dim1,dim2;
	    	System.out.println("The resolution of the video is:  1980 x 1080");
	    	System.out.println("Enter the dimensions to reduce the resolution of the image.");
	    	System.out.print("Enter dimension 1: ");
	    	Scanner s=new Scanner(System.in);
	        dim1=s.nextInt();
	        System.out.print("Enter dimension 2: ");
	    	dim2=s.nextInt();
	    	IVSize customRes=new IVSize(); 
	    	customRes.setWidth(dim1);
	    	customRes.setHeight(dim2);
	   
	
	    	IVAudioAttributes audioAttribute = new IVAudioAttributes();
	    	// here 64kbit/s is 64000
	    	audioAttribute.setBitRate(100000);
	    	audioAttribute.setChannels(2);
	    	audioAttribute.setSamplingRate(44100);
	    	
	    	
	    	IVVideoAttributes videoAttribute = new IVVideoAttributes();
	    	// Here 160 kbps video is 160000
	    	
	    	videoAttribute.setBitRate(120000);
	    	// More the frames more quality and size, but keep it low based on //devices like mobile
	    	
	    	videoAttribute.setFrameRate(20);
	    	videoAttribute.setSize(customRes);
	    	System.out.println("The given has been resized to given resolution ");
	    	System.out.println("c:\\users\\prabhu k\\desktop\\nemp\\newVideo.mp4");
	    	
	    	byte buff[]=file.readAllBytes(); 
    	
	    	byte n[]=compressor.encodeVideoWithAttributes(buff, VideoFormats.MP4,audioAttribute, videoAttribute);
   	
	    	BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream("c:\\users\\prabhu k\\desktop\\nemp\\newVideo.mp4"));
	    	out.write(n);
	    	
	    	System.out.println("The given has been resized to given resolution ");
	    	System.out.println("c:\\users\\prabhu k\\desktop\\nemp\\newVideo.mp4");
	    }

}
