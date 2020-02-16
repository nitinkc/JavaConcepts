package com.nitin.LexicalScopingClosures;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by nitin on Saturday, February/15/2020 at 10:15 PM
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Response {

    @JsonProperty
    private RestResponse RestResponse;


}
