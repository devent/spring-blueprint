package com.anrisoftware.timefractalweb.data.user;

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

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.anrisoftware.timefractalweb.data.common.Operations;

public interface UserService extends Operations<User> {

    User retrieveByName(String name);
    
    Page<User> findPaginated(Pageable pageable);

}