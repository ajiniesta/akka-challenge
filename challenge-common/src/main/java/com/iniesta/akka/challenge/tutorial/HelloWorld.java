package com.iniesta.akka.challenge.tutorial;

import com.iniesta.akka.challenge.tutorial.Greeter.Msg;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class HelloWorld extends UntypedActor {
	
	@Override
	public void preStart() {
		final ActorRef greeter = getContext().actorOf(Props.create(Greeter.class));
		greeter.tell(new Msg("Pete"), getSelf());
	}

	@Override
	public void onReceive(Object msg) throws Exception {
		if (msg instanceof Msg && ((Msg)msg).isDone()) {
			getContext().stop(getSelf());
		}else {
			unhandled(msg);
		}

	}

}
