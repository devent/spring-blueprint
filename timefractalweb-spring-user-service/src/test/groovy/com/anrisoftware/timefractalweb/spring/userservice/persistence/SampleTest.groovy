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
package com.anrisoftware.timefractalweb.spring.userservice.persistence

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic
import static org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.support.AnnotationConfigContextLoader
import org.springframework.transaction.annotation.Transactional

import com.anrisoftware.timefractalweb.spring.userservice.persistence.config.PersistenceConfig
import com.anrisoftware.timefractalweb.spring.userservice.persistence.model.User
import com.anrisoftware.timefractalweb.spring.userservice.persistence.service.UserService

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = [ PersistenceConfig.class ], loader = AnnotationConfigContextLoader.class)
@Transactional
class SampleTest {

    @Autowired
    private UserService service;
    
    @BeforeAll
    static void setUp() {
        // Do something before all tests
    }
    
    @AfterAll
    static void tearDown() {
        // Do something after all tests
    }
    
    @Test
    void "create user"() {
        def userName = randomAlphabetic(6)
        def firstName = randomAlphabetic(6)
        def lastName = randomAlphabetic(6)
        def email = randomAlphabetic(6)
        service.create(new User(userName, firstName, lastName, email));
    }

    @Test
    public final void whenInvalidEntityIsCreated_thenDataException() {
       assertThrows DataIntegrityViolationException, { service.create(new User()) }
    }


}
