/**
 * 
 */
package com.insurance.auto.pojo;

import java.util.List;

/**
 * @author mrdee
 *
 */
public class ChatResponse {

	private List<String> messages;
	private String newMessage;
	private int id;
	private String referenceNumber;
	private String currentQuestion;
	private String chatResponse;

	/**
	 * @return the chatResponse
	 */
	public String getChatResponse() {
		return chatResponse;
	}

	/**
	 * @param chatResponse the chatResponse to set
	 */
	public void setChatResponse(String chatResponse) {
		this.chatResponse = chatResponse;
	}

	/**
	 * @return the messages
	 */
	public List<String> getMessages() {
		return messages;
	}

	/**
	 * @param messages the messages to set
	 */
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	/**
	 * @return the newMessage
	 */
	public String getNewMessage() {
		return newMessage;
	}

	/**
	 * @param newMessage the newMessage to set
	 */
	public void setNewMessage(String newMessage) {
		this.newMessage = newMessage;
	}

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
	 * @return the currentQuestion
	 */
	public String getCurrentQuestion() {
		return currentQuestion;
	}

	/**
	 * @param currentQuestion the currentQuestion to set
	 */
	public void setCurrentQuestion(String currentQuestion) {
		this.currentQuestion = currentQuestion;
	}
	
	
}
