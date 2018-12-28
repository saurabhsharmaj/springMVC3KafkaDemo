package com.sample.appops.model.value;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="EmailMessage")
public class EmailVO  implements Serializable{
	
private static final long serialVersionUID = 1L;
 
	private String fromAddress;
	private String replyToAddress;
	private String toAddress;
	private String ccAddress;
	private String contentOfEmail;
	private String subjectOfEmail;
	private String contentTypeOfEmail;
	private EmailAttachmentVO attachment;
	private String disclaimer;
	private Boolean sentAsInlineImg;

	public String getDisclaimer() {
		return disclaimer;
	}
	@XmlElement(name="Disclaimer")
	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}


	private String bcc;
	private  String bodyoftheEmail;
	
	
	public String getFromAddress() {
		return fromAddress;
	}
	@XmlElement(name="FromAddress")
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	public String getReplyToAddress() {
		return replyToAddress;
	}
	@XmlElement(name="ReplyToAddress")
	public void setReplyToAddress(String replyToAddress) {
		this.replyToAddress = replyToAddress;
	}
	public String getToAddress() {
		return toAddress;
	}
	@XmlElement(name="ToAddress")
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}
	public String getCcAddress() {
		return ccAddress;
	}
	@XmlElement(name="CCAddress")
	public void setCcAddress(String ccAddress) {
		this.ccAddress = ccAddress;
	}
	public String getContentOfEmail() {
		return contentOfEmail;
	}
	@XmlElement(name="ContentOfEmail")
	public void setContentOfEmail(String contentOfEmail) {
		this.contentOfEmail = contentOfEmail;
	}
	public String getSubjectOfEmail() {
		return subjectOfEmail;
	}
	@XmlElement(name="SubjectOfEmail")
	public void setSubjectOfEmail(String subjectOfEmail) {
		this.subjectOfEmail = subjectOfEmail;
	}
	public String getContentTypeOfEmail() {
		return contentTypeOfEmail;
	}
	@XmlElement(name="ContentTypeOfEmail")
	public void setContentTypeOfEmail(String contentTypeOfEmail) {
		this.contentTypeOfEmail = contentTypeOfEmail;
	}
		
	
	public EmailAttachmentVO getAttachment() {
		return attachment;
	}
	public void setAttachment(EmailAttachmentVO attachment) {
		this.attachment = attachment;
	}
	
	public String getBCC() {
		return bcc;
	}
	@XmlElement(name="BCC")
	public void setBCC(String bCC) {
		bcc = bCC;
	}
	public String getBodyoftheEmail() {
		return bodyoftheEmail;
	}
	@XmlElement(name="BodyoftheEmail")
	public void setBodyoftheEmail(String bodyoftheEmail) {
		this.bodyoftheEmail = bodyoftheEmail;
	}
	
	
	public Boolean isSentAsInlineImg() {
		return sentAsInlineImg;
	}
	@XmlElement(name="SentAsInlineImg")
	public void setSentAsInlineImg(Boolean sentAsInlineImg) {
		this.sentAsInlineImg = sentAsInlineImg;
	}

public String toXML() {
	
		StringBuilder emailString = new StringBuilder();
		emailString.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
		emailString.append("<ns1:EmailNotification xmlns:ns1 = \"http://www.equinix.com/gse/integration/schema/qos/notification/email/v1_0\">");
		if (this.getFromAddress() != null){
		 emailString.append("<ns1:From>");
		 emailString.append(this.getFromAddress());
		 emailString.append("</ns1:From>");
		}
		if (this.getToAddress() != null){
		 emailString.append("<ns1:To>");
		 emailString.append(this.getToAddress());
		 emailString.append("</ns1:To>");
		}
		if (this.getCcAddress() != null){
		 emailString.append("<ns1:CC>");
		 emailString.append(this.getCcAddress());
		 emailString.append("</ns1:CC>");
		}
		if (this.getBCC() != null){
		 emailString.append("<ns1:BCC>");
		 emailString.append(this.getBCC());
		 emailString.append("</ns1:BCC>");
		}
		
		if (this.getReplyToAddress() != null){		
		 emailString.append("<ns1:ReplyTo>");
		 emailString.append(this.getReplyToAddress());
		 emailString.append("</ns1:ReplyTo>");
		}
		if (this.getSubjectOfEmail() != null){	
		 emailString.append("<ns1:Subject>");
		 emailString.append(this.getSubjectOfEmail());
		 emailString.append("</ns1:Subject>");
		}
		if (this.getBodyoftheEmail() != null){	
		 emailString.append("<ns1:Body>");
		 emailString.append(this.getBodyoftheEmail());
		 emailString.append("</ns1:Body>");
		}
		if (this.getContentOfEmail() != null){	
		 emailString.append("<ns1:ContentType>");
		 emailString.append(this.getContentOfEmail());
		 emailString.append("</ns1:ContentType>");
		}
		if(this.attachment != null){
		emailString.append(this.attachment.toXML());
		}
		
		if (this.isSentAsInlineImg() != null){	
			emailString.append("<ns1:ContentType>");
			emailString.append(this.isSentAsInlineImg());
			emailString.append("</ns1:ContentType>");
		}
		emailString.append("</ns1:EmailNotification>");
		
		
		
		
		return  emailString.toString();
	}
@Override
public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailVO [fromAddress=");
		builder.append(fromAddress);
		builder.append(", replyToAddress=");
		builder.append(replyToAddress);
		builder.append(", toAddress=");
		builder.append(toAddress);
		builder.append(", ccAddress=");
		builder.append(ccAddress);
		builder.append(", contentOfEmail=");
		builder.append(contentOfEmail);
		builder.append(", subjectOfEmail=");
		builder.append(subjectOfEmail);
		builder.append(", contentTypeOfEmail=");
		builder.append(contentTypeOfEmail);
		builder.append(", attachment=");
		builder.append(attachment);
		builder.append(", disclaimer=");
		builder.append(disclaimer);
		builder.append(", sentAsInlineImg=");
		builder.append(sentAsInlineImg);
		builder.append(", bcc=");
		builder.append(bcc);
		builder.append(", bodyoftheEmail=");
		builder.append(bodyoftheEmail);
		builder.append("]");
		return builder.toString();
}
	
	
	

	}
