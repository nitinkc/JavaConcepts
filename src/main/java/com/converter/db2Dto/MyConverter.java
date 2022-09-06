package com.converter.db2Dto;

public class MyConverter implements DbToDtoConverter<DataDto, Data> {

    private RefDataReadDao refDataReadDao;

    @Override
    public DataDto convert(Data data) {
        return DataDto.builder()
                .createReleaseNumber(data.getReleaseNumber())
                .refData(refDataReadDao.findById(RefTable.class,data.getRefDataId()))
                .build();
    }
}