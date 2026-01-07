package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.config.AirportConfig;
import com.example.demo.entity.Aadhaar;
import com.example.demo.entity.Address;
import com.example.demo.entity.College;
import com.example.demo.entity.Company;
import com.example.demo.entity.Course;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Orders;
import com.example.demo.entity.Person;
import com.example.demo.entity.Recharge;
import com.example.demo.entity.Student;
import com.example.demo.entity.Student5;
import com.example.demo.error.CustomerNotFoundException;
import com.example.demo.error.InvalidFRecharge;
import com.example.demo.repository.AadhaarRepository;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.CollegeRepository;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrdersRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.RechargeRepository;
import com.example.demo.repository.Student5Repository;
import com.example.demo.repository.StudentRepository;

@Service
public class DemoService {

    private final AirportConfig airportConfig;
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	AadhaarRepository aadhaarRepository;
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrdersRepository ordersRepository;
	
	@Autowired
	Student5Repository student5Repository;
	
	@Autowired
	CollegeRepository collegeRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	RechargeRepository rechargeRepository;

    DemoService(AirportConfig airportConfig) {
        this.airportConfig = airportConfig;
    }
	
	// Method to save person
	public void savePerson(Person p) {
		System.out.println("Saving Person....");
		Person per = new Person();
		Aadhaar aadhaar = new Aadhaar();
		aadhaar.setAadhaarNo(p.getAadhaar().getAadhaarNo());
		aadhaar.setAadhaarName(p.getAadhaar().getAadhaarName());
		aadhaar.setDob(p.getAadhaar().getDob());
		aadhaar.setGender(p.getAadhaar().getGender());
		aadhaar.setCreatedDate(new Date());
		// Save Aadhaar
		aadhaarRepository.save(aadhaar);
		per.setPersonname(p.getPersonname());
		per.setEmail(p.getEmail());
		per.setMobile(p.getMobile());
		per.setAddress(p.getAddress());
		per.setAadhaar(aadhaar);
		per.setCreatedDate(new Date());
		personRepository.save(per);
		System.out.println("Person Info Saved Successfully....");
	}

	// Method to save company address
	public Company saveCompanyAddress(Company comp) {
		System.out.println("Saving Company Address....");
		Address address = new Address();
		Company company = new Company();
		address.setFullAddress(comp.getAddress().getFullAddress());
		address.setCity(comp.getAddress().getCity());
		address.setPincode(comp.getAddress().getPincode());
		address.setCreatedDate(new Date());
		// Save Address
		addressRepository.save(address);
		company.setCompanyName(comp.getCompanyName());
		company.setType(comp.getType());
		company.setOwner(comp.getOwner());
		company.setAddress(address);
		company.setCreatedDate(new Date());
		// Save Company
		companyRepository.save(company);
		System.out.println("Successfully Saved Company Address....");
		return company;
	}
	
	// Method to save orders  details
	public String saveOrdersDetails() {
		System.out.println("Saving Orders....");
		Customer customer1 = new Customer();
	//	Customer customer2 = new Customer();
		Orders orders1 = new Orders();
		Orders orders2 = new Orders();
	//	List<Customer> listCust = new ArrayList<>();
		List<Customer> listOrders = new ArrayList<>();
	//	customer.setCustomerName(ord.getCustomer().getCustomerName());
		//customer.setEmail(ord.getCustomer().getEmail());
	//	customer.setMobile(ord.getCustomer().getMobile());
	//	customer.setPref(ord.getCustomer().getPref());
	//	customer.setCreatedDate(new Date());
		customer1.setCustomerName("Yogesh");
		customer1.setEmail("yogesh_1988@gmail.com");
		customer1.setMobile("7878654410");
		customer1.setPref("Books, Perfumes");
		customer1.setCreatedDate(new Date());
		// Save Customer 1
		customerRepository.save(customer1);
		orders1.setOrderName("Perfumes, Doe, Hair Colorer");
		orders1.setDeliveryDate("02-Nov-2025");
		orders1.setCustomer(customer1);
		orders1.setCreatedDate(new Date()); 
		ordersRepository.save(orders1);
		orders2.setOrderName("Horror Books, Jeans, Pepsi");
		orders2.setDeliveryDate("05-Nov-2025");
		orders2.setCustomer(customer1);
		orders2.setCreatedDate(new Date());
		ordersRepository.save(orders2);
		/*customer2.setCustomerName("Ajay");
		customer2.setEmail("ajaydev@yahoo.com");
		customer2.setMobile("9086543219");
		customer2.setPref("Books, Groceries");
		customer2.setCreatedDate(new Date());
		// Save Customer 2
		customerRepository.save(customer2); 
		orders.setOrderName(ord.getOrderName());
		orders.setDeliveryDate(ord.getDeliveryDate());
		orders.setCreatedDate(new Date());
		listCust.add(customer1);
		listCust.add(customer2);
		orders.setCustomer(listCust);
		// Save Orders
		ordersRepository.save(orders);*/
		System.out.println("Orders Details Saved Successfully....!!!");
		return "Orders Details Saved Successfully....";
	}
	
	// Method to save student details
	public List<Student5> saveStudentDetails(Student5 stu) {
		System.out.println("Saving Student Details....!!!");
		College college = new College();
		Student5 student1 = new Student5();
		Student5 student2 = new Student5();
		List<Student5> listStudent = new ArrayList<>();
		college.setCollegeName("Pooja Medical College & Research Center");
		college.setCollegeType("Medical");
		college.setAddress("Plot No. 555, Vikas Nagar, M G Road, Delhi - 201915");
		college.setCreatedDate(new Date());
		/*System.out.println("college name====" + stu.getCollege().getCollegeName());
		college.setCollegeName(stu.getCollege().getCollegeName());
		college.setCollegeType(stu.getCollege().getCollegeType());
		college.setAddress(stu.getCollege().getAddress());
		college.setCreatedDate(new Date());*/
		collegeRepository.save(college);
		/*student1.setRollNo(stu.getRollNo());
		student1.setStudentName(stu.getStudentName());
		student1.setSubject(stu.getSubject());
		student1.setSemester(stu.getSemester());
		student1.setCollege(college);
		student1.setCreatedDate(new Date()); */
		student1.setRollNo((long) 8080807);
		student1.setStudentName("Hemant");
		student1.setSubject("Emergency Medicine");
		student1.setSemester(2);
		student1.setCollege(college);
		student1.setCreatedDate(new Date());
		student5Repository.save(student1);
		student2.setRollNo((long) 75754);
		student2.setStudentName("Vishal");
		student2.setSubject("Radiology");
		student2.setSemester(3);
		student2.setCollege(college);
		student2.setCreatedDate(new Date());
		student5Repository.save(student2);
		/*student2.setRollNo(stu.getRollNo());
		student2.setStudentName(stu.getStudentName());
		student2.setSubject(stu.getSubject());
		student2.setSemester(stu.getSemester());
		student2.setCollege(college);
		student2.setCreatedDate(new Date());*/
		//student5Repository.save(student2);
		listStudent.add(student1);
		listStudent.add(student2);
		System.out.println("Successfully Saved Student Details....!!!");
		return listStudent;
	}
	
	// method to save student course details
	public String saveStudentCourseDetls() {
		System.out.println("Saving Student - Course Details....");
		Course course1 = new Course();
		Course course2 = new Course();
		Student student = new Student();
		Set<Course> setCourses = new HashSet<>();
		course1.setCourseName("MCA");
		course1.setSubjects("Java, OS, DB, Compiler Design, Microservices");
		course1.setDuration(3);
		course1.setCreatedDate(new Date());
		course2.setCourseName("B.Pharma");
		course2.setSubjects("Drug Design, Drug Testing, Quality Control, API Creation");
		course2.setDuration(2);
		course2.setCreatedDate(new Date());
		courseRepository.save(course1);
		courseRepository.save(course2);
		setCourses.add(course1);
		setCourses.add(course2);
		student.setStudentName("Bunty");
		student.setHobbies("Travelling, Reading, Listening Music");
		student.setCourses(setCourses);
		student.setCreatedDate(new Date());
		studentRepository.save(student);
		System.out.println("Done Saved Student - Course Details....");
		return "Student - Course Saved Successfully...!!!";
	}
	
	// method to get customer name
	public Customer retreiveCustomerName(String name) throws CustomerNotFoundException  {
		System.out.println("Getting Customer...." + name);
		Customer c1 = new Customer();
		c1 = customerRepository.findByCustomerName(name);
		// check whether customer is null, if yes throws exception
		if(c1 == null) {
			    throw new CustomerNotFoundException("Customer Not Found....." + name);
		}
		return c1;
		
	}
	
	// Method to save recharge details
	public Recharge saveRecharge(Recharge rec) {
		System.out.println("Saving Recharge Info....");
		long transId = 0;
		LocalDate rechargeDate = LocalDate.now();
		LocalDate createDate = LocalDate.now();
		LocalDate futureRechargeDate = null;
		Random random = new Random();
		Recharge recharge = new Recharge();
		recharge.setCustName(rec.getCustName());
		recharge.setEmail(rec.getEmail());
		recharge.setMobile(rec.getMobile());
		recharge.setOperator(rec.getOperator());
		recharge.setAmount(rec.getAmount());
		recharge.setRechargeDate(rechargeDate);
		recharge.setNoDays(rec.getNoDays());
		// Calculate vadility
		futureRechargeDate = rechargeDate.plusDays(rec.getNoDays());
		recharge.setRechargeValidDate(futureRechargeDate);
		recharge.setCreateDate(createDate);
		recharge.setRemarks(rec.getRemarks());
		// Transaction ID
		transId = random.nextLong();
		recharge.setTransactionId(transId);
		rechargeRepository.save(recharge);
		System.out.println("Recharge Info Saved Successfully....");
		return recharge;
	}
	
	// method to get details of customer by operator
	public List<Recharge> getCustDetails(String opr) {
		System.out.println("Operator...." + opr);
		List<Recharge> listRecharge = new ArrayList<>();
		listRecharge = rechargeRepository.findByOperator(opr);
		return listRecharge;
	}
	
	// method to get detaild by id
	public Recharge getDetailsById(long id) throws InvalidFRecharge {
		Recharge recharge = null;
		Optional<Recharge> opt = rechargeRepository.findById(id);
		if(opt.isPresent()) {
			recharge = opt.get();
			return recharge;
		} else {
		//	throw new NullPointerException("ID Not Found..." + id);
			throw new InvalidFRecharge("Invalid Recharge ID-----" + id); 
		}
	}
	
	
}
