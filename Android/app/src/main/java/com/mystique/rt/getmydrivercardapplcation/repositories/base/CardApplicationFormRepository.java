package com.mystique.rt.getmydrivercardapplcation.repositories.base;

import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;

import java.io.IOException;
import java.util.List;

public interface CardApplicationFormRepository {
    List<CardApplicationForm> getAll() throws IOException;

    CardApplicationForm add(CardApplicationForm applicationForm) throws IOException;

    CardApplicationForm getById(int id) throws IOException;

    CardApplicationForm updateById(int id, CardApplicationForm applicationForm) throws IOException;
}
