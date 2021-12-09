package uk.ac.reigate.scripts

import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

import uk.ac.reigate.scripts.utils.AddressUtils
import uk.ac.reigate.services.schoolimport.SchoolImportService


@Component
class SchoolImportController implements CommandLineRunner {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SchoolImportController.class);
    
    @Autowired
    SchoolImportService schoolImportService
    
    @Override
    public void run(String... args) throws Exception {
        //runWarwickImport()
        //runDeStaffordImport()
        //runReigateImport()
        //runOakwoodImport()
    }
    
    void runWarwickImport() {
        String filename = "import/warwick.xlsx"
        String school = 'THE WARWICK SCHOOL'
        
        Workbook wb = WorkbookFactory.create(new File(filename));
        Sheet sheet = wb.getSheetAt(0)
        Row firstRow = sheet.getRow(0)
        
        for (Cell cell : firstRow ) {
            LOGGER.debug(cell.getColumnIndex() + ': ' + cell.toString())
        }
        
        for (Row currentRow : sheet) {
            if (currentRow.getRowNum() != 0) {
                Date received = new Date('1 Nov 2016')
                String firstName = currentRow.getCell(1)
                String surname = currentRow.getCell(0)
                String middleNames = currentRow.getCell(2)
                String preferredName = currentRow.getCell(4)
                String uln = currentRow.getCell(15)
                String uci = currentRow.getCell(16)
                Date dob = new Date(currentRow.getCell(17).toString())
                String gender = currentRow.getCell(18)
                String parentAddressee = currentRow.getCell(19)
                String home = currentRow.getCell(13)
                String address = currentRow.getCell(5)
                String[] addressLines = address.split(',')
                String postcode = addressLines[addressLines.size()-1]
                addressLines = addressLines.take(addressLines.size()-1)
                
                schoolImportService.addApplication(received, firstName, surname, middleNames, preferredName, uln, uci, dob, gender, parentAddressee, home, addressLines, postcode, school)
            }
        }
    }
    
    void runDeStaffordImport() {
        String filename = "import/de_stafford.xlsx"
        String school = 'DE STAFFORD SCHOOL'
        
        Workbook wb = WorkbookFactory.create(new File(filename));
        Sheet sheet = wb.getSheetAt(0)
        Row firstRow = sheet.getRow(0)
        
        for (Cell cell : firstRow ) {
            LOGGER.debug(cell.getColumnIndex() + ': ' + cell.toString())
        }
        
        for (Row currentRow : sheet) {
            if (currentRow.getRowNum() != 0) {
                Date received = new Date('1 Nov 2016')
                String firstName = currentRow.getCell(1)
                String surname = currentRow.getCell(0)
                String middleNames = null
                String preferredName = null
                String uln = currentRow.getCell(4)
                String uci = currentRow.getCell(5)
                Date dob = new Date(currentRow.getCell(2).toString())
                String gender = currentRow.getCell(3)
                String parentAddressee = currentRow.getCell(6)
                String home = currentRow.getCell(9)
                String address = currentRow.getCell(7)
                String[] addressLines = address.split('\n')
                String postcode = addressLines[addressLines.size()-1]
                addressLines = addressLines.take(addressLines.size()-1)
                
                schoolImportService.addApplication(received, firstName, surname, middleNames, preferredName, uln, uci, dob, gender, parentAddressee, home, addressLines, postcode, school)
            }
        }
    }
    
    void runReigateImport() {
        String filename = "import/reigate.xlsx"
        String school = 'REIGATE SCHOOL'
        
        Workbook wb = WorkbookFactory.create(new File(filename));
        Sheet sheet = wb.getSheetAt(0)
        Row firstRow = sheet.getRow(0)
        
        for (Cell cell : firstRow ) {
            LOGGER.debug(cell.getColumnIndex() + ': ' + cell.toString())
        }
        
        for (Row currentRow : sheet) {
            if (currentRow.getRowNum() != 0) {
                Date received = new Date('1 Nov 2016')
                String firstName = currentRow.getCell(0)
                String surname = currentRow.getCell(3)
                String middleNames = currentRow.getCell(1)
                String preferredName = null
                String uln = currentRow.getCell(17)
                String uci = currentRow.getCell(12)
                String dateString = currentRow.getCell(4).toString()
                Date dob = new Date(currentRow.getCell(4).toString())
                String gender = currentRow.getCell(5)
                String parentAddressee = currentRow.getCell(21)
                String home = null
                
                String houseBuildingNumber = currentRow.getCell(6)
                String houseBuildingName = currentRow.getCell(7)
                String street = currentRow.getCell(8)
                String town = currentRow.getCell(9)
                String postcode = currentRow.getCell(10)
                
                String address = AddressUtils.addressComponentsToAddressString(houseBuildingNumber, houseBuildingName, street, town, postcode)
                String[] addressLines = address.split(',')
                
                addressLines = addressLines.take(addressLines.size()-1)
                
                schoolImportService.addApplication(received, firstName, surname, middleNames, preferredName, uln, uci, dob, gender, parentAddressee, home, addressLines, postcode, school)
            }
        }
    }
    
    void runOakwoodImport() {
        String filename = "import/oakwood.xlsx"
        String school = 'OAKWOOD SCHOOL'
        
        Workbook wb = WorkbookFactory.create(new File(filename));
        Sheet sheet = wb.getSheetAt(0)
        Row firstRow = sheet.getRow(0)
        
        for (Cell cell : firstRow ) {
            LOGGER.debug(cell.getColumnIndex() + ': ' + cell.toString())
        }
        
        for (Row currentRow : sheet) {
            if (currentRow.getRowNum() != 0) {
                Date received = new Date('1 Nov 2016')
                String firstName = currentRow.getCell(1)
                String surname = currentRow.getCell(2)
                String middleNames = null
                String preferredName = null
                String uln = currentRow.getCell(7)
                String uci = null
                Date dob = new Date(currentRow.getCell(4).toString())
                String gender = currentRow.getCell(5)
                String parentAddressee = ((String) currentRow.getCell(15)).trim()
                String home = currentRow.getCell(25)
                String address = currentRow.getCell(24)
                String[] addressLines = address.trim().split('\n')
                String postcode = addressLines[addressLines.size()-1]
                addressLines = addressLines.take(addressLines.size()-1)
                
                schoolImportService.addApplication(received, firstName, surname, middleNames, preferredName, uln, uci, dob, gender, parentAddressee, home, addressLines, postcode, school)
            }
        }
    }
}
