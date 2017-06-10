package de.roamingthings.persistence.auditing;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Alexander Sparkowsky [info@roamingthings.de]
 * @version 2017/06/05
 */
public class CreatableEntityListenerTest {
    @Test
    public void should_update_create_date() throws Exception {
        AuditingTestEntity auditingTestEntity = new AuditingTestEntity();
        CreatableEntityListener creatableEntityListener = new CreatableEntityListener();

        creatableEntityListener.updateCreatedInformation(auditingTestEntity);
        assertThat(auditingTestEntity.getCreatedAt(), notNullValue());
    }

}