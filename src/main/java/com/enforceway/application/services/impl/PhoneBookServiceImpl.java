package com.enforceway.application.services.impl;

import com.enforceway.application.entity.ContactItem;
import com.enforceway.application.entity.R;
import com.enforceway.application.mappers.PhoneBookMapper;
import com.enforceway.application.services.PhoneBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PhoneBookServiceImpl implements PhoneBookService {

    @Autowired
    private PhoneBookMapper phoneBookMapper;

    @Override
    public R retriveContactItems() {
        List<ContactItem> initialedByBResult = this.phoneBookMapper.retrieveByInitial("B");
        List<ContactItem> result = this.phoneBookMapper.retrieveContactList();
        Map<Character, List<Object>> data = new LinkedHashMap<>();
        char alpbertArray[] = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        for (int i = 0; i < alpbertArray.length; i++) {
            char temp = alpbertArray[i];
            List dataList = result.stream().filter(contactItem -> {
                if (String.valueOf(temp).equals(contactItem.getInitial())) {
                    return true;
                }
                return false;
            }).collect(Collectors.toList());
            data.put(temp, dataList);
        }
        List initialUndefinedDataList = result.stream().filter(contactItem -> {
            if (contactItem.getInitial() == null) {
                return true;
            }
            return false;
        }).collect(Collectors.toList());
        data.put('#', initialUndefinedDataList);

        Map<String, Object> res = new HashMap<>();
        res.put("msg", "Ok");
        res.put("data", data);
        return R.ok(res);
    }

    @Override
    public R retriveContactItemById(Integer id) {
        ContactItem contact = this.phoneBookMapper.retrieveContactById(id);
//        Map<String, ContactItem> dataMap = new HashMap();
//        dataMap.put("phoneBook", contact);
//
        R r = R.ok("ok");
        r.put("phoneBook", contact);
        return r;
    }

    @Override
    public R saveContact(ContactItem contactItem) {
        Integer res = this.phoneBookMapper.saveContact(contactItem);
        R r = R.ok("ok");
        r.put("data", res);
        return r;
    }

    @Override
    public R removeContact(Integer contactId) {
        Integer res = this.phoneBookMapper.removeContact(contactId);
        R r = R.ok("ok");
        r.put("data", res);
        return r;
    }
}
