package opensnap.service;
/*
 * Copyright 2002-2014 the original author or authors.
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

import opensnap.domain.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DataInitializer implements InitializingBean {

	private final UserService userService;

	@Autowired
	public DataInitializer(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.userService.create(new User("eric", "3r1c", Arrays.asList("USER")));
		this.userService.create(new User("adeline", "ad3l1n3", Arrays.asList("USER")));
		this.userService.create(new User("johanna", "j0hanna", Arrays.asList("USER")));
		this.userService.create(new User("michel", "m1ch3l", Arrays.asList("USER", "ADMIN")));
	}

}