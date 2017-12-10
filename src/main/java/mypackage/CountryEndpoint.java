//package mypackage;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ws.server.endpoint.annotation.Endpoint;
//import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
//import org.springframework.ws.server.endpoint.annotation.RequestPayload;
//import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
//
///**
// *这个类类似于controller
// * */
//
//@Endpoint
//public class CountryEndpoint {
//    private static final String NAMESPACE_URI = "http://www.yourcompany.com/webservice";
//
//
//
//    @Autowired
//    public CountryEndpoint() {
//
//    }
//
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
//    @ResponsePayload
//    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
//        GetCountryResponse response = new GetCountryResponse();
//        response.setCountry(new Country());
//
//        return response;
//    }
//}