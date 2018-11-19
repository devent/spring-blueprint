package com.anrisoftware.timefractalweb.data.persistence.internal.bundle;

/*-
 * #%L
 * timefractalweb-data-persistence
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

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
    
	public void start(BundleContext context) throws Exception {
		System.out.println("data.persistence bundle starting");
		// Insert bundle activation logic here
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("data.persistence bundle stopping");
		// Insert bundle deactivation logic here
	}
}
