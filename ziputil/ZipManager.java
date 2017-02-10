package ziputil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipManager
{
    /**
     * Used to manage both the ZIP file and its extraction's destination.
     * 
     * @param archive The ZIP file to be extracted.
     * @param dest The file's contents destination.
     * @throws IOException
     */
    public static void unzip(String archive, String dest) throws IOException
    {
        // Create the destination path specified if it doesn't exist.
        File path = new File(dest);
        if (!path.exists()) path.mkdir();
        
        // Iterate over entries in the ZIP file.
        ZipInputStream zip = new ZipInputStream(new FileInputStream(archive));
        ZipEntry entry = zip.getNextEntry();
        
        while (entry != null) {
            String content = dest + File.separator + entry.getName();
            System.out.println("Extract: " + entry.getName());
            // Extract the content if the entry is not a directory.
            if (!entry.isDirectory()) ZipContents.extract(zip, content);
            // Create the content as folder if the entry is a directory.
            else {
                File dir = new File(content);
                dir.mkdir();
            }
            zip.closeEntry();
            entry = zip.getNextEntry();
        }
        
        zip.close();
    }
}
