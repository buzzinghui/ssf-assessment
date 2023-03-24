package ibf2022.batch2.ssf.frontcontroller.controllers;

import java.net.http.HttpClient.Redirect;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ibf2022.batch2.ssf.frontcontroller.model.AuthResponse;
import ibf2022.batch2.ssf.frontcontroller.model.Login;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ibf2022.batch2.ssf.frontcontroller.services.AuthenticationService;


@Controller
public class FrontController {

	List<Login> logins = new ArrayList<>();
	Integer tooShort = 0;
	Boolean successful;

	// TODO: Task 2, Task 3, Task 4, Task 6
	@GetMapping({"/", "/view0"})
    public String getForm(Model model, @RequestParam(required = false) String username, @RequestParam(required = false) String password) {
		Login login;
		if (getUserIndex(username, password) == -1000){
			login = new Login();
		} else {
			login = logins.get(getUserIndex((username), password));
		}
		model.addAttribute("login", login);
		return "view0";
    }

	// @PostMapping("/login")
    // public String submitLoginForm(@Valid Login login, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) throws Exception {
	// 	boolean hasErrors = bindingResult.hasErrors();
	// 	if (hasErrors) {
	// 		model.addAttribute("login", login);
    //         return "view0";
    //     }
	// 	redirectAttributes.addFlashAttribute("login", login);
	// 	//successful = checkLogin(login);
	// 	return "redirect:/api/authenticate";
    // }

	// @RequestMapping("/api/authenticate")
	// public ModelAndView authenticate(Model model, @ModelAttribute("login") Login login) throws Exception {
	// 	AuthenticationService authen = new AuthenticationService();
	// 	authen.authenticate(login.getUsername(), login.getPassword());
	// 	login.setAuthenticated(true);
	// 	logins.add(login);
	// 	if (login.getAuthenticated()){
	// 		return new ModelAndView("redirect:/protected/view1");
	// 	} else {
	// 		model.addAttribute("unauthenticated", login);
	// 		return new ModelAndView("redirect:/");
	// 	}		
	// }

	@RequestMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.TEXT_HTML_VALUE, method=RequestMethod.POST)
    public String submitLoginForm(@Valid @ModelAttribute("login") Login login, BindingResult bindingResult, Model model) throws Exception {
		boolean hasErrors = bindingResult.hasErrors();
		if (hasErrors) {
			model.addAttribute("login", login);
			return "view0";
		} else {
			AuthenticationService authen = new AuthenticationService();
			ResponseEntity<AuthResponse> responseEntity = authen.authenticate(login);
			if (responseEntity != null) {
				HttpStatusCode statusCode = responseEntity.getStatusCode();
				if (statusCode.value() == 201) {
					login.setAuthenticated(true);
						logins.add(login);
					return "view1";
				} else if (statusCode.value() == 401 || statusCode.value() == 400) {
					return "view0";
				} else {
					return "view0";
				}
			} else {
				return "view0";
			}
		}
	}

	@GetMapping("/logout")
	public String submitLogout() {
		System.out.println("i'm out");
		return "redirect:/";
	}

	// @RequestMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.TEXT_HTML_VALUE, method=RequestMethod.POST)
    // public String verifyLogin(@Valid @ModelAttribute("login") Login login, BindingResult bindingResult, Model model) {
    //     // boolean hasErrors = bindingResult.hasErrors();
	// 	System.out.println(login);
    //     // if (hasErrors) {
    //     //     model.addAttribute("login", login);
    //     //     return "view0";
    //     // }
    //     return "view1";
    // }

	public Integer getUserIndex(String username, String password) {
		for (int i = 0; i < logins.size(); i++) {
			if (logins.get(i).getUsername().equals(username)) return i;
		}
		return -1000;
	}

	public Boolean checkLogin(Login login) {

		return successful;
	}
	
}
