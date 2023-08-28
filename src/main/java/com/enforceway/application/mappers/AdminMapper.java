package com.enforceway.application.mappers;

import com.enforceway.application.entity.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    public Admin login(Admin admin);

}
