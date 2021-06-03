package org.example.service;

import org.example.mapper.MemberMapper;
import org.example.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：ZXF
 * @program: lucky-draw
 * @description:
 * @date ：2021-06-03 00:01
 */

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    public int add(Member member) {
        return memberMapper.insertSelective(member);
    }

    public int update(Member member) {
        return memberMapper.updateByPrimaryKeySelective(member);
    }

    public int delete(Integer id) {
        return memberMapper.deleteByPrimaryKey(id);
    }
}
