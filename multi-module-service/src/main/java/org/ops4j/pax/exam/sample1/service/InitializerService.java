/*
 * Copyright 2012 Harald Wellmann
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.ops4j.pax.exam.sample1.service;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.ops4j.pax.exam.sample1.model.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Startup
public class InitializerService {

    private static Logger log = LoggerFactory.getLogger(LibraryService.class);

    @Inject
    private LibraryService libraryService;

    @PostConstruct
    public void init() {
        log.info("filling library");
        if (libraryService.getNumBooks() != 0) {
            return;
        }

        Author golding = libraryService.createAuthor("William", "Golding");
        Author wilde = libraryService.createAuthor("Oscar", "Wilde");

        libraryService.createBook("The Importance of Being Earnest", wilde);
        libraryService.createBook("The Lord of the Flies", golding);
    }
}
