package com.iniesta.akka.challenge.tutorial;

import com.iniesta.akka.challenge.tutorial.Greeter.Msg;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class HelloWorld extends UntypedActor {

	@Override
	public void preStart() {
		final ActorRef greeter = getContext().actorOf(Props.create(Greeter.class));
		greeter.tell(Msg.GREET, getSelf());
	}

	@Override
	public void onReceive(Object msg) throws Exception {
		if (msg == Msg.DONE) {
			getContext().stop(getSelf());
		}else {
			unhandled(msg);
		}

	}

}
