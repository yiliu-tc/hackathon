package ca.gc.tc.hackathon.dao;

import ca.gc.tc.hackathon.entity.RatingType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RatingTypeDao {
    public RatingType findById(Integer id);
    public List<RatingType> findAll();
}
