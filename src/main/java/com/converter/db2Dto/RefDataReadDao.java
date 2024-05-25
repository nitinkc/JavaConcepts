package com.converter.db2Dto;

import java.util.Collection;
import java.util.List;

public interface RefDataReadDao {
    <K extends ReferenceDataAuditFields> List<K> findAll(Class<K> theClass);

    <K extends ReferenceDataAuditFields> K findById(Class<K> theClass, String id);

    <K extends ReferenceDataAuditFields> List<K> findByIds(Class<K> theClass, Collection<String> ids);
}