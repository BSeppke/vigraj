import com.sun.jna.*; 

public class SplineFloatArrayView
{
    int m_width;
    int m_height;
    int m_order;
    Pointer m_siv;
    
    public interface CLibrary extends Library 
    {
        CLibrary INSTANCE = (CLibrary) Native.loadLibrary("vigra_c", CLibrary.class);
        
        Pointer vigra_create_splineimageview1_c (FloatArray arr_in,  int width,  int height);
        Pointer vigra_create_splineimageview2_c (FloatArray arr_in,  int width,  int height);
        Pointer vigra_create_splineimageview3_c (FloatArray arr_in,  int width,  int height);
        Pointer vigra_create_splineimageview4_c (FloatArray arr_in,  int width,  int height);
        Pointer vigra_create_splineimageview5_c (FloatArray arr_in,  int width,  int height);
 
        int	vigra_delete_splineimageview1_c (Pointer siv);
        int vigra_delete_splineimageview2_c (Pointer siv);
        int	vigra_delete_splineimageview3_c (Pointer siv);
        int	vigra_delete_splineimageview4_c (Pointer siv);
        int vigra_delete_splineimageview5_c (Pointer siv);
 
        float vigra_splineimageview1_dx_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview2_dx_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview3_dx_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview4_dx_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview5_dx_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview1_dx3_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview2_dx3_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview3_dx3_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview4_dx3_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview5_dx3_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview1_dxx_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview2_dxx_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview3_dxx_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview4_dxx_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview5_dxx_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview1_dxxy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview2_dxxy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview3_dxxy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview4_dxxy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview5_dxxy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview1_dxy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview2_dxy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview3_dxy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview4_dxy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview5_dxy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview1_dxyy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview2_dxyy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview3_dxyy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview4_dxyy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview5_dxyy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview1_dy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview2_dy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview3_dy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview4_dy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview5_dy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview1_dy3_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview2_dy3_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview3_dy3_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview4_dy3_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview5_dy3_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview1_dyy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview2_dyy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview3_dyy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview4_dyy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview5_dyy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview1_g2_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview2_g2_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview3_g2_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview4_g2_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview5_g2_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview1_g2x_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview2_g2x_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview3_g2x_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview4_g2x_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview5_g2x_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview1_g2xx_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview2_g2xx_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview3_g2xx_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview4_g2xx_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview5_g2xx_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview1_g2xy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview2_g2xy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview3_g2xy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview4_g2xy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview5_g2xy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview1_g2y_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview2_g2y_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview3_g2y_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview4_g2y_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview5_g2y_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview1_g2yy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview2_g2yy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview3_g2yy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview4_g2yy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview5_g2yy_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview1_accessor_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview2_accessor_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview3_accessor_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview4_accessor_c (Pointer siv,  double x,  double y);
        float vigra_splineimageview5_accessor_c (Pointer siv,  double x,  double y);
    }
    
    public SplineFloatArrayView(FloatArray arr, int order) throws Exception
    {
        m_width  = arr.getWidth();
        m_height = arr.getHeight();
        m_order  = order;
        
        switch (m_order)
        {
            case 1:
                m_siv = CLibrary.INSTANCE.vigra_create_splineimageview1_c(arr, m_width, m_height);
                break;
            case 2:
                m_siv = CLibrary.INSTANCE.vigra_create_splineimageview2_c(arr, m_width, m_height);
                break;
            case 3:
                m_siv = CLibrary.INSTANCE.vigra_create_splineimageview3_c(arr, m_width, m_height);
                break;
            case 4:
                m_siv = CLibrary.INSTANCE.vigra_create_splineimageview4_c(arr, m_width, m_height);
                break;
            case 5:
                m_siv = CLibrary.INSTANCE.vigra_create_splineimageview5_c(arr, m_width, m_height);
                break;
            default:
                throw new Exception("Error in SplineFloatArrayView: Order has to be in [1...5]");
        }
    }
    
    public SplineFloatArrayView(FloatArray arr)
    {
        m_width  = arr.getWidth();
        m_height = arr.getHeight();
        m_order  = 2;
        
        m_siv = CLibrary.INSTANCE.vigra_create_splineimageview2_c(arr, m_width, m_height);
    }
    
    @Override
    protected void finalize() throws Exception
    {
        int result = 0;
        
        switch (m_order)
        {
            case 1:
                result = CLibrary.INSTANCE.vigra_delete_splineimageview1_c(m_siv);
                break;
            case 2:
                result = CLibrary.INSTANCE.vigra_delete_splineimageview2_c(m_siv);
                break;
            case 3:
                result = CLibrary.INSTANCE.vigra_delete_splineimageview3_c(m_siv);
                break;
            case 4:
                result = CLibrary.INSTANCE.vigra_delete_splineimageview4_c(m_siv);
                break;
            case 5:
                result = CLibrary.INSTANCE.vigra_delete_splineimageview5_c(m_siv);
                break;
        }
        if(result != 0)
        {
            throw new Exception("Error in SplineFloatArrayView: Cannot free foreign memory!");
        }
    }

    public float get(double x, double y)
    {
        switch (m_order)
        {
            case 1:
                return CLibrary.INSTANCE.vigra_splineimageview1_accessor_c(m_siv, x, y);
            case 2:
                return CLibrary.INSTANCE.vigra_splineimageview2_accessor_c(m_siv, x, y);
            case 3:
                return CLibrary.INSTANCE.vigra_splineimageview3_accessor_c(m_siv, x, y);
            case 4:
                return CLibrary.INSTANCE.vigra_splineimageview4_accessor_c(m_siv, x, y);
            default:
                return CLibrary.INSTANCE.vigra_splineimageview5_accessor_c(m_siv, x, y);
        }
    }
    
    
    public float dx(double x, double y)
    {
        switch (m_order)
        {
            case 1:
                return CLibrary.INSTANCE.vigra_splineimageview1_dx_c(m_siv, x, y);
            case 2:
                return CLibrary.INSTANCE.vigra_splineimageview2_dx_c(m_siv, x, y);
            case 3:
                return CLibrary.INSTANCE.vigra_splineimageview3_dx_c(m_siv, x, y);
            case 4:
                return CLibrary.INSTANCE.vigra_splineimageview4_dx_c(m_siv, x, y);
            default:
                return CLibrary.INSTANCE.vigra_splineimageview5_dx_c(m_siv, x, y);
        }
    }
    public float dy(double x, double y)
    {
        switch (m_order)
        {
            case 1:
                return CLibrary.INSTANCE.vigra_splineimageview1_dy_c(m_siv, x, y);
            case 2:
                return CLibrary.INSTANCE.vigra_splineimageview2_dy_c(m_siv, x, y);
            case 3:
                return CLibrary.INSTANCE.vigra_splineimageview3_dy_c(m_siv, x, y);
            case 4:
                return CLibrary.INSTANCE.vigra_splineimageview4_dy_c(m_siv, x, y);
            default:
                return CLibrary.INSTANCE.vigra_splineimageview5_dy_c(m_siv, x, y);
        }
    }
    
    
    public float dxx(double x, double y)
    {
        switch (m_order)
        {
            case 1:
                return CLibrary.INSTANCE.vigra_splineimageview1_dxx_c(m_siv, x, y);
            case 2:
                return CLibrary.INSTANCE.vigra_splineimageview2_dxx_c(m_siv, x, y);
            case 3:
                return CLibrary.INSTANCE.vigra_splineimageview3_dxx_c(m_siv, x, y);
            case 4:
                return CLibrary.INSTANCE.vigra_splineimageview4_dxx_c(m_siv, x, y);
            default:
                return CLibrary.INSTANCE.vigra_splineimageview5_dxx_c(m_siv, x, y);
        }
    }
    public float dxy(double x, double y)
    {
        switch (m_order)
        {
            case 1:
                return CLibrary.INSTANCE.vigra_splineimageview1_dxy_c(m_siv, x, y);
            case 2:
                return CLibrary.INSTANCE.vigra_splineimageview2_dxy_c(m_siv, x, y);
            case 3:
                return CLibrary.INSTANCE.vigra_splineimageview3_dxy_c(m_siv, x, y);
            case 4:
                return CLibrary.INSTANCE.vigra_splineimageview4_dxy_c(m_siv, x, y);
            default:
                return CLibrary.INSTANCE.vigra_splineimageview5_dxy_c(m_siv, x, y);
        }
    }
    public float dyy(double x, double y)
    {
        switch (m_order)
        {
            case 1:
                return CLibrary.INSTANCE.vigra_splineimageview1_dyy_c(m_siv, x, y);
            case 2:
                return CLibrary.INSTANCE.vigra_splineimageview2_dyy_c(m_siv, x, y);
            case 3:
                return CLibrary.INSTANCE.vigra_splineimageview3_dyy_c(m_siv, x, y);
            case 4:
                return CLibrary.INSTANCE.vigra_splineimageview4_dyy_c(m_siv, x, y);
            default:
                return CLibrary.INSTANCE.vigra_splineimageview5_dyy_c(m_siv, x, y);
        }
    }
    
    
    
    
    public float dx3(double x, double y)
    {
        switch (m_order)
        {
            case 1:
                return CLibrary.INSTANCE.vigra_splineimageview1_dx3_c(m_siv, x, y);
            case 2:
                return CLibrary.INSTANCE.vigra_splineimageview2_dx3_c(m_siv, x, y);
            case 3:
                return CLibrary.INSTANCE.vigra_splineimageview3_dx3_c(m_siv, x, y);
            case 4:
                return CLibrary.INSTANCE.vigra_splineimageview4_dx3_c(m_siv, x, y);
            default:
                return CLibrary.INSTANCE.vigra_splineimageview5_dx3_c(m_siv, x, y);
        }
    }
    public float dxxy(double x, double y)
    {
        switch (m_order)
        {
            case 1:
                return CLibrary.INSTANCE.vigra_splineimageview1_dxxy_c(m_siv, x, y);
            case 2:
                return CLibrary.INSTANCE.vigra_splineimageview2_dxxy_c(m_siv, x, y);
            case 3:
                return CLibrary.INSTANCE.vigra_splineimageview3_dxxy_c(m_siv, x, y);
            case 4:
                return CLibrary.INSTANCE.vigra_splineimageview4_dxxy_c(m_siv, x, y);
            default:
                return CLibrary.INSTANCE.vigra_splineimageview5_dxxy_c(m_siv, x, y);
        }
    }
    public float dxyy(double x, double y)
    {
        switch (m_order)
        {
            case 1:
                return CLibrary.INSTANCE.vigra_splineimageview1_dxyy_c(m_siv, x, y);
            case 2:
                return CLibrary.INSTANCE.vigra_splineimageview2_dxyy_c(m_siv, x, y);
            case 3:
                return CLibrary.INSTANCE.vigra_splineimageview3_dxyy_c(m_siv, x, y);
            case 4:
                return CLibrary.INSTANCE.vigra_splineimageview4_dxyy_c(m_siv, x, y);
            default:
                return CLibrary.INSTANCE.vigra_splineimageview5_dxyy_c(m_siv, x, y);
        }
    }
    public float dy3(double x, double y)
    {
        switch (m_order)
        {
            case 1:
                return CLibrary.INSTANCE.vigra_splineimageview1_dy3_c(m_siv, x, y);
            case 2:
                return CLibrary.INSTANCE.vigra_splineimageview2_dy3_c(m_siv, x, y);
            case 3:
                return CLibrary.INSTANCE.vigra_splineimageview3_dy3_c(m_siv, x, y);
            case 4:
                return CLibrary.INSTANCE.vigra_splineimageview4_dy3_c(m_siv, x, y);
            default:
                return CLibrary.INSTANCE.vigra_splineimageview5_dy3_c(m_siv, x, y);
        }
    }
    
    
    public float g2(double x, double y)
    {
        switch (m_order)
        {
            case 1:
                return CLibrary.INSTANCE.vigra_splineimageview1_g2_c(m_siv, x, y);
            case 2:
                return CLibrary.INSTANCE.vigra_splineimageview2_g2_c(m_siv, x, y);
            case 3:
                return CLibrary.INSTANCE.vigra_splineimageview3_g2_c(m_siv, x, y);
            case 4:
                return CLibrary.INSTANCE.vigra_splineimageview4_g2_c(m_siv, x, y);
            default:
                return CLibrary.INSTANCE.vigra_splineimageview5_g2_c(m_siv, x, y);
        }
    }
    
    
    public float g2x(double x, double y)
    {
        switch (m_order)
        {
            case 1:
                return CLibrary.INSTANCE.vigra_splineimageview1_g2x_c(m_siv, x, y);
            case 2:
                return CLibrary.INSTANCE.vigra_splineimageview2_g2x_c(m_siv, x, y);
            case 3:
                return CLibrary.INSTANCE.vigra_splineimageview3_g2x_c(m_siv, x, y);
            case 4:
                return CLibrary.INSTANCE.vigra_splineimageview4_g2x_c(m_siv, x, y);
            default:
                return CLibrary.INSTANCE.vigra_splineimageview5_g2x_c(m_siv, x, y);
        }
    }
    public float g2y(double x, double y)
    {
        switch (m_order)
        {
            case 1:
                return CLibrary.INSTANCE.vigra_splineimageview1_g2y_c(m_siv, x, y);
            case 2:
                return CLibrary.INSTANCE.vigra_splineimageview2_g2y_c(m_siv, x, y);
            case 3:
                return CLibrary.INSTANCE.vigra_splineimageview3_g2y_c(m_siv, x, y);
            case 4:
                return CLibrary.INSTANCE.vigra_splineimageview4_g2y_c(m_siv, x, y);
            default:
                return CLibrary.INSTANCE.vigra_splineimageview5_g2y_c(m_siv, x, y);
        }
    }
    
    
    public float g2xx(double x, double y)
    {
        switch (m_order)
        {
            case 1:
                return CLibrary.INSTANCE.vigra_splineimageview1_g2xx_c(m_siv, x, y);
            case 2:
                return CLibrary.INSTANCE.vigra_splineimageview2_g2xx_c(m_siv, x, y);
            case 3:
                return CLibrary.INSTANCE.vigra_splineimageview3_g2xx_c(m_siv, x, y);
            case 4:
                return CLibrary.INSTANCE.vigra_splineimageview4_g2xx_c(m_siv, x, y);
            default:
                return CLibrary.INSTANCE.vigra_splineimageview5_g2xx_c(m_siv, x, y);
        }
    }
    public float g2xy(double x, double y)
    {
        switch (m_order)
        {
            case 1:
                return CLibrary.INSTANCE.vigra_splineimageview1_g2xy_c(m_siv, x, y);
            case 2:
                return CLibrary.INSTANCE.vigra_splineimageview2_g2xy_c(m_siv, x, y);
            case 3:
                return CLibrary.INSTANCE.vigra_splineimageview3_g2xy_c(m_siv, x, y);
            case 4:
                return CLibrary.INSTANCE.vigra_splineimageview4_g2xy_c(m_siv, x, y);
            default:
                return CLibrary.INSTANCE.vigra_splineimageview5_g2xy_c(m_siv, x, y);
        }
    }
    public float g2yy(double x, double y)
    {
        switch (m_order)
        {
            case 1:
                return CLibrary.INSTANCE.vigra_splineimageview1_g2yy_c(m_siv, x, y);
            case 2:
                return CLibrary.INSTANCE.vigra_splineimageview2_g2yy_c(m_siv, x, y);
            case 3:
                return CLibrary.INSTANCE.vigra_splineimageview3_g2yy_c(m_siv, x, y);
            case 4:
                return CLibrary.INSTANCE.vigra_splineimageview4_g2yy_c(m_siv, x, y);
            default:
                return CLibrary.INSTANCE.vigra_splineimageview5_g2yy_c(m_siv, x, y);
        }
    }
}
