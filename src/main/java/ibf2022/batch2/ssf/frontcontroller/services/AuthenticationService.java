package ibf2022.batch2.ssf.frontcontroller.services;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import ibf2022.batch2.ssf.frontcontroller.controllers.FrontController;
import ibf2022.batch2.ssf.frontcontroller.model.AuthResponse;
import ibf2022.batch2.ssf.frontcontroller.model.Login;

public class AuthenticationService {

	// private Logger logger = Logger.getLogger(FrontController.class.getName());
	// // TODO: Task 2
	// // DO NOT CHANGE THE METHOD'S SIGNATURE
	// // Write the authentication method in here
	// public void authenticate(String username, String password) throws Exception {
	// 	RestTemplate restTemplate = new RestTemplate();
		
	// 	HttpHeaders headers = new HttpHeaders();
    //     headers.setContentType(MediaType.APPLICATION_JSON);

	// 	String requestBody = "{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}";

	// 	HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

	// 	String authEndpoint = "https://auth.chuklee.com/api/authenticate";
	// 	logger.info("POST /api/authenticate : %s".formatted(username.toString()));
    //     //ResponseEntity<String> response = restTemplate.postForEntity(authEndpoint, entity, String.class);
		
	// 	//System.out.print(response.getStatusCode());
		
	// }
	private final static String AUTH_END_POINT = "https://auth.chuklee.com/api/authenticate";

	public ResponseEntity<AuthResponse> authenticate(Login login) throws Exception {

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<?> entity = new HttpEntity(login, generateHttpHeaders());
		try {
			ResponseEntity<AuthResponse> responseEntity = restTemplate.postForEntity(AUTH_END_POINT,
					entity, AuthResponse.class);
			return responseEntity;
		} catch (Exception e) {
			return null;
		}
	}

	private HttpHeaders generateHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(List.of(MediaType.APPLICATION_JSON));
		return headers;
	}
	// TODO: Task 3
	// DO NOT CHANGE THE METHOD'S SIGNATURE
	// Write an implementation to disable a user account for 30 mins
	public void disableUser(String username) {
	}

	// TODO: Task 5
	// DO NOT CHANGE THE METHOD'S SIGNATURE
	// Write an implementation to check if a given user's login has been disabled
	public boolean isLocked(String username) {
		return false;
	}
}
