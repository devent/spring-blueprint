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

import static com.anrisoftware.timefractalweb.bundle.itest.karaf.KarafConfigurationManager.*
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;

import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.configureSecurity;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.editConfigurationFilePut;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.features;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.karafDistributionConfiguration;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.keepRuntimeFolder;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.logLevel;

import org.apache.karaf.itests.KarafTestSupport
import org.ops4j.pax.exam.Configuration
import org.ops4j.pax.exam.Option
import org.ops4j.pax.exam.karaf.options.LogLevelOption;

class AbstractKarafTest extends KarafTestSupport {

    @Override
    @Configuration
    Option[] config() {
        [
            // KarafDistributionOption.debugConfiguration("8889", true),
            karafDistributionConfiguration().frameworkUrl(karafUrl).name("Apache Karaf").unpackDirectory(new File("target/exam")),
            // enable JMX RBAC security, thanks to the KarafMBeanServerBuilder
            configureSecurity().disableKarafMBeanServerBuilder(),
            // configureConsole().ignoreLocalConsole(),
            keepRuntimeFolder(),
            logLevel(LogLevelOption.LogLevel.INFO),
            mavenBundle().groupId("org.codehaus.groovy").artifactId("groovy").versionAsInProject(),
            mavenBundle().groupId("org.awaitility").artifactId("awaitility").versionAsInProject(),
            mavenBundle().groupId("org.apache.servicemix.bundles").artifactId("org.apache.servicemix.bundles.hamcrest").versionAsInProject(),
            mavenBundle().groupId("org.apache.karaf.itests").artifactId("common").versionAsInProject(),
            mavenBundle().groupId("com.anrisoftware.timefractalweb").artifactId("timefractalweb-data-persistence").versionAsInProject(),
            mavenBundle().groupId("com.anrisoftware.timefractalweb").artifactId("timefractalweb-spring-core-bundles").versionAsInProject(),
            mavenBundle().groupId("com.anrisoftware.timefractalweb").artifactId("timefractalweb-spring-data-bundles").versionAsInProject(),
            mavenBundle().groupId("com.google.guava").artifactId("guava").versionAsInProject(),
            mavenBundle().groupId("org.hibernate.javax.persistence").artifactId("hibernate-jpa-2.1-api").versionAsInProject(),
            mavenBundle().groupId("org.apache.commons").artifactId("commons-lang3").versionAsInProject(),
            features(karafStandardRepo, "scr"),
            editConfigurationFilePut("etc/org.ops4j.pax.web.cfg", "org.osgi.service.http.port", customHttpPort),
            editConfigurationFilePut("etc/org.apache.karaf.management.cfg", "rmiRegistryPort", customRmiRegistryPort),
            editConfigurationFilePut("etc/org.apache.karaf.management.cfg", "rmiServerPort", customRmiServerPort),
            editConfigurationFilePut("etc/org.apache.karaf.shell.cfg", "sshPort", customSshPort),
            editConfigurationFilePut("etc/org.ops4j.pax.url.mvn.cfg", "org.ops4j.pax.url.mvn.localRepository", localRepository)
        ]
    }

}
