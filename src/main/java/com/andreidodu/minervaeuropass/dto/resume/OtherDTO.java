package com.andreidodu.minervaeuropass.dto.resume;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OtherDTO extends SectionCommonDTO{
    private List<OtherItemDTO> otherList;
}
