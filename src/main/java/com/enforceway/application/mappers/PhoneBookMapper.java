package com.enforceway.application.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.enforceway.application.entity.ContactItem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneBookMapper extends BaseMapper<ContactItem> {

    @Select("select id, name, phoneNumber, teleNumber, workAddress, homeAddress, image, image_name, remark, initial from t_phonebook")
    public List<ContactItem> retrieveContactList();

    @Select("<script>select id, name, image from t_phonebook where initial = #{initialStr}</script>")
    public List<ContactItem> retrieveByInitial(@Param("initialStr") String initialString);

    @Select("<script>select id, name, image, image_name, initial, phoneNumber, teleNumber, workAddress, homeAddress, remark from t_phonebook where id = #{contactId}</script>")
    public ContactItem retrieveContactById(@Param("contactId") Integer contactId);

    @Update("<script>update t_phonebook set name = #{name}, image = #{image}, initial=#{initial}, phoneNumber = #{phoneNumber}, teleNumber = #{teleNumber}, "
            + "workAddress=#{workAddress}, homeAddress=#{homeAddress}, remark=#{remark} where id = #{id}</script>")
    public Integer saveContact(ContactItem contactItem);

    @Delete("<script>delete from t_phonebook where id = #{contactId}</script>")
    public Integer removeContact(@Param("contactId") Integer contactId);

}
