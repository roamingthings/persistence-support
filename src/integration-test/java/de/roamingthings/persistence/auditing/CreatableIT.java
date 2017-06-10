/**
 * Copyright 2016 Alexander Sparkowsky
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.roamingthings.persistence.auditing;

import de.roamingthings.junit.rules.jpa.EntityManagerProvider;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Alexander Sparkowsky [info@roamingthings.de]
 * @version 2017/05/01
 */
public class CreatableIT {
    @Rule
    public EntityManagerProvider emProvider = EntityManagerProvider.providerForPersistenceUnit("it-persistence-support");

    @Test
    public void should_set_created_at() {
        AuditingTestEntity testEntity = new AuditingTestEntity();

        emProvider.begin().persist(testEntity);

        assertThat(testEntity.getId(), notNullValue());
        assertThat(testEntity.getCreatedAt(), notNullValue());
        assertThat(testEntity.getModifiedAt(), notNullValue());
        assertThat(testEntity.getModifiedAt(), is(testEntity.getCreatedAt()));

        emProvider.rollback();
    }
}
