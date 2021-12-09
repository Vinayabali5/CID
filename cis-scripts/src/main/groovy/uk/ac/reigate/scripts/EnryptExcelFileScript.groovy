package uk.ac.reigate.scripts

import java.security.GeneralSecurityException

import org.apache.poi.openxml4j.exceptions.InvalidFormatException
import org.apache.poi.openxml4j.opc.OPCPackage
import org.apache.poi.openxml4j.opc.PackageAccess
import org.apache.poi.poifs.crypt.EncryptionInfo
import org.apache.poi.poifs.crypt.EncryptionMode
import org.apache.poi.poifs.crypt.Encryptor
import org.apache.poi.poifs.filesystem.POIFSFileSystem
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class EnryptExcelFileScript {
    
    
    /**
     * @param args
     * @throws IOException
     * @throws InvalidFormatException
     * @throws GeneralSecurityException
     */
    public static void main(String[] args) throws IOException, InvalidFormatException, GeneralSecurityException {
        
        String FILENAME = "./output/test.xlsx"
        
        //create a new workbook
        Workbook wb = new XSSFWorkbook();
         
        //add a new sheet to the workbook
        Sheet sheet1 = wb.createSheet("Sheet1");
         
        //add 2 row to the sheet
        Row row1 = sheet1.createRow(0);
        Row row2 = sheet1.createRow(1);
         
        //create cells in the row
        Cell row1col1 = row1.createCell(0);
        Cell row1col2 = row1.createCell(1);
         
        //add data to the cells
        row1col1.setCellValue("Top Secret Data 1");
        row1col2.setCellValue("Top Secret Data 2");
 
        //write the excel to a file
        try {
            FileOutputStream fileOut = new FileOutputStream(FILENAME);
            wb.write(fileOut);
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        //Add password protection and encrypt the file
        POIFSFileSystem fs = new POIFSFileSystem();
        EncryptionInfo info = new EncryptionInfo(fs, EncryptionMode.agile);
 
        Encryptor enc = info.getEncryptor();
        enc.confirmPassword("s3cr3t");
 
        OPCPackage opc = OPCPackage.open(new File(FILENAME), PackageAccess.READ_WRITE);
        OutputStream os = enc.getDataStream(fs);
        opc.save(os);
        opc.close();
 
        FileOutputStream fos = new FileOutputStream(FILENAME);
        fs.writeFilesystem(fos);
        fos.close();
             
        System.out.println("File created!!");
 
    }
}
