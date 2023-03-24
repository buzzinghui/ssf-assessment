package ibf2022.batch2.ssf.frontcontroller.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ibf2022.batch2.ssf.frontcontroller.model.Login;
import jakarta.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ibf2022.batch2.ssf.frontcontroller.services.AuthenticationService;

@Controller
public class ProtectedController {

	// TODO Task 5
	// Write a controller to protect resources rooted under /protected
	@GetMapping("/protected/view1")
	public String displayView1() {
		return "view1";
	}
}
