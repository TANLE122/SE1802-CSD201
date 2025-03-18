
import java.io.File;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;

// Lib class for file handling
class Lib {
    // Read and display on the screen the content of the file fname
    static void viewFile(String fname) throws Exception {
        File g = new File(fname);
        if (!g.exists()) {
            System.out.println(" The file " + fname + " does not exist!");
            return;
        }
        RandomAccessFile f;
        String s;
        f = new RandomAccessFile(fname, "r");
        System.out.println(" Content of the file " + fname + ":");
        while ((s = f.readLine()) != null)
            System.out.println("  " + s);
        f.close();
    }

    // Read and return line k (k=0,1,2,...) on the file fname
    static public String readLineToStr(String fname, int k) {
        String s = null;
        try {
            RandomAccessFile f = new RandomAccessFile(fname, "r");
            for (int i = 0; i < k; i++)
                f.readLine();
            s = f.readLine();
            f.close();
        } catch (Exception e) {
        }
        return (s);
    }

    // Read line k (k=0,1,2,...) and extracts it to the array strings and return this array
    static public String[] readLineToStrArray(String fname, int k) {
        String s = null;
        try {
            RandomAccessFile f = new RandomAccessFile(fname, "r");
            for (int i = 0; i < k; i++)
                f.readLine();
            s = f.readLine();
            f.close();
        } catch (Exception e) {
        }

        String[] a = new String[100];
        StringTokenizer t = new StringTokenizer(s);
        int i = 0;
        while (t.hasMoreTokens()) {
            a[i++] = t.nextToken().trim();
        }
        int n = i;
        String[] b = new String[n];
        for (i = 0; i < n; i++)
            b[i] = a[i];
        return (b);
    }

    // Read line k (k=0,1,2,...) and extracts it to the array of integers and return this array
    static public int[] readLineToIntArray(String fname, int k) {
        String s = null;
        try {
            RandomAccessFile f = new RandomAccessFile(fname, "r");
            for (int i = 0; i < k; i++)
                f.readLine();
            s = f.readLine();
            f.close();
        } catch (Exception e) {
        }

        int[] a = new int[100];
        StringTokenizer t = new StringTokenizer(s);
        int r, i;
        i = 0;
        while (t.hasMoreTokens()) {
            r = Integer.parseInt(t.nextToken().trim());
            a[i++] = r;
        }
        int n = i;
        int[] b = new int[n];
        for (i = 0; i < n; i++)
            b[i] = a[i];
        return (b);
    }
}