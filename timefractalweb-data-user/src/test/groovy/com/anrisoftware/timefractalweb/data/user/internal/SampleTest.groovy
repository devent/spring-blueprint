/*-
 * #%L
 * timefractalweb-data-user
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
package com.anrisoftware.timefractalweb.data.user.internal

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.support.AnnotationConfigContextLoader
import org.springframework.transaction.annotation.Transactional

import com.anrisoftware.timefractalweb.data.persistence.internal.PersistenceConfig

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = [ PersistenceConfig.class ], loader = AnnotationConfigContextLoader.class)
@Transactional
class SampleTest {

    @BeforeAll
    static void setUp() {
        // Do something before all tests
    }
    
    @AfterAll
    static void tearDown() {
        // Do something after all tests
    }
    
    @Test
    void testAdd() {
        int a = 1, b = 1;

        Assertions.assertEquals(2, a + b);
    }
    
    @Test
    void testDatabaseQuery() {
    }
}
