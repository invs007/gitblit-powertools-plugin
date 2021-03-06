/*
 * Copyright 2014 gitblit.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gitblit.plugin.powertools;

import ro.fortsoft.pf4j.Extension;

import com.gitblit.transport.ssh.commands.CommandMetaData;
import com.gitblit.transport.ssh.commands.DispatchCommand;

@Extension
@CommandMetaData(name = "gitblit", aliases = {"gb"}, description = "Gitblit powertools commands")
public class GitblitDispatcher extends DispatchCommand {

	@Override
	protected void setup() {
		// commands in this dispatcher
		register(ConfigCommand.class);
		register(ResetCommand.class);

		// nested dispatchers
		register(ListDispatcher.class);
		register(TicketsDispatcher.class);
		register(UsersDispatcher.class);
		register(TeamsDispatcher.class);
		register(ProjectsDispatcher.class);
		register(RepositoriesDispatcher.class);
	}
}
