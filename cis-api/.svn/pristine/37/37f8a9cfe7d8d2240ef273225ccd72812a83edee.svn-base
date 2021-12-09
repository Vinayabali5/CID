package uk.ac.reigate.services;

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

import uk.ac.reigate.domain.Address
import uk.ac.reigate.domain.lookup.PostcodeLookup
import uk.ac.reigate.repositories.AddressRepository


@Component
@Service
class PostcodeLookupService {
    
    private final static Logger log = LoggerFactory.getLogger(PostcodeLookupService.class.getName());
    
    @Autowired
    AddressRepository addressRepository
    
    @Value("\${postcode.lookup.key}")
    private String key;
    
    @Value("\${postcode.lookup.username}")
    private String username;
    
    /**
     * This method is provided by the loqate GBG solution interactive find service. You can find all the information needed and references 
     * on the APIs web site: https://www.loqate.com/resources/support/apis/Capture/Interactive/Find/1.1/
     * 
     * @param Key The key used to authenticate with the service.
     * @param Text The search text to find. Ideally a postcode or the start of the address..
     * @param IsMiddleware Whether the API is being called from a middleware implementation (and therefore the calling IP address should not be used for biasing).
     * @param Container A container for the search. This should only be another Id previously returned from this service when the Type of the result was not 'Address'.
     * @param Origin A starting location for the search. This can be the name or ISO 2 or 3 character code of a country, WGS84 coordinates (comma separated) or IP address to search from.
     * @param Countries A comma separated list of ISO 2 or 3 character country codes to limit the search within.
     * @param Limit The maximum number of results to return.
     * @param Language The preferred language for results. This should be a 2 or 4 character language code e.g. (en, fr, en-gb, en-us etc).
     * @return
     * @throws Exception
     */
    private Hashtable[] Capture_Interactive_Find_v1_10(String Key, String Text, Boolean IsMiddleware, String Container, String Origin, String Countries, Integer Limit, String Language) throws Exception {
        
        String requestUrl = new String();
        String key = new String();
        String value = new String();
        String mid = String.valueOf(IsMiddleware)
        String lim = "100"
        //Build the url
        requestUrl = "https://api.addressy.com/Capture/Interactive/Find/v1.10/xmla.ws?";
        requestUrl += "&Key=" + java.net.URLEncoder.encode(Key);
        requestUrl += "&Text=" + java.net.URLEncoder.encode(Text);
        requestUrl += "&IsMiddleware=" + java.net.URLEncoder.encode(mid);
        requestUrl += "&Container=" + java.net.URLEncoder.encode(Container);
        requestUrl += "&Origin=" + java.net.URLEncoder.encode(Origin);
        requestUrl += "&Countries=" + java.net.URLEncoder.encode(Countries);
        requestUrl += "&Limit=" + java.net.URLEncoder.encode(lim);
        requestUrl += "&Language=" + java.net.URLEncoder.encode(Language);
        
        //Get the data
        java.net.URL url = new java.net.URL(requestUrl);
        java.io.InputStream stream = url.openStream();
        javax.xml.parsers.DocumentBuilder docBuilder = javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder();
        org.w3c.dom.Document dataDoc = docBuilder.parse(stream);
        
        //Get references to the schema and data
        org.w3c.dom.NodeList schemaNodes = dataDoc.getElementsByTagName("Column");
        org.w3c.dom.NodeList dataNotes = dataDoc.getElementsByTagName("Row");
        
        //Check for an error
        if (schemaNodes.getLength()==4 && schemaNodes.item(0).getAttributes().getNamedItem("Name").getNodeValue().equals("Error")){
            throw new Exception(dataNotes.item(0).getAttributes().getNamedItem("Description").getNodeValue());
        };
        
        //Work though the items in the response
        java.util.Hashtable[] results = new java.util.Hashtable[dataNotes.getLength()];
        for (int rowCounter=0; rowCounter<dataNotes.getLength(); rowCounter++){
            java.util.Hashtable rowData = new java.util.Hashtable();
            for (int colCounter=0; colCounter<schemaNodes.getLength(); colCounter++) {
                key = (String)schemaNodes.item(colCounter).getAttributes().getNamedItem("Name").getNodeValue();
                if(dataNotes.item(rowCounter).getAttributes().getNamedItem(key)==null)
                {
                    value="";
                }
                else
                {
                    value = (String)dataNotes.item(rowCounter).getAttributes().getNamedItem(key).getNodeValue();
                };
                rowData.put (key, value);
            }
            results[rowCounter] = rowData;
        }
        return results;
        
    }
    
    /**
     * This method is provided by the Postcode Anywhere service. You can find all the information needed and references 
     * on the APIs web site: https://www.loqate.com/resources/support/apis/Capture/Interactive/Retrieve/1/
     *  
     * @param Key The key to use to authenticate to the service.
     * @param Id The Id from a Find method to retrieve the details for.
     * @param Field1Format The FieldxFormat fields can be used to return extra data fields into the corresponding Fieldx response. This needs to be supplied in the format of {{FieldName}}.
     * @param Field2Format
     * @param Field3Format
     * @param Field4Format
     * @param Field5Format
     * @param Field6Format
     * @param Field7Format
     * @param Field8Format
     * @param Field9Format
     * @param Field10Format
     * @param Field11Format
     * @param Field12Format
     * @param Field13Format
     * @param Field14Format
     * @param Field15Format
     * @param Field16Format
     * @param Field17Format
     * @param Field18Format
     * @param Field19Format
     * @param Field20Format
     * @return
     * @throws Exception
     */
    private Hashtable[] Capture_Interactive_Retrieve_v1_00(String Key, String Id, String Field1Format, String Field2Format, String Field3Format, String Field4Format, String Field5Format, String Field6Format, String Field7Format, String Field8Format, String Field9Format, String Field10Format, String Field11Format, String Field12Format, String Field13Format, String Field14Format, String Field15Format, String Field16Format, String Field17Format, String Field18Format, String Field19Format, String Field20Format) throws Exception {
        
        String requestUrl = new String();
        String key = new String();
        String value = new String();
        
        //Build the url
        requestUrl = "https://api.addressy.com/Capture/Interactive/Retrieve/v1.00/xmla.ws?";
        requestUrl += "&Key=" + java.net.URLEncoder.encode(Key);
        requestUrl += "&Id=" + java.net.URLEncoder.encode(Id);
        requestUrl += "&Field1Format=" + java.net.URLEncoder.encode(Field1Format);
        requestUrl += "&Field2Format=" + java.net.URLEncoder.encode(Field2Format);
        requestUrl += "&Field3Format=" + java.net.URLEncoder.encode(Field3Format);
        requestUrl += "&Field4Format=" + java.net.URLEncoder.encode(Field4Format);
        requestUrl += "&Field5Format=" + java.net.URLEncoder.encode(Field5Format);
        requestUrl += "&Field6Format=" + java.net.URLEncoder.encode(Field6Format);
        requestUrl += "&Field7Format=" + java.net.URLEncoder.encode(Field7Format);
        requestUrl += "&Field8Format=" + java.net.URLEncoder.encode(Field8Format);
        requestUrl += "&Field9Format=" + java.net.URLEncoder.encode(Field9Format);
        requestUrl += "&Field10Format=" + java.net.URLEncoder.encode(Field10Format);
        requestUrl += "&Field11Format=" + java.net.URLEncoder.encode(Field11Format);
        requestUrl += "&Field12Format=" + java.net.URLEncoder.encode(Field12Format);
        requestUrl += "&Field13Format=" + java.net.URLEncoder.encode(Field13Format);
        requestUrl += "&Field14Format=" + java.net.URLEncoder.encode(Field14Format);
        requestUrl += "&Field15Format=" + java.net.URLEncoder.encode(Field15Format);
        requestUrl += "&Field16Format=" + java.net.URLEncoder.encode(Field16Format);
        requestUrl += "&Field17Format=" + java.net.URLEncoder.encode(Field17Format);
        requestUrl += "&Field18Format=" + java.net.URLEncoder.encode(Field18Format);
        requestUrl += "&Field19Format=" + java.net.URLEncoder.encode(Field19Format);
        requestUrl += "&Field20Format=" + java.net.URLEncoder.encode(Field20Format);
        
        //Get the data
        java.net.URL url = new java.net.URL(requestUrl);
        java.io.InputStream stream = url.openStream();
        javax.xml.parsers.DocumentBuilder docBuilder = javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder();
        org.w3c.dom.Document dataDoc = docBuilder.parse(stream);
        
        //Get references to the schema and data
        org.w3c.dom.NodeList schemaNodes = dataDoc.getElementsByTagName("Column");
        org.w3c.dom.NodeList dataNotes = dataDoc.getElementsByTagName("Row");
        
        //Check for an error
        if (schemaNodes.getLength()==4 && schemaNodes.item(0).getAttributes().getNamedItem("Name").getNodeValue().equals("Error"))
        {
            throw new Exception(dataNotes.item(0).getAttributes().getNamedItem("Description").getNodeValue());
        };
        
        //Work though the items in the response
        java.util.Hashtable[] results = new java.util.Hashtable[dataNotes.getLength()];
        for (int rowCounter=0; rowCounter<dataNotes.getLength(); rowCounter++)
        {
            java.util.Hashtable rowData = new java.util.Hashtable();
            for (int colCounter=0; colCounter<schemaNodes.getLength(); colCounter++)
            {
                key = (String)schemaNodes.item(colCounter).getAttributes().getNamedItem("Name").getNodeValue();
                if(dataNotes.item(rowCounter).getAttributes().getNamedItem(key)==null)
                {
                    value="";
                }
                else
                {
                    value = (String)dataNotes.item(rowCounter).getAttributes().getNamedItem(key).getNodeValue();
                };
                rowData.put (key, value);
            }
            results[rowCounter] = rowData;
        }
        
        //Return the results
        return results;
    }
    
    /**
     * This method is used to retrieve a list of address id and brief descriptive information for the address to then 
     * be selected and retrieved using the retrieve method.
     * 
     * @param postcode The postcode that you want to use to search for addresses.
     * @return A List of PostcodeLookupDto objects, with an id field used for retrieving address.
     */
    List<PostcodeLookup> search(String text) {
        log.info("*** PostcodeLookupService.search ");
        List<PostcodeLookup> output = new ArrayList<PostcodeLookup>();
        Hashtable[] results = null;
        try {
            results = this.Capture_Interactive_Find_v1_10(this.key, text, true, "GB", "3166-2:GB", "GB", 99, "en-gb");
            for(Hashtable i : results) {
                if(i.get("Type") == "Address") {
                    PostcodeLookup item = new PostcodeLookup()
                    item.type = i.get("Type")
                    item.id = i.get("Id")
                    item.text =  i.get("Text")
                    item.highlight =  i.get("Highlight")
                    item.description =  i.get("Description")
                    output.add(item)
                } else {
                    if (i.get("Type") == "Postcode") {
                        results = this.Capture_Interactive_Find_v1_10(this.key, text, true, i.get("Id"), "3166-2:GB", "GB", 99, "en-gb");
                        results.each { it ->
                            PostcodeLookup item = new PostcodeLookup()
                            item.id = it.get("Id")
                            item.type = it.get("Type")
                            item.text =  it.get("Text")
                            item.highlight =  it.get("Highlight")
                            item.description =  it.get("Description")
                            output.add(item)
                        }
                    }
                }
            }
        } catch (UnknownHostException e) {
            throw e;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return output;
    }
    
    /**
     * This method is used to retrieve a full address for a supplied ID. The ID is found by using the search method. 
     * 
     * @param id The ID for the address to retrieve
     * @return An Address object populated with the data from the Postcode Lookup Service.
     */
    Address retrieve(String id){
        log.info("*** PostcodeLookupService.getById");
        Address output = null
        try {
            Hashtable[] results = this.Capture_Interactive_Retrieve_v1_00(this.key, id, "none", "none","none","none", "none","none","none","none","none","none","none","none","none","none","none","none","none","none","none","none");
            output = new Address()
            output.line1 = results[0].get("Line1")
            output.line2 = results[0].get("Line2")
            output.line3 = results[0].get("Line3")
            output.line4 = results[0].get("Line4")
            output.line5 = results[0].get("Line5")
            output.buildingName = results[0].get("BuildingName")
            output.subBuilding = results[0].get("SubBuilding")
            output.town = results[0].get("City")
            output.county = results[0].get("County")
            output.postcode = results[0].get("PostalCode")
            output.fullAddress = results[0].get("Label")
            log.info("*** PostcodeLookupService.getById123");
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        return output;
    }
    
    public void add(final Address address){
        this.addressRepository.add(address);
        
    }
    
    
}

