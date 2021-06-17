package com.invictus.squirrelchat.server;

// Launch Server 
public class ServerMain {
	public ServerMain(int port) {
		new Server(port);
	}
		public static void main(String[] args) {
			int port;
				if(args.length>1) {
					 System.out.println("Usage : java -jar SquirelChatServer.jar [port]");
				}
				port =Integer.parseInt(args[0]);
				new ServerMain(port);
		}
}
