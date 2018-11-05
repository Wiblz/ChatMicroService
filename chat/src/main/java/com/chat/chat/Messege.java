package com.chat.chat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Messege {
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Long id;
	    
	    private Long serviceId;
		private Long customerId;
	    
	    private LocalDateTime time;
	    
	    /*if true - sent from service provider
	     *if false - sent from customer */
	    private Boolean fromServiceProvider;
	    
	    private String messegeBody;
	    
	    Messege(){}
	    
	    Messege(Long serviceId, Long customerId, String messegeBody, Boolean fromServiceProvider){
	    	this.serviceId = serviceId;
	    	this.customerId = customerId;
	    	this.setMessegeBody(messegeBody);
	    	this.setTime(LocalDateTime.now());
	    	this.fromServiceProvider = fromServiceProvider;
	    }

		public Boolean getFromServiceProvider() {
			return fromServiceProvider;
		}

		public void setFromServiceProvider(Boolean fromServiceProvider) {
			this.fromServiceProvider = fromServiceProvider;
		}

		public String getMessegeBody() {
			return messegeBody;
		}

		public void setMessegeBody(String messegeBody) {
			this.messegeBody = messegeBody;
		}

		public LocalDateTime getTime() {
			return time;
		}

		public void setTime(LocalDateTime time) {
			this.time = time;
		}
		
		public Long getId(){
			return id;
		}
		
		public Long getServiceId() {
			return serviceId;
		}
		public void setServiceId(Long serviceId) {
			this.serviceId = serviceId;
		}
		public Long getCustomerId() {
			return customerId;
		}
		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}
}
