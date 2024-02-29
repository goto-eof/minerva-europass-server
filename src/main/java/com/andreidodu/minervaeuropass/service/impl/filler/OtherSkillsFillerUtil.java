package com.andreidodu.minervaeuropass.service.impl.filler;

import com.andreidodu.minervaeuropass.constants.ResumeConst;
import com.andreidodu.minervaeuropass.dto.resume.ResumeDTO;
import com.andreidodu.minervaeuropass.service.impl.FillerUtil;
import com.andreidodu.minervaeuropass.util.ResumeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Map;

@Order(55)
@Component
@RequiredArgsConstructor
public class OtherSkillsFillerUtil implements FillerUtil {
    private final ResumeUtil resumeUtil;

    public void fillUp(ResumeDTO resumeDTO, Map<String, Object> result) {
        if (resumeDTO.getOtherSkills() != null) {
            result.put(ResumeConst.FIELD_OTHER_SKILLS_TITLE, resumeDTO.getOtherSkills().getTitle());
            result.put(ResumeConst.FIELD_OTHER_SKILLS_DESCRIPTION, resumeDTO.getOtherSkills().getDescription());
            result.put(ResumeConst.FIELD_OTHER_SKILL_SOCIAL_LIST, resumeUtil.listToString(resumeDTO.getOtherSkills().getSocialList()));
            result.put(ResumeConst.FIELD_OTHER_SKILL_ORGANIZATIONAL_LIST, resumeUtil.listToString(resumeDTO.getOtherSkills().getOrganizationalList()));
            result.put(ResumeConst.FIELD_OTHER_SKILL_OTHER_LIST, resumeUtil.listToString(resumeDTO.getOtherSkills().getOtherList()));
        }
    }
}
