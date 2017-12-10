//
//package mypackage;
//
//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlSchemaType;
//import javax.xml.bind.annotation.XmlType;
//
//
//
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "country", namespace = "http://127.0.0.1:8070/webservice", propOrder = {
//    "name",
//    "population",
//    "capital",
//    "currency"
//})
//public class Country {
//
//    @XmlElement(namespace = "http://127.0.0.1:8070/webservice", required = true)
//    protected String name;
//    @XmlElement(namespace = "http://127.0.0.1:8070/webservice")
//    protected int population;
//    @XmlElement(namespace = "http://127.0.0.1:8070/webservice", required = true)
//    protected String capital;
//    @XmlElement(namespace = "http://127.0.0.1:8070/webservice", required = true)
//    @XmlSchemaType(name = "string")
//    protected Currency currency;
//
//    public String getName() {
//        return name;
//    }
//
//
//    public void setName(String value) {
//        this.name = value;
//    }
//
//
//    public int getPopulation() {
//        return population;
//    }
//
//
//    public void setPopulation(int value) {
//        this.population = value;
//    }
//
//
//
//    public String getCapital() {
//        return capital;
//    }
//
//
//    public void setCapital(String value) {
//        this.capital = value;
//    }
//
//
//    public Currency getCurrency() {
//        return currency;
//    }
//
//
//    public void setCurrency(Currency value) {
//        this.currency = value;
//    }
//
//}
