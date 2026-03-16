package com.alpha.SpringBootDemo1.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alpha.SpringBootDemo1.dto.ResponseStructure;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(AdminNotFound.class)
public ResponseEntity<ResponseStructure<String>> AdminNotFoundExceptionHandler(){
	ResponseStructure<String> rs=new ResponseStructure<String>();
	rs.setStatuscode(HttpStatus.NOT_FOUND.value());
	rs.setMessage("Student not found");
	rs.setData("Student data not found");
	return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
}

@ExceptionHandler(CarrierNotFound.class)
public ResponseEntity<ResponseStructure<String>> CarrierNotFoundExceptionHandler(){
	ResponseStructure<String> rs=new ResponseStructure<String>();
	rs.setStatuscode(HttpStatus.NOT_FOUND.value());
	rs.setMessage("Student not found");
	rs.setData("Student data not found");
	return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
}

@ExceptionHandler(ProductNotFound.class)
public ResponseEntity<ResponseStructure<String>> ProductNotFoundExceptionHandler(){
	ResponseStructure<String> rs=new ResponseStructure<String>();
	rs.setStatuscode(HttpStatus.NOT_FOUND.value());
	rs.setMessage("Student not found");
	rs.setData("Student data not found");
	return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
}
}
