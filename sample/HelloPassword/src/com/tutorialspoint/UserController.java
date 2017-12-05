package com.tutorialspoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.User;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.function.Predicate;

@Controller
public class UserController {
	@Autowired
	@Qualifier("userValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView user() {
		User user = new User();	
		user.setFavoriteFrameworks((new String [] {"Spring MVC"}));
		user.setGender("M");
		//populate value on user
		return new ModelAndView("user", "command", user ); 
	}
	
	@ModelAttribute("user")
	public User createUserModel(){
		return new User();
	}
	
	
	@RequestMapping(value = "/infoDisplay", method = RequestMethod.POST)
	public String setPassword(@ModelAttribute("user") @Validated User user, BindingResult bindingResult, ModelMap model) {
		/*List<String> list = Arrays.asList(user.getUsername(),user.getPassword(),user.getAddress());
		Boolean isEmpty = checkVal(list, n-> n.equals(null)||n.equals(""));
		if(isEmpty) {
			//Redirect to error method
			return "redirect:errorPage";
		}*/
		if(bindingResult.hasErrors()) {
			return "user";
		}
		model.addAttribute("username", user.getUsername());
		model.addAttribute("password", user.getPassword());
		model.addAttribute("address", user.getAddress());
		model.addAttribute("receivePaper", user.isReceivePaper());
		model.addAttribute("favoriteFrameworks", user.getFavoriteFrameworks());
		model.addAttribute("gender", user.getGender());
		model.addAttribute("paymentType", user.getPaymentType());
		model.addAttribute("country", user.getCountry());
		//Redirect to users.jsp
		return "users";
	}
	
	@RequestMapping(value = "/errorPage", method = RequestMethod.GET)
	public String errorPage() {
		//go to error.jsp
		return "error";
	}
	
	@ModelAttribute("webFrameworkList")
	public List<String> getWebFrameworkList(){
		List<String> webFrameworkList = new ArrayList<String>();
		webFrameworkList.add("Spring MVC");
		webFrameworkList.add("Microsoft.Net MVC");
		webFrameworkList.add("AngularJs");
		webFrameworkList.add("Struts");
		return webFrameworkList;
	}
	
	@ModelAttribute("paymentTypeList")
	public List<String> getPaymentList(){
		List<String> paymentTypeList = new ArrayList<String>();
		paymentTypeList.add("Cash On Delivery");
		paymentTypeList.add("Convinience Store");
		paymentTypeList.add("Credit Card");
		paymentTypeList.add("Paypal");
		return paymentTypeList;
	}
	
	@ModelAttribute("countryList")
	public Map<String, String> getCountryList(){
		Map<String, String> countryList = new HashMap<String, String>();
		countryList.put("PHL","Philippines");
		countryList.put("JA","Japan");
		countryList.put("US","United States");
		countryList.put("SG","Singapore");
		countryList.put("CH","China");
		return countryList;
	}
	
	
	//Check for null value
/*	public Boolean checkVal(List<String> list, Predicate<String> predicate) {
		for(String n: list) {	
			if(predicate.test(n) ) {
				return true;
			}
		}	
		return false;
	}*/
}
