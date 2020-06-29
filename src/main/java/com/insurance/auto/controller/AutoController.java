/**
 * Created By Deepak Sekar
 */
package com.insurance.auto.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.insurance.auto.chatBot.Chatbot;
import com.insurance.auto.entities.Autoquote;
import com.insurance.auto.pojo.ChatResponse;
import com.insurance.auto.pojo.QuoteInformation;
import com.insurance.auto.pojo.VinReponse;
import com.insurance.auto.repository.AutoquoteRepository;

/**
 * @author mrdee
 *
 */
@RestController 
@RequestMapping(path="/autoinsurance") 
@CrossOrigin(allowCredentials = "true",
origins = {"http://localhost:3000","http://galacticosinsurance.s3-website-us-west-2.amazonaws.com"}, 
allowedHeaders = "*")
public class AutoController {

	@Autowired
	AutoquoteRepository autoquoteRepository;
	
	@GetMapping("/getVin")
	public String getVin(@RequestParam(name = "vin") String vin) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://vpic.nhtsa.dot.gov/api/vehicles/decodevinvalues/";
		String response = restTemplate.getForObject(url + vin + "?format=json", String.class);
		Gson gson = new Gson();
		VinReponse vinresponse = gson.fromJson(response, VinReponse.class);
		return gson.toJson(vinresponse.getResults().get(0));
	}

	@RequestMapping("/autoquote/select/all")
	public List<Autoquote> selectAllHelloObjects() {
		List<Autoquote> quotes = (List<Autoquote>) autoquoteRepository.findAll();
		return quotes;
	}
	
	@RequestMapping("/autoquote/findByCustomerMailId")
	public QuoteInformation findByCustomerMailId(@RequestParam(name = "customerMailId") String customerMailId) {
		List<Autoquote> quotes = (List<Autoquote>) autoquoteRepository.findByCustomerMail(customerMailId);
		if(null != quotes && quotes.size()>0){
			return fillQuoteInformation(quotes.get(0));
		}
		return new QuoteInformation();
	}
	
	@RequestMapping("/autoquote/findByReference")
	public QuoteInformation findByReference(@RequestParam(name = "referenceNumber") String referenceNumber) {
		List<Autoquote> quotes = (List<Autoquote>) autoquoteRepository.findByReferenceNumber(referenceNumber);
		if(null != quotes && quotes.size()>0){
			return fillQuoteInformation(quotes.get(0));
		}
		return new QuoteInformation();
	}
	
	@PostMapping("/autoquote/insert")
	public QuoteInformation insertQuote(@RequestBody QuoteInformation quoteInformation){
		Autoquote autoquotes = new Autoquote();
		
		if(null != quoteInformation && null != quoteInformation.getId() && quoteInformation.getId().trim().length()>0){
			autoquotes.setId(Integer.parseInt(quoteInformation.getId()));
		}
		autoquotes.setCustomerMailId(quoteInformation.getCustomerMailId());
		autoquotes.setDateOfBirth(quoteInformation.getDateOfBirth());
		autoquotes.setDrivingLicense(quoteInformation.getDrivingLicense());
		autoquotes.setFirstName(quoteInformation.getFirstName());
		autoquotes.setGenderSelection(quoteInformation.getGenderSelection());
		autoquotes.setLastName(quoteInformation.getLastName());
		autoquotes.setManufacturer(quoteInformation.getManufacturer());
		autoquotes.setMake(quoteInformation.getMake());
		autoquotes.setModelYear(quoteInformation.getModelYear());
		autoquotes.setVehicleType(quoteInformation.getVehicleType());
		autoquotes.setVin(quoteInformation.getVin());
	    if(null != quoteInformation && null != quoteInformation.getReferenceNumber()&&quoteInformation.getReferenceNumber().trim().length()>0){
	    	autoquotes.setReferenceNumber(quoteInformation.getReferenceNumber());
	    }else{
	    	SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmssSSS");
			Date now = new Date();
		    String strDate = dateFormat.format(now);
	    	autoquotes.setReferenceNumber("GAI"+strDate);	
	    }
	    if(null != quoteInformation && null != quoteInformation.getDrivingLicense() && quoteInformation.getDrivingLicense().length()>0){
	    	String finalQuoteAmount;
	    	String expiryDate;
	    	String factorsConsidered;
	    	String originalQuoteAmount;
	    	String discounts;
	    	
	    	switch (quoteInformation.getDrivingLicense()) {
			case "A1234":
				originalQuoteAmount="$1250/Yearly";
				finalQuoteAmount = "$950/Yearly";
				expiryDate = "31Dec2021";
				factorsConsidered= "No Accidents;No Traffic Violations";
				discounts = "5%";
				break;
			case "B1234":
				originalQuoteAmount="$960/Yearly";
				finalQuoteAmount = "$910/Yearly";
				expiryDate = "31Dec2021";
				factorsConsidered= "No Accidents;No Traffic Violations;New Driver";
				discounts = "2%";
				break;
			case "C1234":
				originalQuoteAmount="$1550/Yearly";
				finalQuoteAmount = "$1450/Yearly";
				expiryDate = "31Dec2021";
				factorsConsidered= "New Customer Discount; Two Traffic violations";
				discounts = "1%";
				break;
			case "D1234":
				originalQuoteAmount="$850/Yearly";
				finalQuoteAmount = "$450/Yearly";
				expiryDate = "31Dec2021";
				factorsConsidered= "No Accidents;No Traffic Violations; Long driving history";
				discounts = "15%";
				break;
			case "E1234":
				originalQuoteAmount="$1250/Yearly";
				finalQuoteAmount = "$950/Yearly";
				expiryDate = "31Dec2021";
				factorsConsidered= "New customer; No Accidents;No Traffic Violations";
				discounts = "5%";
				break;
			default:
				originalQuoteAmount="$1250/Yearly";
				finalQuoteAmount = "$950/Yearly";
				expiryDate = "31Dec2021";
				factorsConsidered= "No Accidents;No Traffic Violations;Standard Discount";
				discounts = "5%";
				break;
			}
	    	autoquotes.setDiscounts(discounts);
	    	autoquotes.setFactorsConsidered(factorsConsidered);
	    	autoquotes.setFinalQuoteAmount(finalQuoteAmount);
	    	autoquotes.setOriginalQuoteAmount(originalQuoteAmount);
	    	autoquotes.setExpiryDate(expiryDate);
	    	quoteInformation.setDiscounts(discounts);
	    	quoteInformation.setFactorsConsidered(factorsConsidered);
	    	quoteInformation.setFinalQuoteAmount(finalQuoteAmount);
	    	quoteInformation.setOriginalQuoteAmount(originalQuoteAmount);
	    	quoteInformation.setExpiryDate(expiryDate);
	    }
	    Autoquote autoQuote = autoquoteRepository.saveAndFlush(autoquotes);
	    if(null !=autoQuote && autoQuote.getId()>0){
	    	if(!(null != quoteInformation && null != quoteInformation.getId() && quoteInformation.getId().trim().length()>0)){
	    		quoteInformation.setId(String.valueOf(autoQuote.getId()));
	    		quoteInformation.setReferenceNumber(autoQuote.getReferenceNumber());
	    		quoteInformation.setQuoteSaveMessage("Quote Information Auto Saved!");
	    	}else{
	    		quoteInformation.setQuoteSaveMessage("Quote Information Successfully Updated!");
	    	}
	    }
		return quoteInformation;
	}

	private QuoteInformation fillQuoteInformation(Autoquote autoQuote){
		QuoteInformation quoteInformation = new QuoteInformation();
		quoteInformation.setCustomerMailId(autoQuote.getCustomerMailId());
		quoteInformation.setDateOfBirth(autoQuote.getDateOfBirth());
		quoteInformation.setDrivingLicense(autoQuote.getDrivingLicense());
		quoteInformation.setFirstName(autoQuote.getFirstName());
		quoteInformation.setGenderSelection(autoQuote.getGenderSelection());
		quoteInformation.setId(String.valueOf(autoQuote.getId()));
		quoteInformation.setLastName(autoQuote.getLastName());
		quoteInformation.setMake(autoQuote.getMake());
		quoteInformation.setManufacturer(autoQuote.getManufacturer());
		quoteInformation.setModelYear(autoQuote.getModelYear());
		quoteInformation.setReferenceNumber(autoQuote.getReferenceNumber());
		quoteInformation.setVehicleType(autoQuote.getVehicleType());
		quoteInformation.setVin(autoQuote.getVin());
		quoteInformation.setExpiryDate(autoQuote.getExpiryDate());
		quoteInformation.setFactorsConsidered(autoQuote.getFactorsConsidered());
		quoteInformation.setDiscounts(autoQuote.getDiscounts());
		quoteInformation.setOriginalQuoteAmount(autoQuote.getOriginalQuoteAmount());
		quoteInformation.setFinalQuoteAmount(autoQuote.getFinalQuoteAmount());
		return quoteInformation;
	}
	@GetMapping("/getChatInfo")
	public ChatResponse getChatInfo(@RequestParam(name = "chatStr") String chatStr) {
		String response = Chatbot.Chat(chatStr);
		ChatResponse chatResponse = new ChatResponse();
		chatResponse.setChatResponse(response);
		return chatResponse;
	}
}
