package webSocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/myserver")
public class MyServer {
	private static HashSet<Session> sessions;
	private static HashMap<String, Session> users;
	
	public MyServer() {
		System.out.println("MyServer()");
		if (sessions == null) {
			sessions = new HashSet<>();
			users = new HashMap<>();
		}
	}
	
	@OnOpen
	public void open(Session session) {
		System.out.println("OnOpen");
		if (sessions.add(session)) {
			users.put(session.getId(), session);
			System.out.println("count: " + sessions.size());
		}
	}
	
	@OnMessage
	public void onMessage(String mesg, Session session) {
		System.out.println("OnMessage: " + mesg);
		for (Session userSession: sessions) {
			try {
				userSession.getBasicRemote().sendText(mesg);
			} catch (IOException e) {
				e.printStackTrace();
			};
		}
	}
	
	@OnClose
	public void close(Session session) {
		System.out.println("OnClose");
		users.remove(session.getId());
		sessions.remove(session);
		System.out.println("count: " + sessions.size());
	}
	
	@OnError
	public void onError(Session session, Throwable t) {
		System.out.println("OnError: " + t.toString());
	}
}
