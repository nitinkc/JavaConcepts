package com.converter.db2Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ReferenceDataAuditFields implements Serializable {

    @Serial
    private static final long serialVersionUID = -3784354643L;

    @Column( name = "START_DATE")
    private Timestamp startDate;

    @Column(name = "END_DATE")
    private Timestamp endDate;

    @Column(name = "UPDATE_DATE_TIME_GMT")
    private Timestamp updateDateTimeGmt;

    @Column(name = "CREATE_RELEASE_NUMBER")
    private Integer releaseNumber;
}