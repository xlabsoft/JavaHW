package org.itstep.java.web.service;

import java.util.List;
import org.itstep.java.web.model.Good;

public interface GoodService {
    List<Good> all();
    List<Good> all(Integer categoryId);
}
