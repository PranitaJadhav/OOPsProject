package com.bridgelabz.clinic;




import java.io.File;
import java.io.IOException;  
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;


public class DoctorImplementation implements DoctorInterface {
	
public static Utility utility	=	new Utility();
 ObjectMapper mapper	=	new ObjectMapper();

int count = 0;


	public List<Doctor> addDoctorToList(List<Doctor> doctorList){
		
		
		 Doctor doctor	=	new Doctor();
		 
		 System.out.println("enter the name of doctor");
		 doctor.setName(utility.read_String());
		 System.out.println("enter the id of doctor");
		 doctor.setId(utility.read_Integer());
		 System.out.println("enter the specialization of doctor");
		 doctor.setSpecialization(utility.read_String());
		 System.out.println("enter the availabity of doctor");
		 doctor.setAvailability(utility.read_String());
		 
		 doctor.setNoOfPatient(0);
		 doctorList.add(doctor);
		 return doctorList;
	}
	

	
	public List<Doctor> readDoctorFile() {
		File doctor1	=	new File("/home/admin1/Desktop/Fellowship_Pranita_Jadhav/OOPsProjects/src/com/bridgelabz/clinic/Doctor.json");
		
		List<Doctor> list1 = null;
		try {
			list1 = mapper.readValue(doctor1, new TypeReference<List<Doctor>>(){});
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * for(Doctor doctor: list1) { System.out.println(doctor.toString()); }
		 */
		
		return list1;
		
		
	}
	public void writeFile(List<Doctor> doctorList) throws JsonGenerationException, JsonMappingException, IOException {
		File doctor1	=	new File("/home/admin1/Desktop/Fellowship_Pranita_Jadhav/OOPsProjects/src/com/bridgelabz/clinic/Doctor.json");
		/*
		 * FileWriter writer = new FileWriter(doctor1); writer.write("");
		 * writer.flush(); mapper.writeValue(this.doctor1, doctorList);
		 */
		
		
		mapper.defaultPrettyPrintingWriter().writeValue(doctor1, doctorList);
		
	}
	
	
	public void searchDocotByName(List<Doctor> doctorList) {
		System.out.println("Enter doctor name You want a appointment");
		String name	=	utility.read_String();
		  for(Doctor doctor:doctorList) {
			  if(doctor.getName().equalsIgnoreCase(name)) {
				  
				  System.out.println(doctor.toString());
				  count++;
			  }
		  }
		  if(count == 0)
			  System.out.println("No Doctor of name "+name+"found");
	}

	
	public void searchDoctorById(List<Doctor> doctorList) {
		System.out.println("Enter doctor id You want a appointment");
		int id	=	utility.read_Integer();
		  for(Doctor doctor: doctorList) {
			  if(doctor.getId() == id) {
				  
				  System.out.println(doctor.toString());
				  count++;
				  
			  }
		  }
    if(count == 0) {
		  System.out.println("No Doctor of id"+id+"Found");

    	
    }
		
	}

	
	public void searchDoctorBySpecialization(List<Doctor> doctorList) {
		System.out.println("Enter the specialization of doctor for appointment");
		String specialization	=	utility.read_String();
		  for(Doctor doctor:doctorList) {
			  if(doctor.getSpecialization().equalsIgnoreCase(specialization)) {
				  System.out.println(doctor.toString());
				  count++;
			  }
		  }
		if( count == 0) {
			
			System.out.println("No doctor found of Specialization"+specialization);
		}
	}

	
	public void searchDoctorByAvailability(List<Doctor> doctorList) {
		
			System.out.println("Enter the timing in am or pm");
			String availability	=	utility.read_String();
		      for(Doctor doctor:doctorList) {
		    	  
		    	  if(doctor.getAvailability().equalsIgnoreCase(availability)) {
		    		  System.out.println(doctor.toString());
		    		  count++;
		    	  }
		      }	
		      
		      if(count == 0) {
		    	  System.out.println("doctor is not available at"+availability);
		      }
		}
}
