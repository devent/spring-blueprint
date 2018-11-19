/*-
 * #%L
 * timefractalweb-bundle-itest
 * %%
 * Copyright (C) 2011 - 2018 Advanced Natural Research Institute
 * %%
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
 * #L%
 */
package com.anrisoftware.timefractalweb.bundle.itest.karaf

import static org.apache.karaf.itests.KarafTestSupport.*
import static org.ops4j.pax.exam.CoreOptions.maven;

import org.ops4j.pax.exam.ConfigurationManager

class KarafConfigurationManager {

    final static cm = new ConfigurationManager()

    static def getKarafUrl() {
        maven() groupId "org.apache.karaf" artifactId "apache-karaf" versionAsInProject() type "tar.gz"
    }

    static def getCustomHttpPort() {
        Integer.toString(getAvailablePort(Integer.parseInt(MIN_HTTP_PORT), Integer.parseInt(MAX_HTTP_PORT)));
    }

    static def getCustomRmiRegistryPort() {
        Integer.toString(getAvailablePort(Integer.parseInt(MIN_RMI_REG_PORT), Integer.parseInt(MAX_RMI_REG_PORT)));
    }

    static def getCustomRmiServerPort() {
        Integer.toString(getAvailablePort(Integer.parseInt(MIN_RMI_SERVER_PORT), Integer.parseInt(MAX_RMI_SERVER_PORT)));
    }

    static def getCustomSshPort() {
        Integer.toString(getAvailablePort(Integer.parseInt(MIN_SSH_PORT), Integer.parseInt(MAX_SSH_PORT)));
    }

    static def getLocalRepository() {
        cm.getProperty("org.ops4j.pax.url.mvn.localRepository", "");
    }

    static String getKarafVersion() {
        cm.getProperty("pax.exam.karaf.version", "4.2.0");
    }

    static def getKarafStandardRepo() {
        maven().groupId("org.apache.karaf.features").artifactId("standard").version(karafVersion).classifier("features").type("xml");
    }
}
