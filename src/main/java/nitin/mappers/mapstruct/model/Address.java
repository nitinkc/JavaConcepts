package nitin.mappers.mapstruct.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Address {
  private String addressLine1;
  private String addressLine2;
  private String city;
  private String state;
  private String zip;
}
