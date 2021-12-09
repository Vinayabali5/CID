package uk.ac.reigate.model;


import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Search result of a search method, meant to be used as return type in the service layer for search methods,
 * when both the result and the total results count are needed.
 *
 * @param <T> The class of object to store in the SearchResult object
 */
public class SearchResult<T> {
    
    @JsonProperty
    private PageInfo pageInfo;
    
    @JsonIgnore
    @Deprecated
    private long resultsCount;
    
    private List<T> result;
    
    /**
     * Default NoArgs constructor
     */
    SearchResult() {}
    
    /**
     * This Constructor is used to create a SearchResult object by using only the List of objects.
     *  
     * @param result The List of objects to return as the search results data.
     */
    SearchResult(List<T> result) {
        this.pageInfo = new PageInfo(0, result.size)
        this.result = result
    }
    
    /**
     * This Constructor is used to create a SearchResult object by using a PageInfo object and the List of objects.
     * 
     * @param pageInfo
     * @param result
     */
    SearchResult(PageInfo pageInfo, List<T> result) {
        this.pageInfo = pageInfo;
        this.result = result;
    }
    
    /**
     * This Constructor is used to create a SearchResult object by providing the number of results and the List of objects.
     * 
     * @param resultsCount The number of results
     * @param result The List of objects to return as the search results data.
     */
    SearchResult(long resultsCount, List<T> result) {
        this.pageInfo = new PageInfo()
        this.pageInfo.totalResults = resultsCount
        this.result = result;
    }
    
    /**
     * This Constructor is used to create a SearchResult object by providing the page number and size of the pages plus the 
     * List of objects.
     * 
     * @param page The page number of the current results set. This is a zero-indexed page number.
     * @param size The size of each page. If this is 0 (zero) or less then the results set is assumed to contain all the 
     * search results.
     * @param results The List of objects to return as the search results data.
     */
    SearchResult(int page, int size, List<T> result) {
        this(new PageInfo(page, size), result)
    }
    
    long getResultsCount() {
        return this.pageInfo.totalResults;
    }
    
    /**
     * This method is used to retrieve the list of objects stored in the SearchResult object
     * 
     * @return The List of objects
     */
    List<T> getResult() {
        return this.result;
    }
}
