package org.apache.hadoop;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.hadoop.model.Configuration;
import org.apache.hadoop.model.Property;

public class Check {
	
	
	/*public static void main(String[] args) throws Exception {  
		
        JAXBContext jc = JAXBContext.newInstance(Configuration.class);  
        Configuration conf = new Configuration();  
        conf.getKvs().add(new Property("hadoop.tmp.dir","/home/hadoop-cdh/temp"));  
   
        Marshaller marshaller = jc.createMarshaller();  
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
        marshaller.marshal(conf, System.out);  
    }  */
	
	public static void main(String[] args) throws JAXBException {
		
		if(args == null || args.length < 5){
			System.out.println("argmument not enough!");
			return;
		}
		String coreDefaultXml = args[0];
		String hdfsDefaultXml = args[1];
		String mapredDefaultXml = args[2];
		String yarnDefaultXml = args[3];
		
		JAXBContext context = JAXBContext.newInstance(Configuration.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		File coreDefault = new File(coreDefaultXml);
		Configuration coreDefaultConf = (Configuration) unmarshaller.unmarshal(coreDefault);
		
		File hdfsDefault = new File(hdfsDefaultXml);
		Configuration hdfsDefaultConf = (Configuration) unmarshaller.unmarshal(hdfsDefault);
		
		File mapredDefault = new File(mapredDefaultXml);
		Configuration mapredDefaultConf = (Configuration) unmarshaller.unmarshal(mapredDefault);
		
		File yarnDefault = new File(yarnDefaultXml);
		Configuration yarnDefaultConf = (Configuration) unmarshaller.unmarshal(yarnDefault);
		
		List<Property> coreDefaultKvs = coreDefaultConf.getKvs();
		List<Property> hdfsDefaultKvs = hdfsDefaultConf.getKvs();
		List<Property> mapredDefaultKvs = mapredDefaultConf.getKvs();
		List<Property> yarnDefaultKvs = yarnDefaultConf.getKvs();
		
		List<Property> allEffectPropertys = new ArrayList<Property>();
		
		allEffectPropertys.addAll(coreDefaultKvs);
		allEffectPropertys.addAll(hdfsDefaultKvs);
		allEffectPropertys.addAll(mapredDefaultKvs);
		allEffectPropertys.addAll(yarnDefaultKvs);
		
		List<Property> allUserPropertys = new ArrayList<Property>();
		
		for (int i = 4; i < args.length; i++) {
			String userXml = args[i];
			File userXmlFile = new File(userXml);
			Configuration userConf = (Configuration) unmarshaller.unmarshal(userXmlFile);
			allUserPropertys.addAll(userConf.getKvs());
		}
		
		List<Property> noeffectgKvs = new ArrayList<Property>();
		for (Property eachProperty : allUserPropertys) {
			if(!allEffectPropertys.contains(eachProperty)){
				noeffectgKvs.add(eachProperty);
			}
		}
		if(noeffectgKvs.size() == 0){
			System.out.println("your config file pass check!");
			return;
		}
		System.out.println(noeffectgKvs.size()+" no effect property found:");
		System.out.println(noeffectgKvs);
	}

}
