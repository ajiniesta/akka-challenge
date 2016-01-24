package com.iniesta.akka.challenge.tutorial;

import akka.actor.UntypedActor;

public class Greeter extends UntypedActor {

	public static class Msg {
		
		private String content;
		
		private boolean done = false;
		
		public Msg(String content) {
			this.content = content;
		}

		public Msg done(){
			done = true;
			return this;
		}
		
		public String content(){
			return content;
		}
		
		public boolean isDone(){
			return done;
		}
	}

	@Override
	public void onReceive(Object msg) throws Exception {
		if (msg instanceof Msg) {
			Msg ct = (Msg)msg;
			System.out.println("Hello, "+ct.content()+"!");
			getSender().tell(ct.done(), getSelf());
		} else {
			unhandled(msg);
		}
	}
}
