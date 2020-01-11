package com.bridgelabz.clinic;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.bridgelabz.clinicManagement.Doctor;

public class PatientImplementation  {
	
public static Utility utility	=	new Utility();

ObjectMapper mapper	=	new ObjectMapper();


public List<Patient> addPatientToList(List<Patient> patientList){
	Patient patient	=	new Patient();
	System.out.println("Enter the name of patient");
	patient.setName(utility.read_String());
	System.out.println("Enter the patient id");
	patient.setId(utility.read_Integer());
	System.out.println("Enter the patient mobile no");
	patient.setMobileNo(utility.read_Integer());
	System.out.println("Enter the patient age");
	patient.setAge(utility.read_Integer());
	
	patientList.add(patient);
	return patientList;

}
public List<Patient> readPatientFile() {
	File Patient	=	new File("/home/admin1/Desktop/Fellowship_Pranita_Jadhav/OOPsProjects/src/com/bridgelabz/clinic/Patient.json");
	List<Patient> list1 = null;
	
		try {
			list1 = mapper.readValue(Patient, new TypeReference<List<Patient>>(){});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	return list1;
	
	
}
	
public void writeFile(List<Patient> PatientList) throws JsonGenerationException, JsonMappingException, IOException {
	File Patient	=	new File("/home/admin1/Desktop/Fellowship_Pranita_Jadhav/OOPsProjects/src/com/bridgelabz/clinic/Patient.json");

	mapper.defaultPrettyPrintingWriter().writeValue(Patient, PatientList);
}

int count = 0;
public void searchPatientByName(List<Patient> patientList) {
	System.out.println("Enter patient name ");
	String name	=	utility.read_String();
	  for(Patient patient: patientList) {
		  if(patient.getName().equalsIgnoreCase(name)) {
			  
			  System.out.println(patient.toString());
			  count++;
		  }
	  }
	  if(count == 0)
		  System.out.println("No Patient of name "+name+"found");
}

public void searchPatientById(List<Patient> patientList) {
	System.out.println("Enter Patient id who want a appointment");
	int id	=	utility.read_Integer();
	  for(Patient patient: patientList) {
		  if(patient.getId() == id) {
			  
			  System.out.println(patient.toString());
			  count++;
			  
		  }
	  }
if(count == 0) {
	  System.out.println("No Doctor of id"+id+"Found");

	
}








}

}