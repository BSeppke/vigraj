import com.sun.jna.*; 
import java.util.*;

public class SplineImageView
{
    ArrayList<SplineFloatArrayView> m_views;
    
    public SplineImageView(Image img, int order) throws Exception
    {
        for(int b=0; b<img.getNumBands(); b++)
        {
            m_views.add(new SplineFloatArrayView(img.getBand(b),order));
        }
    }
    
    public SplineImageView(Image img)
    {
        for(int b=0; b<img.getNumBands(); b++)
        {
            m_views.add(new SplineFloatArrayView(img.getBand(b)));
        }
    }
    
    public float[] get(double x, double y)
    {
        int numBands = m_views.size();
    
        float[] result = new float[numBands];
        
        for(int b=0; b<numBands; b++)
        {
            result[b] = m_views.get(b).get(x,y);
        }
        return result;
    }
    
    
    public float[] dx(double x, double y)
    {
        int numBands = m_views.size();
    
        float[] result = new float[numBands];
        
        for(int b=0; b<numBands; b++)
        {
            result[b] = m_views.get(b).dx(x,y);
        }
        return result;
    }
    public float[] dy(double x, double y)
    {
        int numBands = m_views.size();
    
        float[] result = new float[numBands];
        
        for(int b=0; b<numBands; b++)
        {
            result[b] = m_views.get(b).dy(x,y);
        }
        return result;
    }
    
    
    public float[] dxx(double x, double y)
    {
        int numBands = m_views.size();
    
        float[] result = new float[numBands];
        
        for(int b=0; b<numBands; b++)
        {
            result[b] = m_views.get(b).dxx(x,y);
        }
        return result;
    }
    public float[] dxy(double x, double y)
    {
        int numBands = m_views.size();
    
        float[] result = new float[numBands];
        
        for(int b=0; b<numBands; b++)
        {
            result[b] = m_views.get(b).dxy(x,y);
        }
        return result;
    }
    public float[] dyy(double x, double y)
    {
        int numBands = m_views.size();
    
        float[] result = new float[numBands];
        
        for(int b=0; b<numBands; b++)
        {
            result[b] = m_views.get(b).dyy(x,y);
        }
        return result;
    }
    
    
    
    
    public float[] dx3(double x, double y)
    {
        int numBands = m_views.size();
    
        float[] result = new float[numBands];
        
        for(int b=0; b<numBands; b++)
        {
            result[b] = m_views.get(b).dx3(x,y);
        }
        return result;
    }
    public float[] dxxy(double x, double y)
    {
        int numBands = m_views.size();
    
        float[] result = new float[numBands];
        
        for(int b=0; b<numBands; b++)
        {
            result[b] = m_views.get(b).dxxy(x,y);
        }
        return result;
    }
    public float[] dxyy(double x, double y)
    {
        int numBands = m_views.size();
    
        float[] result = new float[numBands];
        
        for(int b=0; b<numBands; b++)
        {
            result[b] = m_views.get(b).dxyy(x,y);
        }
        return result;
    }
    public float[] dy3(double x, double y)
    {
        int numBands = m_views.size();
    
        float[] result = new float[numBands];
        
        for(int b=0; b<numBands; b++)
        {
            result[b] = m_views.get(b).dy3(x,y);
        }
        return result;
    }
    
    
    public float[] g2(double x, double y)
    {
        int numBands = m_views.size();
    
        float[] result = new float[numBands];
        
        for(int b=0; b<numBands; b++)
        {
            result[b] = m_views.get(b).g2(x,y);
        }
        return result;
    }
    
    
    public float[] g2x(double x, double y)
    {
        int numBands = m_views.size();
    
        float[] result = new float[numBands];
        
        for(int b=0; b<numBands; b++)
        {
            result[b] = m_views.get(b).g2x(x,y);
        }
        return result;
    }
    public float[] g2y(double x, double y)
    {
        int numBands = m_views.size();
    
        float[] result = new float[numBands];
        
        for(int b=0; b<numBands; b++)
        {
            result[b] = m_views.get(b).g2y(x,y);
        }
        return result;
    }
    
    
    public float[] g2xx(double x, double y)
    {
        int numBands = m_views.size();
    
        float[] result = new float[numBands];
        
        for(int b=0; b<numBands; b++)
        {
            result[b] = m_views.get(b).g2xx(x,y);
        }
        return result;
    }
    public float[] g2xy(double x, double y)
    {
        int numBands = m_views.size();
    
        float[] result = new float[numBands];
        
        for(int b=0; b<numBands; b++)
        {
            result[b] = m_views.get(b).g2xy(x,y);
        }
        return result;
    }
    public float[] g2yy(double x, double y)
    {
        int numBands = m_views.size();
    
        float[] result = new float[numBands];
        
        for(int b=0; b<numBands; b++)
        {
            result[b] = m_views.get(b).g2yy(x,y);
        }
        return result;
    }
}
