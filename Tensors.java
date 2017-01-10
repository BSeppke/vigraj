import com.sun.jna.*; 
import java.util.*;

public class Tensors
{
    public interface CLibrary extends Library 
    {
        CLibrary INSTANCE = (CLibrary) Native.loadLibrary("vigra_c", CLibrary.class);
        
        int	vigra_structuretensor_c ( FloatArray arr_in,  FloatArray arr_xx_out,  FloatArray arr_xy_out,  FloatArray arr_yy_out,  int width,  int height,  float inner_scale,  float outer_scale);
        int	vigra_boundarytensor_c ( FloatArray arr_in,  FloatArray arr_xx_out,  FloatArray arr_xy_out,  FloatArray arr_yy_out,  int width,  int height,  float scale);
        int	vigra_boundarytensor1_c ( FloatArray arr_in,  FloatArray arr_xx_out,  FloatArray arr_xy_out,  FloatArray arr_yy_out,  int width,  int height,  float scale);
        int vigra_gradientenergytensor_c ( FloatArray arr_in,  DoubleArray arr_derivKernel_in,  DoubleArray arr_smoothKernel_in,  FloatArray arr_xx_out,  FloatArray arr_xy_out,  FloatArray arr_yy_out,  int width,  int height,  int derivKernel_size,  int smoothKernel_size);
        int	vigra_tensoreigenrepresentation_c ( FloatArray arr_xx_in,  FloatArray arr_xy_in,  FloatArray arr_yy_in,  FloatArray arr_lEV_out,  FloatArray arr_sEV_out,  FloatArray arr_ang_out,  int width,  int height);
        int vigra_tensortrace_c ( FloatArray arr_xx_in,  FloatArray arr_xy_in,  FloatArray arr_yy_in,  FloatArray arr_trace_out,  int width,  int height);
        int vigra_tensortoedgecorner_c ( FloatArray arr_xx_in,  FloatArray arr_xy_in,  FloatArray arr_yy_in,  FloatArray arr_edgeness_out,  FloatArray arr_orientation_out,  FloatArray arr_cornerness_out,  int width,  int height);
        int vigra_hourglassfilter_c ( FloatArray arr_xx_in,  FloatArray arr_xy_in,  FloatArray arr_yy_in,  FloatArray arr_hgxx_out,  FloatArray arr_hgxy_out,  FloatArray arr_hgyy_out,  int width,  int height,  float sigma,  float rho);
 	}
    
    public static ArrayList<Image> structureTensor(Image img, float inner_scale, float outer_scale) throws Exception
    {
    	int numBands = img.getNumBands();
    	
        Image img_txx_out = new Image(img.getWidth(), img.getHeight(), numBands);
        Image img_txy_out = new Image(img.getWidth(), img.getHeight(), numBands);
        Image img_tyy_out = new Image(img.getWidth(), img.getHeight(), numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_structuretensor_c(img.getBand(b), img_txx_out.getBand(b), img_txy_out.getBand(b), img_tyy_out.getBand(b), img.getWidth(), img.getHeight(), inner_scale, outer_scale) != 0)
            {
                throw new Exception("vigra_structuretensor_c failed!");
            }
        }
        ArrayList<Image> result = new ArrayList<Image>();
            result.add(img_txx_out);
            result.add(img_txy_out);
            result.add(img_tyy_out);
        return result;
	}
    
    
    public static ArrayList<Image> boundaryTensor(Image img, float scale) throws Exception
    {
    	int numBands = img.getNumBands();
    	
        Image img_txx_out = new Image(img.getWidth(), img.getHeight(), numBands);
        Image img_txy_out = new Image(img.getWidth(), img.getHeight(), numBands);
        Image img_tyy_out = new Image(img.getWidth(), img.getHeight(), numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_boundarytensor_c(img.getBand(b), img_txx_out.getBand(b), img_txy_out.getBand(b), img_tyy_out.getBand(b), img.getWidth(), img.getHeight(), scale) != 0)
            {
                throw new Exception("vigra_boundarytensor_c failed!");
            }
        }
        ArrayList<Image> result = new ArrayList<Image>();
            result.add(img_txx_out);
            result.add(img_txy_out);
            result.add(img_tyy_out);
        return result;
	}
    
    public static ArrayList<Image> boundaryTensor1(Image img, float scale) throws Exception
    {
    	int numBands = img.getNumBands();
    	
        Image img_txx_out = new Image(img.getWidth(), img.getHeight(), numBands);
        Image img_txy_out = new Image(img.getWidth(), img.getHeight(), numBands);
        Image img_tyy_out = new Image(img.getWidth(), img.getHeight(), numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_boundarytensor1_c(img.getBand(b), img_txx_out.getBand(b), img_txy_out.getBand(b), img_tyy_out.getBand(b), img.getWidth(), img.getHeight(), scale) != 0)
            {
                throw new Exception("vigra_boundarytensor1_c failed!");
            }
        }
        ArrayList<Image> result = new ArrayList<Image>();
            result.add(img_txx_out);
            result.add(img_txy_out);
            result.add(img_tyy_out);
        return result;
	}
    
    
    public static ArrayList<Image> gradientEnergyTensor(Image img, DoubleArray derivKernel, DoubleArray smoothKernel) throws Exception
    {
    	int numBands = img.getNumBands();
    	
        Image img_txx_out = new Image(img.getWidth(), img.getHeight(), numBands);
        Image img_txy_out = new Image(img.getWidth(), img.getHeight(), numBands);
        Image img_tyy_out = new Image(img.getWidth(), img.getHeight(), numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_gradientenergytensor_c(img.getBand(b), derivKernel, smoothKernel, img_txx_out.getBand(b), img_txy_out.getBand(b), img_tyy_out.getBand(b), img.getWidth(), img.getHeight(), derivKernel.getWidth(), smoothKernel.getWidth()) != 0)
            {
                throw new Exception("vigra_gradientenergytensor_c failed!");
            }
        }
        ArrayList<Image> result = new ArrayList<Image>();
            result.add(img_txx_out);
            result.add(img_txy_out);
            result.add(img_tyy_out);
        return result;
	}
    
    public static ArrayList<Image> tensorEigenRepresentation(ArrayList<Image> tensor) throws Exception
    {
        if(tensor.size()!=3)
        {
            throw new Exception("tensorEigenRepresentation: Tensor needs to consist of 3 images: txx, txy and tyy!");
        }
        
    	int width = tensor.get(0).getWidth();
    	int height = tensor.get(0).getHeight();
    	int numBands = tensor.get(0).getNumBands();
        
        Image img_lEV_out = new Image(width, height, numBands);
        Image img_sEV_out = new Image(width, height, numBands);
        Image img_ang_out = new Image(width, height, numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_tensoreigenrepresentation_c(tensor.get(0).getBand(b),tensor.get(1).getBand(b),tensor.get(2).getBand(b), img_lEV_out.getBand(b), img_sEV_out.getBand(b), img_ang_out.getBand(b), width, height) != 0)
            {
                throw new Exception("vigra_tensoreigenrepresentation_c failed!");
            }
        }
        ArrayList<Image> result = new ArrayList<Image>();
            result.add(img_lEV_out);
            result.add(img_sEV_out);
            result.add(img_ang_out);
        return result;
	}
    public static Image tensorTrace(ArrayList<Image> tensor) throws Exception
    {
        if(tensor.size()!=3)
        {
            throw new Exception("tensorTrace: Tensor needs to consist of 3 images: txx, txy and tyy!");
        }
        
    	int width = tensor.get(0).getWidth();
    	int height = tensor.get(0).getHeight();
    	int numBands = tensor.get(0).getNumBands();
        
        Image result = new Image(width, height, numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_tensortrace_c(tensor.get(0).getBand(b),tensor.get(1).getBand(b),tensor.get(2).getBand(b), result.getBand(b), width, height) != 0)
            {
                throw new Exception("vigra_tensortrace_c failed!");
            }
        }
        return result;
	}
    
    public static ArrayList<Image> tensortoEdgeCorner(ArrayList<Image> tensor) throws Exception
    {
        if(tensor.size()!=3)
        {
            throw new Exception("tensortoEdgeCorner: Tensor needs to consist of 3 images: txx, txy and tyy!");
        }
        
    	int width = tensor.get(0).getWidth();
    	int height = tensor.get(0).getHeight();
    	int numBands = tensor.get(0).getNumBands();
    	
        
        Image img_edge_out = new Image(width, height, numBands);
        Image img_orientation_out = new Image(width, height, numBands);
        Image img_corner_out = new Image(width, height, numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_tensortoedgecorner_c(tensor.get(0).getBand(b),tensor.get(1).getBand(b),tensor.get(2).getBand(b), img_edge_out.getBand(b), img_orientation_out.getBand(b), img_corner_out.getBand(b), width, height) != 0)
            {
                throw new Exception("vigra_tensortoedgecorner_c failed!");
            }
        }
        ArrayList<Image> result = new ArrayList<Image>();
            result.add(img_edge_out);
            result.add(img_orientation_out);
            result.add(img_corner_out);
        return result;
	}
    public static ArrayList<Image> hourglassFilter(ArrayList<Image> tensor, float sigma, float rho) throws Exception
    {
        if(tensor.size()!=3)
        {
            throw new Exception("hourglassFilter: Tensor needs to consist of 3 images: txx, txy and tyy!");
        }
        
    	int width = tensor.get(0).getWidth();
    	int height = tensor.get(0).getHeight();
    	int numBands = tensor.get(0).getNumBands();
    	
        Image img_hgxx_out = new Image(width, height, numBands);
        Image img_hgxy_out = new Image(width, height, numBands);
        Image img_hgyy_out = new Image(width, height, numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_hourglassfilter_c(tensor.get(0).getBand(b),tensor.get(1).getBand(b),tensor.get(2).getBand(b), img_hgxx_out.getBand(b), img_hgxy_out.getBand(b), img_hgyy_out.getBand(b), width, height, sigma, rho) != 0)
            {
                throw new Exception("vigra_hourglassfilter_c failed!");
            }
        }
        ArrayList<Image> result = new ArrayList<Image>();
            result.add(img_hgxx_out);
            result.add(img_hgxy_out);
            result.add(img_hgyy_out);
        return result;
	}
}
