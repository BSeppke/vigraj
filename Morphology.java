import com.sun.jna.*; 

public class Morphology
{
    public interface CLibrary extends Library 
    {
        CLibrary INSTANCE = (CLibrary) Native.loadLibrary("vigra_c", CLibrary.class);
        
        int	vigra_distancetransform_c ( FloatArray arr_in,  FloatArray arr_out,  int width,  int height,  float background_label,  int norm);
        int	vigra_discerosion_c ( FloatArray arr_in,  FloatArray arr_out,  int width,  int height,  int radius);
        int	vigra_discdilation_c ( FloatArray arr_in,  FloatArray arr_out,  int width,  int height,  int radius);
        int	vigra_upwindimage_c ( FloatArray arr_in,  FloatArray arr_fac_in,  FloatArray arr_out,  int width,  int height,  float weight);
 	}
    
    public static Image distanceTransform(Image img, float background_label, int norm) throws Exception
    {
    	int numBands = img.getNumBands();
    	
        Image img_out = new Image(img.getWidth(), img.getHeight(), numBands);
    	
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_distancetransform_c(img.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), background_label, norm) != 0)
            {
                throw new Exception("vigra_distancetransform_c failed!");
            }
        }
        return img_out;
	}
    public static Image distanceTransform(Image img, float background_label) throws Exception
    {
        return distanceTransform(img, background_label,2);
    }
    public static Image distanceTransform(Image img) throws Exception
    {
        return distanceTransform(img, 0);
    }
	
    public static Image discErosion(Image img, int radius) throws Exception
    {
    	int numBands = img.getNumBands();
    	
        Image img_out = new Image(img.getWidth(), img.getHeight(), numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_discerosion_c(img.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), radius) != 0)
            {
                throw new Exception("vigra_discerosion_c failed!");
            }
        }
        return img_out;
    }

    public static Image discDilation(Image img, int radius) throws Exception
    {
    	int numBands = img.getNumBands();
    	
        Image img_out = new Image(img.getWidth(), img.getHeight(), numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_discdilation_c(img.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), radius) != 0)
            {
                throw new Exception("vigra_discdilation_c failed!");
            }
        }
        return img_out;
    }
	
    public static Image upwindImage(Image img, Image signum_img, float weight) throws Exception
    {
    	int numBands = img.getNumBands();
    
        if(numBands != signum_img.getNumBands())
        {
           throw new Exception("upwindImage: Image and signum image's number of bands do not match!");
        }
        
        Image img_out = new Image(img.getWidth(), img.getHeight(), numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_upwindimage_c(img.getBand(b), signum_img.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), weight) != 0)
            {
                throw new Exception("vigra_upwindimage_c failed!");
            }
        }
        return img_out;
    }
}
