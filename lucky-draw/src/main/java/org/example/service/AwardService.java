package org.example.service;

import org.example.mapper.AwardMapper;
import org.example.model.Award;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：ZXF
 * @program: lucky-draw
 * @description:
 * @date ：2021-06-03 00:28
 */

@Service
public class AwardService {

    @Autowired
    private AwardMapper awardMapper;

    public int insert(Award award) {
        return awardMapper.insertSelective(award);
    }

    public int update(Award award) {
        return awardMapper.updateByPrimaryKeySelective(award);
    }

    public int delete(Integer id) {
        return awardMapper.deleteByPrimaryKey(id);
    }
}
