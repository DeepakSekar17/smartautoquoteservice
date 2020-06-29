/**
 * 
 */
package com.insurance.auto.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author mrdee
 *
 */
@Entity(name="auto_quote")
public class Autoquote {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String referenceNumber;
	
	private String customerMailId;
	
	private String genderSelection;
	
	private String dateOfBirth;
	
	private String firstName;
	
	private String lastName;
	
	private String vin;
	
	private String modelYear;
	
	private String manufacturer;
	
	private String vehicleType;
	
	private String drivingLicense;
	
	private String finalQuoteAmount;
	
	private String expiryDate;
	
	private String factorsConsidered;
	
	private String originalQuoteAmount;
	
	private String discounts;
	
	private String make;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the referenceNumber
	 */
	public String getReferenceNumber() {
		return referenceNumber;
	}

	/**
	 * @param referenceNumber the referenceNumber to set
	 */
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	/**
	 * @return the customerMailId
	 */
	public String getCustomerMailId() {
		return customerMailId;
	}

	/**
	 * @param customerMailId the customerMailId to set
	 */
	public void setCustomerMailId(String customerMailId) {
		this.customerMailId = customerMailId;
	}

	/**
	 * @return the genderSelection
	 */
	public String getGenderSelection() {
		return genderSelection;
	}

	/**
	 * @param genderSelection the genderSelection to set
	 */
	public void setGenderSelection(String genderSelection) {
		this.genderSelection = genderSelection;
	}

	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the vin
	 */
	public String getVin() {
		return vin;
	}

	/**
	 * @param vin the vin to set
	 */
	public void setVin(String vin) {
		this.vin = vin;
	}

	/**
	 * @return the modelYear
	 */
	public String getModelYear() {
		return modelYear;
	}

	/**
	 * @param modelYear the modelYear to set
	 */
	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}

	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * @return the vehicleType
	 */
	public String getVehicleType() {
		return vehicleType;
	}

	/**
	 * @param vehicleType the vehicleType to set
	 */
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	/**
	 * @return the drivingLicense
	 */
	public String getDrivingLicense() {
		return drivingLicense;
	}

	/**
	 * @param drivingLicense the drivingLicense to set
	 */
	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

	/**
	 * @return the finalQuoteAmount
	 */
	public String getFinalQuoteAmount() {
		return finalQuoteAmount;
	}

	/**
	 * @param finalQuoteAmount the finalQuoteAmount to set
	 */
	public void setFinalQuoteAmount(String finalQuoteAmount) {
		this.finalQuoteAmount = finalQuoteAmount;
	}

	/**
	 * @return the expiryDate
	 */
	public String getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the factorsConsidered
	 */
	public String getFactorsConsidered() {
		return factorsConsidered;
	}

	/**
	 * @param factorsConsidered the factorsConsidered to set
	 */
	public void setFactorsConsidered(String factorsConsidered) {
		this.factorsConsidered = factorsConsidered;
	}

	/**
	 * @return the originalQuoteAmount
	 */
	public String getOriginalQuoteAmount() {
		return originalQuoteAmount;
	}

	/**
	 * @param originalQuoteAmount the originalQuoteAmount to set
	 */
	public void setOriginalQuoteAmount(String originalQuoteAmount) {
		this.originalQuoteAmount = originalQuoteAmount;
	}

	/**
	 * @return the discounts
	 */
	public String getDiscounts() {
		return discounts;
	}

	/**
	 * @param discounts the discounts to set
	 */
	public void setDiscounts(String discounts) {
		this.discounts = discounts;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}


}
