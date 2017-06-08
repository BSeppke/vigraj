import com.sun.jna.*;

import java.io.*;
import java.nio.file.*;
import java.util.Locale;

public class Config 
{	
	public static int runShellCommand(String command, StringBuilder result_str)
	{
		int result = 1;
		
		try
		{
			Runtime r = Runtime.getRuntime();
			String[] commands = {"/bin/bash", "-c", command};
			Process p = r.exec(commands);
			result = p.waitFor();
			
			BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
				
			String line = "";
			while ((line = b.readLine()) != null) 
			{
	  			result_str.append(line + "\n");
			}
			b.close();
		}
		catch(IOException ex)
		{
			System.out.print("Something went wrong IO: ");
			System.out.println(ex.toString());
			result = -1;
		}
		catch(InterruptedException ex)
		{
			System.out.print("Something went wrong INTERRUPTED: ");
			System.out.println(ex.toString());
			result = -2;
		}
		return result;
	}
	
	public static String libName()
	{
		return "vira_c";
	}
	
	public static String libDir()
	{
		return Paths.get(".").toAbsolutePath().normalize().toString() + "/";
	}
	
	public static String libFileName(boolean complete_path)
	{
		if(complete_path)
		{
			return libDir() + libFileName();
		}
		{
			return libFileName();
		}
	}
	
	// Returns "macos", "windows", "linux" or "other" as string ids for OSes
	public static String getOS()
	{
		String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
		
		if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0))
		{
			return "macos";
		}
		else if (OS.indexOf("win") >= 0)
		{
			return "windows";
		}
		else if (OS.indexOf("nux") >= 0)
		{
			return "linux";
		}
		
		return "other";
	}
	public static int getOSBits()
	{
		return Native.POINTER_SIZE*8;
	}
	
	public static String libFileName()
	{
		String os = getOS();
		
		switch (os)
		{
			case "macos":
				return "libvigra_c.dylib";
			case "linux":
				return "libvigra_c.so";
			case "windows":
				return "vigra_c.dll";
		}
		return "";
	}
	
	public static boolean isVigraInstalled()
	{
		StringBuilder vigra_version = new StringBuilder();
		int vigra_installed = runShellCommand("vigra-config --version", vigra_version);
		
		if(vigra_installed == 0)
		{
			String[] nums = vigra_version.toString().trim().split("\\.");
			
			if(nums.length == 3)
			{
				int maj = Integer.parseInt(nums[0]);
				int min = Integer.parseInt(nums[1]);
				return (maj > 1) || ((maj == 1) && (min >= 11));
			}
		}
		return false;
	}  
	
    public interface CLibrary extends Library 
    {
        
        int vigra_imagewidth_c(String filename);
        int vigra_imageheight_c(String filename);
        int vigra_imagenumbands_c(String filename);
        
        int vigra_importgrayimage_c(Pointer p, int width, int height, String filename);
        int vigra_importrgbimage_c(Pointer p_r, Pointer p_g, Pointer p_b, int width, int height, String filename);
        int vigra_importrgbaimage_c(Pointer p_r, Pointer p_g, Pointer p_b, Pointer p_a, int width, int height, String filename);

        int vigra_exportgrayimage_c(Pointer p, int width, int height, String filename);
        int vigra_exportrgbimage_c(Pointer p_r, Pointer p_g, Pointer p_b, int width, int height, String filename);
        int vigra_exportrgbaimage_c(Pointer p_r, Pointer p_g, Pointer p_b, Pointer p_a, int width, int height, String filename);
    }
    
    
	public static boolean isVigraCInstalled()
	{
		try
		{
			Native.loadLibrary("vigra_c", CLibrary.class);
			return true;
		}
		catch(Error err)
		{
		}
		return false;
	}
	
	public static boolean checkInstallVigraC()
	{
		if(isVigraCInstalled())
		{
			return true;
		}
		
		String os = getOS();
		
		if(os == "windows")
		{
			//copy files
			System.out.print("Copying vigra_c files under Windows\n");
			try
			{
				String[] filenames = {	"vigra_c.dll",
										"vigraimpex.dll",
										"fftw-3.3.dll",
										"fftwf-3.3.dll"};
				for(int i=0; i!=filenames.length; i++)
				{	
					Files.copy( Paths.get(libDir() + "vigra_c/bin/win" + getOSBits() + "/" + filenames[i]),
								Paths.get(libDir() +  filenames[i]),
								StandardCopyOption.REPLACE_EXISTING);
				}
				return true;
			}
			catch(Exception ex)
			{
				System.out.print("Something went wrong: ");
				System.out.println(ex.toString());
				return false;				
			}
		}
		else if(os == "macos" || os == "linux")
		{
			//build and then copy result into dir
			if(isVigraInstalled())
			{
				System.out.print("Linux/Mac build of vigra_c:\n    vigra is already installed!\n");
				
				String[] build_cmds = { "mkdir -p vigra_c/build",
										"cd vigra_c/build && cmake .. && make",
										"cp vigra_c/bin/" + libFileName() + " .",
										"rm -r -f vigra_c/build"};
				StringBuilder build_str = new StringBuilder();
				int build_res = 0;
				for(int i=0; i!= build_cmds.length; i++)
				{
					build_res = build_res + runShellCommand(build_cmds[i], build_str);
					System.out.println("Executing: " + build_cmds[i] + "\n");
					System.out.println("Result [" + build_res + "]: " + build_str + "\n");
				}
				System.out.print("Build finished with:\n    '"+ build_str + "'\n");
				
				return (build_res == 0);
			}
			else
			{
				System.out.println("Did not find vigra-config script. Please install vigra >=1.11.0 first!");
			}
		}
		else
		{
			System.out.println("Sorry, operating system: " + os + " is not supported");
		}
		return false;
	}
}
