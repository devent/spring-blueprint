package com.anrisoftware.timefractalweb.spring.userservice.persistence.service.impl;

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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anrisoftware.timefractalweb.spring.userservice.persistence.dao.UserDao;
import com.anrisoftware.timefractalweb.spring.userservice.persistence.model.User;
import com.anrisoftware.timefractalweb.spring.userservice.persistence.service.UserService;
import com.anrisoftware.timefractalweb.spring.userservice.persistence.service.common.AbstractService;
import com.google.common.collect.Lists;

@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {

    @Autowired
    private UserDao dao;

    public UserServiceImpl() {
        super();
    }

    @Override
    protected PagingAndSortingRepository<User, Long> getDao() {
        return dao;
    }

    @Override
    public User retrieveByUserName(final String name) {
        return dao.retrieveByUserName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return Lists.newArrayList(getDao().findAll());
    }

    @Override
    public Page<User> findPaginated(Pageable pageable) {
        return dao.findAll(pageable);
    }

}
