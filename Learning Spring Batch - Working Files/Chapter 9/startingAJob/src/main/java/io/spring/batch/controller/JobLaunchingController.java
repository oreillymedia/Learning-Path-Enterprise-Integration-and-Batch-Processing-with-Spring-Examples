/*
 * Copyright 2016 the original author or authors.
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
package io.spring.batch.controller;

import org.springframework.batch.core.launch.JobOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Michael Minella
 */
@RestController
public class JobLaunchingController {

//	@Autowired
//	private JobLauncher jobLauncher;

	@Autowired
	private JobOperator jobOperator;

//	@Autowired
//	private Job job;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void launch(@RequestParam("name") String name) throws Exception {
//		JobParameters jobParameters =
//				new JobParametersBuilder()
//						.addString("name", name)
//						.toJobParameters();
//		this.jobLauncher.run(job, jobParameters);
		this.jobOperator.start("job", String.format("name=%s", name));
	}
}
