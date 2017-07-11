# vigraj

access (parts of) VIGRA's functionality from Java


## 1. Prerequisites

For Linux and Mac OS X, the vigra Computer Vision library needs to be installed. I recommend the use of a version > 1.11.0. The easiest way to do so, is using your favorite package manager under linux or using MacPorts und  Mac OS X. Otherwise you need to pay attention to install all the needed dependencies on your own.

<b>Attention:</b> Under linux (Ubuntu) I encountered an installation problem of the vigra, such that `vigra-config --libs` pointed to a non-existing file. I was able to solve this by copying the necessary binary to the right position:
> sudo cp /usr/local/lib/libvigraimpex.* /usr/lib/x86_64-linux-gnu

Note, that for Windows, you also need to have installed the MS VC-Runtime (2015) in order to get these binaries running.

You also need to have the JNA package (jna.jar, see https://github.com/java-native-access/jna ) in your classpath!
 
## 2. Installation
Not described yet, just clone the repo wherever you want.

If you just want to test the lib, without installing JNA in your classpath, you may also copy the jar file into the vigraj dir and run the following commands:

To build the lib:
> javac -classpath .:jna.jar -g *.java
 
And then, to run the examples	
> java -classpath .:jna.jar Examples


## 3. Auto-build of the c-wrapper

The vigra\_c wrapper libary will be build automatically for Linux and macOS. For macOS, we assume the installation of VIGRA through the MacPorts package manager
For windows, the binaries are shipped with vigra\_c and will be copied automatically

Although this is at pre-alpha status, enjoy the functionality of VIGRA when working with Java!
