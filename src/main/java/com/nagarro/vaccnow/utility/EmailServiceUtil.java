package com.nagarro.vaccnow.utility;

import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.nagarro.vaccnow.entity.ScheduleTimeslot;

public class EmailServiceUtil {
	
	public static void sendScheduleMail(ScheduleTimeslot scheduleTimeslot) {
		// Recipient's email ID needs to be mentioned.
		String to = scheduleTimeslot.getEmail();
		// Sender's email ID needs to be mentioned
		String from = String.format("vaccineTeam.%s@vaccnow.eg", scheduleTimeslot.getBranch().getBranchName());
		SimpleDateFormat sdf = new SimpleDateFormat(GlobalConstants.YYYY_MM_DD_HH_MM);


		Properties properties = System.getProperties();

		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.defaultEncoding", "UTF-8");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.required", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.setProperty("mail.smtp.socketFactory.fallback", "false");
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.smtp.socketFactory.port", "465");

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("Congratulations, Your Vaccination is scheduled!");

			// Now set the actual message

			message.setText(String.format("\n\n\n"
					+ "Hello "+scheduleTimeslot.getEmail()+","
					+ "\nYou have scheduled appointment for " + scheduleTimeslot.getVaccine().getVaccineName()
					+ " at " + scheduleTimeslot.getBranch().getBranchName()
					+ " - " + sdf.format(scheduleTimeslot.getSlotDate())
					+ ".\n\n\n"));

			// Send message
			Transport.send(message, "<google_mail_id>", "<google_mail_password>");
		} catch (Exception mex) {
			mex.printStackTrace();
		}
	}

}
