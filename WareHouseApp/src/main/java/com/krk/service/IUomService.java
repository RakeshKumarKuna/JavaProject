package com.krk.service;
import java.util.List;
import java.util.Map;
import com.krk.model.Uom;

public interface IUomService {
public Integer saveUom(Uom uom);
public List<Uom> getAllUoms();
public String deleteUom(Integer id);
public Uom getOneRecord(Integer id);
public boolean isUomModelExist(String uomModel);
public List<Object[]> getUomTypeAndCount();
public Map<Integer,String> getUomIdAndModel();
}
