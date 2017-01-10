public class Examples
{
    public static void main(String[] args) 
    {
        String filename ="/Users/seppke/development/vigraj/images/lenna_face.png";
        
        try
        {
	        Image img = Impex.importImage(filename);
        
			for (int y=0; y<10; y++)
			{
				for (int x=0; x<10; x++)
				{
					float[] val = img.get(x,y);
                    
					System.out.print("( ");
                    
					for(int b=0; b<val.length; b++)
					{
						System.out.print((int)val[b]);
						System.out.print(" ");
					}
					System.out.print(") ");
				}
				System.out.println("");
			}
			
	        Impex.exportImage(Filters.gaussianSmoothing(ImgProc.resizeImage(ImgProc.rotateImage(ImgProc.reflectImage(img, 1), 30, 2), (int)(img.getWidth()*1.1), (int)(img.getHeight()*1.1), 2), 2.0f), "/Users/seppke/development/vigraj/images/bla.png");
		}
		catch(Exception ex)
		{
				System.out.print("Something went wrong: ");
				System.out.println(ex.toString());
		}
	}
}
