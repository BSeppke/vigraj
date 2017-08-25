import java.util.*;

public class Image 
{
    public Image()
    {
    	m_width  = 0;
    	m_height = 0;
    }
    
    public Image(int width, int height)
    {
    	this(width, height, 1);
    }
    
    public Image(int width, int height, int numBands)
    {
    	this(width, height, numBands, 0);
    }

    public Image(int width, int height, int numBands, float value)
    {
    	m_width  = width;
    	m_height = height;
    	m_bands = new ArrayList<FloatArray>();
    	
        for (int b=0; b<numBands; b++)
        {
    		FloatArray arr = new FloatArray(width,height, value);
    		m_bands.add(arr);
    	}
    }
    
    public Image(int width, int height, int numBands, float[] value)
    {
    	m_width  = width;
    	m_height = height;
    	m_bands = new ArrayList<FloatArray>();
    	
        for (int b=0; b<numBands; b++)
        {
    		FloatArray arr = new FloatArray(width,height, value[b]);
    		m_bands.add(arr);
    	}
    }
    	
	public int getNumBands()
    {
    	return m_bands.size(); 
    }
    
    public int getWidth()
    {
    	return m_width; 
    }
    
    public int getHeight()
    {
    	return m_height; 
    }
    
    public FloatArray getBand(int idx)
    {
	    return m_bands.get(idx);
    }
    
    public void setBand(int idx, FloatArray band)
    {
	    m_bands.set(idx, band);
    }
    
    public float[] get(int x, int y)
    {
    	int numbands = this.getNumBands();
    	
    	float[] val = new float[numbands];
    	
    	for(int b=0; b<numbands; b++)
    	{
    		val[b] = this.getBand(b).get(x,y);
    	}
    	
	    return val;
    }
    
    ArrayList<FloatArray> m_bands;
    int m_width;
    int m_height;
}
