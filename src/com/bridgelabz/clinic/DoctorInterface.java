package com.bridgelabz.clinic;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.bridgelabz.clinicManagement.Doctor;

public interface DoctorInterface {
	public List<Doctor> addDoctorToList(List<Doctor> doctorList);
	public List<Doctor> readDoctorFile();
	public void writeFile(List<Doctor> doctorList) throws JsonGenerationException, JsonMappingException, IOException;
	public void searchDocotByName(List<Doctor> doctorList);
	public void searchDoctorById(List<Doctor> doctorList);
	public void searchDoctorBySpecialization(List<Doctor> doctorList);
}
