import com.sun.jna.*;

public class FloatArray
	extends Memory
{
    public FloatArray()
    {
    	this(0);
    }
    
    public FloatArray(int size)
    {
    	this(size, 1, 0);
    }
    
    
    public FloatArray(int width, int height, float value)
    {
    	super(width*height*Native.getNativeSize(Float.TYPE));
    	
    	int float_size   = Native.getNativeSize(Float.TYPE);
    	long memory_size = width*height*float_size;
        
        m_width  = width;
        m_height = height;
        
        //Initialize the array with value
        for(long l=0; l<memory_size; l+=float_size)
        {
        	this.setFloat(l, value);
        }
    }
    
    public FloatArray(float[] flat_array, int width, int height)
    {
    	super(width*height*Native.getNativeSize(Float.TYPE));
    
        m_width  = width;
        m_height = height;
        
        this.write(0,flat_array,0,flat_array.length);
    }
    
    public FloatArray(float[][] array2d, int width, int height)
    {
    	super(width*height*Native.getNativeSize(Float.TYPE));
    
        m_width  = width;
        m_height = height;
        
        for(int y=0; y<getHeight(); y++)
        {
            this.write(0, array2d[y], 0, m_width);
        }
    }
    
    public int getWidth()
    {
        return m_width;
    }
    public int getHeight()
    {
        return m_height;
    }
    public int xy2idx(int x, int y)
    {
        return (x + y*m_width)*Native.getNativeSize(Float.TYPE);
    }
    
    public float get(int x, int y)
    {
        return getFloat(xy2idx(x,y));
    }

    public void set(int x, int y, float val)
    {
        setFloat(xy2idx(x,y), val);
    }
    
    public float[] toFlatArray()
    {
        float[] flat_array = new float[m_width*m_height];
            this.read(0,flat_array,0,flat_array.length);
        return flat_array;
    }
    
    public float[][] toArray()
    {
        float[][] array2d = new float[m_height][m_width];
        
        for(int y=0; y<getHeight(); y++)
        {
            this.read(0, array2d[y], 0, m_width);
        }
        return array2d;
    }
    
    int m_width;
    int m_height;
}
