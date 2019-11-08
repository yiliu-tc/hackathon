package ca.gc.tc.hackathon.service;

import ca.gc.tc.hackathon.entity.RatingType;

import java.util.List;

public interface RatingTypeService {
    public RatingType get(Integer id);
    public List<RatingType> list();
}
