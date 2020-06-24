package com.example.algamoney.api.exceptionhandler;

/**
 * @author Rodrigo
 *
 */
public class ExceptionResponse {
	private String mensagem;
	private String detalhes;
	private String httpCodeMessage;

	public ExceptionResponse(String message, String details, String httpCodeMessage) {
		super();
		this.mensagem = message;
		this.detalhes = details;
		this.httpCodeMessage = httpCodeMessage;
	}

	public String getHttpCodeMessage() {
		return httpCodeMessage;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getDetalhes() {
		return detalhes;
	}
}