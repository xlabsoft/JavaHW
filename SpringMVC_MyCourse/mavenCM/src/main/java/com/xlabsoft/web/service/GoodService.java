package com.xlabsoft.web.service;

import com.xlabsoft.web.model.Good;
import java.util.List;

public interface GoodService {
    List<Good> all();
    List<Good> all(Integer categoryId);
}
