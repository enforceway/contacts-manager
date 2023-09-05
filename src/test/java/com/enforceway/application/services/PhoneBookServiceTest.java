package com.enforceway.application.services;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.enforceway.application.entity.ContactItem;
import com.enforceway.application.mappers.ContactItemMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhoneBookServiceTest {

    @Autowired
    private ContactService contactService;

    @Test
    public void testQuerySingleContactItem() {
        Long contactItemId = 1L;
        ContactItem contactItem = this.contactService.getById(contactItemId);
        System.out.println(contactItem);
    }

    @Test
    public void testQueryBatchContactItem() {
        QueryWrapper<ContactItem> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("initial");
        wrapper.like(true, "workAddress", "北京");


        Map<String, Object> contactItems = this.contactService.getMap(wrapper);
        if (contactItems != null) {
            for (Map.Entry<String, Object> entry : contactItems.entrySet()) {
                System.out.println(entry.getKey() + ", " + entry.getValue());
            }
        }
    }

    @Test
    public void testQueryBatchWithCondition1() {
        QueryWrapper<ContactItem> wrapper = new QueryWrapper<>();
        wrapper.gt("age", 10)
                .like("name", "a")
                .or()
                .isNull("teleNumber");

        ContactItem ncontactItem = new ContactItem();
        ncontactItem.setRemark("参与不足");
        boolean res = this.contactService.update(ncontactItem, wrapper);
        assert res == true;
    }

}
