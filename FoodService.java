package com.pooja.dev.service;

import java.io.File;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.pooja.dev.dto.FoodRequestDTO;
import com.pooja.dev.entity.Food;
import com.pooja.dev.entity.FoodMail;
import com.pooja.dev.repository.FoodMailRepository;
import com.pooja.dev.repository.FoodRepository;

import jakarta.mail.internet.MimeMessage;

@Service
public class FoodService {
	
	@Autowired
	private FoodRepository foodRepository;
	
	@Autowired
	private FoodMailRepository foodMailRepository;
	
	@Autowired
	private JavaMailSender mailSender;
	
	// Getting value from properties
	@Value("${image.path}")
	private String imagePath;
	
	@Value("${app.bev}")
	private List<String> listBev;
	
	// method to update food
	@Transactional(timeout = 500, rollbackFor = Exception.class)
	public Food updateFood(FoodRequestDTO foodDTO) {
		System.out.println("Starting Transaction.....");
		System.out.println("Updating Food.......");
		Food food = null;
		// Updated Date
		LocalDate updateDate = LocalDate.now();
		try {
			Optional<Food> optFood = foodRepository.findById(foodDTO.getFoodId());
			while(optFood.isPresent()) {
				food = optFood.get();
				food.setFoodName(foodDTO.getFoodName());
				food.setPrice(foodDTO.getPrice());
				food.setFoodType(foodDTO.getFoodType());	
				food.setUpdatedDate(updateDate); 
				foodRepository.save(food);
				System.out.println("Food Updated Successfully...!!!!");
				return food;
				}
			System.out.println("Transaction Stopped......");
		} catch(Exception ie) {
				System.out.println("Error while processing transaction....");
				ie.printStackTrace();
		}
		return null;
	}
	// Method to send mail & save mail details in DB
	public String sendMail(FoodMail fm) {
		String msg = "";
		try {
			System.out.println("Sending Mail....");
			SimpleMailMessage mail = new SimpleMailMessage();
			mail.setFrom(fm.getFromMail());
			mail.setTo(fm.getToMail());
			mail.setSubject(fm.getSubject());
			mail.setText(fm.getBody());
			mail.setSentDate(new Date());
			mailSender.send(mail); 
			// Saving Mail Details in DB
			saveMailDetls(fm, null);
			msg = "Mail Send Successfully...!!";
			System.out.println(msg);
			return msg;
		} catch(Exception ex) {
			 System.out.println("Error while sending mail.....");
			 ex.printStackTrace();
		}
		return null;
	}
	// Method to save mail details in DB
	public void saveMailDetls(FoodMail fm, String path) {
		try {
			System.out.println("Saving Mail Details....");
			FoodMail mailDB = new FoodMail();
			mailDB.setFromMail(fm.getFromMail());
			mailDB.setToMail(fm.getToMail());
			mailDB.setSubject(fm.getSubject());
			mailDB.setBody(fm.getBody());
			mailDB.setSendDate(new Date()); 
			if(path == null) {
				mailDB.setAttachmentFile("No Attachment");
			} else {
				mailDB.setAttachmentFile(path);
			}
			foodMailRepository.save(mailDB);
			System.out.println("Mail Details Saved Successfully....");
		} catch(Exception ex1) {
			System.out.println("Error while saving mail details.....");
			ex1.printStackTrace();
		}
	}
	// method to send mail with attachment and save details in DB
	public String sendMailWithAttachment(FoodMail fm) {
			//String fileImg = "C:\\Users\\AMIT SONI\\Videos\\Vanshree_Docs\\food_img.jpg";
			String message = "";
		try {
			System.out.println("Sending Mail With Attachments....");
			// MimeMessage
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true);
			File f = new File(imagePath);
			msg.setFrom(fm.getFromMail());
			msg.setTo(fm.getToMail());
			msg.setSubject(fm.getSubject());
			msg.setText(fm.getBody());
			// Takes value from properties
			/*listBev.forEach(res -> {
				   try {
					   msg.setText(res);
					   System.out.println(res);
				   } catch(Exception ex3) {
					   ex3.printStackTrace();
				   }
			}); */
			msg.setSentDate(new Date());
			msg.addAttachment(imagePath, f); 
			mailSender.send(mimeMessage);
			// Test List with value
			listBev.forEach(res -> {
				System.out.print(res + ",");
			});
			System.out.println();
			// Save details in DB
			saveMailDetls(fm, imagePath);
			message = "Mail Send Successfully With Attachments...";
			System.out.println(message);
			return message;
		} catch(Exception ex) {
			System.out.println("Error while sending mail with attachments...");
			ex.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
