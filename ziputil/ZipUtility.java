package ziputil;

import java.io.IOException;

public class ZipUtility
{
    /**
     * A command-line tool used to extract ZIP archives.
     * 
     * @param args The ZIP file and the destination path.
     */
    public static void main(String[] args)
    {
        if (args.length > 2 || args.length < 2) {
            System.err.println("Usage: ziputil [archive] [destination]");
            System.exit(0);
        }
        else {
            try {
                ZipManager.unzip(args[0], args[1]);
            } catch (IOException ex) {
                ex.printStackTrace(System.err);
            }
        }
    }
}
