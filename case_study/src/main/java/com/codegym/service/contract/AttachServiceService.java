package com.codegym.service.contract;


import com.codegym.model.contract.AttachService;

import java.util.List;

public interface AttachServiceService {
    List<AttachService> findAll();

    AttachService findById(int id);
}
