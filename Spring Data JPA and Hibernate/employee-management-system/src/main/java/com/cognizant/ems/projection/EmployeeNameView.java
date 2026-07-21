package com.cognizant.ems.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeNameView {
    String getName();

    @Value("#{target.name + ' <' + target.email + '>'}")
    String getDisplayName();
}
