package com.krk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krk.model.Uom;

public interface IUomService {
public Integer saveUom(Uom uom);
public List<Uom> getAllUoms();
public String deleteUom(Integer id);
public Uom getOneRecord(Integer id);
}
