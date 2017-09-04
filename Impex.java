import com.sun.jna.*; 
import java.io.IOException;

public class Impex 
{
    public interface CLibrary extends Library 
    {
        CLibrary INSTANCE = (CLibrary) Native.loadLibrary("vigra_c", CLibrary.class);

        int vigra_imagewidth_c(String filename);
        int vigra_imageheight_c(String filename);
        int vigra_imagenumbands_c(String filename);
        
        int vigra_importgrayimage_c(Pointer p, int width, int height, String filename);
        int vigra_importrgbimage_c(Pointer p_r, Pointer p_g, Pointer p_b, int width, int height, String filename);
        int vigra_importrgbaimage_c(Pointer p_r, Pointer p_g, Pointer p_b, Pointer p_a, int width, int height, String filename);

        int vigra_exportgrayimage_c(Pointer p, int width, int height, String filename, boolean rescale_range);
        int vigra_exportrgbimage_c(Pointer p_r, Pointer p_g, Pointer p_b, int width, int height, String filename, boolean rescale_range);
        int vigra_exportrgbaimage_c(Pointer p_r, Pointer p_g, Pointer p_b, Pointer p_a, int width, int height, String filename, boolean rescale_range);
    }
    
    public static Image importImage(String filename) throws IOException
    {
        int width    = CLibrary.INSTANCE.vigra_imagewidth_c(filename);
        int height   = CLibrary.INSTANCE.vigra_imageheight_c(filename);
        int numbands = CLibrary.INSTANCE.vigra_imagenumbands_c(filename);
        
        if(width != 0 && height != 0 && numbands != 0)
        {
        	if(numbands == 1)
        	{
            	Image img = new Image(width, height, numbands);
            
                if(CLibrary.INSTANCE.vigra_importgrayimage_c(img.getBand(0), width, height, filename) == 0)
				{
				   	//System.out.println("Imported gray image!");
    	    	    return img;
    	    	}
    	    	else
    	    	{
        			throw new IOException("Gray image could not be loaded from filesystem, although w,h and numBands were read!");
    	    	}
        	}
        	else if(numbands == 3)
        	{
            	Image img = new Image(width, height, numbands);
        	
                if(CLibrary.INSTANCE.vigra_importrgbimage_c(img.getBand(0), img.getBand(1), img.getBand(2), width, height, filename) == 0)
				{
				    return img;
    			}
    	    	else
    	    	{
        			throw new IOException("RGB image could not be loaded from filesystem, although w,h and numBands were read!");
    	    	}
        	}
        	else if(numbands == 4)
        	{
            	Image img = new Image(width, height, numbands);
        	
                if(CLibrary.INSTANCE.vigra_importrgbaimage_c(img.getBand(0), img.getBand(1), img.getBand(2), img.getBand(3), width, height, filename) == 0)
				{
				    return img;
    			}
    	    	else
    	    	{
        			throw new IOException("RGBA image could not be loaded from filesystem, although w,h and numBands were read!");
    	    	}
        	}
        	else
        	{
        		throw new IOException("Image could not be loaded from filesystem, since numBands were not 1, 3 or 4!");
        	}
        }
        else
        {
        	throw new IOException("Image dimensions could not be loaded from filesystem! Maybe the filename was wrong?");
        }
    }   
	
    public static void exportImage(Image img, String filename) throws IOException
    {
    	exportImage(img, filename, true); //Call with rescaling from min...max -> 0...255
    }
    
    public static void exportImage(Image img, String filename, boolean rescale_range) throws IOException
    {
        int width    = img.getWidth();
        int height   = img.getHeight();
        int numbands = img.getNumBands();
        
        if(width != 0 && height != 0 && numbands != 0)
        {
        	if(numbands == 1)
        	{
                if(CLibrary.INSTANCE.vigra_exportgrayimage_c(img.getBand(0), width, height, filename, rescale_range) != 0)
				{
					throw new IOException("Gray image export failed!");
    	    	}
        	}
        	else if(numbands == 3)
        	{
                if(CLibrary.INSTANCE.vigra_exportrgbimage_c(img.getBand(0), img.getBand(1), img.getBand(2), width, height, filename, rescale_range) != 0)
				{
				   throw new IOException("RGB image export failed!");
    	    	}
        	}
        	else if(numbands == 3)
        	{
                if(CLibrary.INSTANCE.vigra_exportrgbaimage_c(img.getBand(0), img.getBand(1), img.getBand(2), img.getBand(3), width, height, filename, rescale_range) != 0)
				{
				   throw new IOException("RGBA image export failed!");
    	    	}
        	}
        	else
        	{
        		throw new IOException("Only images with numBands of 1, 3 or 4 can be exported!");
        	}
        }
        else
        {
        	throw new IOException("Image dimensions need to be >0 for image export!");
        }
    }   
}
