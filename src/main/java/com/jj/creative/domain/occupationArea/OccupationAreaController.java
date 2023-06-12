package com.jj.creative.domain.occupationArea;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jj.creative.utils.pagination.ResponsePagination;

@RestController
@RequestMapping("/api/occupation-area")
public class OccupationAreaController {
    @Autowired
    OccupationAreaService occupationAreaService;

    // @GetMapping("/{businessUnitLocalId}")
    // public ResponsePagination<OccupationArea> list(@PathVariable UUID
    // businessUnitLocalId,
    // @RequestParam(required = false) String name) {
    // return occupationAreaService.list(businessUnitLocalId, name);
    // }

    @PostMapping
    public OccupationArea create(@RequestBody OccupationArea occupationArea) {
        return occupationAreaService.create(occupationArea);
    }
}
