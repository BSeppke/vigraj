public class Examples
{
    public static void main(String[] args) 
    {
    	boolean installed = Config.checkInstallVigraC();
		System.out.print("Has vigra_c been successfully installed?  " + (installed? "Yes" : "No") + "...\n");
		
		if(installed)
		{
			String filename =Config.libDir() + "images/lenna_face.png";
		
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
				
				float[] red = {300, 0, 0};
				
				Image img2 = ImgProc.paddImage(
						Filters.gaussianSmoothing(
								ImgProc.resizeImage(
									ImgProc.rotateImage(
										ImgProc.reflectImage(img, 1),
										30, 2),
									(int)(img.getWidth()*1.1), (int)(img.getHeight()*1.1), 2),
								2.0f),
							10, 20, 30, 40, red);

				Impex.exportImage(img2, Config.libDir() +"/images/bla-rescaled.png");
				Impex.exportImage(img2, Config.libDir() +"/images/bla-clipped.png", false); //Use clipping 0..255 instead of rescaling
			}
			catch(Exception ex)
			{
					System.out.print("Something went wrong: ");
					System.out.println(ex.toString());
			}
		}
	}
}
