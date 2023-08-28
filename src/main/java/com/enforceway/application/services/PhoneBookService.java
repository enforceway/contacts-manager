package com.enforceway.application.services;

import com.enforceway.application.entity.Admin;
import com.enforceway.application.entity.ContactItem;
import com.enforceway.application.entity.R;

public interface PhoneBookService {
    public R retriveContactItems();

    public R retriveContactItemById(Integer id);

    public R saveContact(ContactItem contactItem);

    public R removeContact(Integer contactId);
}
