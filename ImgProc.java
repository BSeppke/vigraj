import com.sun.jna.*; 
import java.util.*;

public class ImgProc
{
    public interface CLibrary extends Library 
    {
        CLibrary INSTANCE = (CLibrary) Native.loadLibrary("vigra_c", CLibrary.class);

 		int	vigra_resizeimage_c ( Pointer arr_in,  Pointer arr_out,  int width_in,  int height_in,  int width_out,  int height_out,  int resample_method);
 		int	vigra_rotateimage_c ( Pointer arr_in,  Pointer arr_out,  int width,  int height,  float angle,  int resample_method);
 		int	vigra_affinewarpimage_c ( Pointer arr_in,  Pointer affineMatrix,  Pointer arr_out,  int width,  int height,  int resample_method);
 		int	vigra_reflectimage_c ( Pointer arr_in,  Pointer arr_out,  int width,  int height,  int reflect_method);
 		int	vigra_fouriertransform_c ( Pointer arr_in,  Pointer arr_real_out,  Pointer arr_imag_out,  int width,  int height);
 		int vigra_fastcrosscorrelation_c ( Pointer arr_in,  Pointer arr_template_in,  Pointer arr_out,  int width,  int height,  int template_width,  int template_height);
 		int	vigra_fastnormalizedcrosscorrelation_c ( Pointer arr_in,  Pointer arr_template_in,  Pointer arr_out,  int width,  int height,  int template_width,  int template_height);
 		int vigra_localmaxima_c ( Pointer arr_in,  Pointer arr_out,  int width,  int height,  boolean eight_connectivity);
 		int	vigra_localminima_c ( Pointer arr_in,  Pointer arr_out,  int width,  int height,  boolean eight_connectivity);
 		int	vigra_subimage_c ( Pointer arr_in,  Pointer arr_out,  int width_in,  int height_in,  int left,  int upper,  int right,  int lower);
 		int vigra_paddimage_c ( Pointer arr_in,  Pointer arr_out,  int width_in,  int height_in,  int left,  int upper,  int right,  int lower);
 	}
    
    public static Image resizeImage(Image img, int new_width, int new_height, int resample_method) throws Exception
    {
    	int numBands = img.getNumBands();

        Image img_out = new Image(new_width, new_height, numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_resizeimage_c(img.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), new_width, new_height, resample_method) != 0)
            {
                throw new Exception("vigra_resizeimage_c failed!");
            }
        }
        return img_out;
	}
	
    public static Image rotateImage(Image img, float angle, int resample_method) throws Exception
    {
    	int numBands = img.getNumBands();

        Image img_out = new Image(img.getWidth(), img.getHeight(), numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_rotateimage_c(img.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), angle, resample_method) != 0)
            {
                throw new Exception("vigra_rotateimage_c failed!");
            }
        }
        return img_out;
	}
	
    public static Image affineWarpImage(Image img, DoubleArray affineMat, int resample_method) throws Exception
    {
    	int numBands = img.getNumBands();

        Image img_out = new Image(img.getWidth(), img.getHeight(), numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_affinewarpimage_c(img.getBand(b), affineMat, img_out.getBand(b), img.getWidth(), img.getHeight(), resample_method) != 0)
            {
                throw new Exception("vigra_affinewarpimage_c failed!");
            }
        }
        return img_out;
	}
	
    public static Image reflectImage(Image img, int reflect_method) throws Exception
    {
    	int numBands = img.getNumBands();

        Image img_out = new Image(img.getWidth(), img.getHeight(), numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_reflectimage_c(img.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), reflect_method) != 0)
            {
                throw new Exception("vigra_reflectimage_c failed!");
            }
        }
        return img_out;
	}
    
    public static ArrayList<Image> fourierTransform(Image img) throws Exception
    {
    	int numBands = img.getNumBands();

        Image img_real_out = new Image(img.getWidth(), img.getHeight(), numBands);
        Image img_imag_out = new Image(img.getWidth(), img.getHeight(), numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_fouriertransform_c(img.getBand(b), img_real_out.getBand(b), img_imag_out.getBand(b), img.getWidth(), img.getHeight()) != 0)
            {
                throw new Exception("vigra_fouriertransform_c failed!");
            }
        }
        ArrayList<Image> result = new ArrayList<Image>();
            result.add(img_real_out);
            result.add(img_imag_out);
        return result;
	}
	
	
    public static Image fastCrossCorrelation(Image img, Image template) throws Exception
    {
    	int numBands = img.getNumBands();

        Image img_out = new Image(img.getWidth(), img.getHeight(), numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_fastcrosscorrelation_c(img.getBand(b), template.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), template.getWidth(), template.getHeight()) != 0)
            {
                throw new Exception("vigra_fastcrosscorrelation_c failed!");
            }
        }
        return img_out;
	}
	
    public static Image fastNormalizedCrossCorrelation(Image img, Image template) throws Exception
    {
    	int numBands = img.getNumBands();
    	
        Image img_out = new Image(img.getWidth(), img.getHeight(), numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_fastnormalizedcrosscorrelation_c(img.getBand(b), template.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), template.getWidth(), template.getHeight()) != 0)
            {
                throw new Exception("vigra_fastnormalizedcrosscorrelation_c failed!");
            }
        }
        return img_out;
	}
	
    public static Image localMinima(Image img, boolean eight_connectivity) throws Exception
    {
    	int numBands = img.getNumBands();

        Image img_out = new Image(img.getWidth(), img.getHeight(), numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_localminima_c(img.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), eight_connectivity) != 0)
            {
                throw new Exception("vigra_localminima_c failed!");
            }
        }
        return img_out;
	}
    public static Image localMinima(Image img) throws Exception
    {
        return localMinima(img, true);
    }
	
    public static Image localMaxima(Image img, boolean eight_connectivity) throws Exception
    {
    	int numBands = img.getNumBands();

        Image img_out = new Image(img.getWidth(), img.getHeight(), numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_localmaxima_c(img.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), eight_connectivity) != 0)
            {
                throw new Exception("vigra_localmaxima_c failed!");
            }
        }
        return img_out;
	}
    public static Image localMaxima(Image img) throws Exception
    {
        return localMaxima(img, true);
    }
	
    	
    public static Image subImage(Image img, int left, int upper, int right, int lower) throws Exception
    {
    	int numBands = img.getNumBands();
    	
        int width  = img.getWidth();
        int height = img.getHeight();
        
        if(left<0 || right<0 || upper<0 || lower<0)
        {
            throw new Exception("vigra_subimage_c failed:  left, right, upper, lower must be positive!");
        }
        
        if(width < left+right || height < upper+lower)
        {
            throw new Exception("vigra_subimage_c failed:  width < left+right || height < upper+lower");
        }

        Image img_out = new Image(img.getWidth()-left-right, img.getHeight()-upper-lower, numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_subimage_c(img.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), left, upper, right, lower) != 0)
            {
                throw new Exception("vigra_subimage_c failed!");
            }
        }
        return img_out;

	}
    	
    public static Image paddImage(Image img, int left, int upper, int right, int lower) throws Exception
    {
    	int numBands = img.getNumBands();
    	
        int width  = img.getWidth();
        int height = img.getHeight();
        
        if(left<0 || right<0 || upper<0 || lower<0)
        {
            throw new Exception("vigra_paddimage_c failed:  left, right, upper, lower must be positive!");
        }
        
    	Image img_out = new Image(img.getWidth()+left+right, img.getHeight()+upper+lower, numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_paddimage_c(img.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), left, upper, right, lower) != 0)
            {
                throw new Exception("vigra_paddimage_c failed!");
            }
        }
        return img_out;
	}
}
