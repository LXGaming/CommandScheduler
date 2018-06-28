/*
 * Copyright 2018 lolnet.co.nz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nz.co.lolnet.commandscheduler.listeners;

import nz.co.lolnet.commandscheduler.CommandScheduler;
import nz.co.lolnet.commandscheduler.configuration.Config;
import org.apache.commons.lang3.StringUtils;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.Getter;
import org.spongepowered.api.event.network.ClientConnectionEvent;

import java.util.Set;

public class CSListener {
    
    @Listener
    public void onClientConnectionJoin(ClientConnectionEvent.Join event, @Getter("getTargetEntity") Player player) {
        Set<String> commands = CommandScheduler.getInstance().getConfig().map(Config::getCommandsOnJoin).orElse(null);
        if (commands == null) {
            return;
        }
        
        for (String command : commands) {
            command = command.replace("[PLAYER]", player.getName());
            if (StringUtils.isNotBlank(command)) {
                Sponge.getCommandManager().process(Sponge.getServer().getConsole(), command);
            }
        }
    }
}