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

package nz.co.lolnet.commandscheduler.configuration;

import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;
import nz.co.lolnet.commandscheduler.util.Toolbox;

import java.util.Set;

@ConfigSerializable
public class Config {
    
    @Setting(value = "debug", comment = "For debugging purposes")
    private boolean debug = false;
    
    @Setting(value = "commandOnJoin", comment = "Commands to run on join")
    private Set<String> commandsOnJoin = Toolbox.newHashSet("");
    
    public boolean isDebug() {
        return debug;
    }
    
    public void setDebug(boolean debug) {
        this.debug = debug;
    }
    
    public Set<String> getCommandsOnJoin() {
        return commandsOnJoin;
    }
    
    public void setCommandsOnJoin(Set<String> commandsOnJoin) {
        this.commandsOnJoin = commandsOnJoin;
    }
}