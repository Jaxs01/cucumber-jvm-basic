package nz.co.assurity.common;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;


/**
 * This holds file operation utilities.
 *
 * @author: Assurity
 * Date: 2/17/16
 * Time: 3:46 PM
 * To change this template use File | Settings | Editor |File and code Templates.
 */
public class FileUtility {


    public static boolean isFileExist(String fileNameWithFullPath) {
        File file = new File(fileNameWithFullPath);
        return file.exists() && !file.isDirectory();
    }

    /**
     * This will verify a file exists
     *
     * @param filePath
     * @param fileName
     * @return
     * @throws Exception
     */
    public static boolean isFileExist(String filePath, String fileName) {
        boolean exist = false;
        File dir = new File(filePath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("Can't find any files in the current directory");
        } else {
            for (int i = 0; i < files.length; i++) {
                // Get filename of file or directory
                String filename = files[i].getName();
                if (filename.indexOf(fileName) > -1) exist = true;

            }

        }
        return exist;
    }


    /**
     * This will delete a given file.
     *
     * @param fileName
     * @param dirPath
     * @return
     * @throws Exception
     */
    public static boolean deleteFile(String dirPath, String fileName) throws Exception {
        File dir = new File(dirPath);
        return (new File(dir.toString() + "/" + fileName).delete());
    }


    /**
     * This will read and return a given file
     *
     * @param filePath
     * @param fileNames
     * @return
     * @throws Exception
     */
    public static String readFile(String filePath, String fileNames) throws Exception {

        File fileName = new File(filePath + "/" + fileNames);
        System.out.println("Reading the file " + fileName);
        StringBuffer content = new StringBuffer();
        if (fileName == null) {
            System.out.println("File is not found.");
            throw new Exception("Make sure the file exist.");
        }
        BufferedReader in = new BufferedReader(new FileReader(fileName));

        String str;
        while ((str = in.readLine()) != null) {
            content.append(str);
        }
        in.close();
        return content.toString();
    }

    public static String readFileWithNewLine(String filePath, String fileNames) throws Exception {

        File fileName = new File(filePath + "/" + fileNames);
        System.out.println("Reading the file " + fileName);
        StringBuffer content = new StringBuffer();
        if (fileName == null) {
            System.out.println("File is not found.");
            throw new Exception("Make sure the file exist.");
        }
        BufferedReader in = new BufferedReader(new FileReader(fileName));

        String str;
        while ((str = in.readLine()) != null) {
            content.append(str + "splitterx");
        }
        in.close();
        return content.toString();
    }

    /**
     * This will write a file to a given location
     *
     * @param path
     * @param fileName
     * @param content
     * @param append
     * @throws IOException
     */
    public static void writeFile(String path, String fileName, String content, boolean append) throws IOException {
        // System.out.println("Writing the file " + fileName + " at " + path);
        File originalFile = new File(path + "/" + fileName);
        if (!originalFile.getParentFile().exists())
            originalFile.getParentFile().mkdirs();
        FileWriter fileWriter = new FileWriter(originalFile, append);
        fileWriter.write(content);
        fileWriter.flush();
        fileWriter.close();
        //System.out.println("Completed writing the file " + fileName + " at " + path);

    }


    public static Document parseXmlFile(String filename, boolean validating) {
        System.out.println("generating the builder from the xml :: [" + filename + "]");
        try {
            // Create a builder factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(validating);


            // Create the builder and parse the file
            Document doc = factory.newDocumentBuilder().parse(new File(filename));
            return doc;
        } catch (SAXException e) {
            // A parsing error occurred; the xml input is not valid
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
        }
        return null;
    }


    public static void replaceString(String fname, String oldPattern, String replPattern) {
        String line;
        StringBuffer sb = new StringBuffer();
        try {
            FileInputStream fis = new FileInputStream(fname);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll(oldPattern, replPattern);
                sb.append(line + "\n");
            }
            reader.close();
            BufferedWriter out = new BufferedWriter(new FileWriter(fname));
            out.write(sb.toString());
            out.close();
        } catch (Throwable e) {
            System.err.println(e.getMessage());

        }
    }

    /**
     * This method returns a list of files with the given extension for the given folder.
     *
     * @param filePath
     * @param fileExt
     * @return
     * @throws Exception
     */


    public static ArrayList<String> getFilesOfGivenExtention(String filePath, String fileExt) throws Exception {
        ArrayList<String> fileNames = new ArrayList<String>();
        String reportName = null;
        File dir = new File(filePath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("Can't find any files in the given directory");
        } else {
            for (int i = 0; i < files.length; i++) {
                // Get filename of file or directory
                String filename = files[i].getName();
                if (filename.indexOf(fileExt) > -1) fileNames.add(filename);
            }
        }
        if (fileNames.size() == 0) {
            throw new Exception("The Folder does not contain given file types.");
        }
        return fileNames;
    }

    public static ArrayList<String> findFilesOfGivenExtensionInSpecifiedDirectory(String dirName, final String fileExtension) {
        ArrayList<String> files = new ArrayList<String>();
        File[] faFiles = new File(dirName).listFiles();
        for (File file : faFiles) {
            if (file.isDirectory()) {
                files.addAll(findFilesOfGivenExtensionInSpecifiedDirectory(file.getAbsolutePath(), fileExtension));
            } else if (file.getName().endsWith(fileExtension)) {
                files.add(file.getAbsolutePath());
            }
        }
        return files;
    }

}




