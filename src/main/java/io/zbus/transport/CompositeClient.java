package io.zbus.transport;

import java.io.IOException;

public class CompositeClient<REQ extends Id, RES extends Id> implements Client<REQ, RES>{
	
	protected Client<REQ, RES> support;  
	
	public CompositeClient(){
		
	}
	
	public CompositeClient(Client<REQ, RES> support){
		this.support = support;
	}
	
	
	public RES invokeSync(REQ req, int timeout) throws IOException, InterruptedException { 
		return support.invokeSync(req, timeout);
	} 
	

	
	public RES invokeSync(REQ req) throws IOException, InterruptedException { 
		return support.invokeSync(req);
	}

	
	public void invokeAsync(REQ req, ResultCallback<RES> callback) throws IOException {
		support.invokeAsync(req, callback);
	}

	
	public void sessionCreated(Session sess) throws IOException {
		support.sessionCreated(sess);
	}

	
	public void sessionToDestroy(Session sess) throws IOException {
		support.sessionToDestroy(sess);
	}

	
	public void onMessage(Object msg, Session sess) throws IOException {
		support.onMessage(msg, sess);
	}

	
	public void onError(Throwable e, Session sess) throws Exception {
		support.onError(e, sess);
		
	}

	
	public void onIdle(Session sess) throws IOException {
		support.onIdle(sess);
	}

	
	public void close() throws IOException {
		support.close();
	}

	
	public boolean hasConnected() {
		return support.hasConnected();
	}

	
	public void connectAsync() throws IOException {
		support.connectAsync();
		
	}

	
	public void connectSync(long timeout) throws IOException, InterruptedException {
		support.connectSync(timeout);
	}

	
	public void ensureConnectedAsync() {
		support.ensureConnectedAsync();
	}

	
	public void sendMessage(REQ req) throws IOException, InterruptedException {
		support.sendMessage(req);
	}

	
	public void onMessage(io.zbus.transport.MessageHandler<RES> msgHandler) {
		support.onMessage(msgHandler);
	}

	
	public void onError(io.zbus.transport.Client.ErrorHandler errorHandler) {
		support.onError(errorHandler);
	}

	
	public void onConnected(io.zbus.transport.Client.ConnectedHandler connectedHandler) {
		support.onConnected(connectedHandler);
	}

	
	public void onDisconnected(io.zbus.transport.Client.DisconnectedHandler disconnectedHandler) {
		support.onDisconnected(disconnectedHandler);
	} 
	
	
	public <V> V attr(String key) {
		return support.attr(key);
	}

	
	public <V> void attr(String key, V value) {
		support.attr(key, value);
	}
 
}
 
