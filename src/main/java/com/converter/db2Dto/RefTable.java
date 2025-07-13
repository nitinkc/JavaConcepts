package com.converter.db2Dto;

import java.io.Serial;
import javax.persistence.Column;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = RefTable.NAME)
public class RefTable extends ReferenceDataAuditFields {

    public static final String NAME = "REF_TABLE";
    @Serial private static final long serialVersionUID = -6116147807948969283L;

    // @PrimaryKey
    @Column(name = "CODE_ID", nullable = false)
    private String codeId;

    @Column(name = "DISPLAY_NAME", nullable = false)
    private String displayName;
}
