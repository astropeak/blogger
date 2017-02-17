package com.aspk.blogger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.io.File;




/**
 *
 */

@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
public class AccountData {

    @XmlElement(name = "account")
    Map<String, String> account;

    public Map<String, String> getAccount(){
        return account;
    }

    public void setAccount(Map<String, String> account){
        this.account = account;
    }
    public String toString(){
        return account.toString();
    }

    // String xml;
    // (String xml){
    //     this.xml = xml;
    // }

    static AccountData newInstance(String xml) {
        try {
            File file = new File(xml);
            JAXBContext jaxbContext = JAXBContext.newInstance(AccountData.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            AccountData ad = (AccountData)jaxbUnmarshaller.unmarshal(file);
            return ad;
        } catch (JAXBException e) {
            throw new RuntimeException("Can't parse xml ", e);
        }
    }

    public static void main (String[] args ) throws Exception {
        AccountData ad = AccountData.newInstance("account.xml");
        System.out.println("ad: "+ad);
        aaa();
    }

    static void aaa()  throws JAXBException{
        JAXBContext jaxbContext = JAXBContext.newInstance(AccountData.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        AccountData aa = new AccountData();
        Map<String, String> mm = new HashMap<String, String>();
        mm.put("id", "cnblogs");
        // List<Map<String, String>> ll = new ArrayList<Map<String, String>>();
        // ll.add(mm);
        // ll.add(mm);
        aa.setAccount(mm);

        //Marshal the employees list in console
        jaxbMarshaller.marshal(aa, System.out);
    }
}