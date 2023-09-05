package com.enforceway.application.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.enforceway.application.entity.ContactItem;
import com.enforceway.application.mappers.ContactItemMapper;
import com.enforceway.application.services.ContactService;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl extends ServiceImpl<ContactItemMapper, ContactItem> implements ContactService {

}
