package uk.ac.reigate.model;

import org.springframework.data.domain.Pageable;

/**
 * The PageInfo object is used to store pagination information for search results. 
 * 
 * @author Michael Horgan
 *
 */
class PageInfo {
    
    int page
    
    int size
    
    String sort
    
    Long totalPages
    
    Long totalResults
    
    /**
     * Creates a blank PageInfo object
     */
    public PageInfo() {
        super();
        this.page = 0;
        this.size = 0;
        this.sort = '';
        this.totalResults = 0;
        this.totalPages = 0;
    }
    
    /**
     * Creates a PageInfo object with a page and size parameter
     * 
     * @param page the current page number (pages are zero indexed)
     * @param size the current page size
     */
    public PageInfo(int page, int size) {
        this();
        this.page = page;
        this.size = size;
    }
    
    /**
     * Creates a PageInfo object with a page, size and sort parameter
     * 
     * @param page the current page number (pages are zero indexed)
     * @param size the current page size
     * @param sort the current sort order being used (eg. 'code,asc')
     */
    public PageInfo(int page, int size, String sort) {
        this(page, size);
        this.sort = sort;
    }
    
    /**
     * Creates a PageInfo object with a page, size and totalResults parameter
     * 
     * @param page the current page number (pages are zero indexed)
     * @param size the current page size
     * @param totalResults the total number of results for the entire record set
     */
    public PageInfo(int page, int size, Long totalResults) {
        this(page, size);
        this.totalResults = totalResults;
        if (size != 0) {
            this.totalPages = totalResults / size;
            if (totalResults % size > 0) {
                this.totalPages++;
            }
        } else {
            this.totalPages = 1;
        }
    }
    
    /**
     * Creates a PageInfo object with a page, size and totalResults parameter
     * 
     * @param page the current page number (pages are zero indexed)
     * @param size the current page size
     * @param sort the current sort order being used (eg. 'code,asc')
     * @param totalResults the total number of results for the entire record set
     */
    public PageInfo(int page, int size, String sort, Long totalResults) {
        this(page, size, totalResults);
        this.sort = sort;
    }
    
    /**
     * Standard toString method 
     */
    @Override
    public String toString() {
        return "PageInfo [page=" + page + ", size=" + size + ", sort=" + sort + ", totalPages=" + totalPages + ", totalResults=" + totalResults + "]";
    }
    
    /**
     * Retrieve the number of the next page 
     * 	
     * @return the next page number or the total number of pages if at the last page.
     */
    public int getNextPage() {
        if (this.page + 1 <= this.totalPages) {
            return this.page + 1
        } else {
            return this.totalPages
        }
    }
}
