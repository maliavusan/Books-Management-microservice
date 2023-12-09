package com.management.books.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HelperUtil {

	/**
	 * Method to build server error message
	 * @param errorMessage
	 * @param detailedMessage
	 * @return
	 */
	public static ResponseEntity<String> returnServerErrorMessage(String errorMessage, String detailedMessage){
		return new ResponseEntity<>(errorMessage +": " + detailedMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	//See if you can make use of this
	// /**
	//  * Method to build server error message
	//  * @param errorMessage
	//  * @return
	//  */
	// public static ResponseEntity<String> returnServerErrorMessage(String errorMessage){
	// 	return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	// }

	// /**
	//  * Method to build bad request error message
	//  * @param errorMessage
	//  * @return
	//  */
	// public static ResponseEntity<String> returnForbiddenRequestErrorMessage(String errorMessage){
	// 	return new ResponseEntity<>(errorMessage, HttpStatus.FORBIDDEN);
	// }
}
