/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coc.cleanup;

/**
 *
 * @author miguel
 */
public class Run {

    public static int main(String[] args) {
        int error = 0;

        String filename = null;
        String newFileName = null;
        boolean write = false;

        switch (args.length) {
            case 1:
                filename = args[0];
                break;
            case 2:
                if (args[1].equals("-w")) {
                    filename = args[0];
                    write = true;
                    newFileName = "cleanXmlFile.xml";
                    break;
                }
            case 3:
                if (args[1].equals("-w")) {
                    filename = args[0];
                    write = true;
                    newFileName = args[2];

                    if (!newFileName.endsWith(".xml")) {
                        newFileName = newFileName + ".xml";
                    }
                    break;
                }
            default:
                System.err.println("Usage $java -cp CoCCleanUp.class FileName.xml [-w [newFileName].xml ]");
                System.exit(0);
                break;
        }

        CoCCleanUp clean = new CoCCleanUp(newFileName, write);
       
        if (clean.cleanDocument(filename) < 0) {
            System.out.println(clean.getErrorMessage());
            error = -1;
        }
        
        return error;
    }
}
