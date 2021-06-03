package org.example.service;

import org.example.mapper.RecordMapper;
import org.example.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：ZXF
 * @program: lucky-draw
 * @description:
 * @date ：2021-06-02 23:54
 */

@Service
public class RecordService {

    @Autowired
    private RecordMapper recordMapper;

    public int add(Integer awardId, List<Integer> memberIds) {
        return recordMapper.batchInsert(awardId, memberIds);
    }

    public int deleteByMemberId(Integer id) {
        Record r = new Record();
        r.setMemberId(id);
        return recordMapper.delete(r);
    }

    public int deleteByAwardId(Integer id) {
        Record r = new Record();
        r.setAwardId(id);
        return recordMapper.delete(r);
    }

    public int deleteBySettingId(Integer settingId) {
        return recordMapper.deleteBySettingId(settingId);
    }
}
