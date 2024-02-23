package com.andreidodu.iteuropass.service.impl;

import com.andreidodu.iteuropass.constants.ResumeConst;
import com.andreidodu.iteuropass.dto.ResumeDTO;
import com.andreidodu.iteuropass.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {


    @Override
    public Map<String, Object> processResumeAndReturnMap(ResumeDTO resumeDTO) {
        Map<String, Object> result = new HashMap<>();
        result.put(ResumeConst.FIELD_FIRST_NAME, resumeDTO.getFirstName());
        result.put(ResumeConst.FIELD_LAST_NAME, resumeDTO.getLastName());
        result.put(ResumeConst.FIELD_CITY, resumeDTO.getCity());
        result.put(ResumeConst.FIELD_COUNTY, resumeDTO.getCounty());
        result.put(ResumeConst.FIELD_COUNTRY, resumeDTO.getCountry());
        result.put(ResumeConst.FIELD_CITIZENSHIP, StringUtils.join(resumeDTO.getCitizenshipList(), ',').replace(",", ", "));
        result.put(ResumeConst.FIELD_EMAIL_LIST, listToListMap(resumeDTO.getEmailMap()));
        result.put(ResumeConst.FIELD_URL_LIST, listToListMap(resumeDTO.getUrlMap()));
        result.put(ResumeConst.FIELD_PHONE_NUMBER_LIST, listToListMap(resumeDTO.getPhoneNumberMap()));
        result.put(ResumeConst.FIELD_BIRTH_DATE, resumeDTO.getBirthDate().toString());

        if (resumeDTO.getIntroduction() != null) {
            result.put("introductionTitle", resumeDTO.getIntroduction().getTitle());
            result.put("introductionContent", resumeDTO.getIntroduction().getContent());
        }
        result.put("applicationName", "IT Europass");

        result.put("mainSkills", listToString(resumeDTO.getMainSkills()));
        result.put("languages", listToString(resumeDTO.getLanguages()));

        return result;
    }

    private List<Map<String, Object>> listToListMap(Map<String, String> listOfMap) {
        List<Map<String, Object>> result = new ArrayList<>();

        for (String key : listOfMap.keySet()) {
            Map<String, Object> map = new HashMap<>();
            map.put(ResumeConst.FIELD_NAME, key);
            map.put(ResumeConst.FIELD_VALUE, listOfMap.get(key));
            result.add(map);
        }

        return result;
    }

    private List<Map<String, Object>> listToList(List<String> list) {
        List<Map<String, Object>> result = new ArrayList<>();

        for (String item : list) {
            Map<String, Object> map = new HashMap<>();
            map.put(ResumeConst.FIELD_VALUE, item);
            result.add(map);
        }

        return result;
    }

    private String listToString(List<String> list) {
        return StringUtils.join(list, '•')
                .replace("•", " • ");
    }
}
