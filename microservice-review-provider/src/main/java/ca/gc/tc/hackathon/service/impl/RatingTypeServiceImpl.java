package ca.gc.tc.hackathon.service.impl;

import ca.gc.tc.hackathon.dao.RatingTypeDao;
import ca.gc.tc.hackathon.entity.RatingType;
import ca.gc.tc.hackathon.service.RatingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingTypeServiceImpl implements RatingTypeService {

    @Autowired
    private RatingTypeDao dao;

    @Override
    public RatingType get(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<RatingType> list() {
        return dao.findAll();
    }
}
