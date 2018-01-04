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
				
				Image img2 = ImgProc.clipImage(
								 ImgProc.paddImage(
								     Filters.medianFilter(
									     ImgProc.resizeImage(
										     ImgProc.rotateImage(
											     ImgProc.reflectImage(img, 1),
												 30, 2),
											 (int)(img.getWidth()*1.1), (int)(img.getHeight()*1.1), 2),
										  3, 3),
									10, 20, 30, 40, red),
								0, 255);
				
				Image img3 = Filters.nonLocalMean(img, 0);
				Image img4 = Filters.nonLocalMean(img, 1);
				
				
				Impex.exportImage(img2, Config.libDir() +"/images/img2-rescaled.png");
				Impex.exportImage(img2, Config.libDir() +"/images/img2-clipped.png", false); //Use clipping 0..255 instead of rescaling

				Impex.exportImage(img3, Config.libDir() +"/images/img-nlm-policy0.png");
				Impex.exportImage(img4, Config.libDir() +"/images/img-nlm-policy1.png");
				
			}
			catch(Exception ex)
			{
					System.out.print("Something went wrong: ");
					System.out.println(ex.toString());
			}
		}
	}
}
