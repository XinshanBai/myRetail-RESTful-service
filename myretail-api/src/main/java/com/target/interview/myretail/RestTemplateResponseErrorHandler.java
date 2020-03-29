package com.target.interview.myretail;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus.Series;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

	@Override
	public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
		return (httpResponse.getStatusCode().series() == Series.CLIENT_ERROR
				|| httpResponse.getStatusCode().series() == Series.SERVER_ERROR);
	}

	@Override
	public void handleError(ClientHttpResponse httpResponse) throws IOException {
		HttpStatus httpStatus = httpResponse.getStatusCode();
		System.out.println("Error occurs while calling RestTemplate methods, status:" + httpStatus.value() + " "
				+ httpStatus.name());
	}
}
