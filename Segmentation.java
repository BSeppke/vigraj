import com.sun.jna.*;

public class Segmentation
{
    public interface CLibrary extends Library 
    {
        CLibrary INSTANCE = (CLibrary) Native.loadLibrary("vigra_c", CLibrary.class);
        
        int	vigra_labelimage_c ( FloatArray arr_in,  FloatArray arr_out,  int width,  int height,  boolean eight_connectivity);
        int	vigra_labelimagewithbackground_c ( FloatArray arr_in,  FloatArray arr_out,  int width,  int height,  boolean eight_connectivity,  float background);
        int vigra_watershedsunionfind_c ( FloatArray arr_in,  FloatArray arr_out,  int width,  int height,  boolean eight_connectivity);
        int vigra_watershedsregiongrowing_c ( FloatArray arr_in,  FloatArray arr_inout,  int width,  int height,  boolean eight_connectivity,  boolean keep_contours,  boolean use_turbo,  double stop_cost);
        int vigra_slic_gray_c ( FloatArray arr_in,  FloatArray arr_out,  int width,  int height,  int seedDistance,  double intensityScaling,  int iterations);
        int vigra_slic_rgb_c ( FloatArray arr_r_in,  FloatArray arr_g_in,  FloatArray arr_b_in,  FloatArray arr_out,  int width,  int height,  int seedDistance,  double intensityScaling,  int iterations);
        int vigra_cannyedgeimage_c ( FloatArray arr_in,  FloatArray arr_out,  int width,  int height,  float scale,  float gradient_threshold,  float mark);
        int vigra_differenceofexponentialedgeimage_c ( FloatArray arr_in,  FloatArray arr_out,  int width,  int height,  float scale,  float gradient_threshold,  float mark);
        int vigra_regionimagetocrackedgeimage_c ( FloatArray arr_in,  FloatArray arr_out,  int width_in,  int height_in,  float mark);
        int vigra_extractfeatures_gray_c ( FloatArray arr_gray_in,  FloatArray arr_labels_in,  FloatArray arr_out,  int width_in,  int height_in,  int max_label);
        int vigra_extractfeatures_rgb_c ( FloatArray arr_r_in,  FloatArray arr_g_in,  FloatArray arr_b_in,  FloatArray arr_labels_in,  FloatArray arr_out,  int width_in,  int height_in,  int max_label);
 	}
    
    public static Image labelImage(Image img, float background_label, boolean eight_connectivity) throws Exception
    {
    	int numBands = img.getNumBands();
    	
        Image img_out = new Image(img.getWidth(), img.getHeight(), numBands);
    	
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_labelimagewithbackground_c(img.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), eight_connectivity, background_label) != -1)
            {
                throw new Exception("vigra_labelimagewithbackground_c failed!");
            }
        }
        return img_out;
	}
    public static Image labelImage(Image img, float background_label) throws Exception
    {
        return labelImage(img, background_label, true);
    }
    
    public static Image labelImage(Image img, boolean eight_connectivity) throws Exception
    {
    	int numBands = img.getNumBands();
    	
        Image img_out = new Image(img.getWidth(), img.getHeight(), numBands);
    	
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_labelimage_c(img.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), eight_connectivity) != -1)
            {
                throw new Exception("vigra_labelimage_c failed!");
            }
        }
        return img_out;
	}
    public static Image labelImage(Image img) throws Exception
    {
        return labelImage(img, true);
    }
    
    
    public static Image watershedsUnionFind(Image img, boolean eight_connectivity) throws Exception
    {
    	int numBands = img.getNumBands();
    	
        Image img_out = new Image(img.getWidth(), img.getHeight(), numBands);
    	
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_watershedsunionfind_c(img.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), eight_connectivity) != -1)
            {
                throw new Exception("vigra_watershedsunionfind_c failed!");
            }
        }
        return img_out;
	}
    public static Image watershedsUnionFind(Image img) throws Exception
    {
        return watershedsUnionFind(img, true);
    }
    
    
    public static Image watershedsRegionGrowing(Image img, Image seeds, boolean eight_connectivity, boolean keep_contours,  boolean use_turbo,  double stop_cost) throws Exception
    {
    	int numBands = img.getNumBands();
    	
        Image img_out = seeds;
    	
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_watershedsregiongrowing_c(img.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), eight_connectivity, keep_contours, use_turbo, stop_cost) != -1)
            {
                throw new Exception("vigra_watershedsregiongrowing_c failed!");
            }
        }
        return img_out;
	}
    public static Image watershedsRegionGrowing(Image img, Image seeds, boolean eight_connectivity, boolean keep_contours,  boolean use_turbo) throws Exception
    {
        return watershedsRegionGrowing(img, seeds, eight_connectivity, keep_contours, use_turbo, -1.0);
    }
    public static Image watershedsRegionGrowing(Image img, Image seeds, boolean eight_connectivity, boolean keep_contours) throws Exception
    {
        return watershedsRegionGrowing(img, seeds, eight_connectivity, keep_contours, false);
    }
    public static Image watershedsRegionGrowing(Image img, Image seeds, boolean eight_connectivity) throws Exception
    {
        return watershedsRegionGrowing(img, seeds, eight_connectivity, false);
    }
    public static Image watershedsRegionGrowing(Image img, Image seeds) throws Exception
    {
        return watershedsRegionGrowing(img, seeds, true);
    }
    public static Image watershedsRegionGrowing(Image img) throws Exception
    {
        Image seeds = labelImage(ImgProc.localMinima(img),0);
        return watershedsRegionGrowing(img, seeds, true);
    }
    
    
    
    public static Image slic(Image img, int seedDistance, double intensityScaling,  int iterations) throws Exception
    {
    	int numBands = img.getNumBands();
    	
    	
        if(numBands == 3) //Assume RGB image -> special handling
        {
            Image img_out = new Image(img.getWidth(), img.getHeight(), 1);
            
            if(CLibrary.INSTANCE.vigra_slic_rgb_c(img.getBand(0), img.getBand(1), img.getBand(2), img_out.getBand(0), img.getWidth(), img.getHeight(), seedDistance, intensityScaling, iterations) != -1)
            {
                throw new Exception("vigra_slic_rgb_c failed!");
            }
            return img_out;
        }
        else //Do bandwise segmentation
        {
            Image img_out = new Image(img.getWidth(), img.getHeight(), numBands);
            
            for(int b=0; b<numBands; b++)
            {
                if(CLibrary.INSTANCE.vigra_slic_gray_c(img.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), seedDistance, intensityScaling, iterations) != -1)
                {
                    throw new Exception("vigra_slic_gray_c failed!");
                }
            }
            return img_out;
        }
    }
    public static Image slic(Image img, int seedDistance, double intensityScaling) throws Exception
    {
        return slic(img, seedDistance, intensityScaling, 40);
    }
    public static Image slic(Image img, int seedDistance) throws Exception
    {
        return slic(img, seedDistance, 20.0);
    }
    public static Image slic(Image img) throws Exception
    {
        return slic(img, 15);
    }
    
    
    public static Image cannyEdgeImage(Image img, float scale, float gradient_threshold, float mark) throws Exception
    {
    	int numBands = img.getNumBands();
    	
        Image img_out = new Image(img.getWidth(), img.getHeight(), numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_cannyedgeimage_c(img.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), scale, gradient_threshold, mark) != 0)
            {
                throw new Exception("vigra_cannyedgeimage_c failed!");
            }
        }
        return img_out;
    }
    
    public static Image differenceOfExponentialEdgeImage(Image img, float scale, float gradient_threshold, float mark) throws Exception
    {
    	int numBands = img.getNumBands();
    	
        Image img_out = new Image(img.getWidth(), img.getHeight(), numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_differenceofexponentialedgeimage_c(img.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), scale, gradient_threshold, mark) != 0)
            {
                throw new Exception("vigra_differenceofexponentialedgeimage_c failed!");
            }
        }
        return img_out;
    }

    public static Image regionImageToCrackEdgeImage(Image img, float mark) throws Exception
    {
    	int numBands = img.getNumBands();
    	
        Image img_out = new Image(img.getWidth()*2+1, img.getHeight()*2+1, numBands);
    
        for(int b=0; b<numBands; b++)
        {
            if(CLibrary.INSTANCE.vigra_regionimagetocrackedgeimage_c(img.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), mark) != 0)
            {
                throw new Exception("vigra_regionimagetocrackedgeimage_c failed!");
            }
        }
        return img_out;
    }
    
    public static Image extractFeatures(Image img, Image labels, int max_label) throws Exception
    {
    	int img_numBands = img.getNumBands();
    	int labels_numBands = img.getNumBands();
        
        if(img_numBands==3 && labels_numBands==1) //Special handling for (none-bandwise) RGB case
        {
            Image img_out = new Image(25, max_label+1, 1);
            
            if(CLibrary.INSTANCE.vigra_extractfeatures_rgb_c(img.getBand(0), img.getBand(1), img.getBand(2), labels.getBand(0), img_out.getBand(0), img.getWidth(), img.getHeight(), max_label) != 0)
            {
                throw new Exception("vigra_extractfeatures_rgb_c failed!");
            }
            
            return img_out;
        }
        else if(img_numBands==labels_numBands)
        {
            Image img_out = new Image(17, max_label+1, img_numBands);
            
            for(int b=0; b<img_numBands; b++)
            {
                if(CLibrary.INSTANCE.vigra_extractfeatures_gray_c(img.getBand(b), labels.getBand(b), img_out.getBand(b), img.getWidth(), img.getHeight(), max_label) != 0)
                {
                    throw new Exception("vigra_extractfeatures_gray_c failed!");
                }
            }
            return img_out;
        }
        else
        {
           throw new Exception("extractFeatures: Image and labels number of bands do not match!");
        }
    }
}
