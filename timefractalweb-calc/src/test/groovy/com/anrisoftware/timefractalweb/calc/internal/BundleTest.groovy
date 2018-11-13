/*-
 * #%L
 * Properties Utilities :: Context Properties
 * %%
 * Copyright (C) 2012 - 2018 Advanced Natural Research Institute
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

package com.anrisoftware.timefractalweb.calc.internal

import static com.anrisoftware.globalpom.utils.TestUtils.*

import org.apache.sling.testing.mock.osgi.junit5.OsgiContext
import org.apache.sling.testing.mock.osgi.junit5.OsgiContextExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

/**
 * Tests the bundles.
 *
 * @author Erwin Müller, erwin.mueller@deventm.de
 * @since 2.2
 */
@ExtendWith(OsgiContextExtension.class)
class BundleTest {

    final OsgiContext context = new OsgiContext()

    @Test
    void "load calculation service"() {
        def service = context.registerInjectActivateService(new CalculationServiceImpl(), null)
        assert service != null
    }

}
