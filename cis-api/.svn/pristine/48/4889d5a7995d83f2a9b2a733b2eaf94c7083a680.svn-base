package uk.ac.reigate.dto.lookup;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.lookup.FileCategory

public class FileCategoryDtoTest {
    
    private FileCategory fileCategory1
    
    private FileCategory fileCategory2
    
    private List<FileCategory> fileCategories
    
    @Before
    public void setup() {
        this.fileCategory1 = new FileCategory(
                id: 1,
                code: 'A',
                description: 'Admissions'
                );
        this.fileCategory2 = new FileCategory(
                id: 2,
                code: 'B',
                description: 'School Report'
                );
        this.fileCategories = Arrays.asList(this.fileCategory1, this.fileCategory2);
    }
    
    @Test
    void testConstructor_nullObject() {
        FileCategory fileCategory = null
        FileCategoryDto fileCategoryTest = new FileCategoryDto( fileCategory )
        assertEquals( fileCategory, null);
    }
    
    @Test
    void testConstructor_fileCategory() {
        FileCategoryDto fileCategoryTest = new FileCategoryDto( fileCategory1 )
        assertEquals( fileCategoryTest.id, fileCategory1.id );
        assertEquals( fileCategoryTest.code, fileCategory1.code);
        assertEquals( fileCategoryTest.description, fileCategory1.description);
    }
    
    @Test
    public void testMapFromFileCategoryEntity(){
        FileCategoryDto fileCategoryTest = FileCategoryDto.mapFromEntity( fileCategory1 )
        assertEquals( fileCategoryTest.id, fileCategory1.id );
        assertEquals( fileCategoryTest.code, fileCategory1.code);
        assertEquals( fileCategoryTest.description, fileCategory1.description);
    }
    
    @Test
    public void testMapFromFileCategorysEntities(){
        List<FileCategoryDto> fileCategorysTest = FileCategoryDto.mapFromList( this.fileCategories )
        assertEquals( fileCategorysTest[0].id, fileCategory1.id );
        assertEquals( fileCategorysTest[0].code, fileCategory1.code );
        assertEquals( fileCategorysTest[0].description, fileCategory1.description);
        assertEquals( fileCategorysTest[1].id, fileCategory2.id );
        assertEquals( fileCategorysTest[1].code, fileCategory2.code );
        assertEquals( fileCategorysTest[1].description, fileCategory2.description);
    }
    
    @Test
    public void testEquals_Same() {
        FileCategoryDto fileCategoryDto1 = new FileCategoryDto(fileCategory1)
        FileCategoryDto fileCategoryDto2 = new FileCategoryDto(fileCategory1)
        assertEquals( fileCategoryDto1, fileCategoryDto2)
    }
    
    @Test
    public void testEquals_Different() {
        FileCategoryDto fileCategoryDto1 = new FileCategoryDto(fileCategory1)
        FileCategoryDto fileCategoryDto2 = new FileCategoryDto(fileCategory2)
        assertNotEquals( fileCategoryDto1, fileCategoryDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        FileCategoryDto fileCategoryDto1 = new FileCategoryDto(fileCategory1)
        FileCategoryDto fileCategoryDto2 = new FileCategoryDto(fileCategory1)
        assertEquals( fileCategoryDto1.hashCode(), fileCategoryDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        FileCategoryDto fileCategoryDto1 = new FileCategoryDto(fileCategory1)
        FileCategoryDto fileCategoryDto2 = new FileCategoryDto(fileCategory2)
        assertNotEquals( fileCategoryDto1.hashCode(), fileCategoryDto2.hashCode())
    }
    
    @Test
    public void testConstructor_FileCategory() {
        FileCategoryDto fileCategoryDto = new FileCategoryDto(fileCategory1)
        assertEquals( fileCategoryDto.code, fileCategory1.code )
        assertEquals( fileCategoryDto.description, fileCategory1.description )
    }
}
