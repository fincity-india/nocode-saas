package com.fincity.saas.ui.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fincity.saas.commons.mongo.controller.AbstractOverridableDataController;
import com.fincity.saas.commons.mongo.document.Schema;
import com.fincity.saas.commons.mongo.repository.SchemaRepository;
import com.fincity.saas.commons.mongo.service.SchemaService;

@RestController
@RequestMapping("api/ui/schemas")
public class SchemaController
        extends AbstractOverridableDataController<Schema, SchemaRepository, SchemaService> {
}