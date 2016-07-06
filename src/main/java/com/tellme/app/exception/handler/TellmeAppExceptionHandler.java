package com.tellme.app.exception.handler;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tellme.app.exception.ClientException;
import com.tellme.app.exception.InvalidRequestException;
import com.tellme.app.exception.client.TellmeAppErrorInfo;

//@ControllerAdvice(basePackages = "com.akosha.checkout")
public class TellmeAppExceptionHandler {

  private static final Logger LOG = LoggerFactory.getLogger(TellmeAppExceptionHandler.class);

//  @ExceptionHandler({NotFoundException.class})
//  public ResponseEntity<CheckoutErrorInfo> handleNotFound(NotFoundException e) {
//    CheckoutErrorInfo error = createError(e);
//    return new ResponseEntity<CheckoutErrorInfo>(error, HttpStatus.NOT_FOUND);
//  }
//
//  @ExceptionHandler({HttpMessageNotReadableException.class})
//  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//  public void handleNotReadable(HttpMessageNotReadableException e) {
//    LOG.error("HttpMessageNotReadableException", e);
//  }


  @ExceptionHandler({InvalidRequestException.class})
  public ResponseEntity<TellmeAppErrorInfo> handleNotFound(InvalidRequestException e) {
    TellmeAppErrorInfo error = createError(e);
    return new ResponseEntity<TellmeAppErrorInfo>(error, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({SQLException.class, DataAccessException.class})
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public void handleDatabase(DataAccessException e) {
    LOG.error("Database Exception", e);
  }


  @ExceptionHandler({Exception.class})
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public void handleExceptions(Exception e) {
    LOG.error("Exception", e);
  }

  private TellmeAppErrorInfo createError(ClientException e) {
    TellmeAppErrorInfo error = new TellmeAppErrorInfo();
    StringBuffer message = new StringBuffer();
    if (null != e.getMessage()) {
      message.append(e.getMessage());
    }
    if (null != e.getErrorCode()) {
      message.append(e.getErrorCode().getMessage());
    }
    if (null != e.getMessagePositionalArgs()) {
      for (Object object : e.getMessagePositionalArgs()) {
        message.append(" ");
        message.append(object);
      }
    }
    error.setMessage(message.toString());
    LOG.error(message.toString(), e);
    return error;
  }

  
}
