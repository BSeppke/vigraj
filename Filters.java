import com.sun.jna.*; 
import java.util.*;

public class Filters
{
    public interface CLibrary extends Library 
    {
        CLibrary INSTANCE = (CLibrary) Native.loadLibrary("vigra_c", CLibrary.class);
        
        int vigra_convolveimage_c ( FloatArray arr_in,  DoubleArray kernel_arr_in,  FloatArray arr_out,  int width,  int height,  int kernel_width,  int kernel_height, int border_treatment);
        int vigra_separableconvolveimage_c ( FloatArray arr_in,  DoubleArray kernel_h_arr_in,  DoubleArray kernel_v_arr_in,  FloatArray arr_out,  int width,  int height,  int kernel_width,  int kernel_height, int border_treatment);
        int vigra_gaussiangradient_c ( FloatArray arr_in,  FloatArray arr_gx_out,  FloatArray arr_gy_out,  int width,  int height,  float sigma);
        int vigra_gaussiangradientmagnitude_c ( FloatArray arr_in,  FloatArray arr_out,  int width,  int height,  float sigma);
        int vigra_gaussiansmoothing_c ( FloatArray arr_in,  FloatArray arr_out,  int width,  int height,  float sigma);
        int vigra_laplacianofgaussian_c ( FloatArray arr_in,  FloatArray arr_out,  int width,  int height,  float scale);
        int vigra_hessianmatrixofgaussian_c ( FloatArray arr_in,  FloatArray arr_xx_out,  FloatArray arr_xy_out,  FloatArray arr_yy_out,  int width,  int height,  float scale);
        int vigra_gaussiansharpening_c ( FloatArray arr_in,  FloatArray arr_out,  int width,  int height,  float sharpening_factor,  float scale);
        int vigra_simplesharpening_c ( FloatArray arr_in,  FloatArray arr_out,  int width,  int height, float sharpening_factor);
        int vigra_medianfilter_c ( FloatArray arr_in,  FloatArray arr_out,  int width,  int height,  int window_width,  int window_height);
        int vigra_nonlineardiffusion_c ( FloatArray arr_in,  FloatArray arr_out,  int width,  int height,  float edge_threshold,  float scale);
        int vigra_shockfilter_c ( FloatArray arr_in,  FloatArray arr_out,  int width,  int height,  float sigma,  float rho,  float upwind_factor_h,  int iterations);
 	}
    
    public static Image colvolveImage(Image img, DoubleArray kernel, int border_treatment) throws Exception
    {
    	int numBands = img.getNumBands();
    	
        Image img_out = new Image(img.getWidth(), img.getHeight(), numBands);
    	
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_convolveimage_c(img.getBand(b), kernel, img_out.getBand(b), img.getWidth(), img.getHeight(), kernel.getWidth(), kernel.getHeight(), border_treatment) != 0)
            {
                throw new Exception("vigra_convolveimage_c failed!");
            }
        }
        return img_out;
	}
    public static Image colvolveImage(Image img, DoubleArray kernel) throws Exception
    {
    	return colvolveImage(img, kernel, 3); //REFLECT MODE by default
    }
    
    public static Image separableColvolveImage(Image img, DoubleArray kernel_h,  DoubleArray kernel_v, int border_treatment) throws Exception
    {
    	int numBands = img.getNumBands();
    	
        Image img_out = new Image(img.getWidth(), img.getHeight(), numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_separableconvolveimage_c(img.getBand(b), kernel_h, kernel_v, img_out.getBand(b), img.getWidth(), img.getHeight(), kernel_h.getWidth(), kernel_v.getHeight(), border_treatment) != 0)
            {
                throw new Exception("vigra_separableconvolveimage_c failed!");
            }
        }
        return img_out;
    }
    public static Image separableColvolveImage(Image img, DoubleArray kernel_h,  DoubleArray kernel_v) throws Exception
    {
    	return separableColvolveImage(img, kernel_h, kernel_v, 3); //REFLECT MODE by default
    }

    public static ArrayList<Image> gaussianGradient(Image img, float sigma) throws Exception
    {
    	int numBands = img.getNumBands();
    	
        Image img_gx_out = new Image(img.getWidth(), img.getHeight(), numBands);
        Image img_gy_out = new Image(img.getWidth(), img.getHeight(), numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_gaussiangradient_c(img.getBand(b), img_gx_out.getBand(b), img_gy_out.getBand(b), img.getWidth(), img.getHeight(), sigma) != 0)
            {
                throw new Exception("vigra_gaussiangradient_c failed!");
            }
        }
        ArrayList<Image> result = new ArrayList<Image>();
            result.add(img_gx_out);
            result.add(img_gy_out);
        return result;
    }
	
    public static Image gaussianGradientMagnitude(Image img, float sigma) throws Exception
    {
    	int numBands = img.getNumBands();
    	
        Image img_out = new Image(img.getWidth(), img.getHeight(), numBands);
    	
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_gaussiangradientmagnitude_c(img.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), sigma) != 0)
            {
                throw new Exception("vigra_gaussiangradientmagnitude_c failed!");
            }
        }
        return img_out;
	}
	
    public static Image gaussianSmoothing(Image img, float sigma) throws Exception
    {
    	int numBands = img.getNumBands();
    	
        Image img_out = new Image(img.getWidth(), img.getHeight(), numBands);
    	
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_gaussiansmoothing_c(img.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), sigma) != 0)
            {
                throw new Exception("vigra_gaussiansmoothing_c failed!");
            }
        }
        return img_out;
	}
	
    public static Image laplacianOfGaussian(Image img, float sigma) throws Exception
    {
    	int numBands = img.getNumBands();
    	
        Image img_out = new Image(img.getWidth(), img.getHeight(), numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_laplacianofgaussian_c(img.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), sigma) != 0)
            {
                throw new Exception("vigra_laplacianofgaussian_c failed!");
            }
        }
        return img_out;
    }

    public static ArrayList<Image> hessianMatrixOfGaussian(Image img, float sigma) throws Exception
    {
    	int numBands = img.getNumBands();
    	
        Image img_xx_out = new Image(img.getWidth(), img.getHeight(), numBands);
        Image img_xy_out = new Image(img.getWidth(), img.getHeight(), numBands);
        Image img_yy_out = new Image(img.getWidth(), img.getHeight(), numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_hessianmatrixofgaussian_c(img.getBand(b), img_xx_out.getBand(b), img_xy_out.getBand(b), img_yy_out.getBand(b), img.getWidth(), img.getHeight(), sigma) != 0)
            {
                throw new Exception("vigra_hessianmatrixofgaussian_c failed!");
            }
        }
        ArrayList<Image> result = new ArrayList<Image>();
            result.add(img_xx_out);
            result.add(img_xy_out);
            result.add(img_yy_out);
        return result;
	}
	
    public static Image gaussianSharpening(Image img, float sharpening_factor, float sigma) throws Exception
    {
    	int numBands = img.getNumBands();
    	
    	Image img_out = new Image(img.getWidth(), img.getHeight(), numBands);
    	
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_gaussiansharpening_c(img.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), sharpening_factor, sigma) != 0)
            {
                throw new Exception("vigra_gaussiansharpening_c failed!");
            }
        }
        return img_out;
    }
	
    public static Image simpleSharpening(Image img, float sharpening_factor) throws Exception
    {
    	int numBands = img.getNumBands();
    
        Image img_out = new Image(img.getWidth(), img.getHeight(), numBands);
    	
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_simplesharpening_c(img.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), sharpening_factor) != 0)
            {
                throw new Exception("vigra_simplesharpening_c failed!");
            }
        }
        return img_out;
    }
	
    public static Image medianFilter(Image img, int filter_width, int filter_height) throws Exception
    {
    	int numBands = img.getNumBands();

        Image img_out = new Image(img.getWidth(), img.getHeight(), numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_medianfilter_c(img.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), filter_width, filter_height) != 0)
            {
                throw new Exception("vigra_medianfilter_c failed!");
            }
        }
        return img_out;
    }
    	
    public static Image nonlinearDiffusion(Image img, float edge_threshold, float sigma) throws Exception
    {
    	int numBands = img.getNumBands();
    	
        Image img_out = new Image(img.getWidth(), img.getHeight(), numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_nonlineardiffusion_c(img.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), edge_threshold, sigma) != 0)
            {
                throw new Exception("vigra_nonlineardiffusion_c failed!");
            }
        }
        return img_out;
    }
    	
    public static Image shockFilter(Image img, float sigma,  float rho,  float upwind_factor_h,  int iterations) throws Exception
    {
    	int numBands = img.getNumBands();
    	
        Image img_out = new Image(img.getWidth(), img.getHeight(), numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_shockfilter_c(img.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), sigma, rho, upwind_factor_h, iterations) != 0)
            {
                throw new Exception("vigra_shockfilter_c failed!");
            }
        }
        return img_out;
    }
}
