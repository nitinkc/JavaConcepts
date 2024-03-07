package sandbox.test;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Sample JSON data
        String jsonData = "{\"additionalLabs\":[{\"careCategoryName\":\"Additional\",\"lab_test_code\":\"7612\",\"name\":\"BLOOD GLUCOSE FINGER STICK\",\"uom\":\" (mg/dL)\",\"drawDate\":\"(12/26)\",\"drawDateDt\":\"12/26/2023\",\"drawDatelocaltzdt\":\"2023-12-26T23:14:39Z\",\"davitaLabFlag\":null,\"value\":\"12\",\"outOfRangeInd\":null},{\"careCategoryName\":\"Additional\",\"lab_test_code\":\"7612\",\"name\":\"BLOOD GLUCOSE FINGER STICK\",\"uom\":\" (mg/dL)\",\"drawDate\":\"(10/16)\",\"drawDateDt\":\"10/16/2023\",\"drawDatelocaltzdt\":\"2023-10-16T09:21:04Z\",\"davitaLabFlag\":null,\"value\":\"120\",\"outOfRangeInd\":null}]}";

        // Parse JSON into object
        ObjectMapper objectMapper = new ObjectMapper();
        AdditionalLabsDto additionalLabsDto = null;
        try {
            additionalLabsDto = objectMapper.readValue(jsonData, AdditionalLabsDto.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Group additional labs by name and uom
        Map<String, LabDetail> labDetailMap = new HashMap<>();
        for (AdditionalLab additionalLab : additionalLabsDto.additionalLabs) {
            String key = additionalLab.name + "-" + additionalLab.uom;
            LabDetail labDetail = labDetailMap.getOrDefault(key, new LabDetail());
            labDetail.name = additionalLab.name;
            labDetail.uom = additionalLab.uom;

            Lab lab = new Lab();
            LabsDatum labsDatum = new LabsDatum();
            labsDatum.value = additionalLab.value;
            labsDatum.davitaLabFlag = (Boolean) additionalLab.davitaLabFlag;
            labsDatum.drawDate = additionalLab.drawDate;
            labsDatum.outOfRangeInd = (Boolean) additionalLab.outOfRangeInd;

            if (lab.labsData == null) {
                lab.labsData = new ArrayList<>();
            }
            lab.labsData.add(labsDatum);

            if (labDetail.labs == null) {
                labDetail.labs = new ArrayList<>();
            }
            labDetail.labs.add(lab);

            labDetailMap.put(key, labDetail);
        }

        // Convert map values to list
        List<LabDetail> labDetails = new ArrayList<>(labDetailMap.values());

        // Print the result
        labDetails.forEach(System.out::println);
    }
}
