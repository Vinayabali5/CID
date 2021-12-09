package uk.ac.reigate.dto;

import static org.junit.Assert.*

import org.junit.Test

import uk.ac.reigate.model.PageInfo

public class PaginationDtoTest {
    
    @Test
    public void testNoArgsConstructor() {
        PaginationDTO paginationDto1 = new PaginationDTO()
        assertNotNull(paginationDto1)
    }
    
    @Test
    public void testConstructorPageSize() {
        PaginationDTO paginationDto = new PaginationDTO(19, 3)
        assertEquals(paginationDto.page, 19)
        assertEquals(paginationDto.size, 3)
    }
    
    @Test
    public void testConstructorPageSort() {
        PaginationDTO paginationDto = new PaginationDTO(19, 3, 'vinaya')
        assertEquals(paginationDto.page, 19)
        assertEquals(paginationDto.size, 3)
        assertEquals(paginationDto.sort, 'vinaya')
    }
    
    @Test
    public void testConstructorPageSortItem() {
        PaginationDTO paginationDto = new PaginationDTO(19, 3, 100L, 200L)
        assertEquals(paginationDto.page, 19)
        assertEquals(paginationDto.size, 3)
        assertEquals(paginationDto.totalItems, 100L)
        assertEquals(paginationDto.totalPages, 200L)
    }
    
    @Test
    public void testConstructorPageSortItemPage() {
        PageInfo pageInfo = new PageInfo()
        PaginationDTO paginationDto = new PaginationDTO(pageInfo)
        assertEquals(paginationDto.page, 0)
        assertEquals(paginationDto.size, 0)
        assertEquals(paginationDto.totalItems, 0)
        assertEquals(paginationDto.totalPages, 0)
    }
}
