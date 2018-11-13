package com.anrisoftware.timefractalweb.calc.internal;

/*-
 * #%L
 * sscontrol-osgi - etcd-service
 * %%
 * Copyright (C) 2016 - 2018 Advanced Natural Research Institute
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

import static com.google.inject.Guice.createInjector;

import javax.inject.Inject;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import com.anrisoftware.timefractalweb.calc.Calculation;
import com.anrisoftware.timefractalweb.calc.CalculationService;

/**
 * Calculation service.
 *
 * @author Erwin Müller, erwin.mueller@deventm.de
 * @since 1.0
 */
@Component
public class CalculationServiceImpl implements CalculationService {

    @Inject
    private CalculationImplFactory serviceFactory;

    @Override
    public Calculation create() {
        return serviceFactory.create();
    }

    @Activate
    protected void start() {
        createInjector(new CalcModule()).injectMembers(this);
    }
}
