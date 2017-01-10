import com.sun.jna.*;

public class DoubleArray
	extends Memory
{
    public DoubleArray()
    {
    	this(0);
    }
    
    public DoubleArray(int size)
    {
    	this(size,1);
    }
    
    
    public DoubleArray(int width, int height)
    {
    	super(width*height*Native.getNativeSize(Double.TYPE));
        
        m_width  = width;
        m_height = height;
    }
    
    public DoubleArray(double[] flat_array, int width, int height)
    {
    	super(width*height*Native.getNativeSize(Double.TYPE));
    
        m_width  = width;
        m_height = height;
        
        this.write(0,flat_array,0,flat_array.length);
    }
    
    public DoubleArray(double[][] array2d, int width, int height)
    {
    	super(width*height*Native.getNativeSize(Double.TYPE));
    
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
        return (x + y*m_width)*Native.getNativeSize(Double.TYPE);
    }
    
    public double get(int x, int y)
    {
        return getDouble(xy2idx(x,y));
    }

    public void set(int x, int y, double val)
    {
        setDouble(xy2idx(x,y), val);
    }
    
    public double[] toFlatArray()
    {
        double[] flat_array = new double[m_width*m_height];
            this.read(0,flat_array,0,flat_array.length);
        return flat_array;
    }
    
    public double[][] toArray()
    {
        double[][] array2d = new double[m_height][m_width];
        
        for(int y=0; y<getHeight(); y++)
        {
            this.read(0, array2d[y], 0, m_width);
        }
        return array2d;
    }
    
    int m_width;
    int m_height;
}
