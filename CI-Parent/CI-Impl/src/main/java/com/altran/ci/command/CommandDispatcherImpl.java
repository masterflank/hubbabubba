package com.altran.ci.command;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

@ApplicationScoped
public class CommandDispatcherImpl implements CommandDispatcher {
    @Inject
    @Any
    private Instance<CommandHandler> handlers;
	
	@Override
	public boolean dispatch(Command command) {
		for (CommandHandler handler : handlers) {
			if (handler.canHandle(command.getClass())) {
				return handler.handle(command);
			}
		}
		throw new RuntimeException("No handler found for command " + command.getClass());
	}

}
