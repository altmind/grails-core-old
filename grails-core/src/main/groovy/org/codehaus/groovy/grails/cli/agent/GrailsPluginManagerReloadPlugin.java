/* Copyright 2011 SpringSource
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codehaus.groovy.grails.cli.agent;

import com.springsource.loaded.Plugins;
import com.springsource.loaded.ReloadEventProcessorPlugin;
import org.codehaus.groovy.grails.plugins.GrailsPluginManager;
import org.codehaus.groovy.grails.plugins.PluginManagerHolder;

/**
 *
 * Reloading agent plugin for use with the GrailsPluginManager
 *
 * @author Graeme Rocher
 * @since 1.4
 */
public class GrailsPluginManagerReloadPlugin implements ReloadEventProcessorPlugin {

    public void reloadEvent(String typename, Class<?> aClass, String encodedTimestamp) {
        GrailsPluginManager pluginManager = PluginManagerHolder.getPluginManager();
        if(pluginManager != null) {
            pluginManager.informOfClassChange(aClass);
        }
    }


    public static void register() {
        Plugins.registerGlobalPlugin(new GrailsPluginManagerReloadPlugin());
    }
}